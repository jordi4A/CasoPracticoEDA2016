package parte2;
import java.util.Scanner;
import parte1.ListaPalabras;
/**
 * Clase para probar el método que genera las variaciones.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduce una palabra de referencia: ");
		String termino=teclado.next();
		ListaPalabras dic=Generador.generar(termino);
		
		System.out.println("\nSe han generado las variaciones:");
		dic.consultarLetra(' ');
		teclado.close();
	}

}
