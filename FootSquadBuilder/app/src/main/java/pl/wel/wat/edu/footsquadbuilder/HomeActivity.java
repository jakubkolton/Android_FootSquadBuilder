package pl.wel.wat.edu.footsquadbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.random;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    public static List<Player> playersBenchList;
    public static List<Player> playersRandomizedList;
    public static int noRandomization = 1;
    public static PlayersListAdapter playersListAdapter;

    public static int getNoRandomization() {
        return noRandomization;
    }
    public static void setNoRandomization(int noRandomization) {
        HomeActivity.noRandomization = noRandomization;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.nav_app_bar_open_drawer_description, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                int id = item.getItemId();
                if (id == R.id.nav_formacja121) {
                    startActivity(new Intent(HomeActivity.this, Formation_1_2_1_Activity.class));
                }
                if (id == R.id.nav_formacja112) {
                    startActivity(new Intent(HomeActivity.this, Formation_1_1_2_Activity.class));
                }
                if (id == R.id.nav_formacja211) {
                    startActivity(new Intent(HomeActivity.this, Formation_2_1_1_Activity.class));
                }
                return true;
            }
        });

        playersBenchList = new ArrayList<>();
        playersRandomizedList = new ArrayList<>();


        playersListAdapter = new PlayersListAdapter(playersRandomizedList);
        RecyclerView rvPlayers = (RecyclerView)findViewById(R.id.rvPlayersRandomizedList_view);
        rvPlayers.setAdapter(playersListAdapter);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));

        playersListAdapter.notifyDataSetChanged();

        playersRandomization(noRandomization);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(this, About_Program_Activity.class));
            return true;
        } else if (item.getItemId() == R.id.nav_formacja121) {

            return true;
        } else if (item.getItemId() == R.id.nav_formacja112) {

            return true;

        } else if (item.getItemId() == R.id.nav_formacja211) {

            return true;
        } else {
            return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
        }
    }

    // Metoda procedury losujacej 10 zawodnikow
    // no - numer losowanie 3-elementowego
    public static void playersRandomization(int no) {

        int position = 0;
        int ID;
        Player randomPlayer = new Player();

        if (noRandomization <= 8) { // 8 pierwszych losowan - po 2 na kazda pozycje
            switch (noRandomization) {
                case 1:
                case 5: // GK
                    position = 1;
                    break;
                case 2:
                case 6: // CB
                    position = 2;
                    break;
                case 3:
                case 7: // CM
                    position = 3;
                    break;
                case 4:
                case 8: // ST
                    position = 4;
                    break;
                default:
                    position = 1; // GK, zeby wykryc bledy
                    break;
            }

            for (int k = 0; k < 3; k++) {
                do {
                    ID = (int) (random() * 99 + 1); // ID w bazie danych: 1-100; w liscie 0-99
                    randomPlayer = MainActivity.getPlayersDB().get(ID-1);
                } while ((randomPlayer.getPosition() != position) || (isAlreadyPicked(ID)) || (isAlreadyRandomized(ID)));

            playersRandomizedList.add(randomPlayer);
            }
        } else if (noRandomization <= 10) { // 2 kolejne losowania na dowolna pozycje
            for (int k = 0; k < 3; k++) {
                do {
                    ID = (int) (random() * 99 + 1);
                    randomPlayer = MainActivity.getPlayersDB().get(ID-1);
                } while ((isAlreadyPicked(ID)) || (isAlreadyRandomized(ID)));
                playersRandomizedList.add(randomPlayer);
            }
        } else { // koniec procedury
            sortPlayersBenchList();
            for (int i = 0; i < playersBenchList.size(); i++) {
                Log.d("Test RANDOMIZATION:", playersBenchList.get(i).getName());
            }
        }
    }

    // Metoda sprawdzajaca, czy wylosowany pilkarz znajduje sie juz na lawce rezerwowych
    public static boolean isAlreadyPicked(int id) {

        for (int i = 0; i < playersBenchList.size(); i++) {
            if (playersBenchList.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }

    // Metoda sprawdzajaca, czy wylosowany pilkarz znajduje sie juz na liscie 3 wylosowanych
    public static boolean isAlreadyRandomized(int id) {

        for (int i = 0; i < playersRandomizedList.size(); i++) {
            if (playersRandomizedList.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }

    // Metoda sortujaca liste rezerwowych wg pozycji
    public static void sortPlayersBenchList() {

        // Sortowanie babelkowe
        boolean sorted = false;
        Player temp = new Player();
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < playersBenchList.size() - 1; i++) {
                if (playersBenchList.get(i).getPosition() > playersBenchList.get(i+1).getPosition()) {
                    temp = playersBenchList.get(i);
                    playersBenchList.set(i, playersBenchList.get(i+1));
                    playersBenchList.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }

    public static List<Player> getPlayersBenchList() {
        return playersBenchList;
    }

    public static List<Player> getPlayersRandomizedList() {
        return playersRandomizedList;
    }

    // Resetuje gre po cofnieciu z tej aktywnosc - pozwala zaczac zabawe od nowa
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // czyszczenie danych gry
        playersBenchList.clear();
        playersRandomizedList.clear();
        noRandomization = 1;
    }

}