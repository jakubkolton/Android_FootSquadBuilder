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

public class Formation_1_2_1_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    public static List<PlayerCard> formationListPlayers;
    public static List<Link> linkList; // lista zgran

    private static Integer squadRating = 0;
    private static Integer squadChemistry = 0;

    private String cardName;
    private String flag = "";
    private List<Player> data;

    TextView FCscore121ST;
    ImageView FCclub121ST;
    ImageView FCcountry121ST;
    TextView FCpos121ST;
    ImageView FCphoto121ST;
    TextView FCname121ST;

    TextView FCscore121CM1;
    ImageView FCclub121CM1;
    ImageView FCcountry121CM1;
    TextView FCpos121CM1;
    ImageView FCphoto121CM1;
    TextView FCname121CM1;

    TextView FCscore121CM2;
    ImageView FCclub121CM2;
    ImageView FCcountry121CM2;
    TextView FCpos121CM2;
    ImageView FCphoto121CM2;
    TextView FCname121CM2;

    TextView FCscore121CB;
    ImageView FCclub121CB;
    ImageView FCcountry121CB;
    TextView FCpos121CB;
    ImageView FCphoto121CB;
    TextView FCname121CB;

    TextView FCscore121GK;
    ImageView FCclub121GK;
    ImageView FCcountry121GK;
    TextView FCpos121GK;
    ImageView FCphoto121GK;
    TextView FCname121GK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation121);

        // pusta lista 5-elementowa na 5 zawodnikow na boisku i pusta lista 6-elementowa na 6 linii zgrania
        formationListPlayers = new ArrayList<>(5);
        linkList = new ArrayList<>(6);
        for (int i = 0; i < 5; i++) {
            formationListPlayers.add(new PlayerCard());
            linkList.add(new Link());
        }
        linkList.add(new Link());

        // Przypisanie widokow z liniami do linii zgrania
        linkList.get(0).setViewLink(findViewById(R.id.link_121_0));
        linkList.get(1).setViewLink(findViewById(R.id.link_121_1));
        linkList.get(2).setViewLink(findViewById(R.id.link_121_2));
        linkList.get(3).setViewLink(findViewById(R.id.link_121_3));
        linkList.get(4).setViewLink(findViewById(R.id.link_121_4));
        linkList.get(5).setViewLink(findViewById(R.id.link_121_5));


        FCscore121ST = (TextView) findViewById(R.id.textViewFutCardScore_121ST);
        FCclub121ST = (ImageView) findViewById(R.id.imageViewFutCardClub_121ST);
        FCcountry121ST = (ImageView) findViewById(R.id.imageViewFutCardCountry_121ST);
        FCpos121ST = (TextView) findViewById(R.id.textViewFutCardPos_121ST);
        FCphoto121ST = (ImageView) findViewById(R.id.imageViewFutCardPhoto_121ST);
        FCname121ST = (TextView) findViewById(R.id.textViewFutCardName_121ST);

        FCscore121CM1 = (TextView) findViewById(R.id.textViewFutCardScore_121CM1);
        FCclub121CM1 = (ImageView) findViewById(R.id.imageViewFutCardClub_121CM1);
        FCcountry121CM1 = (ImageView) findViewById(R.id.imageViewFutCardCountry_121CM1);
        FCpos121CM1 = (TextView) findViewById(R.id.textViewFutCardPos_121CM1);
        FCphoto121CM1 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_121CM1);
        FCname121CM1 = (TextView) findViewById(R.id.textViewFutCardName_121CM1);

        FCscore121CM2 = (TextView) findViewById(R.id.textViewFutCardScore_121CM2);
        FCclub121CM2 = (ImageView) findViewById(R.id.imageViewFutCardClub_121CM2);
        FCcountry121CM2 = (ImageView) findViewById(R.id.imageViewFutCardCountry_121CM2);
        FCpos121CM2 = (TextView) findViewById(R.id.textViewFutCardPos_121CM2);
        FCphoto121CM2 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_121CM2);
        FCname121CM2 = (TextView) findViewById(R.id.textViewFutCardName_121CM2);

        FCscore121CB = (TextView) findViewById(R.id.textViewFutCardScore_121CB);
        FCclub121CB = (ImageView) findViewById(R.id.imageViewFutCardClub_121CB);
        FCcountry121CB = (ImageView) findViewById(R.id.imageViewFutCardCountry_121CB);
        FCpos121CB = (TextView) findViewById(R.id.textViewFutCardPos_121CB);
        FCphoto121CB = (ImageView) findViewById(R.id.imageViewFutCardPhoto_121CB);
        FCname121CB = (TextView) findViewById(R.id.textViewFutCardName_121CB);

        FCscore121GK = (TextView) findViewById(R.id.textViewFutCardScore_121GK);
        FCclub121GK = (ImageView) findViewById(R.id.imageViewFutCardClub_121GK);
        FCcountry121GK = (ImageView) findViewById(R.id.imageViewFutCardCountry_121GK);
        FCpos121GK = (TextView) findViewById(R.id.textViewFutCardPos_121GK);
        FCphoto121GK = (ImageView) findViewById(R.id.imageViewFutCardPhoto_121GK);
        FCname121GK = (TextView) findViewById(R.id.textViewFutCardName_121GK);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bootom_navigation_121);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        data = MainActivity.getPlayersDB();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));

        CardView cardView121ST = (CardView) findViewById(R.id.CardView_121ST);
        cardView121ST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_121ST";
                startActivity(new Intent(Formation_1_2_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView121CM1 = (CardView) findViewById(R.id.CardView_121CM1);
        cardView121CM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_121CM1";
                startActivity(new Intent(Formation_1_2_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView121CM2 = (CardView) findViewById(R.id.CardView_121CM2);
        cardView121CM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_121CM2";
                startActivity(new Intent(Formation_1_2_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView121CB = (CardView) findViewById(R.id.CardView_121CB);
        cardView121CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_121CB";
                startActivity(new Intent(Formation_1_2_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView121GK = (CardView) findViewById(R.id.CardView_121GK);
        cardView121GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_121GK";
                startActivity(new Intent(Formation_1_2_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_bot_home:
                    Toast.makeText(Formation_1_2_1_Activity.this, "home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_bot_rez:
//                    Toast.makeText(Formation_1_2_1_Activity.this, "rezerwa", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Formation_1_2_1_Activity.this, PlayersBenchActivity.class));
                    break;
                case R.id.nav_bot_list:
                    startActivity(new Intent(Formation_1_2_1_Activity.this, PlayersListActivity.class));
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
                case "CardView_121ST":
                    FCscore121ST.setText(Integer.toString(player.getRating()));
                    FCname121ST.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto121ST.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto121ST.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos121ST);
                    elementCard.setClubCard(player, FCclub121ST);
                    elementCard.setCountryCard(player, FCcountry121ST);

                    Player player121ST = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard121ST = new PlayerCard(player121ST, 4);
                    formationListPlayers.set(4, playerCard121ST);
                    break;
                case "CardView_121CM1":
                    FCscore121CM1.setText(Integer.toString(player.getRating()));
                    FCname121CM1.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto121CM1.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto121CM1.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos121CM1);
                    elementCard.setClubCard(player, FCclub121CM1);
                    elementCard.setCountryCard(player, FCcountry121CM1);

                    Player player121CM1 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard121CM1 = new PlayerCard(player121CM1, 4);
                    formationListPlayers.set(2, playerCard121CM1);
                    break;
                case "CardView_121CM2":
                    FCscore121CM2.setText(Integer.toString(player.getRating()));
                    FCname121CM2.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto121CM2.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto121CM2.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos121CM2);
                    elementCard.setClubCard(player, FCclub121CM2);
                    elementCard.setCountryCard(player, FCcountry121CM2);

                    Player player121CM2 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard121CM2 = new PlayerCard(player121CM2, 3);
                    formationListPlayers.set(3, playerCard121CM2);
                    break;
                case "CardView_121CB":
                    FCscore121CB.setText(Integer.toString(player.getRating()));
                    FCname121CB.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto121CB.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto121CB.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos121CB);
                    elementCard.setClubCard(player, FCclub121CB);
                    elementCard.setCountryCard(player, FCcountry121CB);

                    Player player121CB = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard121CB = new PlayerCard(player121CB, 2);
                    formationListPlayers.set(1, playerCard121CB);
                    break;
                case "CardView_121GK":
                    FCscore121GK.setText(Integer.toString(player.getRating()));
                    FCname121GK.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto121GK.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto121GK.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos121GK);
                    elementCard.setClubCard(player, FCclub121GK);
                    elementCard.setCountryCard(player, FCcountry121GK);

                    Player player121GK = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard121GK = new PlayerCard(player121GK, 1);
                    formationListPlayers.set(0, playerCard121GK);


                    break;
            }

            // Test - zakladam, ze bramkarz bedzie ostatni wybrany
            for (int i = 0; i < formationListPlayers.size(); i++) {
                Log.d("Test LINK:", formationListPlayers.get(i).getName()+"\n");
            }

            refreshLinksAndRating(); // odswiezenie danych o zgraniu po kazdej zmianie w skladzie

        }
    };

    // Metoda liczaca zgranie
    @SuppressLint("ResourceAsColor")
    public static void refreshLinksAndRating() {

//         Zgrania z pozycji
        for (int i = 0; i < formationListPlayers.size(); i++) {
            formationListPlayers.get(i).calculateChemistryPosition();
            Log.d("Test FORMATION:", "Zgranie z pozycji " + Integer.toString(i) + ": " + formationListPlayers.get(i).getChemistryPosition().toString()+"\n");
        }

//         Zgrania z polaczen ---------------------------------------------------------------
        linkList.get(0).setPlayer1(formationListPlayers.get(0)); // polaczenie 0 - GK
        linkList.get(0).setPlayer2(formationListPlayers.get(1)); // polaczenie 0 - CB
        linkList.get(0).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(1).setPlayer1(formationListPlayers.get(1)); // polaczenie 1 - CB
        linkList.get(1).setPlayer2(formationListPlayers.get(2)); // polaczenie 1 - CM lewy
        linkList.get(1).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(2).setPlayer1(formationListPlayers.get(1));
        linkList.get(2).setPlayer2(formationListPlayers.get(3));
        linkList.get(2).calculateChemistryLink();
        linkList.get(3).setPlayer1(formationListPlayers.get(2));
        linkList.get(3).setPlayer2(formationListPlayers.get(3));
        linkList.get(3).calculateChemistryLink();
        linkList.get(4).setPlayer1(formationListPlayers.get(2));
        linkList.get(4).setPlayer2(formationListPlayers.get(4));
        linkList.get(4).calculateChemistryLink();
        linkList.get(5).setPlayer1(formationListPlayers.get(3));
        linkList.get(5).setPlayer2(formationListPlayers.get(4));
        linkList.get(5).calculateChemistryLink();

        formationListPlayers.get(0).calculateChemistryLinks(linkList.get(0)); // zgranie GK - z polaczenia 0
        formationListPlayers.get(1).calculateChemistryLinks(linkList.get(0), linkList.get(1), linkList.get(2)); // zgranie CB - z polaczen 0, 1, 2
        formationListPlayers.get(2).calculateChemistryLinks(linkList.get(1), linkList.get(3), linkList.get(3)); // zgranie CM lewy - z polaczen 1,3,4
        formationListPlayers.get(3).calculateChemistryLinks(linkList.get(2), linkList.get(3), linkList.get(5)); // zgranie CM prawy - z polaczen 2,3,5
        formationListPlayers.get(4).calculateChemistryLinks(linkList.get(4), linkList.get(5));

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
        Log.d("Test FORMATION:", "Ocena zespolu: " + squadRating.toString()+"\n");
        Log.d("Test FORMATION:", "Zgranie zespolu: " + squadChemistry.toString()+"\n");

    }

}