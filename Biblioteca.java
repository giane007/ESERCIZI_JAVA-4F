//Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mensola mensola = new Mensola();

        String[] opzioni = {
                "Aggiungi Libro",
                "Rimuovi Libro",
                "Mostra Libri",
                "Esci"
        };

        int scelta;
        do {
            scelta = FrontEnd.Menu(opzioni, sc);
            FrontEnd.ClrScr();

            switch (scelta) {
                case 1 -> {
                    Libro libro = FrontEnd.leggiLibro(sc);
                    if (mensola.addLibro(libro)) {
                        System.out.println("Libro aggiunto con successo!");
                    } else {
                        System.out.println("Libro già presente!");
                    }
                }
                case 2 -> {
                    sc.nextLine(); // Consuma la newline
                    System.out.print("Inserisci il titolo del libro da rimuovere: ");
                    String titolo = sc.nextLine();
                    System.out.print("Inserisci l'autore del libro da rimuovere: ");
                    String autore = sc.nextLine();

                    if (mensola.rimuoviLibroPerAutore(titolo, autore)) {
                        System.out.println("Libro rimosso con successo!");
                    } else {
                        System.out.println("Libro non trovato!");
                    }
                }

                case 3 -> {
                    System.out.println("Libri sulla mensola:");
                    if(mensola.isVuota()){
                        System.out.println("Mensola vuota");
                    } else{
                        for (Libro libro : mensola.getMensola()) {
                            System.out.println(libro);
                        }
                    }

                }
                case 4 -> System.out.println("Uscita dal programma.");
                default -> System.out.println("Opzione non valida.");
            }
            FrontEnd.Wait(1000);
        } while (scelta != 4);
        
        sc.close();
    }
}
//Libro
public class Libro {
    private final String autore;
    private final String titolo;
    private final int nPagine;
    private final double costoPagina;
    private Genere tipo; // Enum

    // Enum per i generi
    public enum Genere {
        ROMANZO, MANUALE, THRILLER, GENERICO
    }

    // Costruttore
    public Libro(String autore, String titolo, int nPagine) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.costoPagina = 0.30; // valore di default
        this.tipo = Genere.GENERICO; // valore di default
    }

    // Costruttore con tipo specificato
    public Libro(String autore, String titolo, int nPagine, Genere tipo) {
        this(autore, titolo, nPagine);
        this.tipo = tipo;
    }

    // Metodi getter
    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNPagine() {
        return nPagine;
    }

    public double getCostoPagina() {
        return costoPagina;
    }

    public Genere getTipo() {
        return tipo;
    }

    // Override di toString
    @Override
    public String toString() {
        return "Libro [Autore: " + autore + ", Titolo: " + titolo + ", Pagine: " + nPagine +
                ", Tipo: " + tipo + ", Costo: " + costoPagina*nPagine + " €]";
    }

    // Override di equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;
        return titolo.equalsIgnoreCase(libro.titolo) && autore.equalsIgnoreCase(libro.autore);
    }
}
//Mensola
import java.util.ArrayList;

public class Mensola {
    private int nLibri;
    private final ArrayList<Libro> mensola;

    // Costruttore
    public Mensola() {
        this.nLibri = 0;
        this.mensola = new ArrayList<>();
    }

    // Aggiungere un libro
    public boolean addLibro(Libro libro) {
        if (!mensola.contains(libro)) {
            mensola.add(libro);
            nLibri++;
            return true;
        }
        return false; // Il libro esiste già
    }

    // Rimuovere un libro
    public boolean rimuoviLibro(Libro libro) {
        if (mensola.remove(libro)) {
            nLibri--;
            return true;
        }
        return false; // Libro non trovato
    }

    // Rimuovere un libro dato titolo e autore
    public boolean rimuoviLibroPerAutore(String titolo, String autore) {
        for (int i = 0; i < mensola.size(); i++) {
            Libro libro = mensola.get(i);
            if (libro.getTitolo().equalsIgnoreCase(titolo) && libro.getAutore().equalsIgnoreCase(autore)) {
                mensola.remove(i);
                nLibri--;
                return true;
            }
        }
        return false; // Libro non trovato
    }


    // Restituire tutti i libri
    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    // Verificare se un libro esiste
    public boolean containsBook(Libro libro) {
        return mensola.contains(libro);
    }

    // Trova libro per indice
    public Libro findLibro(int i) {
        if (i >= 0 && i < mensola.size()) {
            return mensola.get(i);
        }
        return null;
    }

    // Rimuovere tutti i libri di un autore
    public boolean rimuoviTuttiAutori(String autore) {
        boolean rimosso = false;
        for (int i = 0; i < mensola.size(); i++) {
            if (mensola.get(i).getAutore().equalsIgnoreCase(autore)) {
                mensola.remove(i);
                i--; // Decrementare indice per evitare salti
                nLibri--;
                rimosso = true;
            }
        }
        return rimosso;
    }

    // Numero di libri sulla mensola
    public int getNLibri() {
        return nLibri;
    }

    // Verifica se la mensola è vuota
    public boolean isVuota() {
        return mensola.isEmpty();
    }
}
//FrontEnd
import java.util.Scanner;

public class FrontEnd {

    // Mostra menu
    public static int Menu(String[] opzioni, Scanner sc) {
        System.out.println("Menu:");
        for (int i = 0; i < opzioni.length; i++) {
            System.out.println((i + 1) + ". " + opzioni[i]);
        }
        System.out.print("Scegli un'opzione: ");
        return sc.nextInt();
    }

    // Aspetta un certo tempo
    public static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // Pulisci lo schermo
    public static void ClrScr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Leggi un libro
    public static Libro leggiLibro(Scanner sc) {
        sc.nextLine(); // Consuma la newline
        System.out.print("Inserisci autore: ");
        String autore = sc.nextLine();
        System.out.print("Inserisci titolo: ");
        String titolo = sc.nextLine();
        System.out.print("Inserisci numero di pagine: ");
        int nPagine = sc.nextInt();

        System.out.println("Scegli un tipo (1. ROMANZO, 2. MANUALE, 3. THRILLER, 4. GENERICO): ");
        int scelta = sc.nextInt();
        Libro.Genere tipo = switch (scelta) {
            case 1 -> Libro.Genere.ROMANZO;
            case 2 -> Libro.Genere.MANUALE;
            case 3 -> Libro.Genere.THRILLER;
            default -> Libro.Genere.GENERICO;
        };

        return new Libro(autore, titolo, nPagine, tipo);
    }
}
