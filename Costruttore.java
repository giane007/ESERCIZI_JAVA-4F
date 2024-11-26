import java.util.Scanner;


public class Main {
   public static void main(String[] args) {


       final int MAX_X = 10;


       // Creazione due oggetti Punto
       Punto punto1 = new Punto(MAX_X);
       Punto punto2 = new Punto(MAX_X);


       Scanner tastiera = new Scanner(System.in);


       // Coordinate del primo punto
       System.out.println("Inserisci le coordinate del primo punto:");
       System.out.println("Inserisci x1:");
       int x1 = Integer.parseInt(tastiera.nextLine());
       punto1.setX(x1);


       System.out.println("Inserisci y1:");
       int y1 = Integer.parseInt(tastiera.nextLine());
       punto1.setY(y1);


       // Coordinate del secondo punto
       System.out.println("Inserisci le coordinate del secondo punto:");
       System.out.println("Inserisci x2:");
       int x2 = Integer.parseInt(tastiera.nextLine());
       punto2.setX(x2);


       System.out.println("Inserisci y2:");
       int y2 = Integer.parseInt(tastiera.nextLine());
       punto2.setY(y2);


       // Stampare la distanza tra i due punti
       double distanza = calcolaDistanza(punto1, punto2);
       System.out.println("La distanza tra i due punti è: " + distanza);


       //Stampare i quadranti di appartenenza
       System.out.println("Punto 1 (" + x1 + ", " + y1 + ") appartiene al quadrante: " + quadrantePunto(punto1));
       System.out.println("Punto 2 (" + x2 + ", " + y2 + ") appartiene al quadrante: " + quadrantePunto(punto2));


   }


   // Metodo per calcolare la distanza tra due punti
   public static double calcolaDistanza(Punto p1, Punto p2) {
       double dx = p2.getX() - p1.getX();
       double dy = p2.getY() - p1.getY();
       return Math.sqrt(dx * dx + dy * dy); // FORMULA DELLA DISTANZA
   }


   // Metodo per identificare il quadrante di un punto
   public static String quadrantePunto(Punto punto) {
       if (punto.getX() > 0 && punto.getY() > 0) {
           return "Primo Quadrante";
       } else if (punto.getX() < 0 && punto.getY() > 0) {
           return "Secondo Quadrante";
       } else if (punto.getX() < 0 && punto.getY() < 0) {
           return "Terzo Quadrante";
       } else if (punto.getX() > 0 && punto.getY() < 0) {
           return "Quarto Quadrante";
       } else if (punto.getX() == 0 && punto.getY() == 0) {
           return "Origine";
       } else if (punto.getX() == 0) {
           return "Asse Y";
       } else if (punto.getY() == 0) {
           return "Asse X";
       }
       return "Sconosciuto"; // Caso non previsto
   }
}

class Punto {
   private double x;
   private double y;
   private final int MAX_X;  // Limite massimo per x


   //Costruttore
   public Punto(int maxX) {
       this.MAX_X = maxX;
   }


   public void setX(double x) {
       if (x > MAX_X) {
           System.out.println("Errore: x non può essere maggiore di " + MAX_X);
       } else {
           this.x = x;
       }
   }


   public void setY(double y) {
       this.y = y;
   }


   public double getX() {
       return x;
   }


   public double getY() {
       return y;
   }
}
