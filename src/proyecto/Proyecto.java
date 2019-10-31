package proyecto;

import java.io.File;
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
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        try { 
            BuscarArchivos prueba = new BuscarArchivos();
            File folder = new File("D:\\URL\\Cuarto ciclo 2019\\Manejo e implementación de archivos\\Proyecto");
            prueba.listarFicherosPorCarpeta(folder);
    }   catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
