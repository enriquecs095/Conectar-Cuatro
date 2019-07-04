package ProyectoFinal;

import java.util.Scanner;
    
public class ConectarCuatro { 
    final static int Fila = 6;
    final static int Columna = 7;
    static int    Finalizar=0;
    final static int FilaDefecto = Fila - 1;
    static char[][] tablero = new char[Fila][Columna];
    static Scanner leer = new Scanner(System.in);   
    
    public static void CreacionTablero(){
        
        CrearTablero();
        System.out.println("Ingrese numeros de la columna 0 a 6 : ");
        ImprimirPantalla();
        boolean Turno = true;
        while(Turno){
            SoltarX();
            
            ImprimirPantalla();
            if(!RevisarX()){               
                Turno = false; 
                break; 
             }
            
            
            SoltarO();
            
            ImprimirPantalla();
            if(!RevisarO()){
                Turno = false; 
                break; 
            }
      }
    }
    
    public static void CrearTablero() {
        for (int i = 0; Fila > i; i += 1) {
            for (int j = 0; Columna > j; j += 1) {
                tablero[i][j] = '_';
            }
        }
    } 

    public static void ImprimirPantalla() {
        for (int i = 0; Fila > i; i += 1) {
            for (int j = 0; Columna > j; j += 1) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void SoltarX(){
        int contador = 1;
        System.out.println("Turno de jugador 1");
        int columna = leer.nextInt();
        while(true){
            if(columna > Fila){
                System.out.println("Columna no existe");
                break;
            }
            if (tablero[FilaDefecto][columna] == '_') { 
                tablero[FilaDefecto][columna] = 'X';
                break;
            }else if(tablero[FilaDefecto][columna] == 'X' || tablero[FilaDefecto][columna] == 'O'){ 
                if(tablero[FilaDefecto- contador][columna] == '_'){ 
                    tablero[FilaDefecto - contador][columna] = 'X';
                    break; 
                }
            }
            contador += 1; 
            if(contador == Fila){ 
                System.out.println("La columna esta llena");
                break;
            }
        }      
    }

    public static void SoltarO(){
       
        int contador = 1;
        System.out.println("Turno de jugador 2");
        int columna = leer.nextInt();
        while(true){
            if(columna > Fila){
                System.out.println("Columna no existe");
                break;
            }
            if (tablero[FilaDefecto][columna] == '_') { 
                tablero[FilaDefecto][columna] = 'O';
                break; 
            }else if(tablero[FilaDefecto][columna] == 'X' || tablero[FilaDefecto][columna] == 'O'){ 
                if(tablero[FilaDefecto - contador][columna] == '_'){
                    tablero[FilaDefecto - contador][columna] = 'O';
                    break;
                }
            }
            contador += 1; 
            if(contador == Fila){ 
                System.out.println("La columna esta llena");
                break;
            }
        }      
    }

    public static boolean RevisarXHorizontal(){
        boolean Turno = true;
        int contador = 0;
        while(Turno){
            for(int i = 0; Fila > i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'X'){ 
                        contador += 1;
                    }else{
                        contador = 0; 
                    }
                    if(contador >= 4){
                        System.out.println("Jugador 1 gana"); 
                        Turno = false;
                    }
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarXVertical(){
        boolean Turno = true;
        int contador = 0;
        while(Turno){
            for(int j = 0; Columna > j; j += 1){
                for(int i = 0; Fila > i; i += 1){
                    if(tablero[i][j] == 'X'){ 
                        contador += 1;
                    }else{
                        contador= 0; 
                    }
                    if(contador >= 4){
                        System.out.println("Jugador 1 gana"); 
                        Turno = false;
                    }
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarOVertical(){
        boolean Turno = true;
        int contador = 0;
        while(Turno){
            for(int j = 0; Columna > j; j += 1){
                for(int i = 0; Fila > i; i += 1){
                    if(tablero[i][j] == 'O'){ 
                        contador += 1;
                    }else{
                        contador = 0; 
                    }
                    if(contador >= 4){
                        System.out.println("Jugador 2 gana"); 
                        Turno = false;
                    }
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarOHorizontal(){
        boolean Turno = true;
        int contador = 0;
        while(Turno){
            for(int i = 0; Fila > i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'O'){ 
                        contador += 1;
                    }else{
                        contador = 0; 
                    }
                    if(contador >= 4){
                        System.out.println("Jugador 2 gana"); 
                        Turno = false;
                    }
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarXDiagonalAdelante(){
        boolean Turno = true;
        int contador = 0;
        Boolean Revisar = false;
        int RevisarColumna = 1;
        int RevisarFila = 1;
        while(Turno){ 
            for(int i = 0; Fila > i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'X'){ 
                        contador += 1;
                        Revisar = true;
                        while(Revisar){ 
                            if(RevisarColumna + i <= Fila - 1&& RevisarFila + j <= Fila - 1){
                                if(tablero[i + RevisarColumna][j + RevisarFila] == 'X'){ 
                                    contador += 1;
                                }
                            }
                            RevisarColumna += 1;
                            RevisarFila += 1;
                            if(RevisarColumna == Fila -1 || RevisarFila == Columna -1){ 
                                Revisar = false;
                                break;
                            }
                            if(contador >= 4){
                                System.out.println("Jugador 1 gana"); 
                                Revisar = false;
                                Turno = false;
                                break;
                            }
                        }
                    }
                    if(contador >= 4){
                        Turno = false;
                        break;
                    }
                    contador = 0;
                    RevisarColumna = 1;
                    RevisarFila = 1;
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarODiagonalAdelante(){
        boolean Turno = true;
        int contador = 0;
        Boolean Revisar = false;
        int RevisarColumna = 1;
        int RevisarFila = 1;
        while(Turno){ 
            for(int i = 0; Fila > i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'O'){ 
                        contador += 1;
                        Revisar = true;
                        while(Revisar){ 
                            if(RevisarColumna + i <= Fila - 1&& RevisarFila + j <= Columna - 1){
                                if(tablero[i + RevisarColumna][j + RevisarFila] == 'O'){ 
                                    contador += 1;
                                }
                            }
                            RevisarColumna += 1;
                            RevisarFila += 1;
                            if(RevisarColumna == Fila -1 || RevisarFila == Columna -1){ 
                                Revisar = false;
                                break;
                            }
                            if(contador >= 4){
                                System.out.println("Jugador 2 gana"); 
                                Revisar = false;
                                Turno = false;
                                break;
                            }
                        }
                    }
                    if(contador >= 4){
                        Turno = false;
                        break;
                    }
                    contador = 0;
                    RevisarColumna = 1;
                    RevisarFila = 1;
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarXDiagonalAtras(){
        boolean Turno = true;
        int contador = 0;
        Boolean Revisar = false;
        int RevisarColumna = 1;
        int RevisarFila = 1;
        while(Turno){ 
            for(int i = 0; Fila> i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'X'){ 
                        contador += 1;
                        Revisar = true;
                        while(Revisar){ 
                            if(i - RevisarColumna >= 0 && j - RevisarFila >= 0){
                                if(tablero[i - RevisarColumna][j - RevisarFila] == 'X'){
                                    contador += 1; 
                                }
                            }
                            RevisarColumna += 1;
                            RevisarFila += 1;
                            if(RevisarColumna == 0 || RevisarFila == Columna-1){ 
                                Revisar = false;
                                break;
                            }
                            if(contador >= 4){
                                System.out.println("Jugador 1 gana"); 
                                Revisar = false;
                                Turno = false;
                                break;
                            }
                        }
                    }
                    if(contador >= 4){
                        Turno = false;
                        break;
                    }
                    contador = 0;
                    RevisarColumna = 1;
                    RevisarFila = 1;
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarODiagonalAtras(){
        boolean Turno = true;
        int contador = 0;
        Boolean Revisar = false;
        int RevisarColumna = 1;
        int RevisarFila = 1;
        while(Turno){
            for(int i = 0; Fila > i; i += 1){
                for(int j = 0; Columna > j; j += 1){
                    if(tablero[i][j] == 'O'){ 
                        contador += 1;
                        Revisar = true;
                        while(Revisar){ 
                            if(i - RevisarColumna >= 0 && j - RevisarFila >= 0){
                                if(tablero[i - RevisarColumna][j - RevisarFila] == 'O'){
                                    contador += 1; 
                                }
                            }
                            RevisarColumna += 1;
                            RevisarFila += 1;
                            if(RevisarColumna == 0 || RevisarFila == Columna -1){ 
                                Revisar = false;
                                break;
                            }
                            if(contador >= 4){
                                System.out.println("Jugador 2 Gana!"); 
                                Revisar = false;
                                Turno = false;
                                break;
                            }
                        }
                    }
                    if(contador >= 4){
                        Turno = false;
                        break;
                    }
                    contador = 0;
                    RevisarColumna = 1;
                    RevisarFila = 1;
                }
            }
            break;
        }
        return Turno;
    }

    public static boolean RevisarX(){
        boolean Turno = true;
        if(!RevisarXVertical() || !RevisarXHorizontal()|| !RevisarXDiagonalAtras()|| !RevisarXDiagonalAdelante()){
            Turno = false;
        }
        return Turno;
    }

    public static boolean RevisarO(){
        boolean Turno = true;
        if(!RevisarOVertical() || !RevisarOHorizontal() || !RevisarODiagonalAtras() || !RevisarODiagonalAdelante()){
            Turno = false;
        }
        return Turno;
    }
}