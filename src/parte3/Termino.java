package parte3;
import parte1.ListaPalabras;
import parte2.Generador;
/**
 * Nodo que se usa en el diccionario, almacena también las variaciones.
 * Lista que pertenece a un árbol.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Termino {
	String elem;
	Termino prev;
	Termino next;
	ListaPalabras variaciones;
	
	public Termino(String s){
		elem=s;
		if(s!=null)	variaciones=Generador.generar(s);	// Evitamos entrar aquí al crear el elemento first.
	}
	/*** DECISIÓN ***
	 * Se ha decidido que las variaciones del término se genere
	 * en el constructor de éste, así se generará automáticamente
	 * al crear el término en el diccionario (cada término actúa 
	 * como un nodo).
	 */
}
