package Ship;

public abstract class AbstractShip {
    protected Label label;
    protected String name;
    protected int taille;
    protected Orientation orientation;

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


    /* Mutateurs */
    //public void setLabel(Label label) { this.label = label; }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    //public void setName(String nombrePlaces) { this.name = name; }

    //public void setTaille(int taille) {this.taille = taille;}

}