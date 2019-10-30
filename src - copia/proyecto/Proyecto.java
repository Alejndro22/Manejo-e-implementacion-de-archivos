/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas
 */
public class Proyecto {

    public static String tag(String tag){
        if ("TALB".equals(tag)){
            return "Álbum: ";
        }
        else if ("T1T2".equals(tag)){
            return "Nombre de la canción: ";
        }
        else if ("TPE1".equals(tag)){
            return "Artista: ";
        }
        else if ("TPE2".equals(tag)){
            return "Grupo: ";
        }
        else if ("TCON".equals(tag)){
            return "Genero: ";
        }
        else if ("COMM".equals(tag)){
            return "Comentario: ";
        }
        else if ("TDRC".equals(tag)){
            return "Fecha de lanzamiento: ";
        }
        else{
            return null;
        }     
    }
    
    public static void main(String[] args) {
        try {
            short pos=6;
            RandomAccessFile archivo = new RandomAccessFile("Fernando.mp3", "rw");
            archivo.seek(pos);
            int totalTS = archivo.readInt();
            pos=(short) (pos+4);
            
            while(pos< totalTS){
                //Busca la posicion del cursor
                archivo.seek(pos);
                //Lee la etiqueta.
                byte[] TTag = new byte[4];
                archivo.read(TTag);
                String tagg = new String(TTag);
                String read1 = tag(tagg);
                //Lee el tamaño del string.
                int tagSize = archivo.readInt();
                
                if (read1!=null){
                    System.out.println(tagg + " => " +read1);
                    archivo.seek(pos+10);
                    byte[] info = new byte[tagSize];
                    archivo.read(info);
                    String cadena = new String(info);
                    System.out.println(cadena);
                }
                pos=(short) (pos+10+tagSize);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
