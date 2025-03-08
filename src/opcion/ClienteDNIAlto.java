/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import cliente.Cliente;
import excepciones.NotExistsException;
import itv.Taller;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class ClienteDNIAlto extends OpcionTaller{

    public ClienteDNIAlto(Taller taller) {
        super("Cliente con el DNI más alto", taller);
    }

    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        Cliente cliente;
        try {
            cliente = Taller.encontrarMaximo(taller.listaClientes());
            teclado.out("EL DNI MÁS ALTO ES: "+ cliente.getDni());
        } catch (NotExistsException ex) {
            teclado.out(ex.getMessage());
        }
             
        
    }
    
}
