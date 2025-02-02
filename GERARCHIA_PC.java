//MAIN
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PC> pcList = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi un nuovo PC");
            System.out.println("2. Mostra tutti i PC");
            System.out.println("3. Modifica un PC");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline

            switch (scelta) {
                case 1:
                    aggiungiPC(pcList, scanner);
                    break;
                case 2:
                    mostraPC(pcList);
                    break;
                case 3:
                    modificaPC(pcList, scanner);
                    break;
                case 4:
                    System.out.println("Uscita dal programma...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
    }

    private static void aggiungiPC(ArrayList<PC> pcList, Scanner scanner) {
        System.out.println("\nTipo di PC da aggiungere:");
        System.out.println("1. Desktop");
        System.out.println("2. Server");
        System.out.println("3. Notebook");
        System.out.print("Scelta: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consuma il newline

        System.out.print("Processore: ");
        String processore = scanner.nextLine();
        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Memoria (GB): ");
        int memoria = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modello: ");
        String modello = scanner.nextLine();
        System.out.print("Sistema Operativo: ");
        String sistemaOperativo = scanner.nextLine();

        if (tipo == 1) { // Desktop
            System.out.print("Contenitore (grande, medio, piccolo): ");
            String contenitore = scanner.nextLine();
            System.out.print("Scheda Video: ");
            String schedaVideo = scanner.nextLine();
            pcList.add(new Desktop(processore, ram, memoria, marca, modello, sistemaOperativo, contenitore, schedaVideo));
        } else if (tipo == 2) { // Server
            System.out.print("Contenitore (grande, medio, piccolo): ");
            String contenitore = scanner.nextLine();
            System.out.print("Numero Processori: ");
            int numProcessori = scanner.nextInt();
            System.out.print("Ha RAID? (true/false): ");
            boolean raid = scanner.nextBoolean();
            scanner.nextLine();
            pcList.add(new Server(processore, ram, memoria, marca, modello, sistemaOperativo, contenitore, numProcessori, raid));
        } else if (tipo == 3) { // Notebook
            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();
            System.out.print("Altezza (cm): ");
            double altezza = scanner.nextDouble();
            System.out.print("Larghezza (cm): ");
            double larghezza = scanner.nextDouble();
            System.out.print("Profondità (cm): ");
            double profondita = scanner.nextDouble();
            System.out.print("Dimensioni schermo (pollici): ");
            double dimensioniVideo = scanner.nextDouble();
            scanner.nextLine();
            pcList.add(new Notebook(processore, ram, memoria, marca, modello, sistemaOperativo, peso, altezza, larghezza, profondita, dimensioniVideo));
        } else {
            System.out.println("Tipo non valido!");
        }
    }

    private static void mostraPC(ArrayList<PC> pcList) {
        if (pcList.isEmpty()) {
            System.out.println("\nNessun PC registrato.");
        } else {
            System.out.println("\nElenco dei PC registrati:");
            for (int i = 0; i < pcList.size(); i++) {
                System.out.println((i + 1) + ". " + pcList.get(i));
            }
        }
    }

    private static void modificaPC(ArrayList<PC> pcList, Scanner scanner) {
        mostraPC(pcList);
        if (pcList.isEmpty()) return;

        System.out.print("\nInserisci il numero del PC da modificare: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consuma il newline

        if (indice < 0 || indice >= pcList.size()) {
            System.out.println("Indice non valido!");
            return;
        }

        PC pc = pcList.get(indice);
        System.out.println("\nModifica il PC selezionato:");
        System.out.print("Nuovo processore (" + pc.getProcessore() + "): ");
        pc.setProcessore(scanner.nextLine());
        System.out.print("Nuova RAM (" + pc.getRam() + " GB): ");
        pc.setRam(scanner.nextInt());
        System.out.print("Nuova Memoria (" + pc.getMemoria() + " GB): ");
        pc.setMemoria(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nuova Marca (" + pc.getMarca() + "): ");
        pc.setMarca(scanner.nextLine());
        System.out.print("Nuovo Modello (" + pc.getModello() + "): ");
        pc.setModello(scanner.nextLine());
        System.out.print("Nuovo Sistema Operativo (" + pc.getSistemaOperativo() + "): ");
        pc.setSistemaOperativo(scanner.nextLine());

        if (pc instanceof Desktop) {
            Desktop d = (Desktop) pc;
            System.out.print("Nuova Scheda Video (" + d.getSchedaVideo() + "): ");
            d.setSchedaVideo(scanner.nextLine());
        } else if (pc instanceof Server) {
            Server s = (Server) pc;
            System.out.print("Nuovo Numero Processori (" + s.getNumeroProcessori() + "): ");
            s.setNumeroProcessori(scanner.nextInt());
            System.out.print("RAID attivo? (" + s.hasRaid() + "): ");
            s.setRaid(scanner.nextBoolean());
            scanner.nextLine();
        } else if (pc instanceof Notebook) {
            Notebook n = (Notebook) pc;
            System.out.print("Nuovo Peso (" + n.getPeso() + " kg): ");
            n.setPeso(scanner.nextDouble());
            System.out.print("Nuova Altezza (" + n.getAltezza() + " cm): ");
            n.setAltezza(scanner.nextDouble());
            System.out.print("Nuova Larghezza (" + n.getLarghezza() + " cm): ");
            n.setLarghezza(scanner.nextDouble());
            System.out.print("Nuova Profondità (" + n.getProfondita() + " cm): ");
            n.setProfondita(scanner.nextDouble());
            System.out.print("Nuove Dimensioni Schermo (" + n.getDimensioniVideo() + " pollici): ");
            n.setDimensioniVideo(scanner.nextDouble());
            scanner.nextLine();
        }

        System.out.println("Modifica completata con successo!");
    }
}



//PC
public class PC {
    private String processore;
    private int ram;
    private int memoria;
    private String marca;
    private String modello;
    private String sistemaOperativo;

    public PC(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo) {
        this.processore = processore;
        this.ram = ram;
        this.memoria = memoria;
        this.marca = marca;
        this.modello = modello;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getter
    public String getProcessore() { return processore; }
    public int getRam() { return ram; }
    public int getMemoria() { return memoria; }
    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public String getSistemaOperativo() { return sistemaOperativo; }

    // Setter
    public void setProcessore(String processore) { this.processore = processore; }
    public void setRam(int ram) { this.ram = ram; }
    public void setMemoria(int memoria) { this.memoria = memoria; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModello(String modello) { this.modello = modello; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }

    @Override
    public String toString() {
        return "PC [Processore=" + processore + ", RAM=" + ram + "GB, Memoria=" + memoria + "GB, Marca=" + marca +
                ", Modello=" + modello + ", OS=" + sistemaOperativo + "]";
    }
}



//PCFisso
public class PCFisso extends PC {
    private String contenitore;

    public PCFisso(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, String contenitore) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo);
        this.contenitore = contenitore;
    }

    public String getContenitore() { return contenitore; }
    public void setContenitore(String contenitore) { this.contenitore = contenitore; }

    @Override
    public String toString() {
        return super.toString() + ", Contenitore=" + contenitore;
    }
}



//Desktop
public class Desktop extends PCFisso {
    private String schedaVideo;

    public Desktop(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, String contenitore, String schedaVideo) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo, contenitore);
        this.schedaVideo = schedaVideo;
    }

    public String getSchedaVideo() { return schedaVideo; }
    public void setSchedaVideo(String schedaVideo) { this.schedaVideo = schedaVideo; }

    @Override
    public String toString() {
        return super.toString() + ", Scheda Video=" + schedaVideo;
    }
}



//Server
public class Server extends PCFisso {
    private int numeroProcessori;
    private boolean raid;

    public Server(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, String contenitore, int numeroProcessori, boolean raid) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo, contenitore);
        this.numeroProcessori = numeroProcessori;
        this.raid = raid;
    }

    public int getNumeroProcessori() { return numeroProcessori; }
    public void setNumeroProcessori(int numeroProcessori) { this.numeroProcessori = numeroProcessori; }

    public boolean hasRaid() { return raid; }
    public void setRaid(boolean raid) { this.raid = raid; }

    @Override
    public String toString() {
        return super.toString() + ", Numero Processori=" + numeroProcessori + ", RAID=" + raid;
    }
}



//Notebook
public class Notebook extends PC {
        private double peso;
        private double altezza, larghezza, profondita;
        private double dimensioniVideo;

        public Notebook(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, double peso, double altezza, double larghezza, double profondita, double dimensioniVideo) {
            super(processore, ram, memoria, marca, modello, sistemaOperativo);
            this.peso = peso;
            this.altezza = altezza;
            this.larghezza = larghezza;
            this.profondita = profondita;
            this.dimensioniVideo = dimensioniVideo;
        }

        public double getPeso() { return peso; }
        public void setPeso(double peso) { this.peso = peso; }

        public double getAltezza() { return altezza; }
        public void setAltezza(double altezza) { this.altezza = altezza; }

        public double getLarghezza() { return larghezza; }
        public void setLarghezza(double larghezza) { this.larghezza = larghezza; }

        public double getProfondita() { return profondita; }
    public void setProfondita(double profondita) { this.profondita = profondita; }

    public double getDimensioniVideo() { return dimensioniVideo; }
    public void setDimensioniVideo(double dimensioniVideo) { this.dimensioniVideo = dimensioniVideo; }

    @Override
    public String toString() {
        return super.toString() + ", Peso=" + peso + "kg, Dimensioni Video=" + dimensioniVideo + " pollici";
    }
}

