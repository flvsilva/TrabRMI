import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class ServidorCalc extends UnicastRemoteObject implements
		InterfaceServidorCalc {
	/**
		 * 
		 */
	private static final long serialVersionUID = 5744691484250832092L;

	public ServidorCalc() throws RemoteException {
		System.out.println("Novo Servidor instanciado...");
		try {
			servD = (InterfaceServidorDiv) Naming
					.lookup("rmi://127.0.0.1/ServidorDiv");
			servM = (InterfaceServidorMult) Naming
					.lookup("rmi://127.0.0.1/ServidorMult");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {	
			e.printStackTrace();
		}

	}

	public double soma(double a, double b) throws RemoteException {
		return a + b;
	}

	public double subtrai(double a, double b) throws RemoteException {
		return a - b;
	}

	public double multiplica(double a, double b) throws RemoteException {
		return servM.multiplica(a, b);
	}

	public double divide(double a, double b) throws RemoteException {
		return servD.divide(a, b);
	}

	private InterfaceServidorDiv servD;
	private InterfaceServidorMult servM;
}
