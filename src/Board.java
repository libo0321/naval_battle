import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import Ship.*;

public class Board implements IBoard{
    private String name;
    private ShipState[][] navires;
    private Hit[][] frappes;
    private int length;
    private int width;

    public Board(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
        navires = new ShipState[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                navires[i][j] = new ShipState();

        frappes = new Hit[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                frappes[i][j] = Hit.NOT;

    }

    public Board(String name){
        this(name, 10, 10);
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setMName(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return width * length;
    }

    @Override
    public boolean hasShip(int x, int y){
        if (navires[x][y].getShip() != null) return true;
        else return false;
    }

    public void setHit(boolean hit, int x, int y){
        if(hit) frappes[x][y] = Hit.STIKE;
    }

    public boolean getHit(int x, int y){
        if (frappes[x][y] == Hit.MISS) return false;
        else return true;
    }

    @Override
    public boolean putShip(AbstractShip ship, int x, int y){
        if (!(x<0 || y<0 || x>=length || y>=width)) {
            int i = 0;
            switch (ship.getOrientation()) {
                case EAST:
                    if (x - ship.getTaille() >= -1) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()){
                            if (navires[x-i][y].getShip() != (AbstractShip)null ) {return false;}
                            i++;
                        }
                        //if there is no ship
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x-j][y].setShip(ship);
                    }
                    else return false;
                    break;

                case WEST:
                    if (x + ship.getTaille() <= length) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()){
                            if (navires[x+i][y].getShip() !=(AbstractShip)null ) {return false;}
                            i++;
                        }
                        //if there is no ship
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x+j][y].setShip(ship);
                    }
                    else return false;
                    break;

                case NORTH:
                    if (y + ship.getTaille() <= width) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()){
                            if (navires[x][y+i].getShip() !=(AbstractShip)null ) {return false;}
                            i++;
                        }
                        //if there is no ship
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x][y+j].setShip(ship);
                    }
                    else return false;
                    break;

                case SOUTH:
                    if (y - ship.getTaille() >= -1) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()){
                            if (navires[x][y-i].getShip() !=(AbstractShip)null ) {return false;}
                            i++;
                        }
                        //if there is no ship
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x][y-j].setShip(ship);
                    }
                    else return false;
                    break;
            }
            return true;
        }
        else return false;
    }

    /**
     * print the table Navires and Frappes
     */
    public void print(){
        char begin_letter='A';
        System.out.println("Navires : " );
        System.out.print("  ");
        for (int i=(int)begin_letter; i<(int)begin_letter+length; i++){
            System.out.print(" "+(char)i);
        }
        System.out.print("\n");
        for (int j = 1; j<=width; j++){
            System.out.print(j);

            if (j<10) System.out.print("  "); //make sure the table is aligned
            else System.out.print(" ");

            for (int i = 0; i < length; i++){
                if(navires[i][j-1].getShip() == null)
                    System.out.print(". ");
                else System.out.print("S ");
            }
            System.out.print("\n");
        }
        System.out.println("Frappes : " );
        System.out.print("  ");
        for (int i=(int)begin_letter; i<(int)begin_letter+length; i++){
            System.out.print(" "+(char)i);
        }
        System.out.print("\n");
        for (int j = 1; j<=width; j++){
            System.out.print(j);

            if (j<10) System.out.print("  "); //make sure the table is aligned
            else System.out.print(" ");

            for (int i = 0; i < length; i++){
                switch (frappes[i][j-1]) {
                    case MISS:
                        System.out.print("X ");
                        break;
                    case NOT:
                        System.out.print(". ");
                        break;
                    default:
                        System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
                }
            }
            System.out.print("\n");
        }
    }


}
