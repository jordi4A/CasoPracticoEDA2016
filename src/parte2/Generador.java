package parte2;
import parte1.ListaPalabras;
/**
 * Generador de variaciones para t�rminos de nuestro diccionario.
 * @author Jordi Castell�
 * @author Xueyu Ji
 *
 */
public class Generador {
	/**
	 * M�todo que genera todas las variaciones posibles pedidas en el apartado 2.
	 * @param termino palabra base de la que queremos generar la lista.
	 * @return lista con las variaciones generadas.
	 */
	public static ListaPalabras generar(String termino){
		ListaPalabras variaciones=new ListaPalabras();
		String palabra="";
		for(char i='a'; i<='z'; i++){
			for(int j=0; j<termino.length(); j++){	// En este bucle a�adiremos car�cteres y tambi�n los substituiremos.
				palabra=termino.substring(0,j) + i + termino.substring(j+1);	// Substituir car�cter.
				if(!palabra.equals(termino))	// Evita introducir el t�rmino base.
					variaciones.insertarPalabra(palabra);
				palabra=termino.substring(0,j) + i + termino.substring(j);		// A�adir car�cter.
				if(!palabra.equals(termino))
					variaciones.insertarPalabra(palabra);

			}
			palabra=termino+i;
			variaciones.insertarPalabra(palabra);	// T�rmino con el �ltimo car�cter a�adido, necesario para no tener errores con substring.
		}
		if(termino.length() > 1){
			for(int i=0, posElim=0; i<termino.length(); i++){	// Bucle para eliminar caracter.
				if(i>0)posElim=i-1; // Evita n�meros negativos, para no tener errores en substring.
				palabra=termino.substring(0,posElim)+termino.substring(i);	// Se "come" un car�cter al concatenar.
				if(!palabra.equals(termino))
					variaciones.insertarPalabra(palabra);	
			}
			palabra=termino.substring(0,termino.length()-1);	// Al salir del bucle elimina el �ltimo caracter, la variaci�n que falta.
			variaciones.insertarPalabra(palabra);
		}
		return variaciones;
	}
	/*** DECISI�N ***
	 * Hemos decidido que el m�todo para generar las variaciones sea est�tico, ya que
	 * esta clase solo se va a usar para generar las variaciones y as� no necesitamos 
	 * crear un objeto para realizar este proceso.
	 */
}
