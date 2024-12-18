//Classe Main
package Utility;

import Utility.*;

import java.util.Random;
import java.util.Scanner;

// Classe principale
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
            tempo = random.nextInt(4001) + 1000; // Tempo casuale tra 1000 e 5000 ms
            cronometro1.setStartTime();
            Wait(tempo);
            cronometro1.setEndTime();
            cronometro1.calcolaIntTimer();

            tempo = random.nextInt(4001) + 1000;
            cronometro2.setStartTime();
            Wait(tempo);
            cronometro2.setEndTime();
            cronometro2.calcolaIntTimer();

            tempo = random.nextInt(4001) + 1000;
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

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





//Classe Cronometro
package Utility;

public class Cronometro {
    private long startTime;
    private long endTime;
    private int tempoTotale;

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void calcolaIntTimer() {
        this.tempoTotale = (int) (endTime - startTime);
    }

    public int getTempoTotale() {
        return tempoTotale;
    }

    @Override
    public String toString() {
        return tempoTotale + " ms";
    }
}





//Classe Gara
package Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gara {
    private String nomeGara;
    private Pilota nazioneGara;
    private ArrayList<Scuderia> griglia;

    public Gara(String nomeGara, Pilota nazioneGara) {
        this.nomeGara = nomeGara;
        this.nazioneGara = nazioneGara;
        this.griglia = new ArrayList<>();
    }

    public void aggiungiElemento(Scuderia scuderia) {
        griglia.add(scuderia);
    }

    public void ordinaGara() {
        Collections.sort(griglia, Comparator.comparing(Scuderia::getPilotaNome));
    }

    public ArrayList<Scuderia> getGriglia() {
        return griglia;
    }

    public String getVincitore() {
        if (griglia.isEmpty()) return "Nessun vincitore";
        return griglia.get(0).getPilotaNome();
    }
}





//Classe Pilota
package Utility;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;

    public Pilota(String nome, String cognome, String nazionalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + nazionalita + ")";
    }
}





//Classe Scuderia
package Utility;

public class Scuderia implements Comparable<Scuderia> {
    private String nome;
    private String pilotaNome;
    private int punteggio;
    private Cronometro cronometro;

    public Scuderia(String nome, String pilotaNome, int punteggio, Cronometro cronometro) {
        this.nome = nome;
        this.pilotaNome = pilotaNome;
        this.punteggio = punteggio;
        this.cronometro = cronometro;
    }

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

    @Override
    public int compareTo(Scuderia altra) {
        return Integer.compare(this.cronometro.getTempoTotale(), altra.cronometro.getTempoTotale());
    }

    @Override
    public String toString() {
        return "Scuderia: " + nome + ", Pilota: " + pilotaNome + ", Tempo: " + cronometro;
    }
}




//Classe tools
package Utility;

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

    public static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = Integer.parseInt(tastiera.nextLine());
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        } while ((scelta < 1) || (scelta > opzioni.length - 1));
        return scelta;
    }
}
