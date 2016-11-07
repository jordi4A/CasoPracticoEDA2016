package parte3;
/**
 * Interfaz para implementaar el Diccionario.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public interface IDiccionario {
	/**
	 * Recibe un objeto de tipo String y almacena el t�rmino en la colecci�n. 
	 * A�ade adem�s todas sus variaciones aplicando el m�todo de la parte 2.
	 * @param p t�rmino para a�adir a la colecci�n.
	 */
	public void insertarTermino(String p);
	/**
	 * Recibe un objeto de tipo String y elimina dicho t�rmino de  la  colecci�n. 
	 * El borrado de un t�rmino implica tambi�n el borrado de sus variaciones.
	 * @param p t�rmino a eliminar.
	 */	
	public void eliminarTermino(String p);
	/**
	 * Recibe un objeto de tipo String y busca el t�rmino en la colecci�n mostrando 
	 * sus posibles variaciones. Devuelve la posici�n del t�rmino en el diccionario. 
	 * Si no existe el t�rmino devuelve -1.
	 * @param p t�rmino a buscar.
	 * @return posici�n n�merica en la lista.
	 */
	public int buscarTermino(String p);
}
