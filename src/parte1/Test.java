package parte1;
import java.util.Scanner;
/**
 * Clase para probar los m�todos de la ListaPalabas.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		ListaPalabras coleccion=new ListaPalabras();
		int opcion, termPos;	// termPos es para almacenar el �ndice que nos devuelve el m�todo 'buscarPalabra()'
		char letra;
		String palabra;
		boolean salir=false;

		while (!salir){		// Men� de opciones
			System.out.println("Elige una opci�n:");
			System.out.println("\t 1) Insertar elemento.");
			System.out.println("\t 2) Eliminar elemento.");
			System.out.println("\t 3) Buscar elemento.");
			System.out.println("\t 4) Consultar elementos que empiecen por la letra indicada.");
			System.out.println("\t 5) Listar todos los elementos.");
			System.out.println("\t 6) Salir del programa.");
			System.out.print("Elige una opci�n: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){	// Submen�s seg�n la opci�n que elijamos.
				case 1: /* Insertar elemento */							
					System.out.print("Escribe el t�rmino a a�adir: ");
					palabra=teclado.next();
					coleccion.insertarPalabra(palabra);			
					break;
				case 2: /* Eliminar elemento */
					System.out.println("Escribe el t�rmino a borrar: ");
					palabra=teclado.next();
					coleccion.eliminarPalabra(palabra);
					break;
				case 3: /* Buscar elemento */					
					System.out.print("Escribe el t�rmino a buscar: ");
					palabra=teclado.next();
					termPos=coleccion.buscarPalabra(palabra);
					if(termPos >- 1) System.out.println("El elemento se encuentra en la posici�n " + termPos);
					else System.out.println("El elemento no existe en la lista.");
					break;
				case 4: /* Elementos por letra */
					System.out.print("Buscar palabras por la letra: ");					
					letra=teclado.next().charAt(0);
					coleccion.consultarLetra(letra);
					break;
				case 5:
					coleccion.consultarLetra(' ');
					break;
				case 6:	/* Salir del programa */
					System.out.println("�Hasta pronto!");
					salir=true;
					break;
				default:
					System.out.println("La opci�n es incorrecta.");
			}
		}
		teclado.close();
	}
}
/*** DECISI�N ***
 * 1) Por comodidad las clases Test las vamos a implementar
 *    con men�s para poder hacer las pruebas pertinentes.
 *     
 * 2) Ha habido que usar la variable "salir" en el bucle porque
 *    en el switch ya usamos un 'break' para salir del 'case',
 *    si fuese de otro modo valdr�a con un 'true' en la condici�n
 *    del 'while' y un break para salir del bucle.
 *     
 * 3) El caso 5 del switch preguntamos directamente si queremos
 *    hacer un listado completo ya que no se puede meter un car�cter
 *    ' ' por teclado con el m�todo 'next()'.
 */
