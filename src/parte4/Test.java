package parte4;
import java.util.Scanner;
/**
 * Clase test para probar el funcionamiento del diccionario en árbol.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		DiccionarioT diccionario=new DiccionarioT();
		String termino;
		int opcion;
		boolean salir=false;
		
		while(!salir){
			System.out.println("DICCIONARIO_T");
			System.out.println("*************");
			System.out.println("¿Qué deseas hacer?");
			System.out.println("1) Insertar un término.");
			System.out.println("2) Borrar un término.");
			System.out.println("3) Buscar un término.");
			System.out.println("4) Salir del programa.");
			System.out.print("\nElección: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){
				case 1:
					System.out.println("Introduce el término a insertar: ");
					termino=teclado.next();
					diccionario.insertarTermino(termino);
					System.out.println();
					break;
				case 2:
					System.out.print("Introduce el término a eliminar: ");
					termino=teclado.next();
					diccionario.eliminarTermino(termino);
					System.out.println();
					break;
				case 3:
					System.out.print("Introduce el término a buscar: ");
					termino=teclado.next();
					diccionario.buscarTermino(termino);
					System.out.println();
					break;
				case 4:
					salir=true;
					System.out.println("¡Hasta luego!");
					break;
				default:
					System.out.println("Opción incorrecta.");
			}
		}
		teclado.close();
	}

}
