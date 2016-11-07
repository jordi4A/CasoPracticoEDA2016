package parte1;
/**
 * Clase que se usar� para almacenar la colecci�n de la primera parte, implementaci�n con lista simplemente enlazada.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public class ListaPalabras implements IListaPalabras {
	private Nodo first;
	
	public ListaPalabras(){
		first=new Nodo(null);
	}
	
	@Override
	public void insertarPalabra(String p) {
		Nodo newNode=new Nodo(p);
		if(isEmpty()){	// Si la lista est� vac�a el elemento nuevo ser� el primero (first).
			newNode.next=first;
			first=newNode;
			System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
		}
		else if(buscarPalabra(p)!=-1){	// Aqu� se comprueba que no exista el elemento en la colecci�n, para no tener elementos repetidos.
			System.out.println("El t�rmino " + p + " ya est� en la colecci�n, no se a�adir�.");
		}
		else {
			Nodo aux=first;
			while(aux.next!=null){
				if(aux.next.elem==null){	// Comprobamos si estamos en el pen�ltimo elemento.
					if(p.compareTo(aux.elem) > 0){	// Si el par�metro p es mayor que el elemento de aux, a�adimos el nuevo nodo despu�s de aux.
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
						return;
					}
					else {	// Solo se cumple cuando hay un elemento y el nuevo es menor que el que existe.
						newNode.next=first;
						first=newNode;
						System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
						return;
					}
				}
				else {	// Si a�n hay mas elementos despu�s de aux.
					if(p.compareTo(aux.elem) > 0 && p.compareTo(aux.next.elem) < 0){	
						/* Si no ponemos la condici�n de menor que el siguiente, insertaremos el elemento en la posici�n inmediata al menor.
						   Por ejemplo: si insertamos "casa" y tenemos "arbol"->"bola", lo a�adiremos despu�s de "arbol" pero casa no es 
						   menor que "bola", de modo que quedar�a "arbol"->"casa"->"bola" y no estar�a bien ordenado. */
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
						return;
					}
				}
				aux=aux.next;
			}
		}
	}

	@Override
	public void eliminarPalabra(String p) {
		if(isEmpty()){	// Lista vac�a, por lo tanto no existe.
			System.out.println("No se eliminar�, no existe el elemento.");
		}
		else {
			Nodo aux=first;
			Nodo prev=null;	// Nodo previo al auxiliar porque es una lista simplemente enlazada.
			while(aux.next!=null){
				if(aux.elem.equals(p) && prev!=null){	// Si ya hemos inicializado el prev y coincide el elemento de aux nos saltamos el de enmedio.
					prev.next=aux.next;
					System.out.println("Se ha eliminado el t�rmino " + p +".");
					return;
				}
				else if(aux.elem.equals(p) && prev==null){	// Si no hemos inicializado prev significa que intentamos borrar el primer elemento.
					first=aux.next;							// Por lo tanto asignamos first al siguiente del auxiliar.
					System.out.println("Se ha eliminado el t�rmino " + p +".");
					return;
				}
				prev=aux;
				aux=aux.next;
			}
			System.out.println("El t�rmino " + p + " no existe en la colecci�n.");
		}
	}

	@Override
	public int buscarPalabra(String p) {
		int i=0;
		for(Nodo aux=first; aux.next!=null; aux=aux.next){	// Recorremos la lista y si existe un elemento devolvemos el contador saliendo del b�cle.
			if(p.equals(aux.elem)){
				System.out.println("Elemento " + p + " encontrado.");
				return i;
			}
			i++;
		}
		System.out.println("No se ha encontrado el elemento " + p + ".");
		return -1;	// Si ha recorrido la lista entera y no ha encontrado nada podemos garantizar que no existe el elemento, devolvemos -1.
	}

	@Override
	public void consultarLetra(char c) {
		int totalPalabras=0;	// Para contar las palabras que ha encontrado que empiecen por ese car�cter.
		if(isEmpty()){
			System.out.println("No existe ning�n elemento que empiece por el car�cter '" + c + "'.");
		}
		else {
			for(Nodo aux=first; aux.next!=null; aux=aux.next){
				if(c==' '){	// Si hemos indicado el car�cter ' ' contar� e imprimir� todos los elementos de la colecci�n.
					totalPalabras++;
					System.out.println(" * " + aux.elem);
				}
				else if(c==aux.elem.charAt(0)){	// En cambio, si hemos indicado otro car�cter, solo contar� los que empiecen por este.
					totalPalabras++;
					System.out.println(" * " + aux.elem);
				}
			}
			if(totalPalabras>0)		// De este modo podemos informar si no se han hallado coincidencias y de paso cu�ntas en total.
				System.out.println(totalPalabras + " coincidencia(s) encontrada(s).");
			else
				System.out.println("No se han encontrado coincidencias.");
		}
	}
	/**
	 * M�todo para comprobar si la colecci�n est� vac�a.
	 * @return true si est� vac�a y false en caso contrario.
	 */
	public boolean isEmpty(){
		// Ocupa m�s l�neas al tener que informar si est� vac�a, si no tuviesemos que hacerlo, devolver�amos directamente la condici�n del if.
		if(first.next==null){
			System.out.println("La lista est� vac�a.");
			return true;
		}
		else {
			return false;
		}
	}
}
/*** DECISI�N ***
 * Para compara cadenas y saber cu�l es mayor o menor (alfab�ticamente), hemos decidido
 * usar un m�todo predefinido de java para Strings: 'compareTo()', que devuelve n=0 si son iguales
 * n<0 si es menor y n>0 si es mayor. El caso de n=0 no nos interesa ya que no vamos a repetir elementos
 * y vamos a comprobar si ya existe antes de todo, para no meternos a recorrer la lista e intentar insertar.
 * 
 *  ** Orden de complejidad de cada m�todo: **
 * 
 * 1) insertarPalabra. En el mejor de los casos constante O(1) si la lista est� vac�a, en el peor lineal O(n),
 *    que equivaldria a recorrer la lista entera.
 * 2) eliminarPalabra. Complejidad lineal O(n), busca la palabra a eliminar recorriendo uno a uno los elementos.
 * 3) buscarPalabra. Complejidad lineal O(n), recorre la lista buscando la palabra.
 * 4) consultarLetra. Complejidad lineal O(n), recorre toda la lista comprobando que el primer car�cter coincida con el parametro.
 * 5) isEmpty. Tiene una complejidad constante O(1), es independiente del n�mero de palabras.
 */
