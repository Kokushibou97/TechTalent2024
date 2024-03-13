/* Pide el numero de alumnos del curso de programación.
 * Crea un Hashmap para guardar sus nombres y su nota media.
 * La nota media se calculará mediante un método (parcialA + parcialB).
 * Todos estos datos se han de proporcionar por pantalla.
 */

public class Ej01NotasAlumnos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
//      Crear un HashMap con clave de tipo String y valor de tipo Integer
        HashMap<String, Double> notaMediaAlumnos = new HashMap<>();
        
        System.out.println("¿Cuantos alumnos hay en el curso?");
            int alumnosTotales = sc.nextInt();
       
        int i = 0;
        do {
            System.out.println("Alumno número " +(i+1)+":");
          infoRequest(notaMediaAlumnos);
           i++;
        
        }while(i<alumnosTotales);
               
        System.out.println("\nEl listado de alumnos con sus notas es:"
                + "\nNombre / Nota media");
        imprimirKey_asociado_Value(notaMediaAlumnos);
        
        sc.close();
    }  
            
}