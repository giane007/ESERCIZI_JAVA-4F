//Main
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Inserisci coordinata X del punto in alto a sinistra del rettangolo:");
        double x = tastiera.nextDouble();
        System.out.println("Inserisci coordinata Y del punto in alto a sinistra del rettangolo:");
        double y = tastiera.nextDouble();
        System.out.println("Inserisci la base del rettangolo:");
        double base = tastiera.nextDouble();
        System.out.println("Inserisci l'altezza del rettangolo:");
        double altezza = tastiera.nextDouble();

        try {
            Punto puntoAltoSinistra = new Punto(x, y);
            Rettangolo rettangolo = new Rettangolo(puntoAltoSinistra, base, altezza);
            System.out.println(rettangolo);
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

//Classe Segmento
import java.lang.Math;

public class Segmento {
    private double lunghezza;
    public Segmento(Punto primo, Punto secondo){
        this.lunghezza=Math.sqrt(Math.pow(primo.getX()-secondo.getX(),2)+Math.pow(primo.getY()- secondo.getY(),2));
    }

    @Override
    public String toString() {
        return "lunghezza" +lunghezza;
    }
}

//Classe Rettangolo
import java.util.ArrayList;

public class Rettangolo {
    private Punto puntoAltoSinistra;
    private double base;
    private double altezza;
    private ArrayList<Segmento> segmenti;

    public Rettangolo(Punto puntoAltoSinistra, double base, double altezza) throws Exception {
        this.puntoAltoSinistra = puntoAltoSinistra;
        this.base = base;
        this.altezza = altezza;

        // Calcolo dei punti restanti
        Punto puntoAltoDestra = new Punto(puntoAltoSinistra.getX() + base, puntoAltoSinistra.getY());
        Punto puntoBassoSinistra = new Punto(puntoAltoSinistra.getX(), puntoAltoSinistra.getY() - altezza);
        Punto puntoBassoDestra = new Punto(puntoAltoSinistra.getX() + base, puntoAltoSinistra.getY() - altezza);

        // Verifica che tutti i punti siano nel primo quadrante
        verificaPrimoQuadrante(puntoAltoSinistra);
        verificaPrimoQuadrante(puntoAltoDestra);
        verificaPrimoQuadrante(puntoBassoSinistra);
        verificaPrimoQuadrante(puntoBassoDestra);

        // Creazione dei segmenti
        segmenti = new ArrayList<>();
        segmenti.add(new Segmento(puntoAltoSinistra, puntoAltoDestra));  // Base superiore
        segmenti.add(new Segmento(puntoAltoDestra, puntoBassoDestra));  // Lato destro
        segmenti.add(new Segmento(puntoBassoDestra, puntoBassoSinistra));  // Base inferiore
        segmenti.add(new Segmento(puntoBassoSinistra, puntoAltoSinistra));  // Lato sinistro
    }

    private void verificaPrimoQuadrante(Punto punto) throws Exception {
        if (punto.getX() < 0 || punto.getY() < 0) {
            throw new Exception("Il punto " + punto + " non è nel primo quadrante.");
        }
    }

    public ArrayList<Segmento> getSegmenti() {
        return segmenti;
    }

    @Override
    public String toString() {
        return "Rettangolo con base " + base + ", altezza " + altezza + " e segmenti: " + segmenti;
    }
}

//Classe Punto
public class Punto {
    private double x;
    private double y;


    public Punto(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public String trovaQuadrante() {
        if (getX() > 0 && getY() > 0) {
            return "Il punto si trova nel primo quadrante";
        } else if (getX() < 0 && getY() > 0) {
            return "Il punto si trova nel secondo quadrante";
        } else if (getX() > 0 && getY() < 0) {
            return "Il punto si trova nel quarto quadrante";
        } else if (getX() < 0 && getY() < 0) {
            return "Il punto si trova nel terzo quadrante";
        } else if (getX() == 0 && getY() > 0 || getY() < 0) {
            return "Il punto si trova sull'asse Y";
        } else if (getY() == 0 && getX() > 0 || getX() < 0) {
            return "Il punto si trova sull'asse X";
        } else {
            return "Il punto si trova all'origine";
        }
    }

    @Override
    public String toString() {
        return "X=" + getX() + " - Y=" + getY();
    }
}
