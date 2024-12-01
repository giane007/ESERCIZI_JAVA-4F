//CLASSE MAIN

public class Main {
public static void main(String[] args) {
try {
Studente st = new Studente("Riccardo", "Gianesella", 7, 19);
Studente st1 = new Studente("Riccardos", "Gianesellas", 8, 19);
// System.out.println(st);
// System.out.println(st1);
if (st.equals(st1))
System.out.println("Sono uguali");
else {
System.out.println("Non sono uguali");
}
System.out.println(st.compareTo(st1));
} catch (Exception e) {
System.out.println(e.getMessage());
}
System.out.println("Qui il programma continua...");
int numeroMagico = 88;
try {
if (numeroMagico < 100) {
throw new Exception("Numero minore di 100");
}
} catch (Exception e) {
System.out.println(e.getMessage());
}
}
}

//CLASSE STUDENTE


public class Studente {
private String nome, cognome;
private Integer media, eta;

public Studente(String nome, String cognome, int media, int eta) throws Exception {
if (eta < 14) {
throw new Exception("L'età non può essere minore di 14 anni");
}
this.nome = nome;
this.cognome = cognome;
this.media = media;
this.eta = eta;
}

public Studente(String nome, String cognome, int eta) throws Exception {
this(nome, cognome, 0, eta);
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public String getCognome() {
return cognome;
}

public void setCognome(String cognome) {
this.cognome = cognome;
}

public int getMedia() {
return media;
}

public void setMedia(int media) {
this.media = media;
}

public int getEta() {
return eta;
}

public void setEta(int eta) throws Exception {
if (eta < 14) {
throw new Exception("L'età non può essere minore di 14 anni.");
}
this.eta = eta;
}

@Override
public boolean equals(Object obj) {
if (obj instanceof Studente) {
return this.nome.equals(((Studente) obj).nome) && this.cognome.equals(((Studente) obj).cognome);
}
return false;
}

public int compareTo(Object o) {
if (o instanceof Studente)
return this.media.compareTo(((Studente) o).media);
else {
throw new ClassCastException("L'oggetto di comparazione non è valido");
}
}
}
