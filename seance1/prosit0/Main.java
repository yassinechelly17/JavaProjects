public class Main {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        afficheSomme(n1,n2);
        return;
    }

    public static float faireSomme(int a, int b) {
        float somme = a + b;
        return somme;
    }

    public static void afficheSomme(int c, int d) {
        float somme = faireSomme(c, d);
        System.out.println("Le resultat est : " + somme);
        return;
    }
    
}