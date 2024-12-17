import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int tempo;
        Scanner scanner = new Scanner(System.in);

        try {
            // Ottieni i dati da tastiera per la gara
            System.out.println("Inserisci il nome della gara:");
            String nomeGara = scanner.nextLine();

            System.out.println("Inserisci il nome del pilota per la scuderia 1:");
            String pilota1Nome = scanner.nextLine();
            System.out.println("Inserisci il nome della scuderia 1:");
            String scuderia1Nome = scanner.nextLine();

            System.out.println("Inserisci il nome del pilota per la scuderia 2:");
            String pilota2Nome = scanner.nextLine();
            System.out.println("Inserisci il nome della scuderia 2:");
            String scuderia2Nome = scanner.nextLine();

            System.out.println("Inserisci il nome del pilota per la scuderia 3:");
            String pilota3Nome = scanner.nextLine();
            System.out.println("Inserisci il nome della scuderia 3:");
            String scuderia3Nome = scanner.nextLine();

            // Crea il cronometro e le scuderie con i dati inseriti
            Cronometro cronometro1 = new Cronometro();
            Cronometro cronometro2 = new Cronometro();
            Cronometro cronometro3 = new Cronometro();

            Scuderia scuderia1 = new Scuderia(scuderia1Nome, pilota1Nome, 150, cronometro1);
            Scuderia scuderia2 = new Scuderia(scuderia2Nome, pilota2Nome, 120, cronometro2);
            Scuderia scuderia3 = new Scuderia(scuderia3Nome, pilota3Nome, 110, cronometro3);

            Pilota nazioneGara = new Pilota("null", "null", "America");
            Gara gara = new Gara(nomeGara, nazioneGara);

            // Aggiungi le scuderie alla gara
            gara.aggiungiElemento(scuderia1);
            gara.aggiungiElemento(scuderia2);
            gara.aggiungiElemento(scuderia3);

            // Thread per l'animazione ASCII delle macchine
            Thread animazioneThread = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        mostraImmagineCaricamento();
                    }
                } catch (Exception e) {
                    System.out.println("Animazione interrotta.");
                }
            });

            // Avvia l'animazione mentre si calcolano i tempi
            animazioneThread.start();

            // Calcolo dei tempi per ciascuna scuderia
            tempo = random.nextInt(1000, 5000) + 1;  // Ridotto il tempo per test
            cronometro1.setStartTime();
            Wait(tempo);
            cronometro1.setEndTime();
            cronometro1.calcolaIntTimer();

            tempo = random.nextInt(1000, 5000) + 1;
            cronometro2.setStartTime();
            Wait(tempo);
            cronometro2.setEndTime();
            cronometro2.calcolaIntTimer();

            tempo = random.nextInt(1000, 5000) + 1;
            cronometro3.setStartTime();
            Wait(tempo);
            cronometro3.setEndTime();
            cronometro3.calcolaIntTimer();

            // Interrompi l'animazione una volta finito
            animazioneThread.interrupt();
            animazioneThread.join();

            // Ordina la gara
            gara.ordinaGara();

            // Mostra i risultati
            System.out.println("\n=== Risultati della Gara ===");
            gara.getGriglia().forEach(System.out::println);
            System.out.println("Il vincitore è: " + gara.getVincitore() + " Scuderia: " + gara.getGriglia().get(0).getNome());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Funzione per visualizzare l'immagine della macchina che va avanti e indietro in ASCII
    public static void mostraImmagineCaricamento() {
        String macchinaAvanti = "               __\n" +
                "                   _.--\"\"  |\n" +
                "    .----.     _.-'   |/\\| |.--.\n" +
                "    |jrei|__.-'   _________|  |_)  _______________  \n" +
                "    |  .-\"\"-.\"\"\"\"\" ___,    `----'\"))   __   .-\"\"-.\"\"\"\"--._  \n" +
                "    '-' ,--. `    |tic|   .---.       |:.| ' ,--. `      _`.\n" +
                "     ( (    ) ) __|tac|__ \\\\|// _..--  \\/ ( (    ) )--._\".-.\n" +
                "      . `--' ;\\__________________..--------. `--' ;--------'\n" +
                "       `-..-'                               `-..-'";

        String macchinaIndietro =
                "                                     __\n" +
                        "                               _.--\"\"  |\n" +
                        "                .----.     _.-'   |/\\| |.--.\n" +
                        "               |jrei|__.-'   _________|  |_)  _______________  \n" +
                        "               |  .-\"\"-.\"\"\"\"\" ___,    `----'\"))   __   .-\"\"-.\"\"\"\"--._  \n" +
                        "               '-' ,--. `    |tic|   .---.       |:.| ' ,- -. `      _`.\n" +
                        "                ( (    ) ) __|tac|__ \\\\|// _..-- \\/( (    ) )--._\".-.\n" +
                        "                 . `--' ;\\__________________..--------. `--' ;--------'\n" +
                        "                  `-..-'                                `-..-'";

        System.out.print("\r" + macchinaAvanti);
        try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        System.out.print("\r" + macchinaIndietro);
        try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

public class Cronometro {
    private long startTime;         // Tempo di inizio
    private long endTime;           // Tempo di fine
    private int tempoTotale;        // Tempo totale impiegato

    // Imposta l'orario di inizio del cronometro
    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    // Imposta l'orario di fine del cronometro
    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    // Calcola la durata totale in millisecondi
    public void calcolaIntTimer() {
        this.tempoTotale = (int) (endTime - startTime);
    }

    // Restituisce il tempo totale in millisecondi
    public int getTempoTotale() {
        return tempoTotale;
    }

    // Metodo toString per visualizzare il tempo in formato leggibile
    @Override
    public String toString() {
        return tempoTotale + " ms";
    }
}


import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gara {
    private String nomeGara;          // Nome della gara
    private Pilota nazioneGara;       // Nazione della gara (può essere utilizzato per identificare la località)
    private List<Scuderia> griglia;   // Lista delle scuderie partecipanti

    // Costruttore per inizializzare i dati della gara
    public Gara(String nomeGara, Pilota nazioneGara) {
        this.nomeGara = nomeGara;
        this.nazioneGara = nazioneGara;
        this.griglia = new ArrayList<>();
    }

    // Metodo per aggiungere una scuderia alla gara
    public void aggiungiElemento(Scuderia scuderia) {
        griglia.add(scuderia);
    }

    // Ordina le scuderie in base al tempo (più veloce prima)
    public void ordinaGara() {
        Collections.sort(griglia);
    }

    // Restituisce la lista delle scuderie ordinate
    public List<Scuderia> getGriglia() {
        return griglia;
    }

    // Restituisce il vincitore della gara (scuderia con il miglior tempo)
    public String getVincitore() {
        if (griglia.isEmpty()) return "Nessun vincitore";


        return griglia.get(0).getPilotaNome() + " " + griglia.get(0).getPilotaNome();


public class Pilota {
    private String nome;            // Nome del pilota
    private String cognome;         // Cognome del pilota
    private String nazionalita;     // Nazionalità del pilota

    // Costruttore per inizializzare i dati del pilota
    public Pilota(String nome, String cognome, String nazionalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    // Getters per accedere ai dati del pilota
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    // Metodo toString per stampare i dati del pilota in formato leggibile
    @Override
    public String toString() {
        return nome + " " + cognome + " (" + nazionalita + ")";
    }
}


public class Scuderia implements Comparable<Scuderia> {
    private String nome;             // Nome della scuderia
    private String pilotaNome;       // Nome del pilota (ora trattato come Stringa)
    private int punteggio;           // Punteggio della scuderia (può essere usato come bonus o altre logiche)
    private Cronometro cronometro;   // Cronometro per calcolare il tempo della scuderia

    // Costruttore per inizializzare la scuderia con i dati forniti
    public Scuderia(String nome, String pilotaNome, int punteggio, Cronometro cronometro) {
        this.nome = nome;
        this.pilotaNome = pilotaNome;
        this.punteggio = punteggio;
        this.cronometro = cronometro;
    }

    // Getters per i vari attributi
    public String getNome() {
        return nome;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getPilotaNome() {
        return pilotaNome;
    }

    // Implementazione del metodo compareTo per ordinare le scuderie in base al tempo
    @Override
    public int compareTo(Scuderia altra) {
        return Integer.compare(this.cronometro.getTempoTotale(), altra.cronometro.getTempoTotale());
    }

    // Metodo toString per stampare i dati della scuderia in formato leggibile
    @Override
    public String toString() {
        return "Scuderia: " + nome + ", Pilota: " + pilotaNome + ", Tempo: " + cronometro;
    }
}


package utility;

import java.util.Scanner;
public class Tools {

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

    public static int Menu(String opzioni[], Scanner tastiera) {// parametri formali
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
