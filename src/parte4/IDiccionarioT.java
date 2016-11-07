package parte4;

/**
 * Implementación del diccionario para que tenga una complejidad logarítmica,
 * esto se conseguirá usando un árbol binario de búsqueda.
 * 
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public interface IDiccionarioT {
	/**
	 * Inserta un término de forma alfabética ascendente en el diccionario.
	 * @param p término a insertar.
	 */
	public void insertarTermino(String p);
	/**
	 * Elimina el término pasado por parámetro, si existe en el diccionario.
	 * @param p término a eliminar.
	 */
	public void eliminarTermino(String p);
	/**
	 * Muestra el término y sus posibles variaciones.
	 * @param p término a buscar.
	 */
	public void buscarTermino(String p);
}

