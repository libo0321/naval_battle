package Annexe;
import Ship.*;

public class ShipState{
    private AbstractShip ship_here;
    private boolean struck;

    public ShipState(){
        ship_here = null;
    }

    public void addStrick() {
        if (!struck) { //prevent attack at the same position two times
            struck = true;
            ship_here.addStrike();
        }
    }

    public void setShip(AbstractShip ship) { ship_here = ship;}

    public boolean isStruck() { return struck; }

    @Override
    public String toString() {
        if (struck) return ColorUtil.colorize("Ship label : "+ship_here.getLabel(), ColorUtil.Color.RED);
        else return "Ship label : "+ship_here.getLabel();
    }

    public boolean isSunk() { return ship_here.isSunk(); }

    public AbstractShip getShip() { return ship_here; }

}