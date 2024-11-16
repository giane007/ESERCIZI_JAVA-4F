public enum giostre {
   RUOTAPANORAMICA,
   AUTOSCONTRO,
   OTTOVOLANTE,
   TAGADA
}




import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static Tools.Utility.*;


public class Main {
   public static void main(String[] args) {
       boolean esci = false;
       int nBiglietto = 1;
       Scanner sc = new Scanner(System.in);
       final int MAXPERSONE = 10;
       ArrayList<Persona> gestore = new ArrayList<>(MAXPERSONE);
       String[] opzioni = {"GESTORE LUNAPARK", "Registra entrata", "Registra uscita", "Nuova giostra","Esci"};
       do{
           try {
               switch (Menu(opzioni, sc)) {
                   case 1 -> {
                       if (gestore.size() < MAXPERSONE) {
                           gestore.add(registraEntrata(nBiglietto));
                           nBiglietto++;
                       } else {
                           throw new Exception("Il lunapark è pieno");
                       }
                   }
                   case 2 -> {


                   }
                   case 3 -> {


                   }
                   case 4 -> esci = true;
               }
           } catch(Exception e) {
               System.out.println(e.getMessage());
           }
       } while (!esci);
   }
   public static Persona registraEntrata(int nBiglietto){
       Persona cliente = new Persona();
       Random rn = new Random ();
       cliente.biglietto = nBiglietto;
       switch (rn.nextInt(0,4)){
           case 1 -> cliente.giostreUsate = giostre.RUOTAPANORAMICA;
           case 2 -> cliente.giostreUsate = giostre.AUTOSCONTRO;
           case 3 -> cliente.giostreUsate = giostre.OTTOVOLANTE;
           case 4 -> cliente.giostreUsate = giostre.TAGADA;
       }
       return cliente;
   }
   public static boolean findIndex(ArrayList<Persona> gestore, int nBiglietto){
       for (Persona persona : gestore) {
           if (persona.biglietto == nBiglietto) {
               return true;
           }
       }
       return false;
   }
}




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Persona {
   public int biglietto;
   public LocalDateTime entrata = LocalDateTime.now();
   public giostre giostreUsate;


   @Override
   public String toString() {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
       return "Biglietto " + biglietto + ", Orario di entrata" + entrata.format(formatter);
   }
}







package Tools;


import java.util.Scanner;


public class Utility {
   /*public static void main(String[] args) {


   }*/
   private Utility() {
   }


   ; //impedisce di istanziare la classe


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


   public static int Menu(String opzioni[], Scanner tastiera) {// parametri formali
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

