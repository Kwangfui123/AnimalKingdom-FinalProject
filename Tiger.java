import java.awt.*;
import java.util.*;

public class Tiger extends Critter {
    private int colorMoves;
    Color TigerColor;
    Random Rand = new Random();

    public Tiger() {
        colorMoves = 0;
        getColor();
    }

    //Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
    // then randomly picks one of those colors again for the next three moves, then randomly picks another one of
    // those colors for the next three moves, and so on.
    public Color getColor() {
        int rand;
        if (colorMoves % 3 == 0) {
            rand = (int) (Math.random() * 2);
            if (rand == 0) {
                TigerColor = Color.RED;
            }
            if (rand == 1) {
                TigerColor = Color.BLUE;
            }
            if (rand == 2) {
                TigerColor = Color.GREEN;
            }
        }
        return TigerColor;
    }

    public String toString() {
        return "TGR";
    }

    /*always infect if an enemy is in front, otherwise if a wall is in front or
    to the right, then turn left, otherwise if a fellow Tiger is in front, then
    turn right, otherwise hop.*/
    public Action getMove(CritterInfo info) {
        colorMoves++;
        if (info.getFront()==Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront()==Neighbor.WALL || info.getRight()==Neighbor.WALL) {
            return Action.LEFT;
        }
        else if (info.getFront()==Neighbor.SAME) {
            return Action.RIGHT;
        }
        else {
            return Action.HOP;
        }

    }
}

