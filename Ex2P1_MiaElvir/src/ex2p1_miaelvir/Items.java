
package ex2p1_miaelvir;


public class Items {
    //atributos
    String Nombre; 
    int HPpoints; 
    int MPpoints; 

    public Items(String Nombre, int HPpoints, int MPpoints) {
        this.Nombre = Nombre;
        this.HPpoints = HPpoints;
        this.MPpoints = MPpoints;
    }

    public Items() {
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getHPpoints() {
        return HPpoints;
    }

    public void setHPpoints(int HPpoints) {
        this.HPpoints = HPpoints;
    }

    public int getMPpoints() {
        return MPpoints;
    }

    public void setMPpoints(int MPpoints) {
        this.MPpoints = MPpoints;
    }

    @Override
    public String toString() {
        return "--- Items ---\n" + Nombre + "\nHPpoints: " + HPpoints + "\nMPpoints:" + MPpoints + "\n";
    }
    
    
    
    
}
