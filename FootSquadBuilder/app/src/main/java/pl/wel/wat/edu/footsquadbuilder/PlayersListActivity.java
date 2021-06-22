package pl.wel.wat.edu.footsquadbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class PlayersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        PlayerDatabse databse = FootSquadBuilderApplication.getINSTANCE();

        PlayerDao playerDao = databse.playerDao();

        List<Player> data = playerDao.getAll();

        for (Player pl : data) {
            Log.i("Zawodnik: ", pl.toString());
        }

        PlayersListAdapter playersListAdapter = new PlayersListAdapter(data);
        RecyclerView rvPlayers = (RecyclerView)findViewById(R.id.rvPlayersList_view);
        rvPlayers.setAdapter(playersListAdapter);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
    }
}