package pl.wel.wat.edu.footsquadbuilder;

import android.view.View;

public class Link {

    private PlayerCard player1;
    private PlayerCard player2;

    private Integer link; // sila zgrania

    private View viewLink; // widok kolorowej kreski zgrania

    // Gettery i Settery
    public PlayerCard getPlayer1() {
        return player1;
    }
    public void setPlayer1(PlayerCard player1) {
        this.player1 = player1;
    }
    public PlayerCard getPlayer2() {
        return player2;
    }
    public void setPlayer2(PlayerCard player2) {
        this.player2 = player2;
    }
    public Integer getLink() {
        return link;
    }
    public void setLink(Integer link) {
        this.link = link;
    }
    public View getViewLink() {
        return viewLink;
    }
    public void setViewLink(View viewLink) {
        this.viewLink = viewLink;
    }

    public void calculateChemistryLink() {
        Integer score = 0;

        if(player1.getLeague().equals(player2.getLeague()))
            score += 30;
        if (player1.getNationality().equals(player2.getNationality()))
            score += 30;
        if (player1.getClub().equals(player2.getClub()))
            score += 30;

        if (score > 60)
            score = 60;

        this.link = score;
    }

    // Metoda ustawiajaca kolory polaczen
    public void setColor (){

        switch (link) {
            case 60:
                viewLink.setBackgroundResource(R.color.green);
                break;
             case 30:
                viewLink.setBackgroundResource(R.color.orange);
                break;
             case 0:
                viewLink.setBackgroundResource(R.color.red);
                break;
        }
    }

}
