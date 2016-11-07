package parte3;
/**
 * Clase diccionario que almacena t�rminos y sus variaciones.
 * Los m�todos son casi id�nticos a los de ListaPalabra.
 * @author Jordi Castell�
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
			System.out.println("Se ha a�adido el t�rmino " + p + " al diccionario.");
		}
		else if(buscarTermino(p) != -1){
			System.out.println("El t�rmino " + p + " ya est� en el diccionario, no se a�adir�.");
		}
		else {
			Termino aux=first;
			while(aux.next!=null){
				if(aux.next.elem==null){
					if(p.compareTo(aux.elem) > 0){
						newNode.next=aux.next;
						aux.next=newNode;
						System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
						return;
					}
					else {
						newNode.next=first;
						first=newNode;
						System.out.println("Se ha a�adido el t�rmino " + p + " a la colecci�n.");
						return;
					}
				}
				else {
					if(p.compareTo(aux.elem) > 0 && p.compareTo(aux.next.elem) < 0){
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
	public void eliminarTermino(String p) {
		if(isEmpty()){
			System.out.println("No se eliminar�, no existe el t�rmino.");
		}
		else {
			Termino aux=first;
			Termino prev=null;
			while(aux.next!=null){
				if(aux.elem.equals(p) && prev!=null){
					prev.next=aux.next;
					System.out.println("Se ha eliminado el t�rmino " + p +".");
					return;
				}
				else if(aux.elem.equals(p) && prev==null){
					first=aux.next;
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
	public int buscarTermino(String p) {
		int i=0;
		for(Termino aux=first; aux.next!=null; aux=aux.next){
			if(p.equals(aux.elem)){
				aux.variaciones.consultarLetra(' ');
				System.out.println("T�rmino " + p + " encontrado.");
				return i;
			}
			i++;
		}
		System.out.println("No se ha encontrado el t�rmino " + p + ".");
		return -1;
	}	
	/**
	 * M�todo para comprobar si la colecci�n est� vac�a.
	 * @return true si est� vac�a y false en caso contrario.
	 */
	public boolean isEmpty(){
		if(first.next==null){
			System.out.println("La lista est� vac�a.");
			return true;
		}
		else {
			return false;
		}
	}

}
