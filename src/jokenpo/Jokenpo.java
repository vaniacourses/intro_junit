  package jokenpo;

public class Jokenpo {
    /**
     * Esse método calcula o vencedor do jogo Jokenpo (pedra, papel e tesoura)
     * As escolhas podem ser 1 (papel), 2 (pedra) e 3 (tesoura)
     * @param jogador1
     * 		Escolha do jogador 1 
     * @param jogador2
     * 		Escolha do jogador 2
     * @return 0 se houve empate, 1 se jogador 1 venceu, 2 se jogador 2 venceu, 
     * 		-1 se opção é inválida
     */
    public int jogar (int jogador1, int jogador2) {   	
    	
    	int retorno = 0;
    	if ((jogador1 >= 0 ) && (jogador1 <=3) && (jogador2 > 0 ) && (jogador2 <=3)) {   	
        	if (jogador1 != jogador2) {
            	if ((jogador1 - jogador2) == -1 || (jogador1 - jogador2 == 2)) 
            		retorno = 1;
            	else 
            		retorno = 2;        		
        	}
    	}
    	else 
    		retorno = -1;
    	return retorno;
    }  
}



