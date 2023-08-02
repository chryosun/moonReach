public class Player {
    int[] posicion = {0,0,0};
    int indice = 0;
    String nombre="jugador";
    String inicial;
    boolean samenameFlag = false, haLlegado = false;

    public Player(String nom ) {
        this.nombre = nom;
        this.inicial = nom.toUpperCase().substring(0,1);
    }
    
    //funcion tirar dado
    public int tirarDado(){
        return(int) (Math.random() * 6 + 1);
    }
    
    //funcion para mover el jugador
    public void moverPlayer(Grid matrizFunc,int valorDado,Player otrojugador){
        System.out.println("El dado dio " + valorDado+"...");
        
        if(samenameFlag == false){
            if(otrojugador.posicion == posicion){
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+otrojugador.inicial+"  ";
            }
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 0){
            matrizFunc.matriz[posicion[0]][posicion[1]] = "  -  ";
            }
            //
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 1){
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  +  ";
            }
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 2){
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  !  ";
            }
            //
            //cambio de posicion
            if(indice + valorDado >= 26){
                indice = 26;
                posicion = matrizFunc.casillas[indice];
                haLlegado = true;
            }
            if(indice + valorDado < 26){
                indice += valorDado;
                posicion = matrizFunc.casillas[indice];
            }
            //proceso pos cambio de posicion
            
            if(matrizFunc.casillas[indice][2] == 0){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " " + inicial + "," + otrojugador.inicial + " ";
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
            
            if(matrizFunc.casillas[indice][2] == 1){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+ inicial + "  ";
                matrizFunc.printmatriz();
                System.out.println("\nEnhorabuena " + nombre + ", has pasado a la siguiente casilla!");
                //relleno la casilla anterior
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  +  ";
                indice += 1;
                posicion = matrizFunc.casillas[indice];
                
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " " + inicial + "," + otrojugador.inicial + " ";
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
            
            if(matrizFunc.casillas[indice][2] == 2){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+ inicial + "  ";
                matrizFunc.printmatriz();
                System.out.println("\nQue lastima " + nombre + ", has retrocedido una casilla...");
                //relleno la casilla posterior
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  !  ";
                indice -= 1;
                posicion = matrizFunc.casillas[indice];
                //volver la casilla a la normalidad
                
                
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " " + inicial + "," + otrojugador.inicial + " ";
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = "  "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
            
        }
        
        else if(samenameFlag == true){
            if(otrojugador.posicion == posicion){
                matrizFunc.matriz[posicion[0]][posicion[1]] = " "+otrojugador.inicial+"  ";
            }
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 0){
            matrizFunc.matriz[posicion[0]][posicion[1]] = "  -  ";
            }
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 1){
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  +  ";
            }
            if(otrojugador.posicion != posicion && matrizFunc.casillas[indice][2] == 2){
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  !  ";
            }
            //cambio de posicion
            if(indice + valorDado >= 26){
                indice = 26;
                posicion = matrizFunc.casillas[27];
                haLlegado = true;
            }
            if(indice + valorDado < 27){
                indice += valorDado;
                posicion = matrizFunc.casillas[indice];
            }
            //proceso pos cambio de posicion
            
            if(matrizFunc.casillas[indice][2] == 0){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] =  inicial + "," + otrojugador.inicial;
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
            if(matrizFunc.casillas[indice][2] == 1){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                matrizFunc.matriz[posicion[0]][posicion[1]] = " "+ inicial + "  ";
                matrizFunc.printmatriz();
                //relleno la casilla anterior
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  +  ";
                System.out.println("\nEnhorabuena " + nombre + ", has pasado a la siguiente casilla!");
                indice += 1;
                posicion = matrizFunc.casillas[indice];
                
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] =  inicial + "," + otrojugador.inicial ;
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
            
            if(matrizFunc.casillas[indice][2] == 2){
                System.out.println(nombre + " te has movido "+ valorDado + " pasos...");
                matrizFunc.matriz[posicion[0]][posicion[1]] = " "+ inicial + "  ";
                matrizFunc.printmatriz();
                //relleno la casilla posterior
                matrizFunc.matriz[posicion[0]][posicion[1]] = "  !  ";
                System.out.println("\nQue lastima " + nombre + ", has retrocedido una casilla...");
                indice -= 1;
                posicion = matrizFunc.casillas[indice];
                
                if(otrojugador.posicion == posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] =  inicial + "," + otrojugador.inicial ;
                }
                else if(otrojugador.posicion != posicion){
                    matrizFunc.matriz[posicion[0]][posicion[1]] = " "+ inicial + "  ";
                }
                matrizFunc.printmatriz();
            }
        }
        
    }
    
}
