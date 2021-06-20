package pl.wel.wat.edu.footsquadbuilder;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {

    @PrimaryKey (autoGenerate = false)
    private Integer id;
    private String name;
    private Integer position; // 1 - GK, 2 - CB, 3 - CM, 4 - ST
    private String nationality;
    private String league;
    private String club;
    private Integer rating;

    // Konstruktor
    public Player(Integer id, String name, Integer position, String nationality, String league, String club, Integer rating) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.nationality = nationality;
        this.league = league;
        this.club = club;
        this.rating = rating;
    }

    // Konstruktor domyslny (zeby dalo sie dziedziczyc)
    public Player() {
        this.id = 98765;
        this.name = "Player";
        this.position = 1;
        this.nationality = "Poland";
        this.league = "Premier League";
        this.club = "Arsenal";
        this.rating = 25;
    }

    // Settery i Gettery
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getLeague() {
        return league;
    }
    public void setLeague(String league) {
        this.league = league;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
