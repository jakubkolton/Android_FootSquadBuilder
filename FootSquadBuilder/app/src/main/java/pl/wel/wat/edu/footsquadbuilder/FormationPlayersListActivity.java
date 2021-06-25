package pl.wel.wat.edu.footsquadbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class FormationPlayersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation_players_list2);

        List<Player> data = HomeActivity.playersBenchList;

        FormationPlayersListAdapter formationPlayersListAdapter = new FormationPlayersListAdapter(data);
        RecyclerView rvFormationPlayers = (RecyclerView)findViewById(R.id.rvPlayersFormationList_view);
        rvFormationPlayers.setAdapter(formationPlayersListAdapter);
        rvFormationPlayers.setLayoutManager(new LinearLayoutManager(this));
    }
}