/**
 * Un objeto de esta clase guarda la información de un estudiante
 *  
 *  @author David Sena
 */
public class Estudiante {
    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;

    /**
     *  
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
         String[] datos = lineaDatos.split(SEPARADOR);
         this.nombre = datos[0];
         this.apellidos = datos[1].toUpperCase();
         this.faltasNoJustificadas = Integer.parseInt(datos[2].trim());
         this.faltasJustificadas = Integer.parseInt(datos[3].trim());

    }

    

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el nº de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        String nombreApellido = apellidos + ", " + nombre;
        String numAper = "";
        if (faltasNoJustificadas < TipoApercibimiento.TREINTA.tot()){
            numAper = "DIEZ "+"VEINTE "+"TREINTA";
         
        }
        else if(faltasNoJustificadas > TipoApercibimiento.VEINTE.tot()){
            numAper = "DIEZ "+"VEINTE ";
        }
        else if(faltasNoJustificadas > TipoApercibimiento.DIEZ.tot()){
            numAper = "DIEZ ";
        }
        else{
            numAper= "Sin apercibimientos";
        }
        
        
        
        
        String str = ""; 
        str += String.format("%-25s %-35s","Apellidos y Nombre:",nombreApellido);
        str += String.format("%-25s %-35s","\nFaltas No Justificadas:", faltasNoJustificadas);
        str += String.format(" %-25s %-35s","\nFaltas Justificadas:", faltasJustificadas);
        str += String.format(" %-25s %-35s","\nApercibimientos:", numAper );
        
        return str;

    }


     public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai  ,  Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();
        

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}
