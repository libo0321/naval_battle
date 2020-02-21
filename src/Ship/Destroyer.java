package Ship;

public class Destroyer extends AbstractShip {

    public Destroyer(String name, int taille, Orientation orientation) {
        super(name, Label.destroyer, taille, orientation);
    }

    public Destroyer(String name, int taille) {
        this(name, taille, Orientation.EAST);
    }
}
