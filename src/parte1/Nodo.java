package parte1;
/**
 * Nodos para almacenar los elementos, cada elemento se almacena en uno.
 * @author Jordi Castell�
 * @author Xueyu ji
 *
 */
public class Nodo {
	String elem;
	Nodo next;
	
	public Nodo(String s){
		elem=s;
	}
}
/*** DECISI�N ***
 * Se ha decidido implementar una lista simplemente enlazada,
 * por lo tanto solo tendremos la referencia al siguiente 
 * nodo (next) y el elemento que contiene.
 */