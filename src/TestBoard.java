
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import Ship.*;

public class TestBoard{
    public static void main(String [] args) {
        Board board = new Board("Test",11,13);
        Board oppoB = new Board("oppen",11,13);
        Submarine s = new Submarine("ji",4,Orientation.EAST);
        Carrier c = new Carrier("ca",5, Orientation.NORTH);
        Carrier d = new Carrier("ca",5, Orientation.SOUTH);
        Battleship b = new Battleship("bat",3,Orientation.WEST);
        Destroyer d2 =new Destroyer("des",2,Orientation.EAST);
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(s);
        ships.add(c);
        ships.add(d);
        ships.add(b);
        ships.add(d2);


        //board.putShip(s,5,6);
        //board.putShip(c,5,5);
        //board.putShip(d,5,5);
        //board.setHit(true , 5,5);
        //board.print();
        Player p1 = new Player(board, oppoB, ships);
        p1.putShips();
        //p1.ships[0] = s;


    }
}