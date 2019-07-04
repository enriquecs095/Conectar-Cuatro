package ProyectoFinal;

import java.util.Scanner;

public class UsuarioLog {

    static Scanner leer = new Scanner(System.in);
    private Jugador[] NUsuario;
    public String UsuarioSesion;
    public String UsuarioContrario;

    public UsuarioLog() {
        NUsuario = new Jugador[50];
        UsuarioSesion = "";
        UsuarioContrario = "";
    }

    public void MenuPrincipal() {
        String Opcion = "";
        boolean salir = false;
        int PosicionUsuario = 0;
        do {
            System.out.println("\nMENU DE INICIO \n1. Iniciar Sesion "
                    + "\n2. Crear Usuario \n3. Salir \n Ingrese una opcion");
            Opcion = leer.next();
            switch (Opcion) {

                case "1":
                    System.out.println("Ingrese el usuario: ");
                    String UsuarioI = leer.next();
                    System.out.println("Ingrese la contraseña");
                    String ContrasenaI = leer.next();
                    BuscarUsuario(UsuarioI, ContrasenaI);
                    break;

                case "2":
                    CrearUsuario(PosicionUsuario);
                    PosicionUsuario++;
                    break;

                case "3":
                    salir = true;
                    break;

                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        } while (salir != true);

    }

    public void MenuUsuario() {
        boolean salir = false;
        do {
            System.out.println("\nMENU PRINCIPAL" + "\n" + UsuarioSesion + "\n1. Jugar Conectar Cuatro "
                    + "\n2. Ranking \n3. Mi perfil \n4. Cerrar Sesion \n Ingrese una opcion");
            String Opcion = leer.next();

            switch (Opcion) {
                case "1":
                    UsuarioOponente();
                    break;

                case "2":
                    ListaUsuarios();
                    break;

                case "3":
                    MiPerfil();
                    break;

                case "4":
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (salir != true);
    }

    public void MiPerfil() {
        boolean salir = false;
        do {
            System.out.println("\nMENU EDICION");
            System.out.println("1. Editar Perfil");
            System.out.println("2. Ver mis ultimas partidas");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Regresar al menu principal");
            System.out.println("Ingrese una opcion");
            String opcion = leer.next();
            switch (opcion) {

                case "1":
                    EditarPerfil();
                    break;

                case "2":

                    break;

                case "3":
                    EliminarUsuario();
                    break;

                case "4":
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (salir != true);

    }

    public void CargarUsuario(String Usuario) {
        UsuarioSesion = Usuario;

    }

    public void UsuarioContrario(String Usuario) {
        UsuarioContrario = Usuario;

    }

    public void CrearUsuario(int PosicionUsuario) {
        Scanner captar = new Scanner(System.in);
        if (NUsuario[PosicionUsuario] == null) {
            System.out.println("Ingrese el nombre del usuario: ");
            String NombreN = captar.nextLine();
            System.out.println("Ingrese el usuario: ");
            String UsuarioN = captar.next();
            System.out.println("Ingrese la contraseña: ");
            String ContrasenaN = captar.next();
            NUsuario[PosicionUsuario] = new Jugador(NombreN, UsuarioN, ContrasenaN);
        }
        System.out.println("Usuario creado exitosamente");
    }

    public void BuscarUsuario(String Usuario, String Contrasena) {
        boolean EE = false;
        boolean salir = false;
        for (int x = 0; x < NUsuario.length; x++) {
            if (NUsuario[x] != null) {
                if (NUsuario[x].getUsuario().equals(Usuario) && NUsuario[x].getContrasena().equals(Contrasena)) {
                    System.out.println("\nBienvenido");
                    EE = true;
                    CargarUsuario(Usuario);
                    MenuUsuario();
                }
            }
        }
        if (EE == false) {
            System.out.println("Usuario o contraseña incorrecto");
        }
    }

    public void UsuarioOponente() {
        ConectarCuatro objeto3 = new ConectarCuatro();
        int Opcion = 0;
        boolean salir = false;
        String UsuarioO = "";
        boolean EE = false;
        do {
            System.out.println("Ingrese el usuario contrario: ");
            UsuarioO = leer.next();
            for (int x = 0; x < NUsuario.length; x++) {
                if (NUsuario[x] != null) {
                    if (NUsuario[x].getUsuario().equals(UsuarioO)) {
                        System.out.println("Bienvenido\n" + NUsuario[x].getUsuario());
                        EE = true;
                        UsuarioContrario(UsuarioO);
                        objeto3.CreacionTablero();
                        salir = true;
                    }
                }
            }
            if (EE == false) {
                System.out.println("Usuario no existe");
                System.out.println("Desea agregar otro usuario?");
                System.out.println("1. Si     2. No");
                Opcion = leer.nextInt();
                if (Opcion == 1) {
                    salir = false;
                } else if (Opcion == 2) {
                    salir = true;
                } else {
                    System.out.println("Opcion incorrecta");
                }
            }
        } while (salir != true);

    }

    public void ListaUsuarios() {
        for (int x = 0; x < NUsuario.length; x++) {
            if (NUsuario[x] != null) {
                System.out.println("----------------");
                NUsuario[x].Imprimir();
            }
        }
    }

    public void EditarPerfil() {
        int Opcion = 0;
        int posicion = 0;
        String UsuarioN = "";
        String NombreN = "";
        String ContrasenaN = "";

        for (int x = 0; x < NUsuario.length; x++) {
            if (NUsuario[x] != null) {
                if (NUsuario[x].getUsuario().equals(UsuarioSesion)) {
                    NUsuario[x].ModificarDatos();
                }
                posicion = x;
            }
        }
        System.out.println("Que datos desea modificar?");
        System.out.println("1. Nombre 2. Usuario 3. Contrasena 4. salir");
        Opcion = leer.nextInt();
        if (Opcion == 1) {
            System.out.println("Ingrese el nuevo nombre: ");
            NombreN = leer.next();
            NUsuario[posicion].setNombre(NombreN);
            System.out.println("Cambio realizado");
        } else if (Opcion == 2) {
            System.out.println("Ingrese el nuevo usuario: ");
            UsuarioN = leer.next();
            NUsuario[posicion].setUsuario(UsuarioN);
            UsuarioSesion = UsuarioN;
            System.out.println("Cambio realizado");
        } else if (Opcion == 3) {
            System.out.println("Ingrese la nueva contraseña: ");
            ContrasenaN = leer.next();
            NUsuario[posicion].setContrasena(ContrasenaN);
            System.out.println("Cambio realizado");
        } else if (Opcion == 4) {
        }
    }

    public void EliminarUsuario() {
        int Posicion = 0;
        int Confirmar = 0;
        System.out.println("Seguro que desea eliminar su cuenta: ");
        System.out.println("1. Si  2. No");
        Confirmar = leer.nextInt();
        if (Confirmar == 1) {
            for (int x = 0; x < NUsuario.length; x++) {
                if (NUsuario[x].getUsuario().equals(UsuarioSesion)) {
                    NUsuario[x] = null;
                    System.out.println("Usuario eliminado");
                    MenuPrincipal();
                }
            }
        } else if (Confirmar == 2) {
            System.out.println("Regresando al menu...");
        }
    }

    public Jugador[] getNUsuario() {
        return NUsuario;
    }

    public void setNUsuario(Jugador[] NUsuario) {
        this.NUsuario = NUsuario;
    }

    public String getUsuarioSesion() {
        return UsuarioSesion;
    }

    public void setUsuarioSesion(String UsuarioSesion) {
        this.UsuarioSesion = UsuarioSesion;
    }

    public String getUsuarioContrario() {
        return UsuarioContrario;
    }

    public void setUsuarioContrario(String UsuarioContrario) {
        this.UsuarioContrario = UsuarioContrario;
    }
}
