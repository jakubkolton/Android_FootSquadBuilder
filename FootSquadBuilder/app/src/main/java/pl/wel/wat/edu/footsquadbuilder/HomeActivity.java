package pl.wel.wat.edu.footsquadbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.wel.wat.edu.footsquadbuilder.databinding.ActivityHomeBinding;

import static java.lang.Math.random;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    public static List<Player> playersBenchList;
    public static List<Player> playersRandomizedList;

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
        // testy
//        Player testowy = MainActivity.getPlayersDB().get(1);
//        playersBenchList.add(testowy);

        PlayersListAdapter playersListAdapter = new PlayersListAdapter(playersRandomizedList);
        RecyclerView rvPlayers = (RecyclerView)findViewById(R.id.rvPlayersRandomizedList_view);
        rvPlayers.setAdapter(playersListAdapter);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));

        playersRandomization(rvPlayers);

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
    // PAMIETAC O SPRAWDZENIU ID-KOW PILKARZY, ZEBY SIE DUBLOWALI
    public void playersRandomization(RecyclerView rvPlayers) {

        // testy
//        Player testowy = MainActivity.getPlayersDB().get(1);
//        playersBenchList.add(testowy);
//        testowy = MainActivity.getPlayersDB().get(2);
//        playersBenchList.add(testowy);



        int ID;
        Player randomPlayer;
        // Losowanie 2 GK, 2 CB, 2 CM, 2 ST
        for (int j = 1; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 3; k++) {
                    do {
                        ID = (int)(random()*99 + 1);
                        randomPlayer = MainActivity.getPlayersDB().get(ID);
                    } while (randomPlayer.getPosition() != j);
                    playersRandomizedList.add(randomPlayer);
                    // Opoznienie wizualne wyswietlania - COS NIE SMIGA I OPOZNIA CALY PROGRAM
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    
                }
//                playersRandomizedList.removeAll();
//                playersBenchList.add(randomPlayer);
            }
        }
    }

    public static List<Player> getPlayersBenchList() {
        return playersBenchList;
    }
}