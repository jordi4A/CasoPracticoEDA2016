package parte3;
import parte1.ListaPalabras;
import parte2.Generador;
/**
 * Nodo que se usa en el diccionario, almacena tambi�n las variaciones.
 * Lista que pertenece a un �rbol.
 * @author Jordi Castell�
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
		if(s!=null)	variaciones=Generador.generar(s);	// Evitamos entrar aqu� al crear el elemento first.
	}
	/*** DECISI�N ***
	 * Se ha decidido que las variaciones del t�rmino se genere
	 * en el constructor de �ste, as� se generar� autom�ticamente
	 * al crear el t�rmino en el diccionario (cada t�rmino act�a 
	 * como un nodo).
	 */
}
