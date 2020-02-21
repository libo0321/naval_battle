package Ship;

public class Battleship extends AbstractShip {

    public Battleship(String name, int taille, Orientation orientation) {
        super(name, Label.battleship, taille, orientation);
    }

    public Battleship(String name, int taille) {
        this(name, taille, Orientation.EAST);
    }
}

