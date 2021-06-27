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

public class Formation_2_1_1_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    public static List<PlayerCard> formationListPlayers;
    public static List<Link> linkList; // lista zgran

    private static Integer squadRating = 0;
    private static Integer squadChemistry = 0;

    private String cardName;
    private String flag = "";
    private List<Player> data;

    TextView FCscore211ST;
    ImageView FCclub211ST;
    ImageView FCcountry211ST;
    TextView FCpos211ST;
    ImageView FCphoto211ST;
    TextView FCname211ST;

    TextView FCscore211CM;
    ImageView FCclub211CM;
    ImageView FCcountry211CM;
    TextView FCpos211CM;
    ImageView FCphoto211CM;
    TextView FCname211CM;

    TextView FCscore211CB1;
    ImageView FCclub211CB1;
    ImageView FCcountry211CB1;
    TextView FCpos211CB1;
    ImageView FCphoto211CB1;
    TextView FCname211CB1;

    TextView FCscore211CB2;
    ImageView FCclub211CB2;
    ImageView FCcountry211CB2;
    TextView FCpos211CB2;
    ImageView FCphoto211CB2;
    TextView FCname211CB2;

    TextView FCscore211GK;
    ImageView FCclub211GK;
    ImageView FCcountry211GK;
    TextView FCpos211GK;
    ImageView FCphoto211GK;
    TextView FCname211GK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation211);

        // pusta lista 5-elementowa na 5 zawodnikow na boisku i pusta lista 6-elementowa na 6 linii zgrania
        formationListPlayers = new ArrayList<>(5);
        linkList = new ArrayList<>(6);
        for (int i = 0; i < 5; i++) {
            formationListPlayers.add(new PlayerCard());
            linkList.add(new Link());
        }
        linkList.add(new Link());

        // Przypisanie widokow z liniami do linii zgrania
        linkList.get(0).setViewLink(findViewById(R.id.link_211_0));
        linkList.get(1).setViewLink(findViewById(R.id.link_211_1));
        linkList.get(2).setViewLink(findViewById(R.id.link_211_2));
        linkList.get(3).setViewLink(findViewById(R.id.link_211_3));
        linkList.get(4).setViewLink(findViewById(R.id.link_211_4));
        linkList.get(5).setViewLink(findViewById(R.id.link_211_5));


        FCscore211ST = (TextView) findViewById(R.id.textViewFutCardScore_211ST);
        FCclub211ST = (ImageView) findViewById(R.id.imageViewFutCardClub_211ST);
        FCcountry211ST = (ImageView) findViewById(R.id.imageViewFutCardCountry_211ST);
        FCpos211ST = (TextView) findViewById(R.id.textViewFutCardPos_211ST);
        FCphoto211ST = (ImageView) findViewById(R.id.imageViewFutCardPhoto_211ST);
        FCname211ST = (TextView) findViewById(R.id.textViewFutCardName_211ST);

        FCscore211CM = (TextView) findViewById(R.id.textViewFutCardScore_211CM);
        FCclub211CM = (ImageView) findViewById(R.id.imageViewFutCardClub_211CM);
        FCcountry211CM = (ImageView) findViewById(R.id.imageViewFutCardCountry_211CM);
        FCpos211CM = (TextView) findViewById(R.id.textViewFutCardPos_211CM);
        FCphoto211CM = (ImageView) findViewById(R.id.imageViewFutCardPhoto_211CM);
        FCname211CM = (TextView) findViewById(R.id.textViewFutCardName_211CM);

        FCscore211CB1 = (TextView) findViewById(R.id.textViewFutCardScore_211CB1);
        FCclub211CB1 = (ImageView) findViewById(R.id.imageViewFutCardClub_211CB1);
        FCcountry211CB1 = (ImageView) findViewById(R.id.imageViewFutCardCountry_211CB1);
        FCpos211CB1 = (TextView) findViewById(R.id.textViewFutCardPos_211CB1);
        FCphoto211CB1 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_211CB1);
        FCname211CB1 = (TextView) findViewById(R.id.textViewFutCardName_211CB1);

        FCscore211CB2 = (TextView) findViewById(R.id.textViewFutCardScore_211CB2);
        FCclub211CB2 = (ImageView) findViewById(R.id.imageViewFutCardClub_211CB2);
        FCcountry211CB2 = (ImageView) findViewById(R.id.imageViewFutCardCountry_211CB2);
        FCpos211CB2 = (TextView) findViewById(R.id.textViewFutCardPos_211CB2);
        FCphoto211CB2 = (ImageView) findViewById(R.id.imageViewFutCardPhoto_211CB2);
        FCname211CB2 = (TextView) findViewById(R.id.textViewFutCardName_211CB2);

        FCscore211GK = (TextView) findViewById(R.id.textViewFutCardScore_211GK);
        FCclub211GK = (ImageView) findViewById(R.id.imageViewFutCardClub_211GK);
        FCcountry211GK = (ImageView) findViewById(R.id.imageViewFutCardCountry_211GK);
        FCpos211GK = (TextView) findViewById(R.id.textViewFutCardPos_211GK);
        FCphoto211GK = (ImageView) findViewById(R.id.imageViewFutCardPhoto_211GK);
        FCname211GK = (TextView) findViewById(R.id.textViewFutCardName_211GK);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bootom_navigation_211);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        data = MainActivity.getPlayersDB();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-message"));

        CardView cardView211ST = (CardView) findViewById(R.id.CardView_211ST);
        cardView211ST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_211ST";
                startActivity(new Intent(Formation_2_1_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView211CM = (CardView) findViewById(R.id.CardView_211CM);
        cardView211CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_211CM";
                startActivity(new Intent(Formation_2_1_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView211CB1 = (CardView) findViewById(R.id.CardView_211CB1);
        cardView211CB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_211CB1";
                startActivity(new Intent(Formation_2_1_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView211CB2 = (CardView) findViewById(R.id.CardView_211CB2);
        cardView211CB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_211CB2";
                startActivity(new Intent(Formation_2_1_1_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView211GK = (CardView) findViewById(R.id.CardView_211GK);
        cardView211GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = "CardView_211GK";
                startActivity(new Intent(Formation_2_1_1_Activity.this, FormationPlayersListActivity.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_bot_home:
                    Toast.makeText(Formation_2_1_1_Activity.this, "home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_bot_rez:
//                    Toast.makeText(Formation_2_1_1_Activity.this, "rezerwa", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Formation_2_1_1_Activity.this, PlayersBenchActivity.class));
                    break;
                case R.id.nav_bot_list:
                    startActivity(new Intent(Formation_2_1_1_Activity.this, PlayersListActivity.class));
                    break;
            }
            return true;
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
                case "CardView_211ST":
                    FCscore211ST.setText(Integer.toString(player.getRating()));
                    FCname211ST.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto211ST.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto211ST.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos211ST);
                    elementCard.setClubCard(player, FCclub211ST);
                    elementCard.setCountryCard(player, FCcountry211ST);

                    Player player211ST = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard211ST = new PlayerCard(player211ST, 4);
                    formationListPlayers.set(4, playerCard211ST);
                    break;
                case "CardView_211CM":
                    FCscore211CM.setText(Integer.toString(player.getRating()));
                    FCname211CM.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto211CM.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto211CM.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos211CM);
                    elementCard.setClubCard(player, FCclub211CM);
                    elementCard.setCountryCard(player, FCcountry211CM);

                    Player player211CM = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard211CM = new PlayerCard(player211CM, 4);
                    formationListPlayers.set(3, playerCard211CM);
                    break;
                case "CardView_211CB1":
                    FCscore211CB1.setText(Integer.toString(player.getRating()));
                    FCname211CB1.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto211CB1.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto211CB1.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos211CB1);
                    elementCard.setClubCard(player, FCclub211CB1);
                    elementCard.setCountryCard(player, FCcountry211CB1);

                    Player player211CB1 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard211CB1 = new PlayerCard(player211CB1, 3);
                    formationListPlayers.set(1, playerCard211CB1);
                    break;
                case "CardView_211CB2":
                    FCscore211CB2.setText(Integer.toString(player.getRating()));
                    FCname211CB2.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto211CB2.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto211CB2.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos211CB2);
                    elementCard.setClubCard(player, FCclub211CB2);
                    elementCard.setCountryCard(player, FCcountry211CB2);

                    Player player211CB2 = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard211CB2 = new PlayerCard(player211CB2, 2);
                    formationListPlayers.set(2, playerCard211CB2);
                    break;
                case "CardView_211GK":
                    FCscore211GK.setText(Integer.toString(player.getRating()));
                    FCname211GK.setText(player.getName());
                    photoPlayer = "p"+player.getId();
                    contextPhoto = FCphoto211GK.getContext();
                    idPhoto = contextPhoto.getResources().getIdentifier(photoPlayer, "drawable", context.getPackageName());
                    FCphoto211GK.setImageResource(idPhoto);
                    elementCard.setPosCard(player, FCpos211GK);
                    elementCard.setClubCard(player, FCclub211GK);
                    elementCard.setCountryCard(player, FCcountry211GK);

                    Player player211GK = new Player(idClicekCard, player.getName(), player.getPosition(), player.getNationality(),
                            player.getLeague(), player.getClub(), player.getRating());
                    PlayerCard playerCard211GK = new PlayerCard(player211GK, 1);
                    formationListPlayers.set(0, playerCard211GK);


                    break;
            }

            // Test - zakladam, ze bramkarz bedzie ostatni wybrany
            for (int i = 0; i < formationListPlayers.size(); i++) {
                Log.d("Test LINK:", formationListPlayers.get(i).getName()+"\n");
            }

            // POWINNO SIE TO WSZYSTKO ODSWIEZACZ CZESCIEJ
            refreshLinksAndRating();
        }
    };

    // Metoda liczaca zgranie
    @SuppressLint("ResourceAsColor")
    public static void refreshLinksAndRating() {

        // Zgrania z pozycji
        for (int i = 0; i < formationListPlayers.size(); i++) {
            formationListPlayers.get(i).calculateChemistryPosition();
            Log.d("Test FORMATION:", "Zgranie z pozycji " + Integer.toString(i) + ": " + formationListPlayers.get(i).getChemistryPosition().toString()+"\n");
        }
//
//        // Zgrania z polaczen ---------------------------------------------------------------
        linkList.get(0).setPlayer1(formationListPlayers.get(0)); // polaczenie 0 - GK
        linkList.get(0).setPlayer2(formationListPlayers.get(1)); // polaczenie 0 - CB lewy
        linkList.get(0).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(1).setPlayer1(formationListPlayers.get(0)); // polaczenie 1 - GK
        linkList.get(1).setPlayer2(formationListPlayers.get(2)); // polaczenie 1 - CB prawy
        linkList.get(1).calculateChemistryLink(); // liczy zgranie z polaczenia
        linkList.get(2).setPlayer1(formationListPlayers.get(1));
        linkList.get(2).setPlayer2(formationListPlayers.get(2));
        linkList.get(2).calculateChemistryLink();
        linkList.get(3).setPlayer1(formationListPlayers.get(1));
        linkList.get(3).setPlayer2(formationListPlayers.get(3));
        linkList.get(3).calculateChemistryLink();
        linkList.get(4).setPlayer1(formationListPlayers.get(2));
        linkList.get(4).setPlayer2(formationListPlayers.get(3));
        linkList.get(4).calculateChemistryLink();
        linkList.get(5).setPlayer1(formationListPlayers.get(3));
        linkList.get(5).setPlayer2(formationListPlayers.get(4));
        linkList.get(5).calculateChemistryLink();

        formationListPlayers.get(0).calculateChemistryLinks(linkList.get(0), linkList.get(1)); // zgranie GK - z polaczen 0 i 1
        formationListPlayers.get(1).calculateChemistryLinks(linkList.get(0), linkList.get(2), linkList.get(3)); // zgranie CB lewy - z polaczen 0,2,3
        formationListPlayers.get(2).calculateChemistryLinks(linkList.get(1), linkList.get(2), linkList.get(4)); // zgranie CB prawy - z polaczen 1,2,4
        formationListPlayers.get(3).calculateChemistryLinks(linkList.get(3), linkList.get(4), linkList.get(5));
        formationListPlayers.get(4).calculateChemistryLinks(linkList.get(5));

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