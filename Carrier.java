public class Carrier extends AbstractShip{

    public Carrier(Orientation orientation){
        super("Carrier", 'C', 5, orientation);
    }

    public Carrier(){
        super("Carrier", 'C', 5, Orientation.EAST);
    }
}

