

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteJogador {

    private Jogador jogador;
    
    @BeforeEach
    public void antesDeCadaTeste() {
        jogador = new Jogador("Jogador 1");
    }
    
    @Test
    public void deveInstanciarInformandoONome() {
        assertEquals("Jogador 1", jogador.getNome());
    }
    
    @Test
    public void deveTerEscoreInicialZero() {
        assertEquals(0, jogador.getEscore());
    }
    
    @Test
    public void deveIncrementarOEscore() {
        jogador.incrementarEscore(10);
        jogador.incrementarEscore(5);
        
        assertEquals(15, jogador.getEscore());
    }
    
    @Test
    public void deveAtribuirONumeroDaRodada() {
        jogador.setNumeroDaRodada(20);
        
        assertEquals(20, jogador.getNumeroDaRodada());
    }
    
    @Test
    public void naoDeveAceitarValoresNegativosParaOIncrementoDoEscore() {
        jogador.incrementarEscore(-1);
        assertEquals(0, jogador.getEscore());
    }

    @Test
    public void naoDeveAlterarONomeCasoOArgumentoSejaVazio() {
        Jogador j = new Jogador("");
        
        assertEquals("", j.getNome());
    }
}

