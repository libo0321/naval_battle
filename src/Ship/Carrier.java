package Ship;

public class Carrier extends AbstractShip {

    public Carrier(String name, int taille, Orientation orientation) {
        super(name, Label.carrier, taille, orientation);
    }

    public Carrier(String name, int taille) {
        this(name, taille, Orientation.EAST);
    }
}
