import java.util.ArrayList;
import java.util.List;

import Ship.*;

public class TestGame{
    public static void main(String [] args) {
        Board board = new Board("Test",13);
        board.print();
        Board oppoB = new Board("oppen",13);
        Submarine s = new Submarine("ji",Orientation.EAST);
        Carrier c = new Carrier("ca", Orientation.NORTH);
        Carrier d = new Carrier("ca", Orientation.SOUTH);
        Battleship b = new Battleship("bat",Orientation.WEST);
        Destroyer d2 =new Destroyer("des",Orientation.EAST);
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(s);
        ships.add(c);
        ships.add(d);
        ships.add(b);
        ships.add(d2);
        //board.print();
        Player p1 = new Player(board, oppoB, ships);
        p1.putShips();

        int []cord = new int[2];
        BattleShipsAI ai = new BattleShipsAI(oppoB,board);
        int ship_number = ships.size();
        do{
            Hit hit = ai.sendHit(cord);
            System.out.println("attack on ("+cord[0]+", "+cord[1]+")  "
                                +"result : "+hit);
            if (hit==Hit.BATTLESHIP ||hit==Hit.CARRIER ||hit==Hit.DESTROYER ||hit==Hit.SUBMARINE)
                ship_number--;
            board.print();
            sleep(2500);
        }while (ship_number != 0);


        //board.putShip(s,5,6);
        //board.putShip(c,5,5);
        //board.putShip(d,5,5);
        //board.setHit(true , 5,5);

        //System.out.println(board.sendHit(0,2));
        //System.out.println(board.sendHit(0,2));
        //System.out.println(board.sendHit(1,2));
        //System.out.println(board.sendHit(2,2));
        //System.out.println(board.sendHit(5,6));
        //System.out.println(board.sendHit(3,4));
        //System.out.println(board.sendHit(10,2));
        //int []cord = new int[2];
        //p1.sendHit(cord);
        //System.out.println(cord[0]);
        //System.out.println(cord[1]);
        //board.print();
        //p1.ships[0] = s;
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}