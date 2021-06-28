package pl.wel.wat.edu.footsquadbuilder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FormationPlayersListAdapter extends RecyclerView.Adapter<FormationPlayersListAdapter.ViewHolder> {
    private List<Player> players;

    private Context context;

    public FormationPlayersListAdapter(List<Player> mPlayers) { players = mPlayers; }

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

        // Nasluchiwacz klikniec
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reakcja
                int index = holder.getBindingAdapterPosition();
                Log.d("Test LISTENER:", "Klikniete w pozycje " + index);
                // wysylanie zawodnika
                String namePlayerClicked = player.getId().toString();
                Intent intent = new Intent("custom-message");
                intent.putExtra("item", namePlayerClicked);
                LocalBroadcastManager.getInstance(v.getContext()).sendBroadcast(intent);

//                ((FormationPlayersListActivity)context).finish();
                
            }
        });

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
        switch (player.getClub()) {
            case "Angers_SCO":
                imageViewFutCardListClubH.setImageResource(R.drawable.angers_sco);
                break;
            case "Arsenal":
                imageViewFutCardListClubH.setImageResource(R.drawable.arsenal);
                break;
            case "AS_Monaco":
                imageViewFutCardListClubH.setImageResource(R.drawable.as_monaco);
                break;
            case "Atletico":
                imageViewFutCardListClubH.setImageResource(R.drawable.atletico);
                break;
            case "Bayern":
                imageViewFutCardListClubH.setImageResource(R.drawable.bayern);
                break;
            case "Borussia_Dortmund":
                imageViewFutCardListClubH.setImageResource(R.drawable.borussia_dortmund);
                break;
            case "Borussia_M_gladbach":
                imageViewFutCardListClubH.setImageResource(R.drawable.borussia_m_gladbach);
                break;
            case "Celta_de_Vigo":
                imageViewFutCardListClubH.setImageResource(R.drawable.celta_de_vigo);
                break;
            case "Chelsea":
                imageViewFutCardListClubH.setImageResource(R.drawable.chelsea);
                break;
            case "Eintracht_Frankfurt":
                imageViewFutCardListClubH.setImageResource(R.drawable.eintracht_frankfurt);
                break;
            case "FC_Barcelona":
                imageViewFutCardListClubH.setImageResource(R.drawable.fc_barcelona);
                break;
            case "Genoa":
                imageViewFutCardListClubH.setImageResource(R.drawable.genoa);
                break;
            case "Girondins_de_Bordeaux":
                imageViewFutCardListClubH.setImageResource(R.drawable.girondins_de_bordeaux);
                break;
            case "Hoffenheim":
                imageViewFutCardListClubH.setImageResource(R.drawable.hoffenheim);
                break;
            case "Inter":
                imageViewFutCardListClubH.setImageResource(R.drawable.inter);
                break;
            case "Lazio":
                imageViewFutCardListClubH.setImageResource(R.drawable.lazio);
                break;
            case "Leicester_City":
                imageViewFutCardListClubH.setImageResource(R.drawable.leicester_city);
                break;
            case "Liverpool":
                imageViewFutCardListClubH.setImageResource(R.drawable.liverpool);
                break;
            case "LOSC_Lille":
                imageViewFutCardListClubH.setImageResource(R.drawable.losc_lille);
                break;
            case "Manchester_City":
                imageViewFutCardListClubH.setImageResource(R.drawable.manchester_city);
                break;
            case "Manchester_United":
                imageViewFutCardListClubH.setImageResource(R.drawable.manchester_united);
                break;
            case "Milan":
                imageViewFutCardListClubH.setImageResource(R.drawable.milan);
                break;
            case "Napoli":
                imageViewFutCardListClubH.setImageResource(R.drawable.napoli);
                break;
            case "Olympique_de_Marsille":
                imageViewFutCardListClubH.setImageResource(R.drawable.olympique_de_marsille);
                break;
            case "Olympique_Lyonnais":
                imageViewFutCardListClubH.setImageResource(R.drawable.olympique_lyonnais);
                break;
            case "Paris_Saint_Germain":
                imageViewFutCardListClubH.setImageResource(R.drawable.paris_saint_germain);
                break;
            case "Piemonte_Calcio":
                imageViewFutCardListClubH.setImageResource(R.drawable.piemonte_calcio);
                break;
            case "RB_Leipzig":
                imageViewFutCardListClubH.setImageResource(R.drawable.rb_leipzig);
                break;
            case "Real_Madrid":
                imageViewFutCardListClubH.setImageResource(R.drawable.real_madrid);
                break;
            case "Sassuolo":
                imageViewFutCardListClubH.setImageResource(R.drawable.sassuolo);
                break;
            case "Sevilla":
                imageViewFutCardListClubH.setImageResource(R.drawable.sevilla);
                break;
            case "Tottenham_Hotspur":
                imageViewFutCardListClubH.setImageResource(R.drawable.tottenham_hotspur);
                break;
            case "Vfl_Wolfsburg":
                imageViewFutCardListClubH.setImageResource(R.drawable.vfl_wolfsburg);
                break;
            case "Villareal":
                imageViewFutCardListClubH.setImageResource(R.drawable.villareal);
                break;
        }

        ImageView imageViewFutCardListCountryH = holder.imageViewFutCardListCountryL;
        switch (player.getNationality()){
            case "Anglia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.anglia);
                break;
            case "Argentyna":
                imageViewFutCardListCountryH.setImageResource(R.drawable.argentyna);
                break;
            case "Austria":
                imageViewFutCardListCountryH.setImageResource(R.drawable.austria);
                break;
            case "Belgia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.belgia);
                break;
            case "Brazylia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.brazylia);
                break;
            case "Chorwacja":
                imageViewFutCardListCountryH.setImageResource(R.drawable.chorwacja);
                break;
            case "Dania":
                imageViewFutCardListCountryH.setImageResource(R.drawable.dania);
                break;
            case "Francja":
                imageViewFutCardListCountryH.setImageResource(R.drawable.francja);
                break;
            case "Hiszpania":
                imageViewFutCardListCountryH.setImageResource(R.drawable.hiszpania);
                break;
            case "Holandia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.holandia);
                break;
            case "Kongo":
                imageViewFutCardListCountryH.setImageResource(R.drawable.kongo);
                break;
            case "Niemiec":
                imageViewFutCardListCountryH.setImageResource(R.drawable.niemiec);
                break;
            case "Norwegia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.norwegia);
                break;
            case "Polska":
                imageViewFutCardListCountryH.setImageResource(R.drawable.polska);
                break;
            case "Portugalia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.portugalia);
                break;
            case "Senegal":
                imageViewFutCardListCountryH.setImageResource(R.drawable.senegal);
                break;
            case "Serbia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.serbia);
                break;
            case "Slowacja":
                imageViewFutCardListCountryH.setImageResource(R.drawable.slowacja);
                break;
            case "Slowenia":
                imageViewFutCardListCountryH.setImageResource(R.drawable.slowenia);
                break;
            case "Szwajcaria":
                imageViewFutCardListCountryH.setImageResource(R.drawable.szwajcaria);
                break;
            case "Szwecja":
                imageViewFutCardListCountryH.setImageResource(R.drawable.szwecja);
                break;
            case "Urugwaj":
                imageViewFutCardListCountryH.setImageResource(R.drawable.urugwaj);
                break;
            case "Wegry":
                imageViewFutCardListCountryH.setImageResource(R.drawable.wegry);
                break;
            case "Wlochy":
                imageViewFutCardListCountryH.setImageResource(R.drawable.wlochy);
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
