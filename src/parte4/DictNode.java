package parte4;
import parte1.ListaPalabras;
import parte2.Generador;

/**
 * Nodo/hoja del �rbol diccionarioT al que pertenecen los t�rminos.
 * @author Jordi Castell�
 * @author Xueyu Ji
 * 
 */
public class DictNode {
	public String termino;	// Elemento y a la vez clave de cada nodo.
	public ListaPalabras variaciones;
	
	public DictNode parent;
	public DictNode leftChild;
	public DictNode rightChild;
	
	public DictNode(String t){
		termino = t;
		variaciones = Generador.generar(t);
	}
}
