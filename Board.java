public class Board implements IBoard {

    /*Attributs*/
    private String nom;
    private char navires[][] ;
    private boolean frappes[][];

    /*Constructeurs*/
    public Board(String nom, int taille) {
        this.nom = nom;
        this.navires = new char[taille][taille];
        this.frappes = new boolean[taille][taille];

        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                this.navires[i][j]='.';
                this.frappes[i][j]=false;
            }
        }
    }

    public Board(String nom) {
        this.nom = nom;
        this.navires = new char[10][10];
        this.frappes = new boolean[10][10];
        for(int i=0;i<10;++i){
            for(int j=0;j<10;++j){
                this.navires[i][j]='.';
                this.frappes[i][j]=false;
            }
        }
    }


    public void print() {
        System.out.println("-----" + this.nom + "-----");
        System.out.println("Navires : ");
        System.out.print("  ");
        int size = this.navires.length;
        for (int a = 0; a < size; a++)
            System.out.print("  "+(char)(65+a));
        System.out.println();
        for (int i = 0; i < size; i++) {
                System.out.print((i+1)+" ");
            for (int j = 0; j < size; j++) {
                System.out.print(" "+this.navires[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Frappes : ");
        System.out.print("  ");
        for (int b = 0; b < size; b++)
            System.out.print("  "+(char)(65+b));
        System.out.println();
        for (int k = 0; k < size; k++) {
                System.out.print((k+1)+" ");
            for (int l = 0; l < size; l++) {
                if (frappes[k][l]==false)
                    System.out.print(" . ");
                else
                    System.out.print(" x ");
            }
            System.out.println();
        }
    }


        /**
         * Get the size of the grids contained in the Board
         * @return the size of the grids contained in the Board
         */
       public int getSize ()
        {
            return (navires.length);
        }
        /**
         * Put the given ship at the given position
         * @param ship The ship to place on the board
         * @param x
         * @param y
         */
      public void putShip (AbstractShip ship,int x, int y)
        {
                Character label=ship.getLabel();
                int taille= ship.getTaille();
                Orientation orientation= ship.getorientation();
                this.getSize();
                switch(orientation){
                    case EAST: {
                        try {
                            for(int i=y; i<=y+taille-1; i++) {
                                navires[x][i] = label;
                            }
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case WEST: {
                        try {
                            for(int j=y-taille+1; j<=y; j++) {
                                navires[x][j] = label;
                            }
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case NORTH: {
                        try {
                            for(int k=x-taille+1; k<x+1; k++) {
                                navires[k-1][y-1] = label;
                            }
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case SOUTH: {
                        try {
                            for(int l=x; l<=x+taille-1; l++) {
                                navires[l][y] = label;
                            }
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }
        }
        /**
         * Get if a ship is placed at the given position
         * @param x
         * @param y
         * @return true if a ship is located at the given position
         */
        public boolean hasShip ( int x, int y)
        {
            if (navires[x][y]=='.')
            {
                return (false);
            }
            else
                return (true);
        }

        /**
         * Set the state of the hit at a given position
         * @param hit true if the hit must be set to successful
         * @param x
         * @param y
         */
        public void setHit ( boolean hit, int x, int y)
        {
            frappes[x][y] = hit;
        }

        /**
         * Get the state of a hit at the given position
         * @param x
         * @param y
         * @return true if the hit is successful
         */
       public boolean getHit ( int x, int y)
        {
            if (frappes[x][y])
                return (true);
            else
                return (false);
        }
}
