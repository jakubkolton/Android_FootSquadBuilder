package pl.wel.wat.edu.footsquadbuilder;

public class Link {

    private PlayerCard player1;
    private PlayerCard player2;

    private Integer link; // sila zgrania

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

    public void calculateChemistryLink() {
        Integer score = 0;

        if(player1.getLeague() == player2.getLeague())
            score += 30;
        if (player1.getNationality() == player2.getNationality())
            score += 30;
        if (player1.getClub() == player2.getClub())
            score += 30;

        if (score > 60)
            score = 60;

        this.link = score;
    }

}
