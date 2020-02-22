import java.util.NoSuchElementException;

public enum Hit {
    NOT(0,"not tried"),
    MISS(-1, "manqué"),
    STIKE(-2, "touché"),
    DESTROYER(2, "destroyer"),
    SUBMARINE(3, "submarine"),
    BATTLESHIP(4, "battleship"),
    CARRIER(5, "carrier");

    /* ***
     * Attributs
     */
    private int value;
    private String label;

    /* ***
     * Constructeur
     */
    Hit(int value, String label) {
        this.value = value;
        this.label = label;
    }

    /* ***
     * Méthodes
     */
    public static Hit fromInt(int value) {
        for (Hit hit : Hit.values()) {
            if (hit.value == value) {
                return hit;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

    public String toString() {
        return this.label;
    }
};
