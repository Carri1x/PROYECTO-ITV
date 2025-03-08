package opcion;

import excepciones.NotExistsException;
import itv.Taller;

/**
 *
 * @author ÁLVARO CARRIÓN ROMERO
 */
public class MostrarHistoricoFacturasPorFecha extends OpcionTaller{

    public MostrarHistoricoFacturasPorFecha(Taller taller) {
        super("Mostrar histórico facturas por fecha", taller);
    }

    @Override
    public void ejecutar() {
        try {
            taller.mostrarFacturas();
        } catch (NotExistsException ex) {
            teclado.out(ex.getMessage());
        }
    }
    
}
