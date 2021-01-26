/**
 * @author David Sena
 * Punto de entrada a la aplicación
 */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el nº máximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la información solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {

        if(args.length < 1){
            System.out.println("Error en argumentos" + 
                "Sintaxis: java TestGestorFaltas <max_estudiantes>");
        }
        else{
            GestorFaltas curso = new GestorFaltas(Integer.parseInt(args[0]));
            curso.leerDeFichero();
            System.out.println(curso.toString());
            // Justificar faltas 
            if(curso.buscarEstudiante("IRISO FLAMARIQUE ") > 0){
                curso.justificarFaltas("IRISO FLAMARIQUE ", 6);
                System.out.println("Justificadas 6 faltas a IRISO FLAMARIQUE, Carla");
            }
            else{
                System.out.println("No está la alumna");
            }            
        }
    }

}
