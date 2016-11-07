package parte1;
/**
 * Interfaz para implementar la clase listaPalabras.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public interface IListaPalabras {
	/**
	 * Recibe un objeto de tipo String y a�ade dicho objeto a la colecci�n.
	 * La palabra se almacenada en orden alfab�tico ascendente (de la 'a' a la 'z').
	 * Si la palabra ya existe, no se inserta y el m�todo muestra un mensaje informando 
	 * que ya existe en la colecci�n.
	 * @param p Objeto a a�adir a la colecci�n.
	 */
	public void insertarPalabra(String p);
	/**
	 * Recibe un objeto de tipo String y elimina dicha palabra de la colecci�n.
	 * @param p	palabra que queremos eliminar de la lista.
	 */
	public void eliminarPalabra(String p);
	/**
	 * Recibe un objeto de tipo String y comprueba si es una palabra de la colecci�n.
	 * Si existe devuelve su posici�n dentro de la colecci�n, si no existe devuelve -1.
	 * @param p palabra a buscar en la colecci�n.
	 * @return posici�n del objeto en la colecci�n.
	 */
	public int buscarPalabra(String p);
	/**
	 * Recibe un car�cter y busca en la lista todas las palabras que empiecen por esa
	 * letra, mostr�ndolas por pantalla. Si el car�cter pasado es ' ', entonces devuelve
	 * todas las palabras almacenadas en la colecci�n.
	 * @param c referencia de primera letra de las palabras a buscar.
	 */
	public void consultarLetra(char c);
}
