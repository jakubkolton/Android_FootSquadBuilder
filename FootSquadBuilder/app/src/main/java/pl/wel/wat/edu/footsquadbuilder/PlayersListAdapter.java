package pl.wel.wat.edu.footsquadbuilder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.ViewHolder> {

    private List<Player> players;
    private static int choosePosition = -1;

    public static int getChoosePosition() {
        return choosePosition;
    }

    public PlayersListAdapter(List<Player> mPlayers) { players = mPlayers; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View reviewView = inflater.inflate(R.layout.fut_card_list_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(reviewView);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player = players.get(position);

        SetElementCard elementCard = new SetElementCard();

        for (Player p : players) {
            Log.i("Zawodnik: ", p.toString());
        }

        // Nasluchiwacz klikniec
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reakcja
                int index = holder.getBindingAdapterPosition();
                Log.d("Test LISTENER:", "Klikniete w pozycje " + index);
                Player randomPlayer = HomeActivity.getPlayersRandomizedList().get(index);
                HomeActivity.playersBenchList.add(randomPlayer);
                Log.d("Test LISTENER:", "Dodany pilkarz: " + HomeActivity.getPlayersBenchList().get(HomeActivity.getPlayersBenchList().size()-1).getName());

                // Kolejne losowanie
                HomeActivity.playersRandomizedList.clear();
                HomeActivity.playersListAdapter.notifyDataSetChanged();
                HomeActivity.setNoRandomization(HomeActivity.getNoRandomization()+1);
                Log.d("Test LISTENER:", "Kolejne no: " + HomeActivity.getNoRandomization());
                HomeActivity.playersRandomization(HomeActivity.getNoRandomization());
            }
        });

        TextView textViewFutCardListNameH = holder.textViewFutCardListNameL;
        textViewFutCardListNameH.setText(player.getName());
        TextView textViewFutCardListPosH = holder.textViewFutCardListPosL;
        elementCard.setPosCard(player, textViewFutCardListPosH);
        TextView textViewFutCardListScoreH = holder.textViewFutCardListScoreL;
        textViewFutCardListScoreH.setText(Integer.toString(player.getRating()));
        ImageView imageViewFutCardListPhotoH = holder.imageViewFutCardListPhotoL;
        String photoPlayer = "p"+player.getId();
        Context context = imageViewFutCardListPhotoH.getContext();
        int idPhoto = context.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
        imageViewFutCardListPhotoH.setImageResource(idPhoto);
        ImageView imageViewFutCardListClubH = holder.imageViewFutCardListClubL;
        elementCard.setClubCard(player, imageViewFutCardListClubH);
        ImageView imageViewFutCardListCountryH = holder.imageViewFutCardListCountryL;
        elementCard.setCountryCard(player, imageViewFutCardListCountryH);

    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewFutCardListPhotoL;
        public ImageView imageViewFutCardListClubL;
        public ImageView imageViewFutCardListCountryL;
        public TextView textViewFutCardListNameL;
        public TextView textViewFutCardListPosL;
        public TextView textViewFutCardListScoreL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFutCardListPhotoL = (ImageView)itemView.findViewById(R.id.imageViewFutCardListPhoto);
            imageViewFutCardListClubL = (ImageView)itemView.findViewById(R.id.imageViewFutCardListClub);
            imageViewFutCardListCountryL = (ImageView)itemView.findViewById(R.id.imageViewFutCardListCountry);
            textViewFutCardListNameL = (TextView) itemView.findViewById(R.id.textViewFutCardListName);
            textViewFutCardListPosL = (TextView)itemView.findViewById(R.id.textViewFutCardListPos);
            textViewFutCardListScoreL = (TextView)itemView.findViewById(R.id.textViewFutCardListScore);
        }
    }
}
