package parte4;

/**
 * Implementaci�n de diccionario con un �rbol de b�squeda binario.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public class DiccionarioT implements IDiccionarioT {

	DictNode root;
	
	@Override
	public void insertarTermino(String p) {
		DictNode newNode = new DictNode(p);
		if (root == null){	
			root = newNode;		// �rbol vac�o, se inserta como ra�z.
		}
		else {
			insertarTermino(newNode, root);
		}
		System.out.println("Se ha a�adido el termino " + p + " al diccionario."); 
	}

	/**
	 * M�todo recursivo para insertar el t�rmino, es privado porque otra clase solo debe poder acceder
	 * al m�todo con el par�metro String.
	 * @param newNode nodo que queremos insertar.
	 * @param node nodo sobre el que iteramos.
	 */
	private void insertarTermino(DictNode newNode, DictNode node) {
		String termino = newNode.termino;
		if (termino.equals(node.termino)) {
			System.out.println("El termino " + termino + " ya existe.");
			return;
		}
		if(termino.compareTo(node.termino) < 0){	
			if (node.leftChild == null) {
				/* Si el nuevo t�rmino a a�adir es menor que el del nodo que estamos coparando
				 * y no tiene hijo izquierdo, lo a�ade como hijo izquierdo.
				 */
				node.leftChild = newNode;
				newNode.parent = node;
			} 
			else
				insertarTermino(newNode, node.leftChild);
		} 
		else {
			// En cambio, si es mayor y no tiene hijo derecho, lo a�ade a su derecha.
			if(node.rightChild == null){
				node.rightChild = newNode;
				newNode.parent = node;
			} 
			else
				insertarTermino(newNode, node.rightChild);
		}
	}
	
	@Override	
	public void eliminarTermino(String p){
		if (root == null){
			System.out.println("EL diccionario est� vac�o.");
			return;
		}	
		if (root.termino.equals(p)) {	// root es el t�rmino a borrar
			if (root.rightChild == null && root.leftChild == null) {	// no tiene hijos		
				root = null;
				System.out.println("Se ha eliminado el termino " + p + ".");
				return;
			}
			if (root.rightChild != null && root.leftChild == null) {	// tiene hijo derecho
				root = root.rightChild;
				root.parent = null;
				System.out.println("Se ha eliminado el termino " + p + ".");
				return;
			}
			if (root.rightChild == null && root.leftChild != null) {	// tiene solo hijo izquierdo
				root = root.leftChild;
				root.parent = null;
				System.out.println("Se ha eliminado el termino " + p + ".");
				return;
			}
			else {
				/* Tiene dos hijos. Entonces buscamos el nodo con elemento m�s peque�o de la rama
				 * derecha y con su valor sobreescribimos el valor de la ra�z, despu�s eliminamos 
				 * dicho nodo. Tambi�n podr�a hacerse con el mayor de la izquierda.
				 */
				DictNode min = findMin(root.rightChild);
				root.termino = min.termino;
				eliminarTermino(min.termino, min);
			}			
		}
		else if (p.compareTo(root.termino) < 0) {	
			// root no es el t�rmino que buscamos y su valor es mayor, accedemos a la rama izquierda.
			 if(eliminarTermino(p, root.leftChild))
				 System.out.println("Se ha eliminado el termino " + p + ".");
		}
		else {
			if(eliminarTermino(p, root.rightChild))
				System.out.println("Se ha eliminado el termino " + p + ".");
		}		
	}

	/**
	 * M�todo privado recursivo, las otras clases solo deben acceder al otro m�todo (sobrecargado).
	 * @param p t�rmino con el que buscaremos el nodo a borrar.
	 * @param node nodo sobre el que iteramos.
	 * @return true si ha sido borrado, false en caso contrario.
	 */
	private boolean eliminarTermino(String p, DictNode node) {
		if (node == null){
			System.out.println("La clave no existe, no se eliminar�.");
			return false;
		}
		/* El bloque de abajo uso el mismo c�digo que en el m�todo de arriba para borrar el root,
		 * no podemos derivar todo el trabajo en este m�todo porque la ra�z dar�a "nullPointerException"
		 * si preguntaramos por los hijos de su nodo padre.
		 */
		if(p.equals(node.termino)){
			if(node.rightChild == null && node.leftChild == null){
				if(node.parent.rightChild == node){
					node.parent.rightChild = null;
					return true;
				}
				else {
					node.parent.leftChild = null;
					return true;					
				}		
			}
			if(node.rightChild != null && node.leftChild == null){
				if(node.parent.rightChild == node){
					node.parent.rightChild = node.rightChild;
					node.rightChild.parent = node.parent;
					return true;
			
				}
				else {
					node.parent.leftChild = node.rightChild;
					node.rightChild.parent = node.parent;
					return true;
				}
			}
			if(node.rightChild == null && node.leftChild != null){
				if(node.parent.rightChild == node){
					node.parent.rightChild=node.leftChild;
					node.leftChild.parent=node.parent;
					return true;
			
				}
				else {
					node.parent.leftChild = node.leftChild;
					node.leftChild.parent = node.parent;
					return true;
				}
			}
			else {				
				DictNode min = findMin(node.rightChild);
				node.termino = min.termino;
				return eliminarTermino(min.termino, min);				
			}
		}
		else {	// Si no estamos en el nodo a borrar seguimos recurriendo.
			if(p.compareTo(node.termino) < 0){
				return eliminarTermino(p, node.leftChild);
			}
			else{return eliminarTermino(p, node.rightChild);}
		}	
	}
		
	@Override
	public void buscarTermino(String p) {
		DictNode searchNode = root;
		String termino;
		while (searchNode != null) {
			termino = searchNode.termino;
			if (p.equals(termino)) {
				System.out.println("Termino " + termino + " encontrado.");
				break;	// hemos encontrado el t�rmino, salimos del bucle.
			} 
			else if(p.compareTo(termino) < 0){
				searchNode = searchNode.leftChild;
			} 
			else {
				searchNode = searchNode.rightChild;
			}
		}
		if(searchNode == null){		
			// Ha acabado el bucle y hemos llegado hasta abajo, por tanto no existe porque el bucle no se ha interrumpido.
			System.out.println("El termino " + p + " no existe.");
		}
		else {
			// Imprimir nodo y sus variaciones
			System.out.println("Las variaciones del termino " + searchNode.termino + " son: ");
			searchNode.variaciones.consultarLetra(' ');
		}
	}
	
	/**
	 * Encuentra el elemento de menor valor del �rbol y lo devuelve.
	 * @param node nodo sobre el que iterar.
	 * @return devuelve el nodo de menor valor.
	 */
	private DictNode findMin(DictNode node) {
		DictNode aux = node;
		while(aux.leftChild != null){
			aux = aux.leftChild;
		}
		return aux;
	}
}
