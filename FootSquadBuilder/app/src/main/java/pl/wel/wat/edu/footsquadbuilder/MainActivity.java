package pl.wel.wat.edu.footsquadbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

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

    private static List<Player> playersDB = new ArrayList<>();

    // Shared preferences na imie gracza
    public static String NAZWA_PLIKU = "sharedName"; // nazwa pliku przechowujacego dane
    public static String NAME = "name"; // zmienna, kontener na dane - imie
    public static SharedPreferences sharedName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Odczyt imienia z Shared Preferences
        EditText editTextImie = (EditText)findViewById(R.id.EditTextImie); // czasem trzeba dodac final
        sharedName = getSharedPreferences(MainActivity.NAZWA_PLIKU, MODE_PRIVATE);
        String name = sharedName.getString(MainActivity.NAME, "");
        if (name.length() != 0) { // jesli odczytano imie z SharedPreferences
            editTextImie.setText(name);
        }

        View startButton = findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextImie.length() != 0) { // Jesli podano imie, zapisz je w SharedPreferences i uruchom kolejna aktywnosc
                    SharedPreferences.Editor editor = sharedName.edit();
                    editor.putString(NAME, editTextImie.getText().toString());
                    editor.apply();

                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Podaj imię!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Pobranie bazy danych z pliku JSON do pola playersDB
        addItemsFromJsonArray();

        // testy pobierania bazy - UWAGA! W BAZIE PILKARZE MAJA ID OD 1 DO 100, ALE LISTA INDEKSOWANA JEST OD 0 DO 99
        for (int i = 0; i < 100; i++) {
            Log.d("Proba:", playersDB.get(i).getName());
        }

        //animacja logo
            YoYo.with(Techniques.SlideInUp)
                    .duration(2137)
                    .playOn(findViewById(R.id.textView));
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