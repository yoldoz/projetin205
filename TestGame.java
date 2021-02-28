public class TestGame {

    public static void main(String argc[]) {
        Board Board = new Board("test");
        Board.print();
        AbstractShip navires[] = new AbstractShip[3];
        BattleShipsAI ai = new BattleShipsAI(Board, Board);
        int détruits;
        int [] coord=new int[2];
        Destroyer destroyer = new Destroyer();
        navires[0] = destroyer;
        Carrier aircraft = new Carrier();
        navires[1] = aircraft;
        Battleship battleship1 = new Battleship();
        navires[2] = battleship1;
        Battleship battleship2 = new Battleship();
        navires[3] = battleship2;
        Submarine submarine = new Submarine();
        navires[4] = submarine;
        ai.putShips(navires);
        Board.print();

        do
        {
            Hit hit= ai.sendHit(coord);
            Board.print();
            System.out.println("Les coordonnées du hit sont: x= "+coord[0]+" et y = "+coord[1]);
            if (hit == Hit.MISS || hit == Hit.STIKE) {
                System.out.println(hit.getLabel());
            } else {
                System.out.println(hit.getLabel() + " coulé");
            }

            sleep(1000);
            détruits=0;
            for (AbstractShip n : navires) {
                if (n.isSunk()) {
                    détruits++;
                }
            }

        }
        while(détruits < navires.length);


    }
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
