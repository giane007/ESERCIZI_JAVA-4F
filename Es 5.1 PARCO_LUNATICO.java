import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static Tools.Utility.*;


public class Main1 {
   public static void main(String[] args) {
       boolean esci = false;
       int nBiglietto = 0;
       int nPersone = 0;
       Scanner sc = new Scanner(System.in);
       final int MAXPERSONE = 10;
       ArrayList<Persona> lista = new ArrayList<>();
       String[] opzioni = {"GESTORE LUNAPARK", "Registra entrata", "Nuova giostra","Lista giostre per biglietto","Registra uscita","Esci"};
       do{
           switch (Menu(opzioni, sc)) {
               case 1 -> {  //ingresso
                   try {
                       if(nPersone>MAXPERSONE)
                           throw new Exception();
                       nPersone++;
                       Persona p = metodoCreazioneBiglietto(++nBiglietto);
                       lista.add(p);
                       System.out.println("numero assegnato al cliente: "+nBiglietto);


                   } catch( Exception e) {
                       System.out.println("luna park pieno");
                   }
               }
               case 2 -> {  //nuova giostra
                   System.out.println("numero biglietto cliente: ");
                   int numeroB = Integer.parseInt(sc.nextLine());
                   if(metodoTrovaBiglietto(lista, numeroB))
                   {
                       Persona p = metodoNuovaGiostra(numeroB,sc);
                       lista.add(p);
                   } else
                       System.out.println("numero non trovato");
               }
               case 3 -> {


               }
               case 4 -> esci = true;
           }


   } while (!esci);
}
   public static Persona metodoCreazioneBiglietto(int nBiglietto){
       Persona cliente = new Persona();
       cliente.numeroBiglietto = nBiglietto;
       cliente.momentoEvento= LocalDateTime.now(); //momento dell'ingresso
       return cliente;
   }


   public static Persona metodoNuovaGiostra(int nBiglietto, Scanner sc){
       Persona cliente = new Persona();
       boolean esci;
       do {
           try {
               System.out.println("quale giostra vuoi provare?[tagada,ottovolante,ruotapanoramica, autoscontro]");
               cliente.giostreProvate=ListaGiostre.valueOf(sc.nextLine().toUpperCase());
               esci=true;
           } catch(Exception e) {
               System.out.println("giostra non valida");
               esci=false;
           }


       }while(!esci);
       cliente.numeroBiglietto = nBiglietto;
       cliente.momentoEvento= LocalDateTime.now(); //momento della nuova giostra
       return cliente;
   }




   public static boolean metodoTrovaBiglietto(ArrayList<Persona> gestore, int nBiglietto){
       for (Persona persona : gestore) {
           if (persona.numeroBiglietto == nBiglietto) {
               return true;
           }
       }
       return false;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Persona {
   public int numeroBiglietto;
   public LocalDateTime momentoEvento; //o ingresso o salgo in giostra
   public ListaGiostre giostreProvate;


   @Override
   public String toString() {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
       return "Biglietto " + numeroBiglietto + ", Orario" + entrata.format(formatter);
   }
}

