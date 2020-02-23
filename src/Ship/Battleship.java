package Ship;

public class Battleship extends AbstractShip {
    static int Battleship_length = 4;

    public Battleship(String name, Orientation orientation) {
        super(name, Label.battleship, Battleship_length, orientation);
    }

    public Battleship(String name) {
        this(name,  Orientation.EAST);
    }
}

