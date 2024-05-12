package conversordemoneda.principal;
import conversordemoneda.api.ConsultaMoneda;
import conversordemoneda.modelos.Descripcion;
import conversordemoneda.modelos.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner lectura = new Scanner(System.in);
        Descripcion descripcion = new Descripcion();
        int opcion = 0;
        try {
        while (opcion != 2){
            System.out.println(descripcion.menu);
            opcion = Integer.valueOf(lectura.nextLine());
            switch (opcion){
                case 1:
                    Comentario();
                    break;
                case 2:
                    System.out.println("Proceso finalizado");
                    break;
                case 9:
                    System.out.println("Gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Seleccion incorrecto!");
            }
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
       }

    }

    public static void Comentario(){

        Scanner lectura = new Scanner(System.in);

        Descripcion descripcion = new Descripcion();
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();

        System.out.println("Bienvenido");
        System.out.println(descripcion.menu1);
        System.out.println("Seleccione su moneda");
        var opcion1 = Integer.valueOf(lectura.nextLine());

        System.out.println(descripcion.menu2);
        System.out.println("Seleccione su moneda a cambiar");
        var opcion2 = Integer.valueOf(lectura.nextLine());

        String pais1 = Convertidor1(opcion1);
        String pais2 = Convertidor2(opcion2);
        System.out.println("Ingrese el monto");
        var monto = lectura.nextDouble();

        Moneda moneda = consultaMoneda.tipoMoneda(pais1, pais2, monto);
        System.out.println("El valor " + monto + " " + moneda.getBase_code() +
                " corresponde al valor final " + " =>>> " +
                moneda.getConversion_result() + " " + moneda.getTarget_code());

        System.out.println("Proceso finalizado");
    }

    public static String Convertidor1(int opcion1){
            String pais1 = switch (opcion1){
                case 1 -> "PEN";
                case 2 -> "USD";
                case 3 -> "MXN";
                case 4 -> "EUR";
                case 5 -> "ARS";
                case 6 -> "BOB";
                case 7 -> "COP";
                case 8 -> "BRL";
                default -> "Error de digito";
            };
            return pais1;
    }

    public static String Convertidor2(int opcion2){
        String pais2 = switch (opcion2){
            case 1 -> "PEN";
            case 2 -> "USD";
            case 3 -> "MXN";
            case 4 -> "EUR";
            case 5 -> "ARS";
            case 6 -> "BOB";
            case 7 -> "COP";
            case 8 -> "BRL";
            default -> "Error de digito";
        };
        return pais2;
    }
}
