import java.awt.*;

public class WhiteTiger extends Critter{

    private boolean infected;


    public WhiteTiger() {
        infected = false;
        getColor();

    }

    public Color getColor() {
        return Color.WHITE;
    }
    //	"tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected.
    public String toString() {
        if (infected == true) {return "TGR";}
        else {return "tgr";}
    }
    //e	Same as a Tiger. Note: you’ll have to override this method to figure out if it has infected another Critter.
    public Action getMove(CritterInfo info){
        if(info.getFront()==Neighbor.OTHER){
            infected=true;
            return Action.INFECT;
        }
        else if(info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        }
        else if(info.getFront()==Neighbor.SAME){
            return Action.RIGHT;
        }
        else{
            return Action.HOP;
        }
    }
}
