//Main
import java.util.Scanner;


import static Tools.Utility.*;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int contaLibri = 0;
        final int maxLibri = 3;
        boolean uscita = false;
        Libro[] gestore = new Libro[maxLibri];
        String[] opzioni = {"Gestore libri",
                "1- Inserimento",
                "2- Visualizza",
                "3- Ricerca",
                "4- Elimina",
                "5- Scorri mensola",
                "6- Fine"};

        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    if (contaLibri < maxLibri) {
                        Libro nuovoLibro = inserimentoLibro(tastiera);
                        if (!libroDoppio(gestore, contaLibri, nuovoLibro)) {
                            gestore[contaLibri] = nuovoLibro;
                            contaLibri++;
                        } else {
                            System.out.println("Il libro è già presente.");
                        }
                    } else {
                        System.out.println("Spazio finito");
                    }
                }
                case 2 -> {
                    if (contaLibri > 0) {
                        visualizzaLibro(gestore, contaLibri);
                    } else {
                        System.out.println("Nessun libro inserito.");
                    }
                }
                case 3 -> {
                    if (contaLibri > 0) {
                        System.out.println("Inserisci il titolo del libro da cercare:");
                        String titoloCercato = tastiera.nextLine();
                        System.out.println("Inserisci l'autore del libro da cercare:");
                        String autoreCercato = tastiera.nextLine();
                        int indice = ricercaLibro(gestore, contaLibri, titoloCercato, autoreCercato);
                        if (indice != -1) {
                            System.out.println("Libro trovato all'indice: " + indice);
                            System.out.println((indice + 1) + "° " + gestore[indice].formattaDati());
                        } else {
                            System.out.println("Libro non trovato");
                        }
                    } else {
                        System.out.println("Nessun libro inserito.");
                    }
                }
                case 4 -> {
                    if (contaLibri > 0) {
                        System.out.println("Inserisci il titolo e l'autore del libro da cercare:");
                        System.out.println("Titolo: ");
                        String titoloCercato = tastiera.nextLine();
                        System.out.println("Autore: ");
                        String autoreCercato = tastiera.nextLine();
                        if (eliminaLibro(gestore, contaLibri, titoloCercato, autoreCercato)) {
                            System.out.println("Libro eliminato");
                        } else {
                            System.out.println("Libro non trovato");
                        }
                        contaLibri--;
                    } else {
                        System.out.println("Nessun libro inserito.");
                    }
                }
                case 5 -> {
                    if (contaLibri > 0) {
                        System.out.println("Inserisci la posizione del libro (1 a " + contaLibri + "): ");
                        int posizione = Integer.parseInt(tastiera.nextLine()) - 1;

                        if (posizione >= 0 && posizione < contaLibri) {
                            String[] opzioni1 = {"Scorri Libri","Precedente", "Successivo"};
                            int scelta = Menu(opzioni1, tastiera);
                            switch (scelta) {
                                case 1 -> {
                                    if (posizione > 0) {
                                        System.out.println("Libro precedente: " + gestore[posizione - 1].formattaDati());
                                    } else {
                                        System.out.println("Non ci sono libri precedenti.");
                                    }
                                }
                                case 2 -> {
                                    if (posizione < contaLibri - 1) {
                                        System.out.println("Libro successivo: " + gestore[posizione + 1].formattaDati());
                                    } else {
                                        System.out.println("Non ci sono libri successivi.");
                                    }
                                }
                                default -> System.out.println("Scelta non valida.");
                            }
                        } else {
                            System.out.println("Posizione non valida.");
                        }
                    }
                }

                case 6 -> uscita = true;
            }
        } while (!uscita);
    }


    public static Libro inserimentoLibro(Scanner tastiera) {
        Libro libro = new Libro();
        System.out.println("Inserisci il titolo del libro:");
        libro.titolo = tastiera.nextLine();
        System.out.println("Inserisci l'autore del libro:");
        libro.autore = tastiera.nextLine();
        System.out.println("Inserisci il numero di pagine:");
        libro.pagine = Integer.parseInt(tastiera.nextLine());


        String[] opzioni = {"Inserisci il genere", "1- Romanzo", "2- Manuale", "3- Thriller"};
        int scelta;
        do {
            scelta = Menu(opzioni, tastiera);
            switch (scelta) {
                case 1 -> libro.genereLibro = genere.romanzo;
                case 2 -> libro.genereLibro = genere.manuale;
                case 3 -> libro.genereLibro = genere.thriller;
                default -> System.out.println("Scelta non valida, riprova.");
            }
        } while (scelta < 1 || scelta > 3);


        return libro;
    }


    public static void visualizzaLibro(Libro[] gestore, int contaLibri) {
        for (int i = 0; i < contaLibri; i++) {
            System.out.println((i + 1) + "° " + gestore[i].formattaDati());
        }
    }


    public static int ricercaLibro(Libro[] gestore, int contaLibri, String titoloCercato, String autoreCercato) {
        for (int i = 0; i < contaLibri; i++) {
            if (gestore[i].titolo.equalsIgnoreCase(titoloCercato) && gestore[i].autore.equalsIgnoreCase(autoreCercato)) {
                return i;
            }
        }
        return -1;
    }


    public static boolean eliminaLibro(Libro[] gestore, int contaLibri, String titoloCercato, String autoreCercato) {


        for (int i = 0; i < contaLibri; i++) {
            if (gestore[i].titolo.equalsIgnoreCase(titoloCercato) && gestore[i].autore.equalsIgnoreCase(autoreCercato)) {
                for (int j = i; j < contaLibri - 1; j++) {
                    gestore[j] = gestore[j + 1];
                }
                gestore[contaLibri - 1] = null;
                return true;
            }
        }
        return false;
    }


    public static boolean libroDoppio(Libro[] gestore, int contaLibri, Libro nuovoLibro) {
        for (int i = 0; i < contaLibri; i++) {
            if (gestore[i].autore.equalsIgnoreCase(nuovoLibro.autore) && gestore[i].titolo.equalsIgnoreCase(nuovoLibro.titolo)) {
                return true; // Doppione trovato
            }
        }
        return false; // Nessun doppione trovato
    }
}

//Scorrimento
public enum ScorriBanda {
    precedente,
    successivo,
    fine;
}

//Classe libro
public class Libro {
    public String autore;
    public String titolo;
    public int pagine;
    public genere genereLibro;
    public ScorriBanda scorrimento;
    final double COSTOPAGINE = 0.05;


    public String formattaDati() {
        return String.format("Libro: Autore: %s, Titolo: %s, Prezzo Libro: %.2f, Genere: %s", autore, titolo, COSTOPAGINE * pagine, genereLibro);
    }
}

//genere
enum genere {
    romanzo,
    manuale,
    thriller
}

//Utility
package Tools;
import java.util.Scanner;
public class Utility{
    /*public static void main(String[] args) {


    }*/
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
