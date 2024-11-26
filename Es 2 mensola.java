import java.util.Scanner;
import static Tools.Utility.*;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       int contaLibri = 0;
       final int maxLibri = 3;
       boolean uscita = false;
       Libro[] gestore = new Libro[maxLibri];
       String[] opzioni = {"Gestore libri", "1- Inserimento", "2- Visualizza", "3- Ricerca", "4- Elimina", "5- Fine"};


       do {
           switch (Menu(opzioni, tastiera)) {
               case 1 -> {
                   if (contaLibri < maxLibri) {
                       Libro nuovoLibro = inserimentoLibro(tastiera);
                       if (!libroDoppio(gestore, contaLibri, nuovoLibro)) {
                           gestore[contaLibri] = nuovoLibro;
                           contaLibri++;
                       } else {
                           System.out.println("Il libro è già presente.");
                       }
                   } else {
                       System.out.println("Spazio finito");
                   }
               }
               case 2 -> {
                   if (contaLibri > 0) {
                       visualizzaLibro(gestore, contaLibri);
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 3 -> {
                   if (contaLibri > 0) {
                       ricercaLibro(gestore, contaLibri, tastiera);
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 4 -> {
                   if (contaLibri > 0) {
                       System.out.println("Inserisci il titolo del libro da cercare:");
                       String titoloCercato = tastiera.nextLine();
                       eliminaLibro(gestore, contaLibri, titoloCercato);
                       contaLibri--;
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 5 -> uscita = true;
           }
       } while (!uscita);
   }


   public static Libro inserimentoLibro(Scanner tastiera) {
       Libro libro = new Libro();
       System.out.println("Inserisci il titolo del libro:");
       libro.titolo = tastiera.nextLine();
       System.out.println("Inserisci l'autore del libro:");
       libro.autore = tastiera.nextLine();
       System.out.println("Inserisci il numero di pagine:");
       libro.pagine = Integer.parseInt(tastiera.nextLine());


       String[] opzioni = {"Inserisci il genere", "1- Romanzo", "2- Manuale", "3- Thriller"};
       int scelta;
       do {
           scelta = Menu(opzioni, tastiera);
           switch (scelta) {
               case 1 -> libro.genereLibro = genere.romanzo;
               case 2 -> libro.genereLibro = genere.manuale;
               case 3 -> libro.genereLibro = genere.thriller;
               default -> System.out.println("Scelta non valida, riprova.");
           }
       } while (scelta < 1 || scelta > 3);


       return libro;
   }




   public static void visualizzaLibro(Libro[] gestore, int contaLibri) {
       for (int i = 0; i < contaLibri; i++) {
           System.out.println("Libro " + (i + 1) + ":");
           System.out.println(gestore[i].formattaDati());
           System.out.println("Genere: " + gestore[i].genereLibro);
       }
   }


   public static void ricercaLibro(Libro[] gestore, int contaLibri, Scanner tastiera) {
       System.out.println("Inserisci il titolo del libro da cercare:");
       String titoloCercato = tastiera.nextLine();
       boolean trovato = false;
       for (int i = 0; i < contaLibri; i++) {
           if (gestore[i].titolo.equalsIgnoreCase(titoloCercato)) {
               trovato = true;
               System.out.println("Libro trovato:");
               System.out.println(gestore[i].formattaDati());
               System.out.println("Genere: " + gestore[i].genereLibro);
           }
       }
       if (!trovato) {
           System.out.println("Nessun libro trovato con il titolo inserito.");
       }
   }


   public static boolean eliminaLibro(Libro[] gestore, int contaLibri, String titoloCercato) {
       boolean trovato = false;
       for (int i = 0; i < contaLibri; i++) {
           if (gestore[i].titolo.equalsIgnoreCase(titoloCercato)) {
               for (int j = i; j < contaLibri - 1; j++) {
                   gestore[j] = gestore[j + 1];
               }
               gestore[contaLibri - 1] = null;
               trovato = true;
               break;
           }
       }
       if (!trovato) {
           System.out.println("Nessun libro trovato con il titolo inserito.");
       }
       return trovato;
   }
   public static boolean libroDoppio(Libro[] gestore, int contaLibri, Libro nuovoLibro) {
       for (int i = 0; i < contaLibri; i++) {
           if (gestore[i].autore.equalsIgnoreCase(nuovoLibro.autore) && gestore[i].titolo.equalsIgnoreCase(nuovoLibro.titolo)) {
               return true; // Doppione trovato
           }
       }
       return false; // Nessun doppione trovato
   }


}

libro
enum genere {
   romanzo,
   manuale,
   thriller
}
class Libro {
   public String autore;
   public String titolo;
   public int pagine;
   public genere genereLibro;
   final double COSTOPAGINE = 0.05;




   public String formattaDati() {
       return String.format("Autore: %s, Titolo: %s, Prezzo Libro: %.2f", autore, titolo, COSTOPAGINE * pagine);
   }
}

