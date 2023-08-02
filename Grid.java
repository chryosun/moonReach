public class Grid extends App {
    int[][] casillas ={
        //casillas de movimiento para la derecha 
        {0,0,0},{0,1,0},{0,2,0},{0,3,1},{0,4,0},{0,5,1},{0,6,0},{0,7,0},{0,8,2},{0,9,0},
        //casillas de movimiento para abajo
        {1,9,0},{2,9,0},{3,9,0},{4,9,0},
        //casillas de movimiento para la izquierda
        {4,8,0},{4,7,1},{4,6,0},{4,5,0},{4,4,0},{4,3,2},{4,2,0},{4,1,0},{4,0,0},
        //casillas de movimiento para arriba
        {3,0,2},{2,0,0},{1,0,0},{0,0,0}//aqui es la casilla final, donde la pieza que llegue primero a, termina el juego

    };
    String[][] matriz = new String[5][10];
    

    public Grid() {
        //rellenar matriz con espacios vacios
        for(int i=0;i<5;i++){
            for(int j=0;j<10;j++){
                matriz[i][j]= "     ";
            }
        }
        //relenar casillas de movimiento
        for(int casilla[] : casillas) {
            matriz[casilla[0]][casilla[1]] = "  -  ";
        }
        //casillas especiales
        matriz[0][3] = "  +  ";
        matriz[0][5] = "  +  ";
        matriz[0][8] = "  !  ";
        matriz[4][7] = "  +  ";
        matriz[4][3] = "  !  ";
        matriz[3][0] = "  !  ";
    }

    public void printmatriz(){
        for(String lugares[]: matriz){
            for(String lugar: lugares){
                System.out.print(lugar);
            }
            System.out.print("\n");
        }
    }
    public void printmatrizdemo(){
        System.out.println("Inicio/Fin en vuelta -->");
        for(String lugares[]: matriz){
            for(String lugar: lugares){
                System.out.print(lugar);
            }
            System.out.print("\n");
        }
    }
    
}
