package parte1;
/**
 * Clase que se usará para almacenar la colección de la primera parte, implementación con lista simplemente enlazada.
 * @author Jordi Castelló
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
		if(isEmpty()){	// Si la lista está vacía el elemento nuevo será el primero (first).
			newNode.next=first;
			first=newNode;
			System.out.println("Se ha añadido el término " + p + " a la colección.");
		}
		else if(buscarPalabra(p)!=-1){	// Aquí se comprueba que no exista el elemento en la colección, para no tener elementos repetidos.
			System.out.println("El término " + p + " ya está en la colección, no se añadirá.");
		}
		else {
			Nodo aux=first;
			while(aux.next!=null){
				if(aux.next.elem==null){	// Comprobamos si estamos en el penúltimo elemento.
					if(p.compareTo(aux.elem) > 0){	// Si el parámetro p es mayor que el elemento de aux, añadimos el nuevo nodo después de aux.
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha añadido el término " + p + " a la colección.");
						return;
					}
					else {	// Solo se cumple cuando hay un elemento y el nuevo es menor que el que existe.
						newNode.next=first;
						first=newNode;
						System.out.println("Se ha añadido el término " + p + " a la colección.");
						return;
					}
				}
				else {	// Si aún hay mas elementos después de aux.
					if(p.compareTo(aux.elem) > 0 && p.compareTo(aux.next.elem) < 0){	
						/* Si no ponemos la condición de menor que el siguiente, insertaremos el elemento en la posición inmediata al menor.
						   Por ejemplo: si insertamos "casa" y tenemos "arbol"->"bola", lo añadiremos después de "arbol" pero casa no es 
						   menor que "bola", de modo que quedaría "arbol"->"casa"->"bola" y no estaría bien ordenado. */
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha añadido el término " + p + " a la colección.");
						return;
					}
				}
				aux=aux.next;
			}
		}
	}

	@Override
	public void eliminarPalabra(String p) {
		if(isEmpty()){	// Lista vacía, por lo tanto no existe.
			System.out.println("No se eliminará, no existe el elemento.");
		}
		else {
			Nodo aux=first;
			Nodo prev=null;	// Nodo previo al auxiliar porque es una lista simplemente enlazada.
			while(aux.next!=null){
				if(aux.elem.equals(p) && prev!=null){	// Si ya hemos inicializado el prev y coincide el elemento de aux nos saltamos el de enmedio.
					prev.next=aux.next;
					System.out.println("Se ha eliminado el término " + p +".");
					return;
				}
				else if(aux.elem.equals(p) && prev==null){	// Si no hemos inicializado prev significa que intentamos borrar el primer elemento.
					first=aux.next;							// Por lo tanto asignamos first al siguiente del auxiliar.
					System.out.println("Se ha eliminado el término " + p +".");
					return;
				}
				prev=aux;
				aux=aux.next;
			}
			System.out.println("El término " + p + " no existe en la colección.");
		}
	}

	@Override
	public int buscarPalabra(String p) {
		int i=0;
		for(Nodo aux=first; aux.next!=null; aux=aux.next){	// Recorremos la lista y si existe un elemento devolvemos el contador saliendo del búcle.
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
		int totalPalabras=0;	// Para contar las palabras que ha encontrado que empiecen por ese carácter.
		if(isEmpty()){
			System.out.println("No existe ningún elemento que empiece por el carácter '" + c + "'.");
		}
		else {
			for(Nodo aux=first; aux.next!=null; aux=aux.next){
				if(c==' '){	// Si hemos indicado el carácter ' ' contará e imprimirá todos los elementos de la colección.
					totalPalabras++;
					System.out.println(" * " + aux.elem);
				}
				else if(c==aux.elem.charAt(0)){	// En cambio, si hemos indicado otro carácter, solo contará los que empiecen por este.
					totalPalabras++;
					System.out.println(" * " + aux.elem);
				}
			}
			if(totalPalabras>0)		// De este modo podemos informar si no se han hallado coincidencias y de paso cuántas en total.
				System.out.println(totalPalabras + " coincidencia(s) encontrada(s).");
			else
				System.out.println("No se han encontrado coincidencias.");
		}
	}
	/**
	 * Método para comprobar si la colección está vacía.
	 * @return true si está vacía y false en caso contrario.
	 */
	public boolean isEmpty(){
		// Ocupa más líneas al tener que informar si está vacía, si no tuviesemos que hacerlo, devolveríamos directamente la condición del if.
		if(first.next==null){
			System.out.println("La lista está vacía.");
			return true;
		}
		else {
			return false;
		}
	}
}
/*** DECISIÓN ***
 * Para compara cadenas y saber cuál es mayor o menor (alfabéticamente), hemos decidido
 * usar un método predefinido de java para Strings: 'compareTo()', que devuelve n=0 si son iguales
 * n<0 si es menor y n>0 si es mayor. El caso de n=0 no nos interesa ya que no vamos a repetir elementos
 * y vamos a comprobar si ya existe antes de todo, para no meternos a recorrer la lista e intentar insertar.
 * 
 *  ** Orden de complejidad de cada método: **
 * 
 * 1) insertarPalabra. En el mejor de los casos constante O(1) si la lista está vacía, en el peor lineal O(n),
 *    que equivaldria a recorrer la lista entera.
 * 2) eliminarPalabra. Complejidad lineal O(n), busca la palabra a eliminar recorriendo uno a uno los elementos.
 * 3) buscarPalabra. Complejidad lineal O(n), recorre la lista buscando la palabra.
 * 4) consultarLetra. Complejidad lineal O(n), recorre toda la lista comprobando que el primer carácter coincida con el parametro.
 * 5) isEmpty. Tiene una complejidad constante O(1), es independiente del número de palabras.
 */
