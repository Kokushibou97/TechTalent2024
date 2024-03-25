package ejercicio2;
//Interfaz Entregable
interface Entregable {
 void entregar();
 void devolver();
 boolean isEntregado();
 int compareTo(Object a);
}

//Clase Videojuego que implementa la interfaz Entregable
public class Videojuego implements Entregable {
 // ... (código previo de la clase Videojuego)

 @Override
 public void entregar() {
     entregado = true;
 }

 @Override
 public void devolver() {
     entregado = false;
 }

 @Override
 public boolean isEntregado() {
     return entregado;
 }

 @Override
 public int compareTo(Object a) {
     if (a instanceof Videojuego) {
         Videojuego otroVideojuego = (Videojuego) a;
         return horasEstimadas - otroVideojuego.horasEstimadas;
     }
     return 0;
 }

 // Resto del código de la clase Videojuego
}

//Clase Serie que implementa la interfaz Entregable
public class Serie implements Entregable {
 // ... (código previo de la clase Serie)

 @Override
 public void entregar() {
     entregado = true;
 }

 @Override
 public void devolver() {
     entregado = false;
 }

 @Override
 public boolean isEntregado() {
     return entregado;
 }

 @Override
 public int compareTo(Object a) {
     if (a instanceof Serie) {
         Serie otraSerie = (Serie) a;
         return numTemporadas - otraSerie.numTemporadas;
     }
     return 0;
 }

 // Resto del código de la clase Serie
}

//Ejemplo de uso
public class Main {
 public static void main(String[] args) {
     Videojuego videojuego1 = new Videojuego("The Legend of Zelda", 40, "Aventura", "Nintendo");
     Videojuego videojuego2 = new Videojuego("Super Mario", 20, "Plataformas", "Nintendo");

     System.out.println(videojuego1);
     System.out.println(videojuego2);
     System.out.println("Comparison result: " + videojuego1.compareTo(videojuego2));

     Serie serie1 = new Serie("Breaking Bad", "Vince Gilligan", "Drama", 5);
     Serie serie2 = new Serie("Stranger Things", "Duffer Brothers", "Ciencia ficción", 3);

     System.out.println(serie1);
     System.out.println(serie2);
     System.out.println("Comparison result: " + serie1.compareTo(serie2));
 }
}

