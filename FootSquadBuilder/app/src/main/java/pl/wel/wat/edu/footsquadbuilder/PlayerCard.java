package pl.wel.wat.edu.footsquadbuilder;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class PlayerCard extends Player{

    private Integer positionSet; // na jakiej pozycji ustawiony

    private Integer chemistry; // zgranie calkowite
    private Integer chemistryPosition; // zgranie z pozycji
    private Integer chemistryLinks; // zgranie z polaczen

    // Konstruktor - wywolywac go z parametrami - getterami klasy Player
    public PlayerCard(Integer id, Integer position, String nationality, String league, String club, Integer rating, boolean leader, Integer positionSet) {
        super(id, position, nationality, league, club, rating, leader);
        this.positionSet = positionSet;
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

    // Oblicza zgranie z polaczen; Przeciazenie funkcji dla 3 ilosci polaczen
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
}