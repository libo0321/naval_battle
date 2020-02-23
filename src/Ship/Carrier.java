package Ship;

public class Carrier extends AbstractShip {
    static int Carrier_length = 5;

    public Carrier(String name, Orientation orientation) {
        super(name, Label.carrier, Carrier_length, orientation);
    }

    public Carrier(String name) {
        this(name, Orientation.EAST);
    }
}
