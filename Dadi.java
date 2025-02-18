import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        // Messaggi nel main
        String messaggioInserisciGiocatore1 = "Inserisci il nome del Giocatore 1:";
        String messaggioInserisciGiocatore2 = "Inserisci il nome del Giocatore 2:";
        String messaggioInserisciTurni = "Inserisci il numero di turni:";
        String messaggioNumeroTurno = "Turno %d";
        String messaggioVincitoreDelTurno = "%s vince il turno!";
        String messaggioParita = "Parità! Entrambi guadagnano un punto.";
        String messaggioRisultatiFinali = "\nRisultati finali:";
        String messaggioVincitoreTotTurni = " ha vinto %d turni.";
        String messaggioFinePartita = "La partita è finita in parità!";
        String messaggioVincitorePartita = "Il vincitore è: ";
        String messaggioLancioDelDado = "Lancio del dado... ";

        // Input giocatori e turni
        System.out.println(messaggioInserisciGiocatore1);
        String nomeGiocatore1 = tastiera.nextLine();

        System.out.println(messaggioInserisciGiocatore2);
        String nomeGiocatore2 = tastiera.nextLine();

        System.out.println(messaggioInserisciTurni);
        int numeroTurni = Integer.parseInt(tastiera.nextLine());

        // Creazione oggetti per i giocatori e il dado
        Giocatore giocatore1 = new Giocatore(nomeGiocatore1, 0);
        Giocatore giocatore2 = new Giocatore(nomeGiocatore2, 0);
        Dado dado = new Dado(new Random(), 6);

        // Inizializzazione della gara
        Gara gara = new Gara(numeroTurni);
        gara.round(giocatore1, giocatore2, dado, messaggioLancioDelDado, messaggioNumeroTurno, messaggioVincitoreDelTurno, messaggioParita);
        gara.risultatoPartita(giocatore1, giocatore2, messaggioRisultatiFinali, messaggioVincitoreTotTurni, messaggioFinePartita, messaggioVincitorePartita);
    }
}





// File: Gara.java
public class Gara {
    private int turni;

    public Gara(int turni) {
        this.turni = turni;
    }

    public void round(Giocatore g1, Giocatore g2, Dado dado, String messaggioLancioDado, String messaggioTurno, String messaggioVincitoreTurno, String messaggioParita) {
        for (int i = 0; i < turni; i++) {
            // Invia al main che è il turno corrente
            System.out.printf((messaggioTurno) + "%n", i + 1);

            int lancio1 = dado.lanciaConAnimazione(messaggioLancioDado);
            int lancio2 = dado.lanciaConAnimazione(messaggioLancioDado);

            // Risultati per il turno
            if (lancio1 > lancio2) {
                g1.setnVittorie(g1.getnVittorie() + 1);
                System.out.printf((messaggioVincitoreTurno) + "%n", g1.getNomeGiocatore());
            } else if (lancio2 > lancio1) {
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.printf((messaggioVincitoreTurno) + "%n", g2.getNomeGiocatore());
            } else {
                g1.setnVittorie(g1.getnVittorie() + 1);
                g2.setnVittorie(g2.getnVittorie() + 1);
                System.out.println(messaggioParita);
            }
        }
    }

    public void risultatoPartita(Giocatore g1, Giocatore g2, String messaggioRisultatiFinali, String messaggioVincitoreTotTurni, String messaggioFinePartita, String messaggioVincitorePartita) {
        System.out.println(messaggioRisultatiFinali);
        System.out.println(g1.getNomeGiocatore() + String.format(messaggioVincitoreTotTurni, g1.getnVittorie()));
        System.out.println(g2.getNomeGiocatore() + String.format(messaggioVincitoreTotTurni, g2.getnVittorie()));

        if (g1.getnVittorie() > g2.getnVittorie()) {
            System.out.println(messaggioVincitorePartita + g1.getNomeGiocatore());
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            System.out.println(messaggioVincitorePartita + g2.getNomeGiocatore());
        } else {
            System.out.println(messaggioFinePartita);
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

    // Animazione del lancio del dado
    public int lanciaConAnimazione(String messaggioLancioDado) {
        // Animazione del dado
        System.out.print(messaggioLancioDado);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);  // Tempo tra ogni animazione
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Genera il risultato finale
        int risultato = valLancio.nextInt(nFacce) + 1;
        System.out.println("\nLancio: " + risultato);
        return risultato;
    }
}




//Package Tools Utility
package Tools;
import java.util.Scanner;

public class Utility {

    private Utility() {}; // Impedisce di istanziare la classe

    public static void cancellaSchermo() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aspetta(int tempoAttesa) {
        try {
            Thread.sleep(tempoAttesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int menu(String[] opzioni, Scanner tastiera) {
        int scelta;

        do {
            cancellaSchermo();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = Integer.parseInt(tastiera.nextLine());
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                aspetta(2000);
            }
        } while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
}
