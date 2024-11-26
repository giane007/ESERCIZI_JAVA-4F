import static Utility.Tools.*;
import java.util.Scanner;
import java.util.Random;
public class Genera_numeri_casuali {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
     
       String [] opzioni ={"Menu","1.inserimento","2.Visualizzazione","3.Fine"};
       boolean esci = true;
       final int MAX_NUMERI = 100;
       int[] nEstratti= null;
       int [] nGenerati= new int[MAX_NUMERI];
       do{
           switch(Menu(opzioni,tastiera)){
               case 1:
                   System.out.println("Inserimento");
                   /*for(int i=0; i<MAX_NUMERI;i++){
                       nGenerati[i]= numeroRandom.nextInt(0,100)+1;
                   }*/
                   nEstratti = generanumeri(MAX_NUMERI);
                   break;
               case 2:
                   System.out.println("Visualizzazione");
                   for(int i=0; i<nGenerati.length;i++){
                       System.out.println(nEstratti[i]);
                   }
                   break;
               case 3:
                   System.out.println("Fine");
                   esci= false;
                   break;
           }
       }while(esci);
   }


   public static int[] generanumeri(int nNumeri){
       Random numeroRandom = new Random();
       int[] nGenerati = new int [nNumeri];
       for(int i=0; i<nNumeri;i++)
           nGenerati[i] = numeroRandom.nextInt(0,nNumeri)+1;
           return nGenerati;


   }
   public static void generanumeri2(int[]vettore){
       Random numeroRandom = new Random();


       for(int i=0; i<vettore.length;i++)
           vettore[i] = numeroRandom.nextInt(0,vettore.length)+1;




   }
}

