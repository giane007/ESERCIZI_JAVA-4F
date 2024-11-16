import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
   static int conto = 0;
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


       for (int j : vettore) {
           System.out.println(j);
       }


       System.out.println("Che numero vuoi rimuovere dal vettore");
       n = tastiera.nextInt();


       System.out.println();
       //Nuovo vettore
       vettore = removeNum(vettore, n);
       if (test(vettore, n)) {
           System.out.println("Il metodo funziona");
           for (int i : vettore) {
               System.out.println("" + i);
           }
       } else {
           System.out.println("Il metodo non funziona");
       }
   }
   public static int[] removeNum(int[] array, int n) {
       //Contatore per la lughezza del nuovo vettore
       int cont = 0;
       int[] newArray = null;
       //Ciclo per TROVARE la lungnrzza del vettore
       for (int value : array) {
           if (value == n) {
               cont++;
           }
       }
       //Se il contatore è maggiore di 0 popola l'array
       if (cont > 0) {
           newArray = new int[array.length - cont];
           int j = 0;


           for (int k : array) {
               if (k != n) {
                   newArray[j++] = k;
               }
           }
           conto++;
           return newArray;
       }
       //Ritorna l'array
       if(conto > 0){
           return array;
       }
       return null;
   }
   public static boolean test(int[] array, int numero) {
       if (array != null)
       return removeNum(array, numero) != null;
       else
           return false;
   }
}

