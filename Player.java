import java.io.Serializable;
import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        boolean or=true;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            switch(res.orientation) {
                case "n":
                    s.setOrientation(Orientation.NORTH);
                case "s":
                    s.setOrientation(Orientation.SOUTH);
                case "e":
                    s.setOrientation(Orientation.EAST);
                case "w":
                    s.setOrientation(Orientation.WEST);
                default:
                    or=false;
            }

            // TODO put ship at given position
            try {board.putShip(s, res.x, res.y);} catch (Exception e){System.out.println(e);}

            // TODO when ship placement successful
            if(board.hasShip(res.x,res.y)==true)
            {
                if(or==true)
                {
                    ++i;
                    done = i == 5;
                    board.print();
                }
            }

        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            try {

                hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
                if (hit == Hit.MISS) {this.board.setHit(false, hitInput.x, hitInput.y);}
                else {this.board.setHit(true, hitInput.x, hitInput.y);}
                }
            catch(Exception e)
            {
                System.out.println(e);
                done=false;
            }
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
