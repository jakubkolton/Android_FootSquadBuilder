package pl.wel.wat.edu.footsquadbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Formation_2_1_1_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation211);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bootom_navigation_211);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_bot_home:
                    Toast.makeText(Formation_2_1_1_Activity.this, "home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_bot_rez:
                    Toast.makeText(Formation_2_1_1_Activity.this, "rezerwa", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_bot_list:
                    Toast.makeText(Formation_2_1_1_Activity.this, "lista", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };
}