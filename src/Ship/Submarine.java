package Ship;

public class Submarine extends AbstractShip {
    static int Submarine_length = 3;

    public Submarine(String name,  Orientation orientation) {
        super(name, Label.submarine, Submarine_length, orientation);
    }

    public Submarine(String name) {
        this(name, Orientation.EAST);
    }
}
