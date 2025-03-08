/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import excepciones.NotExistsException;
import itv.Taller;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class VehiculosPendientesRevision extends OpcionTaller{

    public VehiculosPendientesRevision(Taller taller) {
        super("Mostrar vehiculos pendientes de revisión", taller);
    }

    /**
     * muestra la lista de vehículos que están esperando a ser revisados
     */
    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        teclado.out("-- MOSTRAR VEHÍCULOS PENDIENTES DE REVISIÓN --\n");
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try {
            vehiculos.addAll(taller.getVehiculos());// son los vehiculos que aún no han entrado en ningun box, es la cola principal
            for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarTodo();
        }
        } catch (NotExistsException ex) {
            teclado.out(ex.getMessage());
        }
        
        
    }
    
}
