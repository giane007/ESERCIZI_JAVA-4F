import static Tools.Utility.*;
import java.util.Scanner;
import java.util.Random;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       String[] opzioni = {"Menu", "1 Genera Random", "2 Visualizzazione", "3 Fine"};
       boolean esci = true;
       final int MAXNUMERI = 100;
       int[] nEstratti2 = new int[MAXNUMERI]; // Array per memorizzare i numeri generati


       do {
           switch (Menu(opzioni, tastiera)) {
               case 1:
                   System.out.println("Generazione");
                   generaNumeri2(nEstratti2);
                   break;
               case 2:
                   System.out.println("Visualizzazione");
                   for (int i = 0; i < nEstratti2.length; i++)
                       System.out.println(nEstratti2[i]);
                   break;
               case 3:
                   System.out.println("Fine");
                   esci = false;
                   break;
           }
       } while (esci);
   }


   // Funzione per generare numeri unici
   public static void generaNumeri2(int[] vettore) {
       Random numeroRandom = new Random();
       int cont = 0;


       while (cont < vettore.length) {
           int numeroGenerato = numeroRandom.nextInt(vettore.length) + 1;


           // Controlla se il numero generato è già stato inserito nell'array
           if (!esisteNelVettore(vettore, numeroGenerato, cont)) {
               vettore[cont] = numeroGenerato;
               cont++;
           }
       }
   }


   // Funzione/metodo per verificare se un numero esiste già nel vettore
   public static boolean esisteNelVettore(int[] vettore, int numero, int limite) {
       for (int i = 0; i < limite; i++) {
           if (vettore[i] == numero) {
               return true;
           }
       }
       return false;
   }


}

//UTILITY
package Tools;
import java.util.Scanner;
public class Utility{
   /*public static void main(String[] args) {


   }*/
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

