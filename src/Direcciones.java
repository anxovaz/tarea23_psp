import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos que devuelven direcciones ip
 */
public class Direcciones {
    /**
     * Método que devuelve las direcciones IPv4 de un dominio
     * @param dominio dominio
     * @return lista de direcciones ipv6
     */
    public static List<String> getIPsV4Dominio(String dominio){
        try{
            List<String> lista = new ArrayList<>();
            for(InetAddress ip: InetAddress.getAllByName(dominio)){
                if(ip instanceof Inet4Address) {
                    lista.add(ip.getHostAddress());
                }
            }
            return lista;

        } catch (UnknownHostException e) {
            System.out.println("No se han encontrado direcciones ipv4 para este dominio");
            return null;
        }
    }

    /**
     * Método que devuelve las direcciones IPv6 de un dominio
     * @param dominio dominio
     * @return lista de direcciones ipv6
     */
    public static List<String> getIPsV6Dominio(String dominio){
        try{
            List<String> lista = new ArrayList<>();
            for(InetAddress ip: InetAddress.getAllByName(dominio)){
                if(ip instanceof Inet6Address) {
                    lista.add(ip.getHostAddress());
                }
            }
            return lista;

        } catch (UnknownHostException e) {
            System.out.println("No se han encontrado direcciones ipv6 para este dominio");
            return null;
        }
    }

    /**
     * Método que devuelve la ip del anfitrión
     * @return ip del anfitrión
     */
    public static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que devuelve el hostnname del anfitrión
     * @return hostnname del anfitrión
     */
    public static String getLocalName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

}
