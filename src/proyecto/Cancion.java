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
public class Cancion {
    private String disquera;
    private String artista;
    private String album;
    private String año;
    private String nombreC;
    private String genero;
    private String direccionC;
    private String duracion; 
    private String urlAutor;
    private String urlDisquera;
    private String biografia;
    
    public Cancion(){
        this.disquera = new String();
        this.artista =  new String();
        this.album =  new String();
        this.año =  new String();
        this.nombreC = new String();
        this.genero = new String();
        this.direccionC =  new String();
        this.duracion = new String();;
        this.urlAutor =  new String();
        this.urlDisquera =  new String();
        this.biografia =  new String();
    }

    public Cancion(String disquera, String artista, String album, String año, String nombreC, String genero, String direccionC, String duracion, String urlAutor, String urlDisquera, String biografia) {
        this.disquera = disquera;
        this.artista = artista;
        this.album = album;
        this.año = año;
        this.nombreC = nombreC;
        this.genero = genero;
        this.direccionC = direccionC;
        this.duracion = duracion;
        this.urlAutor = urlAutor;
        this.urlDisquera = urlDisquera;
        this.biografia = biografia;
    }

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
       
    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUrlAutor() {
        return urlAutor;
    }

    public void setUrlAutor(String urlAutor) {
        this.urlAutor = urlAutor;
    }

    public String getUrlDisquera() {
        return urlDisquera;
    }

    public void setUrlDisquera(String urlDisquera) {
        this.urlDisquera = urlDisquera;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    
}
