package calculadora;

public class Calculadora {
	

	
	/**
	 * Este método soma dois inteiros e retorna o resultado
	 * 
	 * @param a
	 * 	 Primeiro valor a ser adicionado
	 * @param b
	 * 	Segundo valor a ser adicionado
	 * @return O valor retornado é a soma dos dois números
	 */
	public int soma (int a, int b) {
		return a + b;
	}
	
	/**
	 * Este método subtrai dois inteiros e retorna o resultado
	 * 
	 * @param a
	 * 	 Primeiro valor a ser subtraído
	 * @param b
	 * 	Segundo valor a ser subtraído
	 * @return O valor retornado é a subtração dos dois números
	 */	
	public int subtracao(int a, int b) {
		return a - b;
	}
	
	/**
	 * Este método multiplica dois inteiros e retorna o resultado
	 * 
	 * @param a
	 * @param b
	 * @return 
	 */		
	public int multiplicacao(int a, int b) {
		return a * b;
	}
	
	/**
	 * Este método divide dois inteiros e retorna o resultado
	 * 
	 * @param a
	 * @param b
	 * @return 
	 * */	
	public int divisao(int a, int b) {
		return a / b;
	}	

	/**
	 * Este método retorna o somatório 0 até n
	 * 
	 * @param n	  		
	 * @return O retorno será o somatório de 0 até n
	 */
	public int somatoria(int n) {
		int somatorio = 0;
		while (n >= 0) {
			somatorio += n;
			n--;
		}
		return somatorio;
	}
	
	
	/**
	 * Este retorna se um inteiro n é positivo
	 * 
	 * @param n	 
	 * @return
	 */	
	public boolean ehPositivo(int n) {
		return n >= 0;
	}
	
	/**
	 * Esse método compara dois número a e b
	 * @param a
	 * @param b
	 * @return 0 se a==b, 1 se a>b, -1 se a < b
	 */
	public int compara(int a, int b) {
		int retorno = 0;
		if (a==b) {
			retorno = 0;			
		} else if (a > b) {
			retorno = 1;
		} else {
			retorno = -1;
		}
		return retorno;		
	}
	
	
}
