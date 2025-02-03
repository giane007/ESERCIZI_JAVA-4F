//Gestione veicoli/Main
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneVeicoli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Veicolo> veicoli = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi un veicolo");
            System.out.println("2. Mostra tutti i veicoli");
            System.out.println("3. Filtra veicoli per prezzo massimo");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    aggiungiVeicolo(veicoli, scanner);
                    break;
                case 2:
                    mostraVeicoli(veicoli);
                    break;
                case 3:
                    filtraVeicoli(veicoli, scanner);
                    break;
                case 4:
                    System.out.println("Uscita...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
    }

    private static void aggiungiVeicolo(ArrayList<Veicolo> veicoli, Scanner scanner) {
        System.out.println("\nTipo di veicolo:");
        System.out.println("1. Auto");
        System.out.println("2. Camion");
        System.out.print("Scelta: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modello: ");
        String modello = scanner.nextLine();
        System.out.print("Prezzo (€): ");
        double prezzo = scanner.nextDouble();
        System.out.print("Anno: ");
        int anno = scanner.nextInt();
        System.out.print("Chilometri: ");
        int chilometri = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Numero porte: ");
            int numeroPorte = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Tipo di alimentazione (benzina, diesel, elettrico): ");
            String tipoAlimentazione = scanner.nextLine();
            veicoli.add(new Auto(marca, modello, prezzo, anno, chilometri, numeroPorte, tipoAlimentazione));
        } else if (tipo == 2) {
            System.out.print("Capacità di carico (tonnellate): ");
            double capacitaCarico = scanner.nextDouble();
            System.out.print("Numero di assi: ");
            int numeroAssi = scanner.nextInt();
            scanner.nextLine();
            veicoli.add(new Camion(marca, modello, prezzo, anno, chilometri, capacitaCarico, numeroAssi));
        } else {
            System.out.println("Scelta non valida!");
        }
    }

    private static void mostraVeicoli(ArrayList<Veicolo> veicoli) {
        if (veicoli.isEmpty()) {
            System.out.println("\nNessun veicolo registrato.");
        } else {
            System.out.println("\nElenco veicoli:");
            for (Veicolo v : veicoli) {
                System.out.println(v);
            }
        }
    }

    private static void filtraVeicoli(ArrayList<Veicolo> veicoli, Scanner scanner) {
        System.out.print("\nInserisci il prezzo massimo (€): ");
        double prezzoMax = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nVeicoli sotto i " + prezzoMax + "€:");
        for (Veicolo v : veicoli) {
            if (v.getPrezzo() <= prezzoMax) {
                System.out.println(v);
            }
        }
    }
}

//Veicolo
public class Veicolo {
    private String marca;
    private String modello;
    private double prezzo;
    private int anno;
    private int chilometri;

    public Veicolo(String marca, String modello, double prezzo, int anno, int chilometri) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.anno = anno;
        this.chilometri = chilometri;
    }

    // Getter e Setter
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModello() { return modello; }
    public void setModello(String modello) { this.modello = modello; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public int getAnno() { return anno; }
    public void setAnno(int anno) { this.anno = anno; }

    public int getChilometri() { return chilometri; }
    public void setChilometri(int chilometri) { this.chilometri = chilometri; }

    @Override
    public String toString() {
        return marca + " " + modello + " | Anno: " + anno + " | " + chilometri + " km | Prezzo: " + prezzo + " €";
    }
}

//Auto
public class Auto extends Veicolo {
    private int numeroPorte;
    private String tipoAlimentazione;

    public Auto(String marca, String modello, double prezzo, int anno, int chilometri, int numeroPorte, String tipoAlimentazione) {
        super(marca, modello, prezzo, anno, chilometri);
        this.numeroPorte = numeroPorte;
        this.tipoAlimentazione = tipoAlimentazione;
    }

    public int getNumeroPorte() { return numeroPorte; }
    public void setNumeroPorte(int numeroPorte) { this.numeroPorte = numeroPorte; }

    public String getTipoAlimentazione() { return tipoAlimentazione; }
    public void setTipoAlimentazione(String tipoAlimentazione) { this.tipoAlimentazione = tipoAlimentazione; }

    @Override
    public String toString() {
        return "[Auto] " + super.toString() + " | " + numeroPorte + " porte | " + tipoAlimentazione;
    }
}

//Camion
public class Camion extends Veicolo {
    private double capacitaCarico; // in tonnellate
    private int numeroAssi;

    public Camion(String marca, String modello, double prezzo, int anno, int chilometri, double capacitaCarico, int numeroAssi) {
        super(marca, modello, prezzo, anno, chilometri);
        this.capacitaCarico = capacitaCarico;
        this.numeroAssi = numeroAssi;
    }

    public double getCapacitaCarico() { return capacitaCarico; }
    public void setCapacitaCarico(double capacitaCarico) { this.capacitaCarico = capacitaCarico; }

    public int getNumeroAssi() { return numeroAssi; }
    public void setNumeroAssi(int numeroAssi) { this.numeroAssi = numeroAssi; }

    @Override
    public String toString() {
        return "[Camion] " + super.toString() + " | " + capacitaCarico + " tonnellate | " + numeroAssi + " assi";
    }
}

