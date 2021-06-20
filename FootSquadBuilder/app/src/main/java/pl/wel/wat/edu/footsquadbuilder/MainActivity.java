package pl.wel.wat.edu.footsquadbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Player> playersDB = new ArrayList<>(); // czy to nie powinno byc static, zeby bylo dostepne wszedzie?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View startButton = findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

        // Pobranie bazy danych z pliku JSON do pola playersDB
        addItemsFromJsonArray();

        // testy pobierania bazy - UWAGA! W BAZIE PILKARZE MAJA ID OD 1 DO 100, ALE LISTA INDEKSOWANA JEST OD 0 DO 99
//        for (int i = 0; i < 100; i++) {
//            Log.d("Proba:", playersDB.get(i).getName());
//        }
    }

    public static List<Player> getPlayersDB() {
        return playersDB;
    }

    // Metoda pobierajaca baze danych z pliku JSON do Stringa
    private String JsonFileToString() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.player_json_database);
            BufferedReader bufferedReader = null;
            try {
//                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "windows-1250"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    if (!((jsonString = bufferedReader.readLine()) != null))
                        break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                builder.append(jsonString);
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        return new String(builder);
    }

    // Uzupelnianie listy elementami z listy typu JSONArray
    private void addItemsFromJsonArray() {

        try {
            String jsonDataString = JsonFileToString();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);

                Integer id = Integer.parseInt(itemObj.getString("id"));
                String name = itemObj.getString("name");
                Integer position = Integer.parseInt(itemObj.getString("position"));
                String nationality = itemObj.getString("nationality");
                String league = itemObj.getString("league");
                String club = itemObj.getString("club");
                Integer rating = Integer.parseInt(itemObj.getString("rating"));

                Player player = new Player(id, name, position, nationality, league, club, rating);
                playersDB.add(player);
            }

        } catch (JSONException | IOException e) {
            Log.d("JSONException | IOException", "addItemsFromJSON: ", e);
        }
    }


}