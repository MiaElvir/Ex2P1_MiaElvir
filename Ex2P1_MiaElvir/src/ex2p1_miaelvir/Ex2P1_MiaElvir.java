
package ex2p1_miaelvir;
//Fila 2, silla 5

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Ex2P1_MiaElvir {
    //formula pensada (ataque * (1 - defensacontrario))
    //ataque de heartless * 1 - defensadepersonaje //-mi daño 
    //restar ataque a la vida de los heartless//su daño 
    //saco el numero de tal indicec a eso le seteo la hp a la nueva sethp
    //while era hasta qu heartless sea 0 o la lista este vacia 
    //en la pelea si hp == 0 remove 
    static Random ran = new Random(); 
    static Scanner papoy = new Scanner(System.in); 
    static ArrayList<Personaje> Party = new ArrayList<>(); 
    static ArrayList<Items> Mochila = new ArrayList<>(); 
    static ArrayList<Personaje> Reserva = new ArrayList<>(); 
    
    public static void main(String[] args) {
        System.out.println("Entrada al juego, ¿Desea jugar?\n S o N");
        char resp = papoy.next().charAt(0); 
        while (resp == 'S' || resp =='s'){
            Inicializar_listas();
            Jugar();
        }
        
        
       
       
        
        
    }//fin main
    
    public static void Jugar(){
        int cuarto = 1;
        char seguir = 's'; 
        while (cuarto < 6 && (seguir == 's' || seguir == 'S') ){
            System.out.println("Estamos en el cuarto : "+cuarto);
            int content = ran.nextInt(1, 6); 
            
            switch(content){
                case 1: 
                    int heartless = ran.nextInt(1, 4); 
                    int vida_h = 75 * heartless; 
                    Imprimir_personajes(Party);
                    System.out.println("Elije personaje: ");
                    int personaje_elejido = papoy.nextInt();
                    System.out.println("--- MENU ---\n1. Attack\n2. Magic\n3. Items\n4. Party\nIngrese: ");
                    int op_accion = papoy.nextInt(); 
                    switch(op_accion){
                        case 1: 
                            //ataque
                            break; 
                        case 2: 
                            break; 
                        case 3: 
                            break; 
                        case 4: 
                            //cambiar personaje 
                            break; 
                    }
                    
                    //pelea
                    break; 
                case 2:
                    Mochila.add(new Items("Pocion", 50,0));
                    System.out.println("Te has encontrado un cofre que contiene una Pocion!");
                    //cofre con pocion
                    break; 
                case 3: 
                    Mochila.add(new Items("Ether", 0,50)); 
                    System.out.println("Te has encontrado un cofre que contiene un Ether!");
                    //cofre con ether
                    break; 
                case 4: 
                    Mochila.add(new Items("Elixir", 100,100));
                    System.out.println("Te has encontrado un cofre que contiene un Elixir!");
                    //cofre con elixir
                    break; 
                case 5: 
                    //amigos que necesitan ayuda
                    if (Mochila.size() != 0){
                        int items_amigos = ran.nextInt(1,Mochila.size()); 
                        System.out.println("Te has encontrado con amigos que necesitan de tu ayuda\n"
                                + "Decidiste darles "+items_amigos+" items");
                        for (int i = 0; i < items_amigos; i++) {
                            Mochila.remove(i); 
                        }
                    }else{
                        System.out.println("te encontraste con tus amigos pero no podias darle nada porque no tenias nada");
                    }
                    
                    break; 
            }//switch que pasa en el cuarto 
            cuarto++; 
            System.out.println("Deseas Continuar?");
            seguir = papoy.next().charAt(0); 
        }
    
    }
    
    public static void Inicializar_listas(){
        Party.add(new Personaje("Sora", 300, 300,75,15)); 
        Party.add(new Personaje("Donald", 150, 450, 45, 10)); 
        Party.add(new Personaje("Goofy", 450, 100, 150, 50)); 
        Reserva.add(new Personaje("Mickey", 100, 500, 150, 35));
        Reserva.add(new Personaje("Roxas", 300, 300, 15, 75));
        Reserva.add(new Personaje("Kairi", 200, 200, 50, 15));
        Mochila.add(new Items("Pocion", 50, 0)); 
        Mochila.add(new Items("Ether", 0, 50)); 
        Mochila.add(new Items("Elixir",100,100)); 
    }
    
    public static void Imprimir_personajes(ArrayList<Personaje> personajes){
        for (int i = 0; i < personajes.size(); i++) {
            Personaje personaje = personajes.get(i); 
            System.out.println((i+1)+".\n "+personaje.toString());
        } 
    }
    
    public static void Imprimir_items(ArrayList<Items> items){
        for (int i = 0; i < items.size(); i++) {
            Items item = items.get(i); 
            System.out.println((i+1)+".\n"+item.toString());
        }
    }
}
