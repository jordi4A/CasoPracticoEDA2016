package parte1;
/**
 * Interfaz para implementar la clase listaPalabras.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public interface IListaPalabras {
	/**
	 * Recibe un objeto de tipo String y añade dicho objeto a la colección.
	 * La palabra se almacenada en orden alfabético ascendente (de la 'a' a la 'z').
	 * Si la palabra ya existe, no se inserta y el método muestra un mensaje informando 
	 * que ya existe en la colección.
	 * @param p Objeto a añadir a la colección.
	 */
	public void insertarPalabra(String p);
	/**
	 * Recibe un objeto de tipo String y elimina dicha palabra de la colección.
	 * @param p	palabra que queremos eliminar de la lista.
	 */
	public void eliminarPalabra(String p);
	/**
	 * Recibe un objeto de tipo String y comprueba si es una palabra de la colección.
	 * Si existe devuelve su posición dentro de la colección, si no existe devuelve -1.
	 * @param p palabra a buscar en la colección.
	 * @return posición del objeto en la colección.
	 */
	public int buscarPalabra(String p);
	/**
	 * Recibe un carácter y busca en la lista todas las palabras que empiecen por esa
	 * letra, mostrándolas por pantalla. Si el carácter pasado es ' ', entonces devuelve
	 * todas las palabras almacenadas en la colección.
	 * @param c referencia de primera letra de las palabras a buscar.
	 */
	public void consultarLetra(char c);
}
