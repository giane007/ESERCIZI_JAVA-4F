//Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci coordiata X primo punto:");
        double coordinataXprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata Y primo punto:");
        double coordinataYprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata X secondo punto:");
        double coordinataXsecondo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata Y secondo punto:");
        double coordinataYsecondo = tastiera.nextDouble();

        Punto primo = new Punto(coordinataXprimo, coordinataYprimo);
        Punto secondo = new Punto(coordinataXsecondo, coordinataYsecondo);
        Segmento lunghezza = new Segmento(primo, secondo);
        System.out.println(lunghezza.toString());
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
