

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteJogo {
    
    private Jogo jogo;
    
    @BeforeEach
    public void antesDeCadaTeste() {
        jogo = new Jogo();
    }
    
    @Test
    public void deveTerJogadoresDevidaMenteNomeados() {

        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
    }

    @Test
    public void deveDeterminarAColocacaoComUmaRodada() {
        jogo.rodada(5, 10, 2);
        
        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
    }
    
    @Test
    public void deveDeterminarAColocacaoComNRodadas() {
        jogo.rodada(10, 5, 20);
        jogo.rodada(20, 1, 3);
        jogo.rodada(20, 50, 30);
        
        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());
    }
    
    @Test
    public void deveCancelarARodadaCasoDoisOuTresJogadoresEscolhamOMesmoNumero() {
        jogo.rodada(10, 0, 0);
        assertEquals(true, jogo.isRodadaCancelada());
    }
    
    @Test
    public void naoDeveAtribuirPontosCasoSejaFornecidoNumerosForaDoIntervalo() {
        jogo.rodada(10, -1, 51);
        assertEquals(true, jogo.isRodadaCancelada());
    }
    
    @Test
    public void deveSerPossivelReiniciarOJogo() {
        //recolocar comentário
        jogo.rodada(20, 2, 10);
        
        jogo.reiniciarJogo();
        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
        
    }
    
    @Test
    public void deveRetornarAClassifcaoComAPontucaoDeCadaJogador() {
        // Escreve um método, na classe Jogo, chamado getClassificacao, 
        // este não deve ter parâmetros e deve retornar a classificação no
        // formato no seguinte formato:
        // Jogador 1 - 10 pontos
        // Jogador 2 - 3 pontos
        // Jogador 3 - 5 pontos
        //**sendo que o participante que escrever o número do meio recebe 10 pontos.**
        jogo.rodada(5, 10, 2);
        
        assertEquals("Jogador 1 - 10 pontos\nJogador 2 - 0 pontos\nJogador 3 - 0 pontos", jogo.getClassificacao());
        
        
    }
    
}

