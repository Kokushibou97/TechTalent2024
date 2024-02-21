import java.util.Date;
import java.text.SimpleDateFormat;
public class Pre2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("h");
        int HoraActual = Integer.parseInt(dateFormat.format(date));
        String horaHoy;

        switch (HoraActual) {
            case 9:
                horaHoy = "09:00";
                break;
            case 10:
                horaHoy = "10:00";
                break;
            case 11:
            	horaHoy = "11:00";
            	break;
            default:
                horaHoy = "Hora incorrecta";
        }
        System.out.println("La hora actual es " + horaHoy);

	}
}
