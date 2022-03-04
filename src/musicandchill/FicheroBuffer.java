/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicandchill;

/**
 *
 * @author paul.luna
 */
public class FicheroBuffer {
    
    byte [] buffer ;
    int num_recibidos;
    
    public FicheroBuffer(int tamaño){
        num_recibidos=0;
        buffer=new byte[tamaño];
    }
    
    public void añadirDatos(byte [] datos){
        
        // almacenar en buffer los datos que llegan desde la ultima posicion
        //
        System.out.println("num_antes: "+num_recibidos);
        int actual=num_recibidos;
        int i=0;
        while(num_recibidos<datos.length+actual){
            buffer[num_recibidos]=datos[i];
            num_recibidos++;
            i++;
        }
        
        
    }
    
    public boolean estaCompletado(){
        System.out.println("reci: "+num_recibidos+" buffer:" +buffer.length);
        return num_recibidos==buffer.length;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getNum_recibidos() {
        return num_recibidos;
    }   
}
