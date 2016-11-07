package parte4;

/**
 * Implementaci�n del diccionario para que tenga una complejidad logar�tmica,
 * esto se conseguir� usando un �rbol binario de b�squeda.
 * 
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public interface IDiccionarioT {
	/**
	 * Inserta un t�rmino de forma alfab�tica ascendente en el diccionario.
	 * @param p t�rmino a insertar.
	 */
	public void insertarTermino(String p);
	/**
	 * Elimina el t�rmino pasado por par�metro, si existe en el diccionario.
	 * @param p t�rmino a eliminar.
	 */
	public void eliminarTermino(String p);
	/**
	 * Muestra el t�rmino y sus posibles variaciones.
	 * @param p t�rmino a buscar.
	 */
	public void buscarTermino(String p);
}

