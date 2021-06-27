import java.awt.*;

public class NinjaCat extends Critter{
    private boolean infected;

    public NinjaCat() {
        infected = false;
        getColor();
    }

    public Color getColor() {
        if (infected) {
            return Color.BLACK;

        }else {
            return Color.MAGENTA;
        }
    }

    public String toString() {
        if (infected) {
            return "NJC";
        } else {
            return "njc";
        }
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            infected = true;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
    }
