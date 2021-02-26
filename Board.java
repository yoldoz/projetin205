public class Board {

    /*Attributs*/
    private static String nom;
    private static Character[][] navires;
    private static boolean[][] frappes;

    /*Constructeurs*/
    public Board(String nom, int taille) {
        this.nom = nom;
        navires = new Character[taille][taille];
        frappes = new boolean[taille][taille];
    }

    public Board(String nom) {
        this.nom = nom;
        navires = new Character[10][10];
        frappes = new boolean[10][10];
    }


    public static void print() {
        System.out.println("-----" + nom + "-----");
        System.out.println("Navires : ");
        int size = navires.length;
        for (int i = 0; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(" . ");
            }
            System.out.print("\n");
            System.out.println();
        }

        System.out.println("Frappes : ");
        for (int k = 1; k <= size; k++) {
            for (int l = 1; l <= size; l++) {
                System.out.print(" . ");
            }
            System.out.print("\n");
            System.out.println();
        }
    }
