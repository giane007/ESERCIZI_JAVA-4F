import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Inserisci il nome del Giocatore 1:");
        String nome1 = tastiera.nextLine();

        System.out.println("Inserisci il nome del Giocatore 2:");
        String nome2 = tastiera.nextLine();

        System.out.println("Inserisci il numero di turni:");
        int turni = Integer.parseInt(tastiera.nextLine());

        Giocatore giocatore1 = new Giocatore(nome1, 0);
        Giocatore giocatore2 = new Giocatore(nome2, 0);
        Dado dado = new Dado(new Random(), 6, 1);

        Gara gara = new Gara(false, "", turni);
        gara.round(giocatore1, giocatore2, dado);

        gara.risultatoPartita(giocatore1, giocatore2);
    }
}





public class Gara {
    private boolean fineGara = false;
    private String vincitore;
    private int turni;

    public Gara(boolean fineGara, String vincitore, int turni) {
        this.fineGara = fineGara;
        this.vincitore = vincitore;
        this.turni = turni;
    }

    public void round(Giocatore g1, Giocatore g2, Dado dado) {
        for (int i = 0; i < turni; i++) {
            System.out.println("Turno " + (i + 1));

            int lancio1 = dado.lancia();
            int lancio2 = dado.lancia();

            System.out.println(g1.getNomeGiocatore() + " ha lanciato: " + lancio1);
            System.out.println(g2.getNomeGiocatore() + " ha lanciato: " + lancio2);

            if (lancio1 > lancio2) {
                g1.setnVittorie(g1.getnVittorie() + 1);
                System.out.println(g1.getNomeGiocatore() + " vince il turno!");
            } else if (lancio2 > lancio1) {
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.println(g2.getNomeGiocatore() + " vince il turno!");
            } else {
                g1.setnVittorie(g1.getnVittorie() + 1);
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.println("Parità! Entrambi guadagnano un punto.");
            }
        }
    }

    public void risultatoPartita(Giocatore g1, Giocatore g2) {
        System.out.println("\nRisultati finali:");
        System.out.println(g1.getNomeGiocatore() + " ha vinto " + g1.getnVittorie() + " turni.");
        System.out.println(g2.getNomeGiocatore() + " ha vinto " + g2.getnVittorie() + " turni.");

        if (g1.getnVittorie() > g2.getnVittorie()) {
            System.out.println("Il vincitore è: " + g1.getNomeGiocatore());
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            System.out.println("Il vincitore è: " + g2.getNomeGiocatore());
        } else {
            System.out.println("La partita è finita in parità!");
        }
    }
}






public class Giocatore {
    private String nomeGiocatore;
    private int nVittorie;

    public Giocatore(String nomeGiocatore, int nVittorie) {
        this.nomeGiocatore = nomeGiocatore;
        this.nVittorie = nVittorie;
    }

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public int getnVittorie() {
        return nVittorie;
    }

    public void setnVittorie(int nVittorie) {
        this.nVittorie = nVittorie;
    }
}





import java.util.Random;

public class Dado {
    private int nFacce;
    private Random valLancio;

    public Dado(Random valLancio, int nFacce, int valFaccia) {
        this.valLancio = valLancio;
        this.nFacce = nFacce;
    }

    public int lancia() {
        return valLancio.nextInt(nFacce) + 1;
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
