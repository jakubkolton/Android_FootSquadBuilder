package pl.wel.wat.edu.footsquadbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;
import static pl.wel.wat.edu.footsquadbuilder.R.*;

public class Formation_1_1_2_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    public static List<PlayerCard> formationListPlayers;
    public static List<Link> linkList; // lista zgran

    private static Integer squadRating = 0;
    private static Integer squadChemistry = 0;

    private String cardName;
    private String flag = "";
    private List<Player> data;

    TextView NamePlayer112;
    TextView ScoreSquad112;
    TextView ScoreChemistry112;

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
        setContentView(layout.activity_formation112);

        NamePlayer112 = (TextView) findViewById(id.textViewFutCardName_112Sum);
        ScoreSquad112 = (TextView) findViewById(R.id.textViewFutCardSquad_112Sum);
        ScoreChemistry112 = (TextView) findViewById(R.id.textViewFutCardSquadSum_112Sum);

        NamePlayer112.setText(MainActivity.sharedName.getString(MainActivity.NAME, ""));

        // pusta lista 5-elementowa na 5 zawodnikow na boisku i pusta lista 5-elementowa na 5 linii zgrania
        formationListPlayers = new ArrayList<>(5);
        linkList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            formationListPlayers.add(new PlayerCard());
            linkList.add(new Link());
        }
        // Przypisanie widokow z liniami do linii zgrania
        linkList.get(0).setViewLink(findViewById(id.link_112_0));
        linkList.get(1).setViewLink(findViewById(id.link_112_1));
        linkList.get(2).setViewLink(findViewById(id.link_112_2));
        linkList.get(3).setViewLink(findViewById(id.link_112_3));
        linkList.get(4).setViewLink(findViewById(id.link_112_4));


        FCscore112ST1 = (TextView) findViewById(id.textViewFutCardScore_112ST1);
        FCclub112ST1 = (ImageView) findViewById(id.imageViewFutCardClub_112ST1);
        FCcountry112ST1 = (ImageView) findViewById(id.imageViewFutCardCountry_112ST1);
        FCpos112ST1 = (TextView) findViewById(id.textViewFutCardPos_112ST1);
        FCphoto112ST1 = (ImageView) findViewById(id.imageViewFutCardPhoto_112ST1);
        FCname112ST1 = (TextView) findViewById(id.textViewFutCardName_112ST1);

        FCscore112ST2 = (TextView) findViewById(id.textViewFutCardScore_112ST2);
        FCclub112ST2 = (ImageView) findViewById(id.imageViewFutCardClub_112ST2);
        FCcountry112ST2 = (ImageView) findViewById(id.imageViewFutCardCountry_112ST2);
        FCpos112ST2 = (TextView) findViewById(id.textViewFutCardPos_112ST2);
        FCphoto112ST2 = (ImageView) findViewById(id.imageViewFutCardPhoto_112ST2);
        FCname112ST2 = (TextView) findViewById(id.textViewFutCardName_112ST2);

        FCscore112CM = (TextView) findViewById(id.textViewFutCardScore_112CM);
        FCclub112CM = (ImageView) findViewById(id.imageViewFutCardClub_112CM);
        FCcountry112CM = (ImageView) findViewById(id.imageViewFutCardCountry_112CM);
        FCpos112CM = (TextView) findViewById(id.textViewFutCardPos_112CM);
        FCphoto112CM = (ImageView) findViewById(id.imageViewFutCardPhoto_112CM);
        FCname112CM = (TextView) findViewById(id.textViewFutCardName_112CM);

        FCscore112CB = (TextView) findViewById(id.textViewFutCardScore_112CB);
        FCclub112CB = (ImageView) findViewById(id.imageViewFutCardClub_112CB);
        FCcountry112CB = (ImageView) findViewById(id.imageViewFutCardCountry_112CB);
        FCpos112CB = (TextView) findViewById(id.textViewFutCardPos_112CB);
        FCphoto112CB = (ImageView) findViewById(id.imageViewFutCardPhoto_112CB);
        FCname112CB = (TextView) findViewById(id.textViewFutCardName_112CB);

        FCscore112GK = (TextView) findViewById(id.textViewFutCardScore_112GK);
        FCclub112GK = (ImageView) findViewById(id.imageViewFutCardClub_112GK);
        FCcountry112GK = (ImageView) findViewById(id.imageViewFutCardCountry_112GK);
        FCpos112GK = (TextView) findViewById(id.textViewFutCardPos_112GK);
        FCphoto112GK = (ImageView) findViewById(id.imageViewFutCardPhoto_112GK);
        FCname112GK = (TextView) findViewById(id.textViewFutCardName_112GK);

        bottomNavigationView = (BottomNavigationView)findViewById(id.bootom_navigation_112);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        data = MainActivity.getPlayersDB();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));

        CardView cardView112ST1 = (CardView) findViewById(id.CardView_112ST1);
        cardView112ST1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112ST1";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112ST2 = (CardView) findViewById(id.CardView_112ST2);
        cardView112ST2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112ST2";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CM = (CardView) findViewById(id.CardView_112CM);
        cardView112CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112CM";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CB = (CardView) findViewById(id.CardView_112CB);
        cardView112CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_112CB";
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112GK = (CardView) findViewById(id.CardView_112GK);
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
                case id.nav_bot_home:
                    Toast.makeText(Formation_1_1_2_Activity.this, "home", Toast.LENGTH_SHORT).show();
                    break;
                case id.nav_bot_rez:
//                    Toast.makeText(Formation_1_1_2_Activity.this, "rezerwa", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Formation_1_1_2_Activity.this, PlayersBenchActivity.class));
                    break;
                case id.nav_bot_list:
                    startActivity(new Intent(Formation_1_1_2_Activity.this, PlayersListActivity.class));
                    break;
            }
            return false;
        }
    };

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            String ItemCard = intent.getStringExtra("item");
            Toast.makeText(context, ItemCard + " " + flag, Toast.LENGTH_SHORT).show();

            SetElementCard elementCard = new SetElementCard();
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
                    elementCard.setPosCard(player, FCpos112ST1);
                    elementCard.setClubCard(player, FCclub112ST1);
                    elementCard.setCountryCard(player, FCcountry112ST1);

                    Player player112ST1 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard112ST1 = new PlayerCard(player112ST1, 4);
                    formationListPlayers.set(3, playerCard112ST1);
                    break;
                case "CardView_112ST2":
                    FCscore112ST2.setText(Integer.toString(player.getRating()));
                    FCname112ST2.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112ST2.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112ST2.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos112ST2);
                    elementCard.setClubCard(player, FCclub112ST2);
                    elementCard.setCountryCard(player, FCcountry112ST2);

                    Player player112ST2 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard112ST2 = new PlayerCard(player112ST2, 4);
                    formationListPlayers.set(4, playerCard112ST2);
                    break;
                case "CardView_112CM":
                    FCscore112CM.setText(Integer.toString(player.getRating()));
                    FCname112CM.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112CM.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112CM.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos112CM);
                    elementCard.setClubCard(player, FCclub112CM);
                    elementCard.setCountryCard(player, FCcountry112CM);

                    Player player112CM = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard112CM = new PlayerCard(player112CM, 3);
                    formationListPlayers.set(2, playerCard112CM);
                    break;
                case "CardView_112CB":
                    FCscore112CB.setText(Integer.toString(player.getRating()));
                    FCname112CB.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112CB.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112CB.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos112CB);
                    elementCard.setClubCard(player, FCclub112CB);
                    elementCard.setCountryCard(player, FCcountry112CB);

                    Player player112CB = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard112CB = new PlayerCard(player112CB, 2);
                    formationListPlayers.set(1, playerCard112CB);
                    break;
                case "CardView_112GK":
                    FCscore112GK.setText(Integer.toString(player.getRating()));
                    FCname112GK.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto112GK.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto112GK.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos112GK);
                    elementCard.setClubCard(player, FCclub112GK);
                    elementCard.setCountryCard(player, FCcountry112GK);

                    Player player112GK = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard112GK = new PlayerCard(player112GK, 1);
                    formationListPlayers.set(0, playerCard112GK);


                    break;
            }

            // Test - zakladam, ze bramkarz bedzie ostatni wybrany
            for (int i = 0; i < formationListPlayers.size(); i++) {
                Log.d("Test LINK:", formationListPlayers.get(i).getName()+"\n");
            }

            refreshLinksAndRating(); // odswiezenie danych o zgraniu po kazdej zmianie w skladzie
        }
    };

    // Metoda liczaca zgranie i ocene calkowita zespolu
    @SuppressLint("ResourceAsColor")
    public static void refreshLinksAndRating() {

        // Zgrania z pozycji
        for (int i = 0; i < formationListPlayers.size(); i++) {
            formationListPlayers.get(i).calculateChemistryPosition();
            Log.d("Test FORMATION:", "Zgranie z pozycji " + Integer.toString(i) + ": " + formationListPlayers.get(i).getChemistryPosition().toString()+"\n");
        }

        // Zgrania z polaczen ---------------------------------------------------------------
        linkList.get(0).setPlayer1(formationListPlayers.get(0)); // polaczenie 0 - GK
        linkList.get(0).setPlayer2(formationListPlayers.get(1)); // polaczenie 0 - CB
        linkList.get(0).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(1).setPlayer1(formationListPlayers.get(1)); // polaczenie 1 - CB
        linkList.get(1).setPlayer2(formationListPlayers.get(2)); // polaczenie 1 - CM
        linkList.get(1).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(2).setPlayer1(formationListPlayers.get(2));
        linkList.get(2).setPlayer2(formationListPlayers.get(3));
        linkList.get(2).calculateChemistryLink();
        linkList.get(3).setPlayer1(formationListPlayers.get(2));
        linkList.get(3).setPlayer2(formationListPlayers.get(4));
        linkList.get(3).calculateChemistryLink();
        linkList.get(4).setPlayer1(formationListPlayers.get(3));
        linkList.get(4).setPlayer2(formationListPlayers.get(4));
        linkList.get(4).calculateChemistryLink();

        formationListPlayers.get(0).calculateChemistryLinks(linkList.get(0)); // zgranie GK - z polaczenia 0
        formationListPlayers.get(1).calculateChemistryLinks(linkList.get(0), linkList.get(1)); // zgranie CB - z polaczen 0 i 1
        formationListPlayers.get(2).calculateChemistryLinks(linkList.get(1), linkList.get(2), linkList.get(3)); // zgranie CM - z polaczen 1,2,3
        formationListPlayers.get(3).calculateChemistryLinks(linkList.get(2), linkList.get(4));
        formationListPlayers.get(4).calculateChemistryLinks(linkList.get(3), linkList.get(4));

        // Kolory polaczen
        for (int i = 0; i < linkList.size(); i++) {
            linkList.get(i).setColor();
        }

        for (int i = 0; i < formationListPlayers.size(); i++) {
            Log.d("Test FORMATION:", "Zgranie pilkarzy z polaczen " + Integer.toString(i) + ": " + formationListPlayers.get(i).getChemistryLinks().toString()+"\n");
        }

        for (int i = 0; i < linkList.size(); i++) {
            Log.d("Test FORMATION:", "Sila polaczenia " + Integer.toString(i) + ": " + linkList.get(i).getLink().toString()+"\n");
        }

        // ---------------------------------------------------------------

        // Zgranie calkowite pilkarza
        for (int i = 0; i < formationListPlayers.size(); i++) {
            formationListPlayers.get(i).calculateChemistryTotal();
            Log.d("Test FORMATION:", "Zgranie calkowite pilkarza " + Integer.toString(i) + ": " + formationListPlayers.get(i).getChemistry().toString()+"\n");
        }

        // Zgranie i ocena zespolu
        squadRating = 0;
        squadChemistry = 0;
        for (int i = 0; i < formationListPlayers.size(); i++) {
            squadRating +=  formationListPlayers.get(i).getRating();
            squadChemistry +=  formationListPlayers.get(i).getChemistry();
        }
        squadRating = (int)round((double)squadRating/5.0);
        squadChemistry = (int)round(squadChemistry/5.0);
        Log.d("Test FORMATION:", "Imie gracza: " + MainActivity.sharedName.getString(MainActivity.NAME, "") +"\n");
        Log.d("Test FORMATION:", "Ocena zespolu: " + squadRating.toString()+"\n");
        Log.d("Test FORMATION:", "Zgranie zespolu: " + squadChemistry.toString()+"\n");
    }
}