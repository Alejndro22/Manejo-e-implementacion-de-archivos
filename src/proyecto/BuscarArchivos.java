package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Douglas
 */
public class BuscarArchivos {   
    Guardar almacenDeRegistros = new Guardar("biblioteca.data");
    Cancion r = new Cancion();
    
    public String tag(String tag){
        if ("TALB".equals(tag)){
            return "Álbum: ";
        }
        else if ("TIT2".equals(tag)){
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
        else if ("TYER".equals(tag)){
            return "Año del álbum: ";
        }
        else{
            return null;
        }     
    }
    public String AssignFromTag(String tag, String data){
        if ("TALB".equals(tag)){
            r.setAlbum(data);
            return "Álbum: ";
        }
        else if ("TIT2".equals(tag)){
            r.setNombreC(data);
            return "Nombre de la canción: ";
        }
        else if ("TPE1".equals(tag)){
            r.setArtista(data);
            return "Artista: ";
        }
        else if ("TPE2".equals(tag)){
            r.setArtista(data);
            return "Grupo: ";
        }
        else if ("TCON".equals(tag)){
            r.setGenero(data);
            return "Genero: ";
        }
        else if ("COMM".equals(tag)){
            r.setBiografia(data);
            return "Comentario: ";
        }
        else if ("TDRC".equals(tag)){
            r.setAño(data);
            return "Fecha de lanzamiento: ";
        }
        else if ("TYER".equals(tag)){
            r.setAño(data);
            return "Año del álbum: ";
        }
        else{
            return null;
        }     
    }
        
    public void listarFicherosPorCarpeta(final File carpeta) throws FileNotFoundException, IOException  {
        
        for(final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                 if (ficheroEntrada.getName().endsWith(".mp3") || ficheroEntrada.getName().endsWith(".MP3"))
                    {
                        System.out.println(ficheroEntrada);
                        r = new Cancion();
                        short pos=3; int totalTS;
                        RandomAccessFile archivo = new RandomAccessFile(ficheroEntrada, "r");
                        archivo.seek(pos);
                        byte Bver = archivo.readByte();

                        if (Bver==3){       
                            pos=6;
                            archivo.seek(pos);
                            totalTS = archivo.readInt();
                        }
                        else if(Bver== 4){  
                            pos=6;
                            archivo.seek(pos);
                            totalTS = archivo.readInt()/2;
                        }
                        else{
                            totalTS=0;
                        }
                        pos=(short) (pos+4);                
                        while(pos < totalTS){
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
                                AssignFromTag(tagg, cadena);
                                System.out.println(cadena);
                            }
                            pos=(short) (pos+10+tagSize);
                        }
//                        System.out.println(r.getAlbum()+r.getArtista()+r.getAño()+r.getBiografia()+r.getDireccionC()+r.getDisquera());
                        
                        System.out.println("FINNNNNNNNNNNNN");
                        System.out.println(r.getAlbum()+r.getArtista()+r.getAño()+r.getBiografia()+r.getDireccionC()+r.getDisquera());
                        almacenDeRegistros.agregarCancion(r, r.getNombreC());  
                        System.out.println(r.getAlbum()+r.getArtista()+r.getAño()+r.getBiografia()+r.getDireccionC()+r.getDisquera());
                    }
            }
        }
        almacenDeRegistros.guardar();
    }
    
}
