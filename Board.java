public class Board implements IBoard {

    /*Attributs*/
    private static String nom;
    private static Character[][] navires;
    private static boolean[][] frappes;

    /*Constructeurs*/
    public Board(String nom, int taille) {
        this.nom = nom;
        for(int i=1;i<=taille;i++){
            for(int j=1;j<=taille;i++){
                navires[i][j]='.';
                frappes[i][j]=false;
            }
        }
    }

    public Board(String nom) {
        this(nom,10);
    }


    public static void print() {
        System.out.println("-----" + nom + "-----");
        System.out.println("Navires : ");
        int size = navires.length;
        for (int i = 0; i <= size; i++) {
                System.out.print((char)(65+i)+" ");
            System.out.println();
            for (int j = 1; j <= size; j++) {
                System.out.print(navires[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Frappes : ");
        for (int k = 1; k <= size; k++) {
                System.out.print((char)(65+k)+ " ");
            System.out.println();
            for (int l = 1; l <= size; l++) {
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
                            for(int i=y; i<=y+taille-1; i++)
                                navires[x][i]=label;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case WEST: {
                        try {
                            for(int j=y-taille+1; j<=y; j++)
                                navires[x][j]=label;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case NORTH: {
                        try {
                            for(int k=x-taille+1; k<=x; k++)
                                navires[k][y]=label;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    case SOUTH: {
                        try {
                            for(int l=x; l<=x+taille-1; l++)
                                navires[l][y]=label;
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
            if (navires[x][y].equals('.'))
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
