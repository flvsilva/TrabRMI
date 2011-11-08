import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.*;

public class Cliente {

	public Cliente() {

		System.out.println("Iniciando o Cliente...");

		try {
			serv = (InterfaceServidorCalc) Naming
					.lookup("rmi://127.0.0.1/ServidorCalc");
		} catch (Exception e) {
			System.out.println("Falhou a inicialização do Cliente.\n" + e);
			System.out
					.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão rodando corretamente.\n");
			System.exit(0);
		}
	}

	public double soma(double a, double b) throws RemoteException {
		return serv.soma(a, b);
	}

	public double subtrai(double a, double b) throws RemoteException {
		return serv.subtrai(a, b);
	}

	public double multiplica(double a, double b) throws RemoteException {
		return serv.multiplica(a, b);
	}

	public double divide(double a, double b) throws RemoteException {
		return serv.divide(a, b);
	}

	public static void main(String[] argv) {
		Cliente c = new Cliente();
		
		try {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("1º valor: ");
			String valor1 = teclado.readLine();
			System.out.println("2º valor: ");
			String valor2 = teclado.readLine();
			System.out.println("Operador (+, -, *, /): ");
			String operador = teclado.readLine();
			teclado.close();
				
			if (operador.equals("+")) {
				double v1 = Double.valueOf(valor1);
				double v2 = Double.valueOf(valor2);
				Double resul = serv.soma(v1, v2);
				String res = resul.toString();
				System.out.println("Resultado: "+res);
				
			} else if (operador == "-") {
				double v1 = Double.valueOf(valor1);
				double v2 = Double.valueOf(valor2);
				Double resul = serv.subtrai(v1, v2);
				String res = resul.toString();
				System.out.println("Resultado: "+res);
				
			} else if (operador == "*") {
				double v1 = Double.valueOf(valor1);
				double v2 = Double.valueOf(valor2);
				Double resul = serv.multiplica(v1, v2);
				String res = resul.toString();
				System.out.println("Resultado: "+res);
				
			} else if (operador == "/") {
				double v1 = Double.valueOf(valor1);
				double v2 = Double.valueOf(valor2);
				Double resul = serv.divide(v1, v2);
				String res = resul.toString();
				System.out.println("Resultado: "+res);
			} else {
				System.out.println("Operação não reconhecida.");
			}
		} catch (Exception e) {
			System.out.println("Excepção durante chamadas remotas:" + e);
		}
	}

	private static InterfaceServidorCalc serv; // A interface para o objeto remoto
}
