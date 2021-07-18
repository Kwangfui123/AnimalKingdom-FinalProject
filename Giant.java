import java.awt.*;

public class Giant extends Critter {
    private int move;

    public Giant() {
        move = 1;
        getColor();
    }

    public Color getColor() {
        return Color.GRAY;
    }

    //"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
    public String toString() {
        if (move > 18) {
            move = 1;
        } else if (move <= 6) {
            return "fee";
        } else if (move <= 12) {
            return "fie";
        }
        return "fum";
    }

    //	always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
    public Action getMove(CritterInfo info) {
        move++;
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        }
        else{
            return Action.RIGHT;
        }
    }
}




