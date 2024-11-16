import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//Classe Pilota

class Pilota {
   private String nome;


   public Pilota(String nome) {
       this.nome = nome;
   }


   public String getNome() {
       return nome;
   }
}

//Classe main

public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       System.out.println("Inserisci il nome della gara:");
       String nomeGara = tastiera.nextLine();


       // Crea una gara
       Gara gara = new Gara(nomeGara);


       System.out.println("Inserisci la quantità di piloti:");
       int quantità = Integer.parseInt(tastiera.nextLine());


       // Aggiungi piloti alla gara
       for (int i = 0; i < quantità; i++) {
           System.out.println("Inserisci il nome del " + (i + 1) + "° pilota:");
           String nomePilota = tastiera.nextLine();
           Pilota pilota = new Pilota(nomePilota);
           gara.aggiungiPilota(pilota);
       }


       // Corri la gara
       gara.corriGara();
   }
}






//Classe gara

import java.util.ArrayList;
import java.util.Random;


class Gara {
   static String nome;
   ArrayList<Pilota> piloti;
   static int risultato;  // 1 se il pilota ha vinto, 0 se non ha vinto


   public Gara(String nome) {
       this.nome = nome;
       this.piloti = new ArrayList<>();
   }


   public void aggiungiPilota(Pilota pilota) {
       piloti.add(pilota);
   }


   public void corriGara() {
       // Simula l'esito della gara
       Random rand = new Random();
       risultato = rand.nextInt(piloti.size());  // Seleziona un pilota casuale
       Pilota vincitore = piloti.get(risultato);


       System.out.println("Gara partita!");
       System.out.println("Il pilota " + vincitore.getNome() + " ha vinto!");
   }
}

