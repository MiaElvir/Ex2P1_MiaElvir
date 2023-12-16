
package ex2p1_miaelvir;


public class Personaje {
    
    //atributos
    String Nombre; 
    int HP; 
    int MP; 
    int AttackPoints; 
    int DefensePoints; 

    public Personaje(String Nombre, int HP, int MP, int AttackPoints, int DefensePoints) {
        this.Nombre = Nombre;
        this.HP = HP;
        this.MP = MP;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }

    public Personaje() {
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getAttackPoints() {
        return AttackPoints;
    }

    public void setAttackPoints(int AttackPoints) {
        this.AttackPoints = AttackPoints;
    }

    public int getDefensePoints() {
        return DefensePoints;
    }

    public void setDefensePoints(int DefensePoints) {
        this.DefensePoints = DefensePoints;
    }

    
    @Override
    public String toString() {
        return  Nombre + ":\nHP: " + HP + "\nMP: " + MP + "\nAttackPoints: " + AttackPoints + "\nDefensePoints: " + DefensePoints+"\n";
    }
    
    
    
    
}//fin personaje 
