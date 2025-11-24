package org.docencia.hilos;

import org.docencia.hilos.model.Ataque;
import java.util.*;
import java.util.concurrent.*;

public class CalculadoraDanoCritico {

    static class TareaCalcularDano implements Callable<Integer> {
        private final Ataque ataque;
        TareaCalcularDano(Ataque ataque) { this.ataque = ataque; }

        @Override
        public Integer call() throws Exception {
            boolean critico = Math.random() < ataque.getProbCritico();
            int dano = (int) (ataque.getDanioBase() * (critico ? ataque.getMultiplicadorCritico() : 1));
            Thread.sleep(300);
            return dano;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Ataque> ataques = List.of(
                new Ataque("Mago", 120, 0.3, 2.5),
                new Ataque("Guerrero", 150, 0.15, 2.0),
                new Ataque("Pícaro", 90, 0.5, 3.0),
                new Ataque("Arquera", 110, 0.35, 2.2)
        );

        List<Future<Integer>> futuros = new ArrayList<>();
        for (Ataque a : ataques)
            futuros.add(pool.submit(new TareaCalcularDano(a)));

        int total = 0;
        for (Future<Integer> f : futuros)
            total += f.get();

        System.out.println("Daño total raid: " + total);
        pool.shutdown();
    }
}
