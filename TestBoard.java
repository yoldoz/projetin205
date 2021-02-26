public class TestBoard {

    public static void main(String[] args) {
        Board A = new Board("GRILLE1");
        Battleship B= new Battleship(Orientation.NORTH);
        A.putShip(B, 7,5);
        A.print();

    }
}




