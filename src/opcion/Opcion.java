package opcion;

import itv.Taller;
import util.GestorIO;
import util.Interval;

/**
 * @author irene, alvaro, alejandro
 */
public abstract class Opcion {
    GestorIO teclado = new GestorIO();
    protected String titulo;
    
    
    public Opcion(String titulo) {
        this.titulo = titulo;
        
    }

    /**
     * muestra las opciones
     */
    public void mostrar(int numeroOpcion){
        teclado.out(numeroOpcion + ". "+ this.titulo +"\n");
    }

    
    public abstract void ejecutar();
    
}