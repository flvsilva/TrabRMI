import java.rmi.*;

public interface InterfaceServidorDiv extends Remote {
    public double divide(double a, double b) throws RemoteException;
}
