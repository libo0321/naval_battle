
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import Ship.*;

public class TestBoard{
    public static void main(String [] args) {
        Board board = new Board("Test",11,13);
        Submarine s = new Submarine("ji",4,Orientation.EAST);
        Carrier c = new Carrier("ca",5, Orientation.NORTH);
        Carrier d = new Carrier("ca",5, Orientation.SOUTH);
        board.putShip(s,5,6);
        board.putShip(c,5,5);
        board.putShip(d,5,5);
        board.print();

    }
}