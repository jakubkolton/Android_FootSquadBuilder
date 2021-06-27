package pl.wel.wat.edu.footsquadbuilder;

import static java.lang.Math.abs;
import static java.lang.Math.random;
import static java.lang.Math.round;

public class PlayerCard extends Player{

    private Integer positionSet; // na jakiej pozycji ustawiony

    private Integer chemistry; // zgranie calkowite
    private Integer chemistryPosition; // zgranie z pozycji
    private Integer chemistryLinks; // zgranie z polaczen

    // Konstruktor - wywolywac go z parametrami - getterami klasy Player
    public PlayerCard(Integer id, String name, Integer position, String nationality, String league, String club, Integer rating, Integer positionSet) {
        super(id, name, position, nationality, league, club, rating);
        this.positionSet = positionSet;
    }

    // Konstruktor - wywolywany na obiekcie klasy Player
    public PlayerCard (Player player, Integer positionSet) {
        super(player.getId(), player.getName(), player.getPosition(), player.getNationality(), player.getLeague(), player.getClub(), player.getRating());
        this.positionSet = positionSet;
    }

    // Konstruktor domyslny - wypluwa "smieciowych" pilkarzy, ktorzy nie beda mieli zgrania
    public PlayerCard() {
        super(101, "Player", 6, String.valueOf(random()),  String.valueOf(random()),  String.valueOf(random()), 0);
        this.positionSet = 9;
        this.setChemistryPosition(0);
        this.setChemistryLinks(0);
        this.setChemistry(0);
    }


    // Gettery i Settery
    public Integer getPositionSet() {
        return positionSet;
    }
    public void setPositionSet(Integer positionSet) {
        this.positionSet = positionSet;
    }
    public Integer getChemistry() {
        return chemistry;
    }
    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }
    public Integer getChemistryPosition() {
        return chemistryPosition;
    }
    public void setChemistryPosition(Integer chemistryPosition) {
        this.chemistryPosition = chemistryPosition;
    }
    public Integer getChemistryLinks() {
        return chemistryLinks;
    }
    public void setChemistryLinks(Integer chemistryLinks) {
        this.chemistryLinks = chemistryLinks;
    }

    // Oblicza zgranie z pozycji
    public void calculateChemistryPosition() {
        Integer score;
        Integer difference = abs(this.positionSet - this.getPosition());

        if (difference == 0) {
            score = 40;
        } else if (difference == 1) {
            score = 20;
        } else {
            score = 0;
        }

        this.chemistryPosition = score;
    }

    // Oblicza zgranie z polaczen; Przeciazenie funkcji dla 3 roznych ilosci polaczen (1,2,3)
    public void calculateChemistryLinks(Link link1) {
        this.chemistryLinks = link1.getLink();
    }
    public void calculateChemistryLinks(Link link1, Link link2) {
        Integer score = (int) round((link1.getLink() + link2.getLink())/2.0);

        this.chemistryLinks = score;
    }
    public void calculateChemistryLinks(Link link1, Link link2, Link link3) {
        Integer score = (int) round((link1.getLink() + link2.getLink() + link3.getLink())/3.0);

        this.chemistryLinks = score;
    }

    // Oblicza calkowite zgranie karty (0-100)
    public void calculateChemistryTotal() {
        this.chemistry = this.chemistryLinks + this.chemistryPosition;
    }
}
