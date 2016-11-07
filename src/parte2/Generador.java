package parte2;
import parte1.ListaPalabras;
/**
 * Generador de variaciones para términos de nuestro diccionario.
 * @author Jordi Castelló
 * @author Xueyu Ji
 *
 */
public class Generador {
	/**
	 * Método que genera todas las variaciones posibles pedidas en el apartado 2.
	 * @param termino palabra base de la que queremos generar la lista.
	 * @return lista con las variaciones generadas.
	 */
	public static ListaPalabras generar(String termino){
		ListaPalabras variaciones=new ListaPalabras();
		String palabra="";
		for(char i='a'; i<='z'; i++){
			for(int j=0; j<termino.length(); j++){	// En este bucle añadiremos carácteres y también los substituiremos.
				palabra=termino.substring(0,j) + i + termino.substring(j+1);	// Substituir carácter.
				if(!palabra.equals(termino))	// Evita introducir el término base.
					variaciones.insertarPalabra(palabra);
				palabra=termino.substring(0,j) + i + termino.substring(j);		// Añadir carácter.
				if(!palabra.equals(termino))
					variaciones.insertarPalabra(palabra);

			}
			palabra=termino+i;
			variaciones.insertarPalabra(palabra);	// Término con el último carácter añadido, necesario para no tener errores con substring.
		}
		if(termino.length() > 1){
			for(int i=0, posElim=0; i<termino.length(); i++){	// Bucle para eliminar caracter.
				if(i>0)posElim=i-1; // Evita números negativos, para no tener errores en substring.
				palabra=termino.substring(0,posElim)+termino.substring(i);	// Se "come" un carácter al concatenar.
				if(!palabra.equals(termino))
					variaciones.insertarPalabra(palabra);	
			}
			palabra=termino.substring(0,termino.length()-1);	// Al salir del bucle elimina el último caracter, la variación que falta.
			variaciones.insertarPalabra(palabra);
		}
		return variaciones;
	}
	/*** DECISIÓN ***
	 * Hemos decidido que el método para generar las variaciones sea estático, ya que
	 * esta clase solo se va a usar para generar las variaciones y así no necesitamos 
	 * crear un objeto para realizar este proceso.
	 */
}
