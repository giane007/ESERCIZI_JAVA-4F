//Main
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Main per testare la classe Automobile
public class Main{
    public static void main(String[] args) {
        // Creazione di alcune automobili
        Automobile auto1 = new Automobile("Fiat", "Panda", 1200);
        Automobile auto2 = new Automobile("Toyota", "Yaris", 1300);
        Automobile auto3 = new Automobile("BMW", "Serie 3", 2000);
        Automobile auto4 = new Automobile("Audi", "A3", 1600);
        Automobile auto5 = new Automobile("Ford", "Fiesta", 1000);

        // Test del metodo equals
        System.out.println("auto1 è uguale a auto2? " + auto1.equals(auto2));
        System.out.println("auto1 è uguale a auto5? " + auto1.equals(auto5));

        // Test del metodo confrontaCilindrata
        System.out.println("Confronto cilindrata tra auto1 e auto2: " + auto1.confrontaCilindrata(auto2));
        System.out.println("Confronto cilindrata tra auto3 e auto4: " + auto3.confrontaCilindrata(auto4));

        // Creazione di una lista di automobili
        List<Automobile> listaAuto = new ArrayList<>();
        listaAuto.add(auto1);
        listaAuto.add(auto2);
        listaAuto.add(auto3);
        listaAuto.add(auto4);
        listaAuto.add(auto5);

        // Stampa della lista di automobili
        System.out.println("\nLista di automobili:");
        for (Automobile auto : listaAuto) {
            System.out.println(auto);
        }

        // Ordinamento della lista in ordine crescente di cilindrata
        listaAuto.sort(Comparator.comparingInt(Automobile::getCilindrata));
        System.out.println("\nLista di automobili ordinata per cilindrata crescente:");
        for (Automobile auto : listaAuto) {
            System.out.println(auto);
        }

        // Ordinamento della lista in ordine decrescente di cilindrata
        listaAuto.sort((a1, a2) -> Integer.compare(a2.getCilindrata(), a1.getCilindrata()));
        System.out.println("\nLista di automobili ordinata per cilindrata decrescente:");
        for (Automobile auto : listaAuto) {
            System.out.println(auto);
        }
    }
}

//Automobile
public class Automobile {
    // Attributi
    private String marca;
    private String modello;
    private int cilindrata;

    // Costruttore che accetta attributi
    public Automobile(String marca, String modello, int cilindrata) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
    }

    // Costruttore che accetta un altro oggetto Automobile
    public Automobile(Automobile auto) {
        this.marca = auto.marca;
        this.modello = auto.modello;
        this.cilindrata = auto.cilindrata;
    }

    // Getter e setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    // Metodo toString (con override) per la stampa dei tre attributi
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modello: " + modello + ", Cilindrata: " + cilindrata;
    }

    // Metodo per verificare se due auto sono uguali (stessi valori per marca, modello e cilindrata)
    public boolean equals(Automobile altro) {
        return this.marca.equals(altro.marca) && this.modello.equals(altro.modello) && this.cilindrata == altro.cilindrata;
    }

    // Metodo per confrontare due auto in base alla cilindrata
    public int confrontaCilindrata(Automobile altro) {
        return Integer.compare(this.cilindrata, altro.cilindrata);
    }
}
