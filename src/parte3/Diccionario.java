package parte3;
/**
 * Clase diccionario que almacena términos y sus variaciones.
 * Los métodos son casi idénticos a los de ListaPalabra.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Diccionario implements IDiccionario {
	private Termino first;
	
	public Diccionario(){
		first=new Termino(null);
	}
	
	@Override
	public void insertarTermino(String p) {
		Termino newNode=new Termino(p);
		if(isEmpty()){
			newNode.next=first;
			first=newNode;
			System.out.println("Se ha añadido el término " + p + " al diccionario.");
		}
		else if(buscarTermino(p) != -1){
			System.out.println("El término " + p + " ya está en el diccionario, no se añadirá.");
		}
		else {
			Termino aux=first;
			while(aux.next!=null){
				if(aux.next.elem==null){
					if(p.compareTo(aux.elem) > 0){
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha añadido el término " + p + " a la colección.");
						return;
					}
					else {
						newNode.next=first;
						first=newNode;
						System.out.println("Se ha añadido el término " + p + " a la colección.");
						return;
					}
				}
				else {
					if(p.compareTo(aux.elem) > 0 && p.compareTo(aux.next.elem) < 0){
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
	public void eliminarTermino(String p) {
		if(isEmpty()){
			System.out.println("No se eliminará, no existe el término.");
		}
		else {
			Termino aux=first;
			Termino prev=null;
			while(aux.next!=null){
				if(aux.elem.equals(p) && prev!=null){
					prev.next=aux.next;
					System.out.println("Se ha eliminado el término " + p +".");
					return;
				}
				else if(aux.elem.equals(p) && prev==null){
					first=aux.next;
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
	public int buscarTermino(String p) {
		int i=0;
		for(Termino aux=first; aux.next!=null; aux=aux.next){
			if(p.equals(aux.elem)){
				aux.variaciones.consultarLetra(' ');
				System.out.println("Término " + p + " encontrado.");
				return i;
			}
			i++;
		}
		System.out.println("No se ha encontrado el término " + p + ".");
		return -1;
	}	
	/**
	 * Método para comprobar si la colección está vacía.
	 * @return true si está vacía y false en caso contrario.
	 */
	public boolean isEmpty(){
		if(first.next==null){
			System.out.println("La lista está vacía.");
			return true;
		}
		else {
			return false;
		}
	}

}
