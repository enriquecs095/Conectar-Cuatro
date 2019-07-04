package ProyectoFinal;
import java.util.Scanner;
public class Jugador {
   
   private String Nombre;
   private String Contrasena;
   private String Usuario;
   private int Puntaje;
   
   public Jugador(){
   Nombre="";
   Usuario="";
   Contrasena="";
   Puntaje=0;
}  
   
   public Jugador(String N, String U, String C){
   Nombre=N;
   Usuario=U;
   Contrasena=C;
   Puntaje=0;
   }
   
    public void Imprimir(){
        System.out.println("El puntaje es: "+ Puntaje + "\nNombre Completo: "+Nombre+"\nUsuario: "+Usuario);          
    }   
    
    public void ModificarDatos(){
        System.out.println("\nNombre Completo: "+Nombre+"\nUsuario: "+Usuario);
        
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }


    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

}
