
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
        System.out.println("Entrada al juego\n¿Desea jugar?\nS o N");
        char resp = papoy.next().charAt(0); 
        while (resp == 'S' || resp =='s'){
            Inicializar_listas();
            Jugar();
        }
        
        
       
       
        
        
    }//fin main
    
    public static void Jugar(){
        int cuarto = 1;
        char seguir = 's'; 
        while (cuarto < 20 && (seguir == 's' || seguir == 'S') ){
            System.out.println("Estamos en el cuarto : "+cuarto);
            int content = ran.nextInt(1, 6); 
            
            switch(content){
                case 1: 
                    int heartless = ran.nextInt(1, 4); 
                    System.out.println("Nos encontramos con "+heartless+" heartless");
                    int vida_h = 75 * heartless; 
                    while (vida_h > 0 && (Party.isEmpty() != true) ){
                        Imprimir_personajes(Party);
                        System.out.println("Elije el personaje: ");
                        int personaje_elejido = papoy.nextInt();
                        while (personaje_elejido > 4 || personaje_elejido < 0){
                            System.out.println("Debe elegir de las opciones posibles: \nVuelva a Ingresar: ");
                            personaje_elejido = papoy.nextInt(); 
                        }
                        Personaje personaje = new Personaje(); 
                        switch (personaje_elejido){
                            case 1: 
                                personaje = Party.get(0);
                                break; 
                            case 2: 
                                personaje = Party.get(1);
                                break; 
                            case 3: 
                                personaje = Party.get(2);
                                break; 
                        }
                        System.out.println("--- MENU ---\n1. Attack\n2. Magic\n3. Items\n4. Party\nIngrese: ");
                        int op_accion = papoy.nextInt(); 

                        switch(op_accion){
                            case 1: 
                                //ataque
                                vida_h -= personaje.getAttackPoints();
                                if (vida_h < 0){
                                    vida_h = 0; 
                                }
                                int daño = personaje.getAttackPoints()*1-(personaje.getDefensePoints()/100); 
                                //personaje.toString();
                                int nuevo_hp = personaje.getHP()-daño; 
                                System.out.println(personaje.getNombre()+" ataco!\n"+personaje.getNombre()+" recibio el golpe!");
                                System.out.println("Los Heartless les queda "+vida_h+" de vida\n");
                                personaje.setHP(nuevo_hp);
                                
                                break; 
                            case 2: 
                                System.out.println("--- HECHIZOS ---\n1. Blizzard 50MP - 50DMG\n2.Firaga 25MP - 25 DMG\n3. Gravity 75MP - 100DMG");
                                int hechizo = papoy.nextInt(); 
                                switch (hechizo){
                                    case 1: 
                                        System.out.println("\n"+personaje.getNombre()+" uso Blizzard!");
                                        vida_h-=50; 
                                        if (vida_h < 0){
                                            vida_h = 0; 
                                        }
                                        
                                        personaje.setMP(personaje.getMP()-50);
                                        daño = personaje.getAttackPoints()*1-(personaje.getDefensePoints()/100); 
                                        nuevo_hp = personaje.getHP()-daño; 
                                        System.out.println(personaje.getNombre()+" recibio el golpe!");
                                        System.out.println("A los Heartless les queda "+vida_h+" de vida");
                                         personaje.setHP(nuevo_hp);
                                        break; 
                                    case 2: 
                                        System.out.println("\n"+personaje.getNombre()+" uso Firaga!");
                                        vida_h-=25; 
                                        if (vida_h < 0){
                                            vida_h = 0; 
                                        }
                                        personaje.setMP(personaje.getMP()-25);
                                        daño = personaje.getAttackPoints()*1-(personaje.getDefensePoints()/100); 
                                        nuevo_hp = personaje.getHP()-daño;
                                        
                                        System.out.println(personaje.getNombre()+" recibio el golpe!");
                                        System.out.println("A los Heartless les queda "+vida_h+" de vida");
                                         personaje.setHP(nuevo_hp);
                                        break; 
                                    case 3: 
                                        System.out.println("\n"+personaje.getNombre()+" uso Gravity!");
                                        vida_h-=100; 
                                        if (vida_h < 0){
                                            vida_h = 0; 
                                        }
                                        personaje.setMP(personaje.getMP()-75);
                                        daño = personaje.getAttackPoints()*1-(personaje.getDefensePoints()/100); 
                                        nuevo_hp = personaje.getHP()-daño; 
                                        System.out.println(personaje.getNombre()+" recibio el golpe!");
                                        System.out.println("A los Heartless les queda "+vida_h+" de vida");
                                         personaje.setHP(nuevo_hp);
                                        break; 
                                }
                                break; 
                            case 3: 
                                Imprimir_items(Mochila); 
                                System.out.println("Elije un item: ");
                                int item = papoy.nextInt(); 
                                Items item_u = new Items(); 
                                item_u = Mochila.get(item-1); 
                                System.out.println(personaje.getNombre()+ " uso "+item_u.getNombre()); 
                                System.out.println(personaje.getNombre()+" recibio el golpe!");
                                vida_h -= personaje.getAttackPoints(); 
                                System.out.println("A los Heartless les queda "+vida_h+" de vida");
                                personaje.setHP(personaje.getHP()+item_u.getHPpoints());
                                daño = personaje.getAttackPoints()*1-(personaje.getDefensePoints()/100); 
                                nuevo_hp = personaje.getHP()-daño; 
                                personaje.setHP(nuevo_hp);
                                Mochila.remove(item-1); 
                                
                                break; 
                            case 4: 
                                Imprimir_Reserva(Reserva);
                                System.out.println("Que personaje desea agregar?");
                                int cambio = papoy.nextInt(); 
                                while (cambio < 1 || cambio > 3){
                                    System.out.println("Su respuesta debe estar dentro del rango\nVuelva a Ingresarlo: ");
                                    cambio = papoy.nextInt(); 
                                }
                                Personaje cambio_p = new Personaje(); 
                                cambio_p = Reserva.get(cambio-1); 
                                Party.remove(personaje_elejido-1); 
                                Party.add(cambio_p); 
                                System.out.println("El personaje ha sido cambiado antes del ataque");
                                System.out.println("Los Heartless les queda "+vida_h+" de vida");
                                
                                //cambiar personaje 
                                break; 
                        }
                    }//while
                    
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
                        for (int i = 0; i < items_amigos-1; i++) {
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
    
    }//fin jugar
    
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
    
    public static void Imprimir_Reserva(ArrayList<Personaje> pReserva){
        for (int i = 0; i < pReserva.size(); i++) {
            Personaje personaje = pReserva.get(i); 
            System.out.println((i+1)+".\n "+personaje.toString());
        } 
    }
}
