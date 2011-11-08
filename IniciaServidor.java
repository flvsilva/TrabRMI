import java.rmi.*;

public class IniciaServidor {
	public static void main(String argv[]) {
		try {
			System.out.println("Iniciando servidor...");
			Naming.rebind("ServidorDiv", new ServidorDiv());
			Naming.rebind("ServidorMult", new ServidorMult());
			Naming.rebind("ServidorCalc", new ServidorCalc());
		} catch (Exception e) {
			System.out.println("Ocorreu um problema na inicialização do servidor.\n"
					+ e.toString());
		}
	}
}
