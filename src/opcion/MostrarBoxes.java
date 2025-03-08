/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class MostrarBoxes extends OpcionTaller {

    
    public MostrarBoxes(Taller taller){
        super("Mostrar estado de todos los boxes", taller);
    }

    /**
     * muestra el estado de todos los boxes
     */
    @Override
    public void ejecutar(){
        teclado.out("-- MOSTRAR ESTADO DE TODOS LOS BOXES --\n");
        taller.mostrarBoxes();
    }
   

}
