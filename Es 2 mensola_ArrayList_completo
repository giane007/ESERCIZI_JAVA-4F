import static Tools.Utility.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;




public class Main {
   public static void main(String[] args) throws ParseException {
       Scanner tastiera = new Scanner(System.in);
       ArrayList<Libro> gestore = new ArrayList<>();
       boolean uscita = false;
       int conta=0;
       String[] opzioni = {
               "Gestore libri",
               "- Inserimento",
               "- Visualizza",
               "- Ricerca",
               "- Ricerca per titolo",
               "- Ricerca per autore",
               "- Trova Tutti",
               "- Cambia data",
               "- Elimina",
               "- Elimina per autore",
               "- Elimina per titolo",
               "- Fine"
       };
       DateFormat d = new SimpleDateFormat("dd-MM-yyyy");


       do {
           switch (Menu(opzioni, tastiera)) {
               case 1 -> {
                   Libro nuovoLibro = inserimentoLibro(tastiera);
                   if (!libroDoppio(gestore, nuovoLibro)) {
                       gestore.add(nuovoLibro);
                       System.out.println("Libro inserito con successo.");
                       conta++;
                   } else {
                       System.out.println("Il libro è già presente.");
                   }
               }
               case 2 -> {
                   if (conta>0) {
                       visualizzaLibri(gestore);
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 3 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo del libro da cercare:");
                       String titoloCercato = tastiera.nextLine();
                       System.out.println("Inserisci l'autore del libro da cercare:");
                       String autoreCercato = tastiera.nextLine();
                       int indice = ricercaLibro(gestore, titoloCercato, autoreCercato);
                       if (indice != -1) {
                           System.out.println("Libro trovato all'indice: " + indice);
                           System.out.println(gestore.get(indice).formattaDati());
                       } else {
                           System.out.println("Libro non trovato.");
                       }
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 4 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo del libro da cercare:");
                       String titoloCercato = tastiera.nextLine();
                       int indice = trovaPerTitolo(gestore, titoloCercato);
                       if (indice != -1) {
                           System.out.println("Libro trovato all'indice: " + indice);
                           System.out.println(gestore.get(indice).formattaDati());
                       } else {
                           System.out.println("Libro non trovato.");
                       }
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 5 -> {
                   if (conta>0) {
                       System.out.println("Inserisci l'autore del libro da cercare:");
                       String autoreCercato = tastiera.nextLine();
                       int indice = trovaPerAutore(gestore, autoreCercato);
                       if (indice != -1) {
                           System.out.println("Libro trovato all'indice: " + indice);
                           System.out.println(gestore.get(indice).formattaDati());
                       } else {
                           System.out.println("Libro non trovato.");
                       }
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 6 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo del libro da cercare:");
                       String titoloCercato = tastiera.nextLine();
                       System.out.println("Inserisci l'autore del libro da cercare:");
                       String autoreCercato = tastiera.nextLine();


                       ArrayList<String> libriTrovati = findAll(gestore, titoloCercato, autoreCercato);
                       if (!libriTrovati.isEmpty()) {
                           System.out.println("Libri trovati:");
                           libriTrovati.forEach(System.out::println);
                       } else {
                           System.out.println("Nessun libro trovato.");
                       }


                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 7 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo del libro da cercare:");
                       String titoloCercato = tastiera.nextLine();
                       System.out.println("Inserisci l'autore del libro da cercare:");
                       String autoreCercato = tastiera.nextLine();
                       System.out.println("Inserisci la nuova data di pubblicazione (dd-MM-yyyy):");
                       Date dataNuova = d.parse(tastiera.nextLine());
                       int indice = ricercaLibro(gestore, titoloCercato, autoreCercato);
                       if (indice != -1) {
                           cambioData(gestore, indice, dataNuova);
                           System.out.println("Data di pubblicazione aggiornata.");
                       } else {
                           System.out.println("Libro non trovato.");
                       }
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 8 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo del libro da eliminare:");
                       String titoloCercato = tastiera.nextLine();
                       System.out.println("Inserisci l'autore del libro da eliminare:");
                       String autoreCercato = tastiera.nextLine();
                       if (eliminaLibro(gestore, titoloCercato, autoreCercato)) {
                           System.out.println("Libro eliminato.");
                       } else {
                           System.out.println("Libro non trovato.");
                       }
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 9 -> {
                   if (conta>0) {
                       System.out.println("Inserisci l'autore dei libri da eliminare:");
                       String autoreCercato = tastiera.nextLine();
                       int rimossi = eliminaLibriAutore(gestore, autoreCercato);
                       System.out.println("Sono stati rimossi " + rimossi + " libri.");
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 10 -> {
                   if (conta>0) {
                       System.out.println("Inserisci il titolo dei libri da eliminare:");
                       String titoloCercato = tastiera.nextLine();
                       int rimossi = eliminaLibriTitolo(gestore, titoloCercato);
                       System.out.println("Sono stati rimossi " + rimossi + " libri.");
                   } else {
                       System.out.println("Nessun libro inserito.");
                   }
               }
               case 11 -> uscita = true;
               default -> System.out.println("Opzione non valida. Riprova.");
           }
       } while (!uscita);
   }


   // Metodo per inserire un libro
   public static Libro inserimentoLibro(Scanner tastiera) throws ParseException {
       Libro libro = new Libro();
       DateFormat d = new SimpleDateFormat("dd-MM-yyyy");


       System.out.println("Inserisci il titolo del libro:");
       libro.titolo = tastiera.nextLine();


       System.out.println("Inserisci l'autore del libro:");
       libro.autore = tastiera.nextLine();


       System.out.println("Inserisci il numero di pagine:");
       libro.pagine = Integer.parseInt(tastiera.nextLine());


       System.out.println("Inserisci la data di pubblicazione (dd-MM-yyyy):");
       libro.dataLibro = d.parse(tastiera.nextLine());


       String[] opzioni = {"Inserisci il genere", "1- Romanzo", "2- Manuale", "3- Thriller"};
       int scelta;
       do {
           scelta = Menu(opzioni, tastiera);
           switch (scelta) {
               case 1 -> libro.genereLibro = Genere.romanzo;
               case 2 -> libro.genereLibro = Genere.manuale;
               case 3 -> libro.genereLibro = Genere.thriller;
               default -> System.out.println("Scelta non valida.");
           }
       } while (scelta < 1 || scelta > 3);


       return libro;
   }




   public static void visualizzaLibri(ArrayList<Libro> gestore) {
       for (int i = 0; i < gestore.size(); i++) {
           System.out.println((i + 1) + "° " + gestore.get(i).formattaDati());
       }
   }




   public static boolean libroDoppio(ArrayList<Libro> gestore, Libro libro) {
       return gestore.stream().anyMatch(l -> l.titolo.equalsIgnoreCase(libro.titolo) && l.autore.equalsIgnoreCase(libro.autore));
   }




   public static int ricercaLibro(ArrayList<Libro> gestore, String titolo, String autore) {
       for (int i = 0; i < gestore.size(); i++) {
           Libro libro = gestore.get(i);
           if (libro.titolo.equalsIgnoreCase(titolo) && libro.autore.equalsIgnoreCase(autore)) {
               return i;
           }
       }
       return -1;
   }




   public static boolean eliminaLibro(ArrayList<Libro> gestore, String titolo, String autore) {
       int indice = ricercaLibro(gestore, titolo, autore);
       if (indice != -1) {
           gestore.remove(indice);
           return true;
       }
       return false;
   }




   public static void cambioData(ArrayList<Libro> gestore, int indice, Date nuovaData) {
       gestore.get(indice).dataLibro = nuovaData;
   }




   public static ArrayList<String> findAll(ArrayList<Libro> gestore, String titolo, String autore) {
       ArrayList<String> risultati = new ArrayList<>();
       for (int i = 0; i < gestore.size(); i++) {
           Libro libro = gestore.get(i);
           if (libro.titolo.equalsIgnoreCase(titolo) && libro.autore.equalsIgnoreCase(autore)) {
               risultati.add("Posizione: " + (i + 1) + " - " + libro.formattaDati());
           }
       }
       return risultati;
   }




   public static int eliminaLibriAutore(ArrayList<Libro> gestore, String autore) {
       int iniziale = gestore.size();
       gestore.removeIf(libro -> libro.autore.equalsIgnoreCase(autore));
       return iniziale - gestore.size();
   }




   public static int eliminaLibriTitolo(ArrayList<Libro> gestore, String titolo) {
       int iniziale = gestore.size();
       gestore.removeIf(libro -> libro.titolo.equalsIgnoreCase(titolo));
       return iniziale - gestore.size();
   }




   public static int trovaPerTitolo(ArrayList<Libro> gestore, String titolo) {
       for (int i = 0; i < gestore.size(); i++) {
           if (gestore.get(i).titolo.equalsIgnoreCase(titolo)) {
               return i;
           }
       }
       return -1;
   }




   public static int trovaPerAutore(ArrayList<Libro> gestore, String autore) {
       for (int i = 0; i < gestore.size(); i++) {
           if (gestore.get(i).autore.equalsIgnoreCase(autore)) {
               return i;
           }
       }
       return -1;
   }
}


LIBRO
import java.util.Date;
public class Libro {
   public String autore;
   public String titolo;
   public int pagine;
   public Genere genereLibro;
   public Date dataLibro;
   final double COSTOPAGINE = 0.05;




   public String formattaDati() {
       return String.format("Libro: Autore: %s, Titolo: %s, Prezzo Libro: %.2f, Genere: %s,Data di pubblicazione: %s", autore, titolo, COSTOPAGINE * pagine, genereLibro, dataLibro);
   }
}

GENERE
public enum Genere {
   romanzo,
   manuale,
   thriller
}

UTILITY
package Tools;
import java.util.Scanner;
public class Utility{


   private Utility()
   {}; //impedisce di istanziare la classe
   public static void clrScr() {
       try {
           new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public static void Wait(int attesa) {
       try {
           Thread.sleep(attesa);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
   public static int Menu(String []opzioni, Scanner tastiera) {// parametri formali
       int scelta;


       do {
           clrScr();
           System.out.println("------------------");
           System.out.println(opzioni[0]);
           System.out.println("------------------");
           for (int i = 1; i < opzioni.length; i++) {
               System.out.println("[" + i + "]" + " " + opzioni[i]);
           }
           scelta = (Integer.parseInt(tastiera.nextLine()));
           //tastiera.nextLine();
           if ((scelta < 1) || (scelta > opzioni.length - 1)) {
               System.out.println("Opzione Sbagliata");
               Wait(2000);
           }
       }
       while ((scelta < 1) || (scelta > opzioni.length - 1));
       //tastiera.nextLine();
       return scelta;
   }
}


