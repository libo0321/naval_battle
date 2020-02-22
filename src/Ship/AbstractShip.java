package Ship;

public abstract class AbstractShip {
    protected Label label;
    protected String name;
    protected int taille;
    protected Orientation orientation;
    private int strickCount = 0;

    public AbstractShip(String name, Label label, int taille, Orientation orientation) {
        this.name = name;
        this.label = label;
        this.taille = taille;
        this.orientation = orientation;
    }
    /* Accesseurs */
    public Label getLabel() {
        return label;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getName() {
        return name;
    }

    public int getTaille() {
        return taille;
    }

    public void addStrike() { strickCount++; }

    public boolean isSunk() { return strickCount == taille; }


    /* Mutateurs */
    //public void setLabel(Label label) { this.label = label; }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    //public void setName(String nombrePlaces) { this.name = name; }

    //public void setTaille(int taille) {this.taille = taille;}

}