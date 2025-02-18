import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        // Messaggi nel main
        String inserisciGiocatore1 = "Inserisci il nome del Giocatore 1:";
        String inserisciGiocatore2 = "Inserisci il nome del Giocatore 2:";
        String inserisciTurni = "Inserisci il numero di turni:";
        String numeroTurno = "Turno %d";
        String vincitoreDelTurno = "%s vince il turno!";
        String parita = "Parità! Entrambi guadagnano un punto.";
        String risultatiFinali = "\nRisultati finali:";
        String vincitoreTotTurni = " ha vinto %d turni.";
        String finePartita = "La partita è finita in parità!";
        String vincitorePartita = "Il vincitore è: ";
        String lancioDelDado = "Lancio del dado... ";

        // Input giocatori e turni
        System.out.println(inserisciGiocatore1);
        String nome1 = tastiera.nextLine();

        System.out.println(inserisciGiocatore2);
        String nome2 = tastiera.nextLine();

        System.out.println(inserisciTurni);
        int turni = Integer.parseInt(tastiera.nextLine());

        // Creazione oggetti per i giocatori e il dado
        Giocatore giocatore1 = new Giocatore(nome1, 0);
        Giocatore giocatore2 = new Giocatore(nome2, 0);
        Dado dado = new Dado(new Random(), 6);

        // Inizializzazione della gara
        Gara gara = new Gara(turni);
        gara.round(giocatore1, giocatore2, dado, lancioDelDado, numeroTurno, vincitoreDelTurno, parita);
        gara.risultatoPartita(giocatore1, giocatore2, risultatiFinali, vincitoreTotTurni, finePartita, vincitorePartita);
    }
}





// File: Gara.java
public class Gara {
    private int turni;

    public Gara(int turni) {
        this.turni = turni;
    }

    public void round(Giocatore g1, Giocatore g2, Dado dado, String diceRollingMessage, String turnMessage, String winnerTurnMessage, String drawMessage) {
        for (int i = 0; i < turni; i++) {
            // Invia al main che è il turno corrente
            System.out.printf((turnMessage) + "%n", i + 1);

            int lancio1 = dado.lanciaConAnimazione(diceRollingMessage);
            int lancio2 = dado.lanciaConAnimazione(diceRollingMessage);

            // Risultati per il turno
            if (lancio1 > lancio2) {
                g1.setnVittorie(g1.getnVittorie() + 1);
                System.out.printf((winnerTurnMessage) + "%n", g1.getNomeGiocatore());
            } else if (lancio2 > lancio1) {
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.printf((winnerTurnMessage) + "%n", g2.getNomeGiocatore());
            } else {
                g1.setnVittorie(g1.getnVittorie() + 1);
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.println(drawMessage);
            }
        }
    }

    public void risultatoPartita(Giocatore g1, Giocatore g2, String finalResultsMessage, String winsMessage, String gameOverMessage, String gameWinnerMessage) {
        System.out.println(finalResultsMessage);
        System.out.println(g1.getNomeGiocatore() + String.format(winsMessage, g1.getnVittorie()));
        System.out.println(g2.getNomeGiocatore() + String.format(winsMessage, g2.getnVittorie()));

        if (g1.getnVittorie() > g2.getnVittorie()) {
            System.out.println(gameWinnerMessage + g1.getNomeGiocatore());
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            System.out.println(gameWinnerMessage + g2.getNomeGiocatore());
        } else {
            System.out.println(gameOverMessage);
        }
    }
}





// File: Giocatore.java
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


// File: Dado.java
import java.util.Random;

public class Dado {
    private int nFacce;
    private Random valLancio;

    public Dado(Random valLancio, int nFacce) {
        this.valLancio = valLancio;
        this.nFacce = nFacce;
    }

    // Dice animation before the roll
    public int lanciaConAnimazione(String diceRollingMessage) {
        // Animazione del dado
        System.out.print(diceRollingMessage);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);  // Tempo tra ogni animazione
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Genera il risultato finale
        int result = valLancio.nextInt(nFacce) + 1;
        System.out.println("\nLancio: " + result);
        return result;
    }
}




//Package Tools Utility
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
