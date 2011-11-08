import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorDiv extends UnicastRemoteObject implements
		InterfaceServidorDiv {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5306491849534896962L;

	protected ServidorDiv() throws RemoteException {
		System.out.println("Divisor no ar...");
	}

	public double divide(double a, double b) throws RemoteException {
		return a / b;
	}

}
