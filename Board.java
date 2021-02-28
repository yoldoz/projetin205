import java.net.NoRouteToHostException;
public class Board implements IBoard{

    /*Attributs*/
    private String nom;
    private shipState navires[][] ;
    private Boolean frappes[][];

    /*Constructeurs*/
    public Board(String nom, int taille) {
        this.nom = nom;
        this.navires = new shipState[taille][taille];
        this.frappes = new Boolean[taille][taille];

        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                navires[i][j]=null;
                System.out.println(" . ");
                this.frappes[i][j]=false;
            }
        }
    }

    public Board(String nom) {
        this.nom = nom;
        this.navires = new shipState[10][10];
        this.frappes = new Boolean[10][10];
        for(int i=0;i<10;++i){
            for(int j=0;j<10;++j){
                navires[i][j]=null;
                System.out.println(" . ");
                this.frappes[i][j]=false;
            }
        }
    }

    public shipState getNavires(int x, int y){
        return(this.navires[x][y]);
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
                if (this.navires[i][j] == null)
                    System.out.print(ColorUtil.colorize(" . ", ColorUtil.Color.WHITE));
                else {
                    if(this.navires[i][j].isStruck())
                        System.out.print(ColorUtil.colorize(" " + this.navires[i][j].ship.getLabel() + " ", ColorUtil.Color.RED));
                    else
                        System.out.print(ColorUtil.colorize(" " + this.navires[i][j].ship.getLabel() + " ", ColorUtil.Color.WHITE));
                }
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
                if (frappes[k][l]==null)
                    System.out.print(" . ");
                else if (frappes[k][l]==false)
                    System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.WHITE));
                else if (frappes[k][l]==true)
                    System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.RED));
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
      public void putShip (AbstractShip ship,int x, int y) throws Exception {
          Character label = ship.getLabel();
          int taille = ship.getTaille();
          Orientation orientation = ship.getorientation();
          int n = this.getSize();
          switch (orientation) {
              case EAST:
                  int t = 0, z = 0;
                  for (int i = y - 1; i <= y + taille - 2; i++) {
                      if (x - 1 < 0 || x - 1 > n || i < 0 || i > n)
                          z++;
                  }
                  if (z != 0) {
                      throw new Exception("IMPOSSIBLE NAVIRE " + label + " SORT DE LA GRILLE!");
                  } else {
                      for (int i = y - 1; i <= y + taille - 2; i++) {
                          if (navires[x - 1][i] != null) {
                              t++;
                          }
                      }
                      if (t != 0) {
                          throw new Exception("IMPOSSIBLE CHEVAUCHEMENT DE " + label + " AVEC UN AUTRE NAVIRE!");
                      }

                      for (int c = y; c <= y + taille - 1; c++) {
                          navires[x - 1][c - 1].ship.setLabel(label);
                      }
                  }
                  break;
              case WEST:
                  int t1 = 0, z1 = 0;
                  for (int i1 = y - taille; i1 <= y - 1; i1++) {
                      if (x - 1 < 0 || x - 1 > n || i1 < 0 || i1 > n) {
                          z1++;
                      }
                  }
                  if (z1 != 0) {
                      throw new Exception("IMPOSSIBLE NAVIRE " + label + " SORT DE LA GRILLE!");
                  } else {
                      for (int i = y - taille; i <= y - 1; i++) {
                          if (navires[x - 1][i] != null) {
                              t1++;
                          }
                      }
                      if (t1 != 0) {
                          throw new Exception("IMPOSSIBLE CHEVAUCHEMENT DE " + label + " AVEC UN AUTRE NAVIRE!");
                      } else {
                          for (int j = y - taille; j <= y - 1; j++) {
                              navires[x - 1][j].ship.setLabel(label);
                          }
                      }
                  }
                  break;

              case NORTH:
                  int t2 = 0, z2 = 0;
                  for (int i = x - taille; i < x; i++) {
                      if (y - 1 < 0 || y - 1 > n || i < 0 || i > n)
                          z2++;
                  }
                  if (z2 != 0) {
                      throw new Exception("IMPOSSIBLE NAVIRE " + label + " SORT DE LA GRILLE!");
                  } else {
                      for (int i = x - taille; i < x; i++) {
                          if (navires[i][y - 1] != null) {
                              t2++;
                          }
                      }
                      if (t2 != 0) {
                          throw new Exception("IMPOSSIBLE CHEVAUCHEMENT DE " + label + " AVEC UN AUTRE NAVIRE!");
                      } else {
                          for (int k = x - taille; k < x; k++) {
                              navires[k][y - 1].ship.setLabel(label);
                          }
                      }
                  }
                  break;
              case SOUTH:

                  int t3 = 0, z3 = 0;
                  for (int i = x -1; i <= x+taille-2; i++) {
                      if (y - 1 < 0 || y - 1 > n || i < 0 || i > n)
                          z3++;
                  }
                  if (z3 != 0) {
                      throw new Exception("IMPOSSIBLE NAVIRE " + label + " SORT DE LA GRILLE!");
                  } else {
                          for (int i = x - 1; i <= x+taille-2; i++) {
                              if (navires[i][y - 1] != null) {
                                  t3++;
                              }
                          }
                          if (t3 != 0) {
                              throw new Exception("IMPOSSIBLE CHEVAUCHEMENT DE " + label + " AVEC UN AUTRE NAVIRE!");
                          } else {
                              for (int l = x-1; l <= x + taille - 2; l++) {
                                  navires[l][y - 1].ship.setLabel(label);
                              }
                          }
                  }
                  break;
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
            if (navires[x-1][y-1]==null)
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
        public void setHit ( Boolean hit, int x, int y)
        {
            frappes[x-1][y-1] = hit;
        }

        /**
         * Get the state of a hit at the given position
         * @param x
         * @param y
         * @return true if the hit is successful
         */
       public Boolean getHit ( int x, int y)
        {
            if (frappes[x-1][y-1])
                return (true);
            else if(!frappes[x][y])
                return (false);
            else
                return null;
        }

    /**
     * Sends a hit at the given position
     * @param x
     * @param y
     * @return status for the hit (eg : strike or miss)
     */
    public Hit sendHit(int x, int y) throws Exception
    {
        Hit hit=Hit.MISS;
        x=x-1;
        y=y-1;
        try {
            if (navires[x][y] == null) {
                hit = Hit.MISS;
                System.out.println(" frappe ratée ");
            } else if ((navires[x][y].ship.getLabel() == 'D') || (navires[x][y].ship.getLabel() == 'S') || (navires[x][y].ship.getLabel() == 'B') || (navires[x][y].ship.getLabel() == 'C')) {
                this.navires[x][y].ship.addStrike();
                if (this.navires[x][y].ship.isSunk()) {
                    hit.setValue(this.navires[x][y].ship.getTaille());
                    switch (this.navires[x][y].ship.getTaille()) {
                        case 2: {
                            hit = Hit.DESTROYER;
                            System.out.println(this.navires[x][y].ship.getLabel() + " coulé ");
                        }
                        case 3: {
                            hit = Hit.SUBMARINE;
                            System.out.println(this.navires[x][y].ship.getLabel() + " coulé ");
                        }
                        case 4: {
                            hit = Hit.BATTLESHIP;
                            System.out.println(this.navires[x][y].ship.getLabel() + " coulé ");
                        }
                        case 5: {
                            hit = Hit.CARRIER;
                            System.out.println(this.navires[x][y].ship.getLabel() + " coulé ");
                        }
                    }
                } else {
                    hit = Hit.STIKE;
                    System.out.println(this.navires[x][y].ship.getLabel() + " touché ");
                }
            }
            return (hit);
        }
        catch(Exception e){
            throw new Exception(e);
        }

    }

}
