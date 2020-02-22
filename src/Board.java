import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import Ship.*;

public class Board implements IBoard{
    private String name;
    private char[][] navires;
    private boolean[][] frappes;
    private int length;
    private int width;

    public Board(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
        navires = new char[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                navires[i][j] = '.';

        frappes = new boolean[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                frappes[i][j] = false;
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
        if (navires[x][y] != '.') return true;
        else return false;
    }

    public void setHit(boolean hit, int x, int y){
        frappes[x][y] = hit;
    }

    public Boolean getHit(int x, int y){
        return frappes[x][y];
    }

    @Override
    public void putShip(AbstractShip ship, int x, int y){
        if (!(x<0 || y<0 || x>=length || y>=width)) {
            boolean no_ship = true;
            int i = 0;
            switch (ship.getOrientation()) {
                case EAST:
                    if (x - ship.getTaille() >= -1) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()&&no_ship){
                            if (navires[x-i][y] == 'S') {no_ship = false;}
                            i++;
                        }
                        //if there is no ship
                        if (no_ship)
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x-j][y] = 'S';
                    }
                    break;

                case WEST:
                    if (x + ship.getTaille() <= length) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()&&no_ship){
                            if (navires[x+i][y] == 'S') {no_ship = false;}
                            i++;
                        }
                        //if there is no ship
                        if (no_ship)
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x+j][y] = 'S';
                    }
                    break;

                case NORTH:
                    if (y + ship.getTaille() <= width) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()&&no_ship){
                            if (navires[x][y+i] == 'S') {no_ship = false;}
                            i++;
                        }
                        //if there is no ship
                        if (no_ship)
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x][y+j] = 'S';
                    }
                    break;

                case SOUTH:
                    if (y - ship.getTaille() >= -1) {
                        //test if a ship has occupied the place
                        while (i < ship.getTaille()&&no_ship){
                            if (navires[x][y-i] == 'S') {no_ship = false;}
                            i++;
                        }
                        //if there is no ship
                        if (no_ship)
                            for (int j = 0; j<ship.getTaille(); j++)
                                navires[x][y-j] = 'S';
                    }
                    break;
            }
        }
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
                System.out.print(navires[i][j-1]+" ");
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
                if (frappes[i][j-1])
                    System.out.print("x ");
                else System.out.print(". ");
            }
            System.out.print("\n");
        }
    }


}
