import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServidorMult extends Remote {
	public double multiplica(double a, double b) throws RemoteException;
}
