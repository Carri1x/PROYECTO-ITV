/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import excepciones.NotExistsException;
import interfaces.ComparatorModelo;
import itv.Taller;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class MostrarVehiculosPorModelo extends OpcionTaller{

    public MostrarVehiculosPorModelo(Taller taller) {
        super("Mostrar vehiculos ordenados por modelo", taller);
    }

    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        TreeSet<Vehiculo> vehiculos = new TreeSet<>(new ComparatorModelo());
        try {
            vehiculos.addAll(taller.getVehiculos());
            for (Vehiculo vehiculo : vehiculos) {
                vehiculo.mostrarTodo();
            }
        } catch (NotExistsException ex) {
            teclado.out(ex.getMessage());
                  
        }
    }
    
}
