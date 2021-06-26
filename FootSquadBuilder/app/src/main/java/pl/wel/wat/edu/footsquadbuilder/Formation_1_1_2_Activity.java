package pl.wel.wat.edu.footsquadbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Formation_1_1_2_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private String cardName;
    private String flag = "";
    private List<Player> data;

    TextView FCscore112ST1;
    ImageView FCclub112ST1;
    ImageView FCcountry112ST1;
    TextView FCpos112ST1;
    ImageView FCphoto112ST1;
    TextView FCname112ST1;

    TextView FCscore112ST2;
    ImageView FCclub112ST2;
    ImageView FCcountry112ST2;
    TextView FCpos112ST2;
    ImageView FCphoto112ST2;
    TextView FCname112ST2;

    TextView FCscore112CM;
    ImageView FCclub112CM;
    ImageView FCcountry112CM;
    TextView FCpos112CM;
    ImageView FCphoto112CM;
    TextView FCname112CM;

    TextView FCscore112CB;
    ImageView FCclub112CB;
    ImageView FCcountry112CB;
    TextView FCpos112CB;
    ImageView FCphoto112CB;
    TextView FCname112CB;

    TextView FCscore112GK;
    ImageView FCclub112GK;
    ImageView FCcountry112GK;
    TextView FCpos112GK;
    ImageView FCphoto112GK;
    TextView FCname112GK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation112);

        FCscore112ST1 = (TextView) findViewById(R.id.textViewFutCardScore_112ST1);
        FCclub112ST1 = (ImageView) findViewById(R.id.imageViewFutCardClub_112ST1);
        FCcountry112ST1 = (ImageView) findViewById(R.id.imageViewFutCardCountry_112ST1);
        FCpos112ST1 = (TextView) findViewById(R.id.textViewFutCardPos_112ST1);
        FCphoto112ST1 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_112ST1);
        FCname112ST1 = (TextView) findViewById(R.id.textViewFutCardName_112ST1);

        FCscore112ST2 = (TextView) findViewById(R.id.textViewFutCardScore_112ST2);
        FCclub112ST2 = (ImageView) findViewById(R.id.imageViewFutCardClub_112ST2);
        FCcountry112ST2 = (ImageView) findViewById(R.id.imageViewFutCardCountry_112ST2);
        FCpos112ST2 = (TextView) findViewById(R.id.textViewFutCardPos_112ST2);
        FCphoto112ST2 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_112ST2);
        FCname112ST2 = (TextView) findViewById(R.id.textViewFutCardName_112ST2);

        FCscore112CM = (TextView) findViewById(R.id.textViewFutCardScore_112CM);
        FCclub112CM = (ImageView) findViewById(R.id.imageViewFutCardClub_112CM);
        FCcountry112CM = (ImageView) findViewById(R.id.imageViewFutCardCountry_112CM);
        FCpos112CM = (TextView) findViewById(R.id.textViewFutCardPos_112CM);
        FCphoto112CM = (ImageView) findViewById(R.id.imageViewFutCardPhoto_112CM);
        FCname112CM = (TextView) findViewById(R.id.textViewFutCardName_112CM);

        FCscore112CB = (TextView) findViewById(R.id.textViewFutCardScore_112CB);
        FCclub112CB = (ImageView) findViewById(R.id.imageViewFutCardClub_112CB);
        FCcountry112CB = (ImageView) findViewById(R.id.imageViewFutCardCountry_112CB);
        FCpos112CB = (TextView) findViewById(R.id.textViewFutCardPos_112CB);
        FCphoto112CB = (ImageView) findViewById(R.id.imageViewFutCardPhoto_112CB);
        FCname112CB = (TextView) findViewById(R.id.textViewFutCardName_112CB);

        FCscore112GK = (TextView) findViewById(R.id.textViewFutCardScore_112GK);
        FCclub112GK = (ImageView) findViewById(R.id.imageViewFutCardClub_112GK);
        FCcountry112GK = (ImageView) findViewById(R.id.imageViewFutCardCountry_112GK);
        FCpos112GK = (TextView) findViewById(R.id.textViewFutCardPos_112GK);
        FCphoto112GK = (ImageView) findViewById(R.id.imageViewFutCardPhoto_112GK);
        FCname112GK = (TextView) findViewById(R.id.textViewFutCardName_112GK);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bootom_navigation_112);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        data = MainActivity.getPlayersDB();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));

        CardView cardView112ST1 = (CardView) findViewById(R.id.CardView_112ST1);
        cardView112ST1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112ST1";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112ST2 = (CardView) findViewById(R.id.CardView_112ST2);
        cardView112ST2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112ST2";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CM = (CardView) findViewById(R.id.CardView_112CM);
        cardView112CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112CM";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CB = (CardView) findViewById(R.id.CardView_112CB);
        cardView112CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112CB";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112GK = (CardView) findViewById(R.id.CardView_112GK);
        cardView112GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112GK";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_bot_home:
                    Toast.makeText(Formation_1_1_2_Activity.this, "home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_bot_rez:
//                    Toast.makeText(Formation_1_1_2_Activity.this, "rezerwa", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Formation_1_1_2_Activity.this, PlayersBenchActivity.class));
                    break;
                case R.id.nav_bot_list:
                    startActivity(new Intent(Formation_1_1_2_Activity.this, PlayersListActivity.class));
                    break;
            }
            return false;
        }
    };

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String ItemCard = intent.getStringExtra("item");
            Toast.makeText(context, ItemCard + " " + flag, Toast.LENGTH_SHORT).show();

            Integer idClicekCard = Integer.parseInt(ItemCard) - 1;
            Player player = data.get(idClicekCard);
            Context contextPhoto;
            String photoPlayer;
            int idPhoto;

            switch (flag){
                case "CardView_112ST1":
                    FCscore112ST1.setText(Integer.toString(player.getRating()));
                    FCname112ST1.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112ST1.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112ST1.setImageResource(idPhoto);
                    setPosCard(player, FCpos112ST1);
                    setClubCard(player, FCclub112ST1);
                    setCountryCard(player, FCcountry112ST1);
                    break;
                case "CardView_112ST2":
                    FCscore112ST2.setText(Integer.toString(player.getRating()));
                    FCname112ST2.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112ST2.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112ST2.setImageResource(idPhoto);
                    setPosCard(player, FCpos112ST2);
                    setClubCard(player, FCclub112ST2);
                    setCountryCard(player, FCcountry112ST2);
                    break;
                case "CardView_112CM":
                    FCscore112CM.setText(Integer.toString(player.getRating()));
                    FCname112CM.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112CM.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112CM.setImageResource(idPhoto);
                    setPosCard(player, FCpos112CM);
                    setClubCard(player, FCclub112CM);
                    setCountryCard(player, FCcountry112CM);
                    break;
                case "CardView_112CB":
                    FCscore112CB.setText(Integer.toString(player.getRating()));
                    FCname112CB.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112CB.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112CB.setImageResource(idPhoto);
                    setPosCard(player, FCpos112CB);
                    setClubCard(player, FCclub112CB);
                    setCountryCard(player, FCcountry112CB);
                    break;
                case "CardView_112GK":
                    FCscore112GK.setText(Integer.toString(player.getRating()));
                    FCname112GK.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112GK.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112GK.setImageResource(idPhoto);
                    setPosCard(player, FCpos112GK);
                    setClubCard(player, FCclub112GK);
                    setCountryCard(player, FCcountry112GK);
                    break;
            }
        }
    };

    public void setPosCard(Player player, TextView card) {
        switch (player.getPosition()){
            case 1:
                card.setText("GK");
                break;
            case 2:
                card.setText("CB");
                break;
            case 3:
                card.setText("CM");
                break;
            case 4:
                card.setText("ST");
                break;
        }
    }

    public void setClubCard(Player player, ImageView card) {
        switch (player.getClub()) {
            case "Angers_SCO":
                card.setImageResource(R.drawable.angers_sco);
                break;
            case "Arsenal":
                card.setImageResource(R.drawable.arsenal);
                break;
            case "AS_Monaco":
                card.setImageResource(R.drawable.as_monaco);
                break;
            case "Atletico ":
                card.setImageResource(R.drawable.atletico);
                break;
            case "Bayern":
                card.setImageResource(R.drawable.bayern);
                break;
            case "Borussia_Dortmund":
                card.setImageResource(R.drawable.borussia_dortmund);
                break;
            case "Borussia_M_gladbach":
                card.setImageResource(R.drawable.borussia_m_gladbach);
                break;
            case "Celta_de_Vigo":
                card.setImageResource(R.drawable.celta_de_vigo);
                break;
            case "Chelsea":
                card.setImageResource(R.drawable.chelsea);
                break;
            case "Eintracht_Frankfurt":
                card.setImageResource(R.drawable.eintracht_frankfurt);
                break;
            case "FC_Barcelona":
                card.setImageResource(R.drawable.fc_barcelona);
                break;
            case "Genoa":
                card.setImageResource(R.drawable.genoa);
                break;
            case "Girondins_de_Bordeaux":
                card.setImageResource(R.drawable.girondins_de_bordeaux);
                break;
            case "Hoffenheim":
                card.setImageResource(R.drawable.hoffenheim);
                break;
            case "Inter":
                card.setImageResource(R.drawable.inter);
                break;
            case "Lazio":
                card.setImageResource(R.drawable.lazio);
                break;
            case "Leicester_City":
                card.setImageResource(R.drawable.leicester_city);
                break;
            case "Liverpool":
                card.setImageResource(R.drawable.liverpool);
                break;
            case "LOSC_Lille":
                card.setImageResource(R.drawable.losc_lille);
                break;
            case "Manchester_City ":
                card.setImageResource(R.drawable.manchester_city);
                break;
            case "Manchester_United":
                card.setImageResource(R.drawable.manchester_united);
                break;
            case "Milan":
                card.setImageResource(R.drawable.milan);
                break;
            case "Napoli":
                card.setImageResource(R.drawable.napoli);
                break;
            case "Olympique_de_Marsille":
                card.setImageResource(R.drawable.olympique_de_marsille);
                break;
            case "Olympique_Lyonnais":
                card.setImageResource(R.drawable.olympique_lyonnais);
                break;
            case "Paris_Saint_Germain":
                card.setImageResource(R.drawable.paris_saint_germain);
                break;
            case "Piemonte_Calcio":
                card.setImageResource(R.drawable.piemonte_calcio);
                break;
            case "RB_Leipzig":
                card.setImageResource(R.drawable.rb_leipzig);
                break;
            case "Real_Madrid":
                card.setImageResource(R.drawable.real_madrid);
                break;
            case "Sassuolo":
                card.setImageResource(R.drawable.sassuolo);
                break;
            case "Sevilla":
                card.setImageResource(R.drawable.sevilla);
                break;
            case "Tottenham_Hotspur":
                card.setImageResource(R.drawable.tottenham_hotspur);
                break;
            case "Vfl_Wolfsburg":
                card.setImageResource(R.drawable.vfl_wolfsburg);
                break;
            case "Villareal":
                card.setImageResource(R.drawable.villareal);
                break;
        }
    }

    public void setCountryCard(Player player, ImageView card) {
        switch (player.getNationality()){
            case "Anglia":
                card.setImageResource(R.drawable.anglia);
                break;
            case "Argentyna":
                card.setImageResource(R.drawable.argentyna);
                break;
            case "Austria":
                card.setImageResource(R.drawable.austria);
                break;
            case "Belgia":
                card.setImageResource(R.drawable.belgia);
                break;
            case "Brazylia":
                card.setImageResource(R.drawable.brazylia);
                break;
            case "Chorwacja":
                card.setImageResource(R.drawable.chorwacja);
                break;
            case "Dania":
                card.setImageResource(R.drawable.dania);
                break;
            case "Francja":
                card.setImageResource(R.drawable.francja);
                break;
            case "Hiszpania":
                card.setImageResource(R.drawable.hiszpania);
                break;
            case "Holandia":
                card.setImageResource(R.drawable.holandia);
                break;
            case "Kongo":
                card.setImageResource(R.drawable.kongo);
                break;
            case "Niemiec":
                card.setImageResource(R.drawable.niemiec);
                break;
            case "Norwegia":
                card.setImageResource(R.drawable.norwegia);
                break;
            case "Polska":
                card.setImageResource(R.drawable.polska);
                break;
            case "Portugalia":
                card.setImageResource(R.drawable.portugalia);
                break;
            case "Senegal":
                card.setImageResource(R.drawable.senegal);
                break;
            case "Serbia":
                card.setImageResource(R.drawable.serbia);
                break;
            case "Slowacja":
                card.setImageResource(R.drawable.slowacja);
                break;
            case "Slowenia":
                card.setImageResource(R.drawable.slowenia);
                break;
            case "Szwajcaria":
                card.setImageResource(R.drawable.szwajcaria);
                break;
            case "Szwecja":
                card.setImageResource(R.drawable.szwecja);
                break;
            case "Urugwaj":
                card.setImageResource(R.drawable.urugwaj);
                break;
            case "Wegry":
                card.setImageResource(R.drawable.wegry);
                break;
            case "Wlochy":
                card.setImageResource(R.drawable.wlochy);
                break;
        }
    }
}