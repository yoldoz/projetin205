public class shipState extends AbstractShip {

    public AbstractShip ship;
    public boolean struck;

    public shipState(String nom, Character label, int taille, Orientation orientation, boolean struck){
        super(nom, label, taille, orientation);
        this.struck=struck;
    }


    public void addStrike(){
         if(ship.addStrike()!=0)
             System.out.println("navire touché");
         else
             System.out.println("navire non touché");
    }

    public boolean isStruck(){
        return struck;
    }

    public String toString(){
        Character l=ship.getLabel();
        String lab=String.valueOf(l);
        if(struck){
            return (ColorUtil.colorize(lab, ColorUtil.Color.RED));
        }
        else {
            return(ColorUtil.colorize(lab,ColorUtil.Color.WHITE));
        }
    }

    public boolean isSunk(){
        return (ship.isSunk());
    }

    public AbstractShip getShip(){
        return (this.ship);
    }

    public void setShip(AbstractShip A) {
        this.ship = A;
    }

    public void setStruck(boolean S) {
        this.struck = S;
    }

}
