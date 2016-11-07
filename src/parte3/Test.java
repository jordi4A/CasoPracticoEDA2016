package parte3;
import java.util.Scanner;

/**
 * Clase test para probar el diccionario.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Diccionario diccionario=new Diccionario();
		String termino;
		int opcion;
		boolean salir=false;
		
		while(!salir){
			System.out.println("DICCIONARIO");
			System.out.println("***********");
			System.out.println("�Qu� deseas hacer?");
			System.out.println("1) Insertar un t�rmino.");
			System.out.println("2) Borrar un t�rmino.");
			System.out.println("3) Buscar un t�rmino.");
			System.out.println("4) Salir del programa.");
			System.out.print("\nElecci�n: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){
				case 1:
					System.out.println("Introduce el t�rmino a insertar: ");
					termino=teclado.next();
					diccionario.insertarTermino(termino);
					System.out.println();
					break;
				case 2:
					System.out.print("Introduce el t�rmino a eliminar: ");
					termino=teclado.next();
					diccionario.eliminarTermino(termino);
					System.out.println();
					break;
				case 3:
					System.out.print("Introduce el t�rmino a buscar: ");
					termino=teclado.next();
					diccionario.buscarTermino(termino);
					System.out.println();
					break;
				case 4:
					salir=true;
					System.out.println("�Hasta luego!");
					break;
				default:
					System.out.println("Opci�n incorrecta.");
			}
		}
		teclado.close();
	}

}
