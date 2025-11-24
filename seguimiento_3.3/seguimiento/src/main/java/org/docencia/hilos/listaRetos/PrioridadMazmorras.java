package org.docencia.hilos.listaRetos;




import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Clase que ejecuta prioridad en mazmorras
 * @author cdiagal
 * @version 1.0.0
 */

public class PrioridadMazmorras {

    static class PeticionMazmorra implements Runnable, Comparable<PeticionMazmorra> {
        private final String nombreJugador;
        private final int prioridad; 
        private final String mazmorra;

        public PeticionMazmorra(String nombreJugador, int prioridad, String mazmorra) {
            this.nombreJugador = nombreJugador;
            this.prioridad = prioridad;
            this.mazmorra = mazmorra;
        }

        @Override
        public void run() {
            String hilo = Thread.currentThread().getName();
            System.out.println("[" + hilo + "] Preparando mazmorra '" + mazmorra +
                    "' para " + nombreJugador + " (prioridad " + prioridad + ")");
        }

        @Override
        public int compareTo(PeticionMazmorra o) {
            return Integer.compare(o.prioridad, this.prioridad); 
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Runnable> cola = new PriorityBlockingQueue<>();
        ExecutorService gmBots = new ThreadPoolExecutor(
                3, 3, 0L, TimeUnit.MILLISECONDS, cola);

        gmBots.execute(new PeticionMazmorra("Leia", 1, "Catacumbas"));
        gmBots.execute(new PeticionMazmorra("Gandalf", 3, "Moria"));
        gmBots.execute(new PeticionMazmorra("DarthVader", 2, "Torre Oscura"));

        gmBots.shutdown();
    }
}
