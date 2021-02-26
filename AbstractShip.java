public abstract class AbstractShip {

    protected Character label;
    protected String nom;
    protected int taille;
    protected Orientation orientation;

    /*Constructeur valué*/
    public AbstractShip(String nom, Character label, int taille, Orientation orientation){
        this.nom=nom;
        this.label=label;
        this.taille=taille;
        this.orientation=orientation;
    }

    /*Accesseurs*/
    public String getNom(){ return nom;}
    public Character getLabel(){ return label;}
    public int getTaille(){ return taille;}
    public Orientation getorientation(){ return orientation; }

    /*Mutateurs*/
    public void setNom(String nom){ this.nom=nom;}
    public void setLabel(Character label){ this.label=label;}
    public void setTaille(int taille){ this.taille=taille;}
    public void setOrientation(Orientation orientation){ this.orientation=orientation;}
}
