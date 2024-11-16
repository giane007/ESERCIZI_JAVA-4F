import java.util.LinkedList;


public class MainLibro {
   public static void main(String[] args) {
       // Creazione della LinkedList di Libro
       LinkedList<Libro> biblioteca = new LinkedList<>();


       // Creazione di alcuni libri
       Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 1954);
       Libro libro2 = new Libro("1984", "George Orwell", 1949);
       Libro libro3 = new Libro("Il Nome della Rosa", "Umberto Eco", 1980);


       // add
       biblioteca.add(libro1);
       biblioteca.add(libro2);
       System.out.println("Dopo add: " + biblioteca);


       // addFirst
       biblioteca.addFirst(libro3);
       System.out.println("Dopo addFirst: " + biblioteca);


       // addLast
       Libro libro4 = new Libro("La Divina Commedia", "Dante Alighieri", 1320);
       biblioteca.addLast(libro4);
       System.out.println("Dopo addLast: " + biblioteca);


       // remove
       biblioteca.remove(libro2);
       System.out.println("Dopo remove (1984): " + biblioteca);


       // removeFirst
       biblioteca.removeFirst();
       System.out.println("Dopo removeFirst: " + biblioteca);


       // removeLast
       biblioteca.removeLast();
       System.out.println("Dopo removeLast: " + biblioteca);


       // contains
       System.out.println("Contiene 'Il Signore degli Anelli'? " + biblioteca.contains(libro1));


       // getFirst
       System.out.println("Primo libro: " + biblioteca.getFirst());


       // getLast
       System.out.println("Ultimo libro: " + biblioteca.getLast());


       // indexOf
       System.out.println("Indice di 'Il Signore degli Anelli': " + biblioteca.indexOf(libro1));


       // isEmpty
       System.out.println("È vuota? " + biblioteca.isEmpty());


       // lastIndexOf
       biblioteca.add(libro1);
       System.out.println("Ultimo indice di 'Il Signore degli Anelli': " + biblioteca.lastIndexOf(libro1));


       // set
       biblioteca.set(0, libro4);
       System.out.println("Dopo set (indice 0 -> 'La Divina Commedia'): " + biblioteca);


       // equals
       LinkedList<Libro> altraBiblioteca = new LinkedList<>(biblioteca);
       System.out.println("È uguale a altraBiblioteca? " + biblioteca.equals(altraBiblioteca));


       // size
       System.out.println("Dimensione: " + biblioteca.size());


       // clear
       biblioteca.clear();
       System.out.println("Dopo clear: " + biblioteca);
   }
}
Libro
class Libro {
   private String titolo;
   private String autore;
   private int anno;


   public Libro(String titolo, String autore, int anno) {
       this.titolo = titolo;
       this.autore = autore;
       this.anno = anno;
   }


   public String getTitolo() {
       return titolo;
   }


   public String getAutore() {
       return autore;
   }


   public int getAnno() {
       return anno;
   }


   @Override
   public String toString() {
       return "Libro{" +
               "titolo='" + titolo + '\'' +
               ", autore='" + autore + '\'' +
               ", anno=" + anno +
               '}';
   }


   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Libro libro = (Libro) o;
       return anno == libro.anno &&
               titolo.equals(libro.titolo) &&
               autore.equals(libro.autore);
   }
}
Main
import java.util.LinkedList;


public class Main {
   public static void main(String[] args) {
       // Creazione della LinkedList di Integer
       LinkedList<Integer> numeri = new LinkedList<>();


       // add
       numeri.add(10);
       numeri.add(20);
       numeri.add(30);
       System.out.println("Dopo add: " + numeri);


       // addFirst
       numeri.addFirst(5);
       System.out.println("Dopo addFirst: " + numeri);


       // addLast
       numeri.addLast(40);
       System.out.println("Dopo addLast: " + numeri);


       // remove
       numeri.remove(Integer.valueOf(20));
       System.out.println("Dopo remove (20): " + numeri);


       // removeFirst
       numeri.removeFirst();
       System.out.println("Dopo removeFirst: " + numeri);


       // removeLast
       numeri.removeLast();
       System.out.println("Dopo removeLast: " + numeri);


       // contains
       System.out.println("Contiene 10? " + numeri.contains(10));


       // getFirst
       System.out.println("Primo elemento: " + numeri.getFirst());


       // getLast
       System.out.println("Ultimo elemento: " + numeri.getLast());


       // indexOf
       System.out.println("Indice di 30: " + numeri.indexOf(30));


       // isEmpty
       System.out.println("È vuota? " + numeri.isEmpty());


       // lastIndexOf
       numeri.add(10);
       System.out.println("Ultimo indice di 10: " + numeri.lastIndexOf(10));


       // set
       numeri.set(1, 25);
       System.out.println("Dopo set (indice 1 -> 25): " + numeri);


       // equals
       LinkedList<Integer> altriNumeri = new LinkedList<>(numeri);
       System.out.println("È uguale a altriNumeri? " + numeri.equals(altriNumeri));


       // size
       System.out.println("Dimensione: " + numeri.size());


       // clear
       numeri.clear();
       System.out.println("Dopo clear: " + numeri);
   }
}

