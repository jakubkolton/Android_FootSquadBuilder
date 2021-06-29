package pl.wel.wat.edu.footsquadbuilder;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("Select * FROM Player")
    List<Player> getAll();

    @Insert
    long saveInDatabase(Player player);


}
