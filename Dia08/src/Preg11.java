import java.util.Scanner;

public class Preg11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduce el número de día que quieras saber. Ten en cuenta que se empieza desde el lunes número 1");
        int diaSemana = scanner.nextInt();
        String message;
        
        switch (diaSemana) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                message = "Es un día laboral, toma tu expresso double shot";
                break;
            case 6:
            case 7:
                message = "No es un día laboral, en teoría, pero igualmente te toca hacer algo lol";
                break;
            default:
                message = "Día inválido";
                break;
        }
        
        System.out.println(message);
        scanner.close();
    }
}
