package pl.wel.wat.edu.footsquadbuilder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.ViewHolder> {

    private List<Player> players;

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

        for (Player p : players) {
            Log.i("Zawodnik: ", p.toString());
        }

        TextView textViewFutCardListNameH = holder.textViewFutCardListNameL;
        textViewFutCardListNameH.setText(player.getName());
        TextView textViewFutCardListPosH = holder.textViewFutCardListPosL;
        switch (player.getPosition()){
            case 1:
                textViewFutCardListPosH.setText("GK");
                break;
            case 2:
                textViewFutCardListPosH.setText("CB");
                break;
            case 3:
                textViewFutCardListPosH.setText("CM");
                break;
            case 4:
                textViewFutCardListPosH.setText("ST");
                break;
        }
        TextView textViewFutCardListScoreH = holder.textViewFutCardListScoreL;
        textViewFutCardListScoreH.setText(Integer.toString(player.getRating()));
        ImageView imageViewFutCardListPhotoH = holder.imageViewFutCardListPhotoL;
        String photoPlayer = "p"+player.getId();
        Context context = imageViewFutCardListPhotoH.getContext();
        int idPhoto = context.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
        imageViewFutCardListPhotoH.setImageResource(idPhoto);
        ImageView imageViewFutCardListClubH = holder.imageViewFutCardListClubL;
        switch (player.getClub()){
            case "Angers_SCO":
                imageViewFutCardListClubH.setImageResource(R.drawable.angers_sco);
                break;
            case "Arsenal":
                imageViewFutCardListClubH.setImageResource(R.drawable.arsenal);
                break;
        }

        ImageView imageViewFutCardListCountryH = holder.imageViewFutCardListCountryL;
        switch (player.getNationality()){
            case "Anglia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.anglia);
                break;
        }

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
