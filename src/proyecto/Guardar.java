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
    //Para esta clase se utilizaron conceptos aprendidos en clase, con una base en un ejercicio realizado.
    //Se crean los elementos necesarios como vistos en clase.    
    private String nombreDeArchivo;
    
    private ArrayList<Cancion> ListaRegistros;
    
    private ArrayList<IndiceCanciones> IndiceRegistros;
    
    public Guardar(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
        this.ListaRegistros = new ArrayList<>();
        this.IndiceRegistros = new ArrayList<>();
        
        
    }
    //Se utiliza para obtener el arreglo desde otras clases.
    public ArrayList getCanciones(){
       ListaRegistros = new ArrayList<Cancion>();
       return ListaRegistros;
    }
    //Se utiliza para obtener el arreglo desde otras clases.
    public ArrayList getIndCan(){
       IndiceRegistros = new ArrayList<IndiceCanciones>();
       return IndiceRegistros;
    }
    
    //Añade la canción a la lista y también al indice.
    public void agregarCancion(Cancion cancion, String nombreC){
        this.ListaRegistros.add(cancion);
        this.IndiceRegistros.add(new IndiceCanciones(nombreC,0));
    }
    
    //Primero escribe la posición del índice.
    //Comienza a escribir el archivo, escribiendo primero la longitud de cada cadena y luego escribiendo la misma.
    //De igual manera se escribe el índice.
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
                
                archivo.write(cancion.getAño().length());
                archivo.writeBytes(cancion.getAño());   
                
                archivo.write(cancion.getNombreC().length());
                archivo.writeBytes(cancion.getNombreC());   
                
                archivo.write(cancion.getGenero().length());
                archivo.writeBytes(cancion.getGenero());   
                
                archivo.write(cancion.getDireccionC().length());
                archivo.writeBytes(cancion.getDireccionC());   
                
                archivo.write(cancion.getUrlAutor().length());
                archivo.writeBytes(cancion.getUrlAutor());   
                
                archivo.write(cancion.getUrlDisquera().length());
                archivo.writeBytes(cancion.getUrlDisquera());   
                
                archivo.write(cancion.getBiografia().length());
                archivo.writeBytes(cancion.getBiografia());   
            
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
    
    //Parte del editar que cambia los valores en el array.
    public void Editar(String nombre, String Disquera, String Autor, String Album, String Año, String Genero, String DireccionC, String URLAutor, String URLDisquera, String Biografia){
        for (int i=0; i<ListaRegistros.size(); i++){
            if(nombre == null ? ListaRegistros.get(i).getNombreC() == null : nombre.equals(ListaRegistros.get(i).getNombreC())){
                ListaRegistros.get(i).setAlbum(Album);
                ListaRegistros.get(i).setArtista(Autor);
                ListaRegistros.get(i).setDisquera(Disquera);
                ListaRegistros.get(i).setAño(Año);
                ListaRegistros.get(i).setGenero(Genero);
                ListaRegistros.get(i).setDireccionC(DireccionC);
                ListaRegistros.get(i).setUrlAutor(URLAutor);
                ListaRegistros.get(i).setUrlDisquera(URLDisquera);
                ListaRegistros.get(i).setBiografia(Biografia);
            }
            
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
