import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            ICalculatorService service = (ICalculatorService) java.rmi.Naming.lookup("//localhost:1099/CalculatorService");

            Scanner scanner = new Scanner(System.in);
            char opcion;
            boolean salir = false;

            do {
                System.out.println("Seleccione una operación:");
                System.out.println("a) Calcular área de un cuadrado");
                System.out.println("b) Calcular área de un círculo");
                System.out.println("c) Salir");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.next().charAt(0);

                double num1, resultado;

                switch (opcion) {
                    case 'a':
                        System.out.print("Ingrese el lado del cuadrado: ");
                        num1 = scanner.nextDouble();
                        resultado = service.calcularAreaCuadrado(num1);
                        System.out.println("Área del cuadrado: " + resultado);
                        break;
                    case 'b':
                        System.out.print("Ingrese el radio del círculo: ");
                        num1 = scanner.nextDouble();
                        resultado = service.calcularAreaCirculo(num1);
                        System.out.println("Área del círculo: " + resultado);
                        break;
                    case 'c':
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }

                if (!salir) {
                    System.out.print("¿Desea realizar otra operación? (s/n): ");
                    char continuar = scanner.next().charAt(0);
                    if (continuar != 's') {
                        salir = true;
                    }
                }
                
                // Limpiar la consola
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } while (!salir);

            scanner.close();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
