package ejercicio2;
public class Main {
    public static void main(String[] args) {
        // Crear arrays de Series y Videojuegos
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        // Crear objetos en cada posición del array
        series[0] = new Serie("Breaking Bad", "Vince Gilligan", "Drama", 5);
        series[1] = new Serie("Stranger Things", "Duffer Brothers", "Ciencia ficción", 3);
        series[2] = new Serie("Friends", "David Crane, Marta Kauffman", "Comedia", 10);
        series[3] = new Serie("Game of Thrones", "David Benioff, D.B. Weiss", "Fantasía", 8);
        series[4] = new Serie("The Office", "Greg Daniels", "Comedia", 9);

        videojuegos[0] = new Videojuego("The Legend of Zelda", 40, "Aventura", "Nintendo");
        videojuegos[1] = new Videojuego("Super Mario", 20, "Plataformas", "Nintendo");
        videojuegos[2] = new Videojuego("FIFA 21", 15, "Deportes", "EA Sports");
        videojuegos[3] = new Videojuego("Assassin's Creed Valhalla", 60, "Acción", "Ubisoft");
        videojuegos[4] = new Videojuego("Minecraft", 30, "Aventura", "Mojang");

        // Entregar algunos Videojuegos y Series
        videojuegos[0].entregar();
        videojuegos[2].entregar();
        series[1].entregar();
        series[3].entregar();

        // Contar Videojuegos y Series entregados
        int videojuegosEntregados = 0;
        int seriesEntregadas = 0;

        for (Videojuego v : videojuegos) {
            if (v.isEntregado()) {
                videojuegosEntregados++;
            }
        }

        for (Serie s : series) {
            if (s.isEntregado()) {
                seriesEntregadas++;
            }
        }

        // Encontrar Videojuego con más horas estimadas y Serie con más temporadas
        Videojuego videojuegoMasHoras = videojuegos[0];
        Serie serieMasTemporadas = series[0];

        for (Videojuego v : videojuegos) {
            if (v.compareTo(videojuegoMasHoras) > 0) {
                videojuegoMasHoras = v;
            }
        }

        for (Serie s : series) {
            if (s.compareTo(serieMasTemporadas) > 0) {
                serieMasTemporadas = s;
            }
        }

        // Mostrar información
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);
        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuego con más horas estimadas:\n" + videojuegoMasHoras);
        System.out.println("Serie con más temporadas:\n" + serieMasTemporadas);
    }
}

