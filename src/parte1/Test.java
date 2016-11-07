package parte1;
import java.util.Scanner;
/**
 * Clase para probar los métodos de la ListaPalabas.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		ListaPalabras coleccion=new ListaPalabras();
		int opcion, termPos;	// termPos es para almacenar el índice que nos devuelve el método 'buscarPalabra()'
		char letra;
		String palabra;
		boolean salir=false;

		while (!salir){		// Menú de opciones
			System.out.println("Elige una opción:");
			System.out.println("\t 1) Insertar elemento.");
			System.out.println("\t 2) Eliminar elemento.");
			System.out.println("\t 3) Buscar elemento.");
			System.out.println("\t 4) Consultar elementos que empiecen por la letra indicada.");
			System.out.println("\t 5) Listar todos los elementos.");
			System.out.println("\t 6) Salir del programa.");
			System.out.print("Elige una opción: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){	// Submenús según la opción que elijamos.
				case 1: /* Insertar elemento */							
					System.out.print("Escribe el término a añadir: ");
					palabra=teclado.next();
					coleccion.insertarPalabra(palabra);			
					break;
				case 2: /* Eliminar elemento */
					System.out.println("Escribe el término a borrar: ");
					palabra=teclado.next();
					coleccion.eliminarPalabra(palabra);
					break;
				case 3: /* Buscar elemento */					
					System.out.print("Escribe el término a buscar: ");
					palabra=teclado.next();
					termPos=coleccion.buscarPalabra(palabra);
					if(termPos >- 1) System.out.println("El elemento se encuentra en la posición " + termPos);
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
					System.out.println("¡Hasta pronto!");
					salir=true;
					break;
				default:
					System.out.println("La opción es incorrecta.");
			}
		}
		teclado.close();
	}
}
/*** DECISIÓN ***
 * 1) Por comodidad las clases Test las vamos a implementar
 *    con menús para poder hacer las pruebas pertinentes.
 *     
 * 2) Ha habido que usar la variable "salir" en el bucle porque
 *    en el switch ya usamos un 'break' para salir del 'case',
 *    si fuese de otro modo valdría con un 'true' en la condición
 *    del 'while' y un break para salir del bucle.
 *     
 * 3) El caso 5 del switch preguntamos directamente si queremos
 *    hacer un listado completo ya que no se puede meter un carácter
 *    ' ' por teclado con el método 'next()'.
 */
