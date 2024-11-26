import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner per input da tastiera
        Scanner tastiera = new Scanner(System.in);

        Frazione frazione1;
        Frazione frazione2;

        try {
            // Creazione della prima frazione
            System.out.println("Inserisci la prima frazione (numeratore e denominatore separati da spazio):");
            int numeratore1 = tastiera.nextInt();
            int denominatore1 = tastiera.nextInt();
            tastiera.nextLine(); // Consuma il resto della linea
            frazione1 = new Frazione(numeratore1, denominatore1);

            // Creazione della seconda frazione
            System.out.println("Inserisci la seconda frazione (numeratore/denominatore):");
            String frazioneInput = tastiera.nextLine();
            frazione2 = new Frazione(frazioneInput);

            // Somma di due frazioni
            Frazione sommaFrazione = frazione1.somma(frazione2);
            System.out.println("Somma frazioni (come frazione): " + sommaFrazione.visualizza());

            // Somma di due frazioni come valore decimale
            double sommaValore = frazione1.sommaValore(frazione2);
            System.out.println("Somma frazioni (come valore decimale): " + sommaValore);

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
//Classe Frazione
public class Frazione {
    private int numeratore;
    private int denominatore;

    // Costruttore
    public Frazione(int numeratore, int denominatore) throws Exception{
        if (denominatore == 0) {
            throw new Exception("Denominatore non può essere 0");
        } else {
            this.numeratore = numeratore;
            this.denominatore = denominatore;
            semplifica();
        }
    }

    // Costruttore per accettare una frazione come stringa (es. "1/4")
    public Frazione(String frazione) throws Exception{
        
        String[] parti = frazione.split("/");
        if (parti.length != 2) {
            throw new NumberFormatException("Formato della frazione non valido. Inserisci: numeratore/denominatore");
        }
        this.numeratore = Integer.parseInt(parti[0]);
        this.denominatore = Integer.parseInt(parti[1]);
        if (denominatore == 0)
            throw new Exception("Denominatore non può essere 0");

        semplifica();
    }

    // Metodo per sommare due frazioni e restituire una nuova frazione
    public Frazione somma(Frazione altra) throws Exception{
        try{

            int nuovoNumeratore = this.numeratore * altra.denominatore + altra.numeratore * this.denominatore;
            int nuovoDenominatore = this.denominatore * altra.denominatore;
            return new Frazione(nuovoNumeratore, nuovoDenominatore);
        }catch(Exception e){
            throw new Exception("Impossibile sommare le frazioni");
        }
    }

    // Metodo per sommare due frazioni e restituire il risultato come valore decimale
    public double sommaValore(Frazione altra) throws Exception{
        Frazione sommaFrazione = this.somma(altra);
        return (double) sommaFrazione.numeratore / sommaFrazione.denominatore;
    }

    // Metodo per visualizzare la frazione in formato "numeratore/denominatore"
    public String visualizza() {
        return numeratore + "/" + denominatore;
    }

    // Metodo per semplificare la frazione
    private void semplifica() {
        int gcd = mcd(Math.abs(numeratore), Math.abs(denominatore));
        numeratore /= gcd;
        denominatore /= gcd;
        if (denominatore < 0) { // Per garantire che il denominatore sia sempre positivo
            numeratore = -numeratore;
            denominatore = -denominatore;
        }
    }

    // Metodo per calcolare il massimo comune divisore (MCD)
    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
