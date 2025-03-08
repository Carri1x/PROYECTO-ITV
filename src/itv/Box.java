package itv;

import excepciones.FullQueueException;
import excepciones.NotExistsException;
import itv.FaseRevision;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 * 
 * @author irene, alvaro, alejandro
 */
public class Box {

    private GestorIO teclado = new GestorIO();
    private static final int NUM_FASES = 4;
    private GenericQueue<FaseRevision> fases;

    
    public Box() {
        fases = new GenericQueue<>(NUM_FASES);
        for (int i = 0; i < NUM_FASES; i++) {
            try {
                fases.insertarElemento(new FaseRevision(i));
            } catch (FullQueueException ex) {
                teclado.out("No se han podido añadir todos los elementos a la cola");
            }
        }
    }

    /**
     * Verifica si la primera fase del box está libre.
     * 
     * @return true si el box está libre, false en caso contrario.
     */
    public boolean estaLibre() {
        return !fases.getPrimero().tieneVehiculo();
    }

    /**
     * Asigna un vehículo a la primera fase de revisión si el box está libre.
     * 
     * @param vehiculo el vehículo a asignar.
     */
    public void asignarVehiculo(Vehiculo vehiculo){
        if (estaLibre()) {
            fases.getPrimero().asignarVehiculoFase(vehiculo);
            teclado.out("Vehículo con matrícula " + vehiculo.getMatricula() + " asignado al box.");
        } else {
            teclado.out("El box está ocupado.");
        }
    }
    
    /**
     * Copia el último vehículo que pasó por la última fase de revisión.
     * 
     * @return el vehículo en la última fase del box.
     */
    public Vehiculo copiarUltimoVehiculo()throws NotExistsException{
        if(!fases.getUltimo().tieneVehiculo())throw new NotExistsException("No hay vehículos en la última fase");
        return fases.getUltimo().getVehiculo();
    }

    /**
     * Avanza los vehículos de las fases en un box.
     * Si la última fase está ocupada, se elimina el vehículo antes de mover los demás.
     */
    public void avanzarVehiculos() {
        boolean hayVehiculos = false;
        for (int i = 0; i < NUM_FASES; i++) {
            if(fases.getCola().get(i).tieneVehiculo()){
                hayVehiculos = true;
                break;
            }
        }
        if(!hayVehiculos){
            System.out.println("NO HAY VEHÍCULOS EN ESTE BOX PARA AVANZAR");
        }else{
            if(fases.getUltimo().tieneVehiculo()){
                Vehiculo ultimo = fases.getUltimo().eliminarVehiculo();                
                System.out.println("EL VEHíCULO CON LA MATRÍCULA "+ultimo.getMatricula()+" HA SUPERADO LAS FASES DE REVISIÓN Y HA ABANDONADO EL TALLER.\n");                
            }
            for (int i = NUM_FASES-1; i > 0; i--) {
                fases.getCola().get(i).asignarVehiculoFase(fases.getCola().get(i-1).getVehiculo());
                fases.getCola().get(i-1).eliminarVehiculo();                
            }
            teclado.out("LA PRIMERA FASE AHORA ESTÁ LIBRE PARA RECIBIR NUEVOS VEHÍCULOS");
        }
//        for (FaseRevision fase : fases) {
//            if (!fase.estaLibre()) {
//                hayVehiculos = true;
//                break;
//            }
//        }
//        if (fases.estaVacia()) {
//            teclado.out("No hay vehículos en este box para avanzar.\n");
//            return;
//        }
//        if (!fases[fases.length - 1].estaLibre()) {
//            Vehiculo ultimoVehiculoFase = fases[fases.length - 1].getVehiculo();
//            teclado.out("El vehículo con matrícula " + ultimoVehiculoFase.getMatricula() + " ha superado las fases de revisión y ha abandonado el taller.\n");           
//            fases[fases.length - 1].eliminarVehiculo();
//        }
//        for (int i = fases.length - 1; i > 0; i--) {
//            if (!fases[i - 1].estaLibre()) {
//                fases[i].setVehiculo(fases[i - 1].getVehiculo());
//                fases[i - 1].eliminarVehiculo();
//            }
//        }
//        if (fases[0].estaLibre()) {
//            teclado.out("La primera fase ahora está libre para recibir nuevos vehículos.\n");
//        }
    }

    /**
     * Muestra el estado actual de cada fase en el box.
     */
    public void mostrarEstado() {
        for (int i = 0; i < NUM_FASES; i++) {
            String estado = fases.getCola().get(i).estaLibre() ? "vacía" : "ocupada por " + fases.getCola().get(i).getMatriculaVehiculo();
            teclado.out("\nFase " + (i+1) + " está " + estado + ".");
        }
    }

    /**
     * Valida si la matrícula de un vehículo está presente en alguna fase del box.
     * 
     * @param matricula la matrícula a validar.
     * @return true si la matrícula es válida.
     */
    public boolean matriculaValida(String matricula) {
        for (int i = 0; i < NUM_FASES; i++) {
            if (!fases.getCola().get(i).matriculaValida(matricula)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si el box está libre en la primera fase.
     * 
     * @return true si la primera fase está libre, false en caso contrario.
     */
    public boolean boxLibre() {
        return this.estaLibre();
    }
    
    /**
     * Verifica si la última fase del box está ocupada.
     * 
     * @return true si la última fase está ocupada, false en caso contrario.
     */
    public boolean ultimaFaseOcupada(){
        return !fases.getUltimo().estaLibre();
    }
}