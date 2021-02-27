public class TestBoard {

    public static void main(String[] args) {
        Board A = new Board("GRILLE");
        Battleship B= new Battleship(Orientation.NORTH);
        Carrier C= new Carrier(Orientation.EAST);
        Destroyer D= new Destroyer(Orientation.WEST);
        Submarine S= new Submarine(Orientation.SOUTH);
        try {A.putShip(B, 2,2);} catch (Exception e){System.out.println(e);}
        try {A.putShip(C, 10,10);} catch (Exception e){System.out.println(e);}
        try {A.putShip(D, 5,4);} catch (Exception e){System.out.println(e);}
        try {A.putShip(S, 10,10);} catch (Exception e){System.out.println(e);}
        A.print();
    }
}




