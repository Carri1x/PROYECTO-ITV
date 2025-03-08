
package opcion;

import cliente.Cliente;
import excepciones.NotExistsException;
import itv.Taller;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IRENE, ÁLVARO, ALEJANDRO
 */
public class InformeClientesVIP extends OpcionTaller{

    public InformeClientesVIP(Taller taller) {
        super("Generar informe de clientes VIP", taller);
    }

    @Override
    public void ejecutar() {
        TreeSet<Cliente> clientesVip;
        int i= 0;
        try {
            clientesVip = taller.getClientesVip();
            teclado.out("\n------ CLIENTES VIP ------\n");
            for (Cliente cliente : clientesVip) {
                teclado.out("Cliente "+(++i)+""
                            + "\nDNI: "+cliente.getDni()
                            +"\nNombre: "+cliente.getNombre()
                            +"\nTelefono: "+cliente.getTelefono()+"\n\n");
            }
        } catch (NotExistsException ex) {
            System.out.println(ex);
        }
        
    }
    
}
