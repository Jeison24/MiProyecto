package musicandchill;

import java.util.Vector;

/**
 *
 * @author paul.luna
 */
public class FicheroParticionado {
    
    String protocolo;
    byte [] datos_music;
    Usuario origen;
    Usuario destino;
    Vector <String> listaConectados = new Vector<String>();
    
    public FicheroParticionado(){}

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public byte[] getDatos_music() {
        return datos_music;
    }

    public void setDatos_music(byte[] datos_music) {
        this.datos_music = datos_music;
    }

    public Usuario getOrigen() {
        return origen;
    }

    public void setOrigen(Usuario origen) {
        this.origen = origen;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    public Vector<String> getListaConectados() {
        return listaConectados;
    }

    public void setListaConectados(Vector<String> listaConectados) {
        this.listaConectados = listaConectados;
    }

    @Override
    public String toString() {
        return "Musica{" + "nombre=" + protocolo + ", datos_music=" + datos_music + ", origen=" + origen + ", destino=" + destino + ", listaConectados=" + listaConectados + '}';
    }
}
