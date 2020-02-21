package Ship;

public class Submarine extends AbstractShip {

    public Submarine(String name, int taille, Orientation orientation) {
        super(name, Label.submarine, taille, orientation);
    }

    public Submarine(String name, int taille) {
        this(name, taille, Orientation.EAST);
    }
}
