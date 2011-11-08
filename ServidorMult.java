import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServidorMult extends UnicastRemoteObject implements
InterfaceServidorMult {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5588499247558294579L;

	protected ServidorMult() throws RemoteException {
		System.out.println("Multiplicador no ar...");
	}

	public double multiplica(double a, double b) throws RemoteException {
		return a * b;
	}

}
