package pl.wel.wat.edu.footsquadbuilder;

public class Player {

    private Integer id;
    private Integer position;
    private String nationality;
    private String league;
    private String club;
    private Integer rating;
    private boolean leader;

    // Konstruktor
    public Player(Integer id, Integer position, String nationality, String league, String club, Integer rating, boolean leader) {
        this.id = id;
        this.position = position;
        this.nationality = nationality;
        this.league = league;
        this.club = club;
        this.rating = rating;
        this.leader = leader;
    }

    // Konstruktor domyslny (zeby dalo sie dziedziczyc)
    public Player() {
        this.id = 98765;
        this.position = 1;
        this.nationality = "Poland";
        this.league = "Premier League";
        this.club = "Arsenal";
        this.rating = 25;
        this.leader = false;
    }

    // Settery i Gettery
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public boolean isLeader() {
        return leader;
    }
    public void setLeader(boolean leader) {
        this.leader = leader;
    }
}
