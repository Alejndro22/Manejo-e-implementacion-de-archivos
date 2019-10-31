/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas
 */
public class Guardar {
    private String nombreDeArchivo;
    
    private ArrayList<Cancion> ListaRegistros;
    
    private ArrayList<IndiceCanciones> IndiceRegistros;

    public Guardar(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
        this.ListaRegistros = new ArrayList<>();
        this.IndiceRegistros = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion, String nombreC){
        this.ListaRegistros.add(cancion);
        this.IndiceRegistros.add(new IndiceCanciones(nombreC,0));
    }
    
    public void guardar(){
        try {            
            RandomAccessFile archivo = new RandomAccessFile(nombreDeArchivo,"rw");
            archivo.seek(2);
            int punteroAIndice = 0; 
            
            archivo.writeShort(punteroAIndice);
            
            int contadorIndice = 0;
            for(Cancion cancion : ListaRegistros){
                IndiceRegistros.get(contadorIndice++).setPosicion((int)archivo.getFilePointer());
                
                archivo.write(cancion.getDisquera().length());
                archivo.writeBytes(cancion.getDisquera());
                
                archivo.write(cancion.getArtista().length());
                archivo.writeBytes(cancion.getArtista());
                
                archivo.write(cancion.getAlbum().length());
                archivo.writeBytes(cancion.getAlbum());                
            }

            punteroAIndice = (int)archivo.getFilePointer();
            
            for(IndiceCanciones indice: IndiceRegistros){
                archivo.writeInt((int) indice.getPosicion());
                archivo.writeByte(indice.getNombreC().length());
                archivo.writeBytes(indice.getNombreC());
            }
            
            archivo.seek(0);
            archivo.writeInt(punteroAIndice);
            
            archivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public ArrayList<Cancion> getListaRegistros() {
        return ListaRegistros;
    }

    public void setListaRegistros(ArrayList<Cancion> ListaRegistros) {
        this.ListaRegistros = ListaRegistros;
    }

    public ArrayList<IndiceCanciones> getIndiceRegistros() {
        return IndiceRegistros;
    }

    public void setIndiceRegistros(ArrayList<IndiceCanciones> IndiceRegistros) {
        this.IndiceRegistros = IndiceRegistros;
    }
}
