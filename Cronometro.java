public class Simulazione {
    public static void main(String[] args) {
        // Creazione di un'istanza del cronometro
        Cronometro cronometro = new Cronometro();

        // Simulazione del cronometro
        cronometro.avvia(); // Avvia il cronometro

        // Simula un'attesa prima del primo giro
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        cronometro.registraGiro(); // Registra il primo giro

        // Simula un'attesa prima del secondo giro
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        cronometro.registraGiro(); // Registra il secondo giro

        // Simula un'attesa prima del terzo giro
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        cronometro.registraGiro(); // Registra il terzo giro

        // Ferma il cronometro
        cronometro.ferma();

        // Stampa il tempo totale
        System.out.println("Tempo totale: " + cronometro.tempoTotale() + " ms");

        // Stampa i dettagli dei giri
        cronometro.stampaDettagliGiri();

        // Stampa le differenze tra i tempi dei giri
        cronometro.stampaDifferenzeGiri();
    }
}

//Classe cronometro
import java.util.ArrayList;
import java.util.List;

class Cronometro {
    private long tempoInizio; // Memorizza il tempo di avvio in millisecondi
    private long tempoFine;   // Memorizza il tempo di fine in millisecondi
    private boolean inEsecuzione; // Stato del cronometro (true se in esecuzione)
    private List<Long> tempiGiri; // Elenco dei tempi di ciascun giro

    // Costruttore
    public Cronometro() {
        this.inEsecuzione = false;
        this.tempiGiri = new ArrayList<>();
    }

    // Metodo per avviare il cronometro
    public void avvia() {
        if (!inEsecuzione) {
            this.tempoInizio = System.currentTimeMillis();
            this.inEsecuzione = true;
            System.out.println("Cronometro avviato alle " + tempoInizio + " ms.");
        } else {
            System.out.println("Il cronometro è già avviato.");
        }
    }

    // Metodo per fermare il cronometro
    public void ferma() {
        if (inEsecuzione) {
            this.tempoFine = System.currentTimeMillis();
            this.inEsecuzione = false;
            System.out.println("Cronometro fermato alle " + tempoFine + " ms.");
        } else {
            System.out.println("Il cronometro è già fermo.");
        }
    }

    // Metodo per registrare un giro
    public void registraGiro() {
        if (inEsecuzione) {
            long tempoCorrente = System.currentTimeMillis();
            long tempoGiro = tempoCorrente - tempoInizio;
            tempiGiri.add(tempoGiro);
            System.out.println("Giro registrato: " + tempoGiro + " ms dall'inizio.");
        } else {
            System.out.println("Non è possibile registrare un giro senza avviare il cronometro.");
        }
    }

    // Metodo per calcolare il tempo totale
    public long tempoTotale() {
        if (inEsecuzione) {
            return System.currentTimeMillis() - tempoInizio;
        } else {
            return tempoFine - tempoInizio;
        }
    }

    // Metodo per visualizzare i dettagli dei giri
    public void stampaDettagliGiri() {
        if (tempiGiri.isEmpty()) {
            System.out.println("Nessun giro registrato.");
        } else {
            System.out.println("Dettagli dei giri registrati:");
            for (int i = 0; i < tempiGiri.size(); i++) {
                System.out.println("Giro " + (i + 1) + ": " + tempiGiri.get(i) + " ms");
            }
        }
    }

    // Metodo per calcolare la differenza tra i tempi dei giri
    public void stampaDifferenzeGiri() {
        if (tempiGiri.size() < 2) {
            System.out.println("Sono necessari almeno due giri per calcolare le differenze.");
        } else {
            System.out.println("Differenze tra i tempi dei giri:");
            for (int i = 1; i < tempiGiri.size(); i++) {
                long differenza = tempiGiri.get(i) - tempiGiri.get(i - 1);
                System.out.println("Differenza tra giro " + i + " e giro " + (i + 1) + ": " + differenza + " ms");
            }
        }
    }
}
