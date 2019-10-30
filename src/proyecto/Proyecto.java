
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proyecto {    
    public static void main(String[] args) {
        try { 
            BuscarArchivos prueba = new BuscarArchivos();
//            javaIOUtils.readFolderFiles("D:\\URL\\Cuarto ciclo 2019\\Manejo e implementación de archivos\\Proyecto");

            String files;
            File folder = new File("C:\\Users\\Usuario\\Desktop\\Proyecto");
            prueba.listarFicherosPorCarpeta(folder);
            File[] listOfFiles = folder.listFiles();

//            for (int i = 0; i < listOfFiles.length; i++)
//            {
//
//                if (listOfFiles[i].isFile())
//                {
//                    files = listOfFiles[i].getName();
//                    if (files.endsWith(".mp3") || files.endsWith(".MP3"))
//                    {
//                        short pos=3; int totalTS;
//                        RandomAccessFile archivo = new RandomAccessFile(files, "r");
//                        archivo.seek(pos);
//                        byte Bver = archivo.readByte();
//
//                        if (Bver==3){       
//                            pos=6;
//                            archivo.seek(pos);
//                            totalTS = archivo.readInt();
//                            System.out.println("a");
//                        }
//                        else if(Bver== 4){  
//                            pos=6;
//                            archivo.seek(pos);
//                            totalTS = archivo.readInt()/2;
//                        }
//                        else{
//                            totalTS=0;
//                        }
//                        pos=(short) (pos+4);                
//                        while(pos < totalTS){
//                            //Busca la posicion del cursor
//                            archivo.seek(pos);
//                            //Lee la etiqueta.
//                            byte[] TTag = new byte[4];
//                            archivo.read(TTag);
//                            String tagg = new String(TTag);
//                            String read1 = tag(tagg);
//                            //Lee el tamaño del string.
//                            int tagSize = archivo.readInt();
//
//                            if (read1!=null){
//                                System.out.println(tagg + " => " +read1);
//                                archivo.seek(pos+10);
//                                byte[] info = new byte[tagSize];
//                                archivo.read(info);
//                                String cadena = new String(info);
//                                System.out.println(cadena);
//                            }
//                            pos=(short) (pos+10+tagSize);
//                        }
//                        archivo.close();
//                        System.out.println("FINNNNNNNNNNNNN");
//                    }
//                }
//            }

//            short pos=3; int totalTS;
//            RandomAccessFile archivo = new RandomAccessFile("file_example_MP3_5MG.mp3", "rw");
//            archivo.seek(pos);
//            byte Bver = archivo.readByte();
//            
//            if (Bver==3){       
//                pos=6;
//                archivo.seek(pos);
//                totalTS = archivo.readInt();
//                System.out.println("a");
//            }
//            else if(Bver== 4){  
//                pos=6;
//                archivo.seek(pos);
//                totalTS = archivo.readInt()/2;
//            }
//            else{
//                totalTS=0;
//            }
//            pos=(short) (pos+4);                
//            while(pos < totalTS){
//                //Busca la posicion del cursor
//                archivo.seek(pos);
//                //Lee la etiqueta.
//                byte[] TTag = new byte[4];
//                archivo.read(TTag);
//                String tagg = new String(TTag);
//                String read1 = tag(tagg);
//                //Lee el tamaño del string.
//                int tagSize = archivo.readInt();
//                
//                if (read1!=null){
//                    System.out.println(tagg + " => " +read1);
//                    archivo.seek(pos+10);
//                    byte[] info = new byte[tagSize];
//                    archivo.read(info);
//                    String cadena = new String(info);
//                    System.out.println(cadena);
//                }
//                pos=(short) (pos+10+tagSize);
//            }
//            archivo.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }   catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
