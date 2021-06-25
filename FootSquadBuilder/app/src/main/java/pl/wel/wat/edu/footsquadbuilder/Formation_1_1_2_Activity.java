package pl.wel.wat.edu.footsquadbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Formation_1_1_2_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation112);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bootom_navigation_112);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        CardView cardView112ST1 = (CardView) findViewById(R.id.CardView_112ST1);
        cardView112ST1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112ST2 = (CardView) findViewById(R.id.CardView_112ST2);
        cardView112ST2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CM = (CardView) findViewById(R.id.CardView_112CM);
        cardView112CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112CB = (CardView) findViewById(R.id.CardView_112CB);
        cardView112CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formation_1_1_2_Activity.this, FormationPlayersListActivity.class));
            }
        });

        CardView cardView112GK = (CardView) findViewById(R.id.CardView_112GK);
        cardView112GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}