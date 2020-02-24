import java.io.Serializable;
import java.util.List;
import Ship.*;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getLength());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            switch (res.orientation){
                case "e":
                    s.setOrientation(Orientation.EAST);
                    break;
                case "n":
                    s.setOrientation(Orientation.NORTH);
                    break;
                case "w":
                    s.setOrientation(Orientation.WEST);
                    break;
                case "s":
                    s.setOrientation(Orientation.SOUTH);
                    break;
            }
            // TODO put ship at given position
            if(board.putShip(s,res.x,res.y)) {
                // TODO when ship placement successful
                ++i;
                board.print();
            }
            else System.err.println("out of the board or one ship has taken this place");
            done = i == 5;

        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = true;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // call sendHit on this.opponentBoard
            hit = opponentBoard.sendHit(hitInput.x, hitInput.y);
            // Game expects sendHit to return BOTH hit result & hit coords.
            // to return coords, we use coords as parametre
            int i = 0;
            coords[i] = hitInput.x;
            coords[i+1] = hitInput.y;
            i+=2;
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
