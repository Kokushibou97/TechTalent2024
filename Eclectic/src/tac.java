//METODOS PARA EL EJERCICIO
public static void infoRequest(HashMap <String, Double> listadoHashmap) {
         Scanner sc = new Scanner(System.in);
        String nombreAlumno;
        double primerParcial; double segundoParcial; double notaMedia;
        
        System.out.println("¿Cual es su nombre?");
            nombreAlumno = sc.nextLine();
        System.out.println("Nota primer parcial:");
            primerParcial = sc.nextDouble();
        System.out.println("Nota segundo parcial:");
            segundoParcial = sc.nextDouble();
        
        notaMedia = calcularMedia(primerParcial, segundoParcial);
        
        introducirInfoAlumno(listadoHashmap,nombreAlumno, notaMedia);
    }
    
    public static double calcularMedia (double notaPrimerParcial, double notaSegundoParcial) {
        double notaMediaCalculada = ((notaPrimerParcial + notaSegundoParcial)/2);
        return notaMediaCalculada;
    }
    
    public static void introducirInfoAlumno (HashMap <String, Double> listadoAlumnos, String nombreAlumno, double notaMedia) {
        listadoAlumnos.put(nombreAlumno, notaMedia);
    }
    
//    Devuelve KEY / VALUE(KEY), para mostrar listados del Hashmap
    public static void imprimirKey_asociado_Value (HashMap <String, Double> listadoHashmap) {
    // Iterar sobre las claves del HashMap
        for (String key : listadoHashmap.keySet()) {
        double valueDeKey = listadoHashmap.get(key);
            System.out.println(key+ " / " +valueDeKey);
        }    
    }