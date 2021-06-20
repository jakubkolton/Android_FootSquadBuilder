package pl.wel.wat.edu.footsquadbuilder;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Player.class}, version =  1)
public abstract class PlayerDatabse extends RoomDatabase {

    public abstract PlayerDao playerDao();
}
