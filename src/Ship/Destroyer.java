package Ship;

public class Destroyer extends AbstractShip {
    static int Destroyer_length = 2;

    public Destroyer(String name, Orientation orientation) {
        super(name, Label.destroyer, Destroyer_length, orientation);
    }

    public Destroyer(String name) {
        this(name,  Orientation.EAST);
    }
}
