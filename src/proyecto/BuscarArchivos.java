package proyecto;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class BuscarArchivos { 
    
    // Se inician los lectores del archivo.
    Guardar almacenDeRegistros;
    File archivo;
    FileInputStream archivoRead;
    
    Cancion r = new Cancion();
    
    //Se asegura que no exista el archivo biblioteca para evitar que se sobreescriban los datos.
    //De no existir entonces se crea.
    public BuscarArchivos() throws FileNotFoundException, IOException {
        String a="";
        this.archivo = new File("biblioteca.data");
        if(!archivo.exists()){
            almacenDeRegistros = new Guardar("biblioteca.data");
            
        }
        else{
            a=System.getProperty("user.dir");
            this.archivoRead = new FileInputStream(a+"\\biblioteca.data");
            archivoRead.close();
            archivo.delete();
            almacenDeRegistros = new Guardar("biblioteca.data");
        }
    }
    //Obtiene el arrayList de canciones para poder acceder a los datos.
    public ArrayList getListaCanciones(){
        ArrayList<Cancion> canciones = almacenDeRegistros.getListaRegistros();
        return canciones;
    }
    
    //Un intento de editar por medio de ArrayLists
    public void Edit(String nombre, String Disquera, String Autor, String Album, String Año, String Genero, String DireccionC, String URLAutor, String URLDisquera, String Biografia){
        almacenDeRegistros.Editar(nombre, Disquera, Autor, Album, Año, Genero, DireccionC, URLAutor, URLDisquera, Biografia);
    }
    
    
    //Compara unicamente para saber a que le corresponde cada etiqueta para mostrar en consola.
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
    //Es muy similar al anterior, pero con la diferencia que este almacena la información en el arrayList para
    // preparar que se pueda escribir en el archivo.
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
        else if ("WOAR".equals(tag)){
            r.setUrlAutor(data);
            return "Año del álbum: ";
        }
        else if ("WPUB ".equals(tag)){
            r.setUrlDisquera(data);
            return "Año del álbum: ";
        }
 
        else{
            return null;
        }     
    }
        
    //Funcion recursiva encoontrada en internet para poder recorrer las carpetas y poder obtener únicamente archivos .mp3
    //Dentro de ella se busca la información en las etiquetas ID3.
    public void listarFicherosPorCarpeta(final File carpeta) throws FileNotFoundException, IOException  {
        
        for(final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                 if (ficheroEntrada.getName().endsWith(".mp3") || ficheroEntrada.getName().endsWith(".MP3"))
                    {
                        
                        r = new Cancion();
                        String pathh = ficheroEntrada.getAbsolutePath();
                        r.setDireccionC(pathh);
                        short pos=3; int totalTS;
                        RandomAccessFile archivo = new RandomAccessFile(ficheroEntrada, "r");
                        archivo.seek(pos);
                        byte Bver = archivo.readByte();
                        //Se asegura de si la subversión es 3 o 4 para poder obrener toda la información.
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
                                //Define el array de bytes para almacenar la información.
                                byte[] info = new byte[tagSize];
                                archivo.read(info);
                                String cadena = new String(info);
                                //Se manda a AssignFromTag para poder almacenar la información del registro R.
                                AssignFromTag(tagg, cadena);
                                System.out.println(cadena);
                            }
                            //Se pasa el cursor a la siguiente posición.
                            pos=(short) (pos+10+tagSize);
                        }

                        
                        System.out.println("FINNNNNNNNNNNNN");
                        //Se almacena el registro r en la Lista de canciones y se genera su respectivo espacio en el Indice.
                        almacenDeRegistros.agregarCancion(r, r.getNombreC());  
                    }
            }
        }
        almacenDeRegistros.guardar();
    }
    
}
