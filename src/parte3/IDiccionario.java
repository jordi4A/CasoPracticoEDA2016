package parte3;
/**
 * Interfaz para implementaar el Diccionario.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public interface IDiccionario {
	/**
	 * Recibe un objeto de tipo String y almacena el término en la colección. 
	 * Añade además todas sus variaciones aplicando el método de la parte 2.
	 * @param p término para añadir a la colección.
	 */
	public void insertarTermino(String p);
	/**
	 * Recibe un objeto de tipo String y elimina dicho término de  la  colección. 
	 * El borrado de un término implica también el borrado de sus variaciones.
	 * @param p término a eliminar.
	 */	
	public void eliminarTermino(String p);
	/**
	 * Recibe un objeto de tipo String y busca el término en la colección mostrando 
	 * sus posibles variaciones. Devuelve la posición del término en el diccionario. 
	 * Si no existe el término devuelve -1.
	 * @param p término a buscar.
	 * @return posición númerica en la lista.
	 */
	public int buscarTermino(String p);
}
