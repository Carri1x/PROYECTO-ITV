package opcion;

import excepciones.FullQueueException;
import excepciones.NotExistsException;
import factura.Factura;
import itv.GenericQueue;
import itv.Taller;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class CalculoPagamentosRevisados extends OpcionTaller {

    

    public CalculoPagamentosRevisados(Taller taller) {
        super("Calcular y pagar vehículo revisado",taller);
        
    }

    /**
     * Calcula y cobra el precio totaln de un vehiculo
     */
    @Override
    public void ejecutar() {
       teclado.out("-- CALCULAR Y PAGA VEHÍCULO REVISADO --\n");
        try{
            Vehiculo vehiculo = taller.extraerVehiculoPago();
            double precio = vehiculo.calcularPrecio();
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " tiene que pagar: " + precio + "\n");
            taller.agregarFactura(new Factura(vehiculo, precio));
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " se ha añadido al historial.\n");
        }catch(NotExistsException ex){
            System.out.println(ex.getMessage());
        }
              

    }
}


