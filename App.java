import java.util.Scanner;
import java.io.IOException;

public class App{
    
    public static int opc;
    public static Scanner sc = new Scanner(System.in);
    public static Scanner textoscan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        Banner banner = new Banner();
        Grid matriz1 = new Grid();
        banner.displayBanner();
        info();
        
        do {
            System.out.println("1. \u00BFC\u00F3mo se juega?");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            System.out.print("Pon tu opci\u00F3n: ");
            opc = sc.nextInt();
            System.out.println();
      
        switch (opc){
            case 1:
                reglas();
                System.out.println("\n");
                matriz1.printmatrizdemo();
                System.out.print("Presione [Enter] para continuar...");
                textoscan.nextLine();
                System.out.println();
                break;
            case 2:
                String nameone, nametwo;
                System.out.println("Bienvenidos a MoonReach!");
                System.out.println("Antes de empezar, ingrese el nombre de los jugadores");
                System.out.print("Jugador 1:");
                nameone = textoscan.nextLine();
                Player player1 = new Player(nameone);
                System.out.print("Jugador 2:");
                nametwo = textoscan.nextLine();
                Player player2 = new Player(nametwo);
                initPlayer(matriz1,player1,player2);
                matriz1.printmatriz();
                do{
                   System.out.println("Turno de " + player1.nombre);
                   System.out.println("Presione [Enter] para iniciar el dado");
                   textoscan.nextLine();
                   borrarPantalla();
                   player1.moverPlayer(matriz1,player1.tirarDado(),player2);

                   
                   System.out.println("Turno de " + player2.nombre);
                   System.out.println("Presione [Enter] para iniciar el dado");
                   textoscan.nextLine();
                   borrarPantalla();
                   player2.moverPlayer(matriz1,player2.tirarDado(),player1);
                   
                   
                }while((player1.haLlegado == false) && (player2.haLlegado == false));
                
                if(player1.haLlegado){
                    System.out.println("Enhorabuena " + player1.nombre + ", has ganado el juego!!");
                    break;
                }
                
                if(player2.haLlegado){
                    System.out.println("Enhorabuena " + player2.nombre + ", has ganado el juego!!");
                    break;
                }
                
                break;
                
            case 3:
                System.out.println("Adios!");
                break;
            
            default:
                System.out.println("Opci\u00F3n Inv\u00E1lida"); //Opción Inválida
                break;
        }
        } while (opc != 3 && opc != 2);
        
    
    }    
    public static void info(){
        System.out.println("\t\t\t\t\tUniversidad Catolica de Honduras");
        System.out.println("\t\t\t\t\t\tJose Eduardo Castro");
        System.out.println("\t\t\t\t\t\tRoque Castillo");
        System.out.println("\t\t\t\t\t\tDeinar Jared Mej\u00EDa");
        System.out.println("\t\t\t\t\t\tVersion 1.1");
    }   
    public static void reglas(){
        System.out.println("\t\t\tREGLAS!!!!\n");
        System.out.println("1. Tira el dado para mover la pieza atravez de la matriz");
        System.out.println("2. Si caes en una casilla \"+\", la pieza se mueve a la siguiente casilla");
        System.out.println("3. Si caes en una casilla \"!\", la pieza se mueve a la casilla previa");
        System.out.println("5. Alcanza la luna para ganar!");
    }
    
    //funcion para posicionar al jugador al inicio de la matriz
    public static void initPlayer(Grid gridFunc, Player jugador1, Player jugador2){
        if(jugador1.inicial.equals(jugador2.inicial)){
            jugador1.inicial = jugador1.inicial + "1";
            jugador2.inicial = jugador2.inicial + "2";
            jugador1.samenameFlag = true;
            jugador2.samenameFlag = true;
            System.out.printf("\nLos jugadores son: %s(%s) y %s(%s)\n",jugador1.nombre,jugador1.inicial,jugador2.nombre,jugador2.inicial);
            gridFunc.matriz[0][0] = jugador1.inicial + "," + jugador2.inicial;
        }
        else if(!jugador1.inicial.equals(jugador2.inicial)){
            gridFunc.matriz[0][0]  = " " +jugador1.inicial + "," + jugador2.inicial + " ";
        }
    }
    public static void borrarPantalla() throws IOException, InterruptedException{
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
}

