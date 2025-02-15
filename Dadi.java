import Tools.Utility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        int giocatori = 2;
        int turni;

        System.out.println("Inserisci il numero di turni");
        Gara.setTurni = (Integer.parseInt(tastiera.nextLine()));

    switch (Utility.Menu(giocatori)) {}

    }
}






public class Gara {
    public static int setTurni;
    private boolean fineGara = false;
    private String Vincitore;
    private int turni;

    public boolean isFineGara() {
        return fineGara;
    }

    public boolean setFineGara(boolean fineGara) {
        return this.fineGara = fineGara;
    }

    public void setTurni(int turni) {
        this.turni = turni;
    }

    public int getTurni() {
        return turni;
    }

    public void setVincitore(String vincitore) {
        Vincitore = vincitore;
    }

    public String getVincitore() {
        return Vincitore;
    }

    public Gara(boolean fineGara, String vincitore, int turni) {
        this.fineGara = fineGara;
        Vincitore = vincitore;
        this.turni = turni;
    }

    public void round(String nomeGiocatore1, String nomeGiocatore2, Dado) {
        for(int i=0; i< turni; i++){
            if(i % 2 ==0){
                System.out.println("Turno del giocatore 1");

            }else{
                System.out.println("Turno del giocatore 2");
            }

        }
    }

    public void risultatoPartita(String nomeGiocatore1, String nomeGiocatore2){

    }

    public void resettaGioco(boolean fineGara){
        setFineGara(fineGara) = true;
    }
}






public class Giocatore {
    private String nomeGiocatore;
    private int nVittorie;



    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setnVittorie(int nVittorie) {
        this.nVittorie = nVittorie;
    }

    public int getnVittorie() {
        return nVittorie;
    }


    public Giocatore(String nomeGiocatore, int nVittorie) {
        this.nomeGiocatore = nomeGiocatore;
        this.nVittorie = nVittorie;
    }
}






import java.util.Random;
public class Dado {
    private int nFacce;
    private int valFaccia;
    private Random valLancio = new Random();

    public void setnFacce(int nFacce) {
        this.nFacce = nFacce;
    }

    public void setValFaccia(int valFaccia) {
        this.valFaccia = valFaccia;
    }

    public void setValLancio(Random valLancio) {
        this.valLancio = valLancio;
    }

    public int getnFacce() {
        return nFacce;
    }

    public int getValFaccia() {
        return valFaccia;
    }

    public Random getValLancio() {
        return valLancio;
    }

    public Dado(Random valLancio, int nFacce, int valFaccia) {
        this.valLancio = valLancio;
        this.nFacce = nFacce;
        this.valFaccia = valFaccia;
    }
}





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
