package pl.wel.wat.edu.footsquadbuilder;

import android.app.Application;

import androidx.room.Room;

public class FootSquadBuilderApplication extends Application {
    private static  PlayerDatabse INSTANCE;

    public static PlayerDatabse getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = Room.databaseBuilder(getApplicationContext(), PlayerDatabse.class, "PlayerDatabase").
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
}
