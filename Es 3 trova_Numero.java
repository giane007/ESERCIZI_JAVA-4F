import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       int[] vettore = {1, 2, 3, 4, 1, 5, 6, 7, 1, 10};


       //Fa vedere il vettore
       System.out.println("Array: ");
       for (int i=0;i<vettore.length;i++) {
           System.out.print(vettore[i] + " ");
       }
       System.out.println(); //Salta una riga
      
       System.out.println("Che numero vuoi cercare?");
       int numero = tastiera.nextInt();


       int cont = findAll(vettore, numero);


       if (cont > 0) {
           System.out.println("Il numero " + numero + " è stato trovato " + cont + " volte.");
       } else {
           System.out.println("Nessun numero trovato.");
       }
      
   }


   public static int findAll(int[] array, int n) {
       int cont = 0;


       for (int i = 0; i < array.length; i++) {
           if (array[i] == n) {
               cont++;
               System.out.println("Trovato in posizione: " + i); // Stampa la posizione dell'elemento
           }
       }


       return cont;
   }
}

