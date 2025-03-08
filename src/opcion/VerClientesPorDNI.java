/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import cliente.Cliente;
import excepciones.NotExistsException;
import itv.Taller;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;

/**
 *
 * @author irene
 */
public class VerClientesPorDNI extends OpcionTaller{

    public VerClientesPorDNI(Taller taller) {
        super("Ver clientes ordenados por DNI", taller);
    }

    /**
     * muestra los clientes en orden por DNI
     */
    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        teclado.out("-- VER CLIENTES ORDENADOS POR DNI --\n");
        try {
            TreeSet<Cliente> clientes = new TreeSet<>(taller.listaClientes());
            for (Cliente cliente : clientes) {
                teclado.out(cliente.toString());
            }
        } catch (NotExistsException ex) {
            teclado.out(ex.getMessage());
        }
            
        
    }
    
}
