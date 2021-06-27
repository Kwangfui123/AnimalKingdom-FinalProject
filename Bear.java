import java.awt.*;

public class Bear extends Critter{
    private boolean polar;
    private int move;


    public Bear(boolean polar) {
        this.polar = polar;
        getColor();
    }

    public Color getColor() {
        //Color.WHITE for a polar bear, else, color.Black;
        if (this.polar) { return Color.WHITE; }
        else { return Color.BLACK; }
    }

    public String toString() {
        //Should alternate on each different move between a slash character (/)
        // and a backslash character () starting with a slash.
        if (move%2 == 0) { return "/"; }
        else {return "\\"; }
    }

    //always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.


    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;

        } else {
            return super.getMove(info);
        }
    }
}
