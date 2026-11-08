import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase Main
 */
public class Main {
    /**
     * Muestra la ip y hostname del anfitrión y después pide dominios indefinidamente hasta que el usuario indique salir
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String dominio = "";
        int contador = 1;

        //Muestra la ip del anfitrión y su hostname sólo 1 vez
        System.out.println("Dirección ip de este equipo: " + Direcciones.getLocalIP());
        System.out.println("Nombre de este equipo: " + Direcciones.getLocalName());

        while(true){
            System.out.println("Introduce un dominio (escribe salir para salir): ");
            dominio = sc.next().toLowerCase(); //convierte la entrada del scanner a minúsculas
            if(dominio.compareTo("salir") == 0){ //si el usuario indicó salir hace un break que sale del while infinito
                break;
            }

            //Direcciones IPv4
            List<String> listaip4 = Direcciones.getIPsV4Dominio(dominio);
            if(listaip4 != null) { //Si el dominio tiene direcciones ipv4
                System.out.println("Direcciones ipv4 de " + dominio);
                for (String ipv4 :listaip4) {
                    System.out.println("Direccion ip " + contador + ": " + ipv4);
                    contador++;
                }
                contador=1;
            }

            System.out.println();

            //Direcciones IPv4
            List<String> listaip6 = Direcciones.getIPsV6Dominio(dominio);
            if(listaip6 != null) { //Si el dominio tiene direcciones ipv6
                System.out.println("Direcciones ipv6 de " + dominio);
                for (String ipv6 :listaip6) {
                    System.out.println("Direccion ip " + contador + ": " + ipv6);
                    contador++;
                }
            }

        }

        sc.close();
    }
}
