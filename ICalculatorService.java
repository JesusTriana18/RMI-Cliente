import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculatorService extends Remote {
    double calcularAreaCuadrado(double lado) throws RemoteException;
    double calcularAreaCirculo(double radio) throws RemoteException;
}