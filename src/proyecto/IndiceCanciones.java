/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Douglas
 */
public class IndiceCanciones implements Comparable<IndiceCanciones> {
    //Se declara lo necesario y la posicion en int pues se han dejado 4 bytes para ella.
    private String nombreC;
    private int posicion;

    public IndiceCanciones(String nombreC, int posicion) {
        this.nombreC = nombreC;
        this.posicion = posicion;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    @Override
    public int compareTo(IndiceCanciones o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
