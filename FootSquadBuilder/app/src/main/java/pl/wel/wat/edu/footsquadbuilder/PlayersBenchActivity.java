package pl.wel.wat.edu.footsquadbuilder;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlayersBenchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_bench_list);

        PlayerDatabse databse = FootSquadBuilderApplication.getINSTANCE();

        // Testy
//        Player testowy = MainActivity.getPlayersDB().get(1);
//        List<Player> playersBenchList = new ArrayList<>();
//        playersBenchList.add(testowy);
//        Log.d("Proba LAWKA:", playersBenchList.get(0).getName());


        PlayersListAdapter playersListAdapter = new PlayersListAdapter(HomeActivity.getPlayersBenchList());
        RecyclerView rvPlayers = (RecyclerView)findViewById(R.id.rvPlayersBenchList_view);
        rvPlayers.setAdapter(playersListAdapter);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
    }
}
