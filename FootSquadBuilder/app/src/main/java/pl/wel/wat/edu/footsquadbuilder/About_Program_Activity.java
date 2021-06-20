package pl.wel.wat.edu.footsquadbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class About_Program_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_program);


        // testy pobierania bazy - UWAGA! W BAZIE PILKARZE MAJA ID OD 1 DO 100, ALE LISTA INDEKSOWANA JEST OD 0 DO 99
//        List<Player> playersDB = MainActivity.getPlayersDB();
//        for (int i = 0; i < 100; i++) {
//            Log.d("Proba INFO:", playersDB.get(i).getName());
//        }
    }


}