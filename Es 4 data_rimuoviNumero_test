import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);


       //LocalDate oggi = LocalDate.now();
       //System.out.println(oggi);


       //String data;
       //System.out.println("Inserisci la data");
       // data = tastiera.nextLine();


       //LocalDate date = LocalDate.parse(data);
       //System.out.println(date.plusDays(1));
       //System.out.println(date.getMonth());
       //System.out.println(date.format(DateTimeFormatter.ofPattern("MM")));




       int n;


       //Vettore di partenza
       int[] vettore = {1, 4, 6, 1, 7, 8, 9, 10, 1};


       for(int i=0;i<vettore.length;i++) {
           System.out.println(vettore[i]);
       }




       System.out.println("Che numero vuoi rimuovere dal vettore");
       n = tastiera.nextInt();


       System.out.println();
       //Nuovo vettore
       int[] newVettore = removeNum(vettore, n);
       test(vettore,n,newVettore);
       for (int i : newVettore) {
           System.out.println("" + i);
       }
   }


   public static int[] removeNum(int[] array, int n) {


       //Contatore per la lughezza del nuovo vettore
       int cont = 0;
       int[] newArray = null;


       //Ciclo per TROVARE la lungnrzza del vettore
       for (int i = 0; i < array.length; i++) {
           if (array[i] != n) {
               cont++;
           }
       }


       //Se il contatore è maggiore di 0 popola l'array
       if (cont > 0) {
           newArray = new int[cont];
           int j = 0;


           for (int i = 0; i < array.length; i++) {
               if (array[i] != n) {
                   newArray[j++] = array[i];
               }
           }
       }


       //Ritorna l'array
       return newArray;
   }
   public static boolean test(int[] array, int numero, int[] array2) {


       // metodo rimuoviNumero
       int[] risultato = removeNum(array, numero);


       // Confrontiamo la lunghezza dei due array
       if (risultato.length != array2.length) {
           return false;
       }


       // Confrontiamo elemento per elemento
       for (int i = 0; i < risultato.length; i++) {
           if (risultato[i] != array2[i]) {
               return false;
           }
       }


       // Se tutti i controlli sono passati, il test è corretto
       return true;
   }
}

