import static Tools.Utility.*;




import java.util.Scanner;
import java.util.Random;




public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       String[] opzioni = {"Menu", "1 Genera Random", "2 Visualizzazione", "3 Cancella", "4 Fine"};
       boolean esci = true;
       final int MAXNUMERI = 100;
       int[] nEstratti2 = new int[MAXNUMERI]; // Array per memorizzare i numeri generati




       do {
           switch (Menu(opzioni, tastiera)) {
               case 1:
                   System.out.println("Generazione numeri casuali...");
                   generaNumeri2(nEstratti2);
                   break;
               case 2:
                   System.out.println("Visualizzazione numeri:");
                   visualizzaNumeri(nEstratti2);
                   break;
               case 3:
                   System.out.println("Inserisci il numero da cancellare:");
                   int numero = Integer.parseInt(tastiera.nextLine());
                   cancella(nEstratti2, numero);
                   break;
               case 4:
                   System.out.println("Rimpiazzza numero");
                   int num;
                   System.out.println("Inserisci il valore da rimpiazzare");
                   num = Integer.parseInt(tastiera.nextLine());
                   rimpiazza(nEstratti2,num);
                   break;
               case 5:
                   System.out.println("Fine del programma.");
                   esci = false;
                   break;
               default:
                   System.out.println("Opzione non valida. Riprova.");
           }
       } while (esci);
       tastiera.close();
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




   // Funzione per cancellare un numero specifico e ricompattare il vettore
   public static void cancella(int[] vettore, int numero) {
       boolean trova = false;
       for (int i = 0; i < vettore.length; i++) {
           if (vettore[i] == numero) {
               trova = true;
               // Sposta gli elementi successivi a sinistra
               for (int j = i; j < vettore.length - 1; j++) {
                   vettore[j] = vettore[j + 1];
               }
               vettore[vettore.length - 1] = 0; // Mette 0 alla fine dopo la ricompattazione
               i--; // Ricomincia il controllo dall'indice corrente
           }
       }
       if (trova) {
           System.out.println("Numero " + numero + " cancellato e vettore ricompattato.");
       } else {
           System.out.println("Numero " + numero + " non trovato.");
       }
   }




   // Funzione per visualizzare i numeri in righe di 10
   public static void visualizzaNumeri(int[] vettore) {
       for (int i = 0; i < vettore.length; i++) {
           System.out.printf("%4d ", vettore[i]);
           if ((i + 1) % 10 == 0) {
               System.out.println(); // Nuova riga ogni 10 numeri
           }
       }
   }
  
   public static void rimpiazza(int [] vettore,int valore){
      
     
       for (int i = 0; i < vettore.length; i++) {
           if (esisteNelVettore(vettore,valore,)) {
              
               // Sposta gli elementi successivi a sinistra
               for (int j = i; j < vettore.length - 1; j++) {
                   vettore[j] = vettore[j + 1];
               }
               vettore[vettore.length - 1] = 0; // Mette 0 alla fine dopo la ricompattazione
               i--; // Ricomincia il controllo dall'indice corrente
           }
           if (esisteNelVettore(vettore,valore,)) {
              
           } else {
               System.out.println("Numero " + valore + " non trovato.");
           }
       }
      
   }
}



