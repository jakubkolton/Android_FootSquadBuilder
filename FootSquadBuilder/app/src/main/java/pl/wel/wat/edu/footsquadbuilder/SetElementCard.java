package pl.wel.wat.edu.footsquadbuilder;

import android.widget.ImageView;
import android.widget.TextView;

public class SetElementCard {
    public void setPosCard(Player player, TextView card){
        switch (player.getPosition()){
            case 1:
                card.setText("GK");
                break;
            case 2:
                card.setText("CB");
                break;
            case 3:
                card.setText("CM");
                break;
            case 4:
                card.setText("ST");
                break;
        }
    }

    public void setClubCard(Player player, ImageView card) {
        switch (player.getClub()) {
            case "Angers_SCO":
                card.setImageResource(R.drawable.angers_sco);
                break;
            case "Arsenal":
                card.setImageResource(R.drawable.arsenal);
                break;
            case "AS_Monaco":
                card.setImageResource(R.drawable.as_monaco);
                break;
            case "Atletico ":
                card.setImageResource(R.drawable.atletico);
                break;
            case "Bayern":
                card.setImageResource(R.drawable.bayern);
                break;
            case "Borussia_Dortmund":
                card.setImageResource(R.drawable.borussia_dortmund);
                break;
            case "Borussia_M_gladbach":
                card.setImageResource(R.drawable.borussia_m_gladbach);
                break;
            case "Celta_de_Vigo":
                card.setImageResource(R.drawable.celta_de_vigo);
                break;
            case "Chelsea":
                card.setImageResource(R.drawable.chelsea);
                break;
            case "Eintracht_Frankfurt":
                card.setImageResource(R.drawable.eintracht_frankfurt);
                break;
            case "FC_Barcelona":
                card.setImageResource(R.drawable.fc_barcelona);
                break;
            case "Genoa":
                card.setImageResource(R.drawable.genoa);
                break;
            case "Girondins_de_Bordeaux":
                card.setImageResource(R.drawable.girondins_de_bordeaux);
                break;
            case "Hoffenheim":
                card.setImageResource(R.drawable.hoffenheim);
                break;
            case "Inter":
                card.setImageResource(R.drawable.inter);
                break;
            case "Lazio":
                card.setImageResource(R.drawable.lazio);
                break;
            case "Leicester_City":
                card.setImageResource(R.drawable.leicester_city);
                break;
            case "Liverpool":
                card.setImageResource(R.drawable.liverpool);
                break;
            case "LOSC_Lille":
                card.setImageResource(R.drawable.losc_lille);
                break;
            case "Manchester_City ":
                card.setImageResource(R.drawable.manchester_city);
                break;
            case "Manchester_United":
                card.setImageResource(R.drawable.manchester_united);
                break;
            case "Milan":
                card.setImageResource(R.drawable.milan);
                break;
            case "Napoli":
                card.setImageResource(R.drawable.napoli);
                break;
            case "Olympique_de_Marsille":
                card.setImageResource(R.drawable.olympique_de_marsille);
                break;
            case "Olympique_Lyonnais":
                card.setImageResource(R.drawable.olympique_lyonnais);
                break;
            case "Paris_Saint_Germain":
                card.setImageResource(R.drawable.paris_saint_germain);
                break;
            case "Piemonte_Calcio":
                card.setImageResource(R.drawable.piemonte_calcio);
                break;
            case "RB_Leipzig":
                card.setImageResource(R.drawable.rb_leipzig);
                break;
            case "Real_Madrid":
                card.setImageResource(R.drawable.real_madrid);
                break;
            case "Sassuolo":
                card.setImageResource(R.drawable.sassuolo);
                break;
            case "Sevilla":
                card.setImageResource(R.drawable.sevilla);
                break;
            case "Tottenham_Hotspur":
                card.setImageResource(R.drawable.tottenham_hotspur);
                break;
            case "Vfl_Wolfsburg":
                card.setImageResource(R.drawable.vfl_wolfsburg);
                break;
            case "Villareal":
                card.setImageResource(R.drawable.villareal);
                break;
        }
    }

    public void setCountryCard(Player player, ImageView card) {
        switch (player.getNationality()){
            case "Anglia":
                card.setImageResource(R.drawable.anglia);
                break;
            case "Argentyna":
                card.setImageResource(R.drawable.argentyna);
                break;
            case "Austria":
                card.setImageResource(R.drawable.austria);
                break;
            case "Belgia":
                card.setImageResource(R.drawable.belgia);
                break;
            case "Brazylia":
                card.setImageResource(R.drawable.brazylia);
                break;
            case "Chorwacja":
                card.setImageResource(R.drawable.chorwacja);
                break;
            case "Dania":
                card.setImageResource(R.drawable.dania);
                break;
            case "Francja":
                card.setImageResource(R.drawable.francja);
                break;
            case "Hiszpania":
                card.setImageResource(R.drawable.hiszpania);
                break;
            case "Holandia":
                card.setImageResource(R.drawable.holandia);
                break;
            case "Kongo":
                card.setImageResource(R.drawable.kongo);
                break;
            case "Niemiec":
                card.setImageResource(R.drawable.niemiec);
                break;
            case "Norwegia":
                card.setImageResource(R.drawable.norwegia);
                break;
            case "Polska":
                card.setImageResource(R.drawable.polska);
                break;
            case "Portugalia":
                card.setImageResource(R.drawable.portugalia);
                break;
            case "Senegal":
                card.setImageResource(R.drawable.senegal);
                break;
            case "Serbia":
                card.setImageResource(R.drawable.serbia);
                break;
            case "Slowacja":
                card.setImageResource(R.drawable.slowacja);
                break;
            case "Slowenia":
                card.setImageResource(R.drawable.slowenia);
                break;
            case "Szwajcaria":
                card.setImageResource(R.drawable.szwajcaria);
                break;
            case "Szwecja":
                card.setImageResource(R.drawable.szwecja);
                break;
            case "Urugwaj":
                card.setImageResource(R.drawable.urugwaj);
                break;
            case "Wegry":
                card.setImageResource(R.drawable.wegry);
                break;
            case "Wlochy":
                card.setImageResource(R.drawable.wlochy);
                break;
        }
    }
}
