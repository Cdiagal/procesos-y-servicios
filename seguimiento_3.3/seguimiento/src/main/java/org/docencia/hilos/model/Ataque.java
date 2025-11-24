package org.docencia.hilos.model;

import java.util.Objects;

/**
 * Clase Ataque de CalculadoraDanoCritico
 * @author cdiagal
 * @version 1.0.0
 */
public class Ataque {
    private String nombreAtacante;
    private int danioBase;
    private double probCritico;
    private double multiplicadorCritico;

    /**
     * Constructor vacio.
     */
    public Ataque(){}

    /**
     * Constructor con el nombre unico del atacante.
     * @param nombreAtacante
     */
    public Ataque(String nombreAtacante){
        this.nombreAtacante = nombreAtacante;
    }

    /**
     * Constructor con todas las propiedades de la clase.
     * @param nombreAtacante del atacante.
     * @param danioBase que causa.
     * @param probCritico que genera.
     * @param multiplicadorCritico que genera.
     */
    public Ataque(String nombreAtacante, int danioBase, double probCritico, double multiplicadorCritico) {
        this.nombreAtacante = nombreAtacante;
        this.danioBase = danioBase;
        this.probCritico = probCritico;
        this.multiplicadorCritico = multiplicadorCritico;
    }


    public String getNombreAtacante() {
        return this.nombreAtacante;
    }

    public void setNombreAtacante(String nombreAtacante) {
        this.nombreAtacante = nombreAtacante;
    }

    public int getDanioBase() {
        return this.danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public double getProbCritico() {
        return this.probCritico;
    }


    public double getMultiplicadorCritico() {
        return this.multiplicadorCritico;
    }

    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ataque)) {
            return false;
        }
        Ataque ataque = (Ataque) o;
        return Objects.equals(nombreAtacante, ataque.nombreAtacante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreAtacante);
    }
    
}
