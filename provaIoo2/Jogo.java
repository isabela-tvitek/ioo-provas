public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogador3;
    private int rodada;
    private Jogador primeiroColocado;
    private Jogador segundoColocado;
    private Jogador terceiroColocado;
    private boolean rodadaCancelada = false;
    

    public Jogo(){
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
        jogador3 = new Jogador("Jogador 3");
        
        primeiroColocado = jogador1;
        segundoColocado = jogador2;
        terceiroColocado = jogador3;
    }

    public String getPrimeiroColocado() {
        return primeiroColocado.getNome();
    }

    public String getSegundoColocado() {
        return segundoColocado.getNome();
    }

    public String getTerceiroColocado() {
        return terceiroColocado.getNome();
    }

    public void setPrimeiroColocado(Jogador primeiroColocado) {
        this.primeiroColocado = primeiroColocado;
    }

    public void setSegundoColocado(Jogador segundoColocado) {
        this.segundoColocado = segundoColocado;
    }

    public void setTerceiroColocado(Jogador terceiroColocado) {
        this.terceiroColocado = terceiroColocado;
    }

    public void rodada(int numero1, int numero2, int numero3){
        
        if((numero1== numero2|| numero1 == numero3 || numero2 == numero3) || 
          ((numero1 < 1 || numero1 > 50) || (numero2 < 1 || numero2 > 50) 
          || (numero3 < 1 || numero3 > 50))){
            rodadaCancelada = true;
            return;
        }
        
        
        int rodada = 0;
        jogador1.setNumeroDaRodada(numero1);
        jogador2.setNumeroDaRodada(numero2);
        jogador3.setNumeroDaRodada(numero3);
        
        //incrementando pontuação vencedor rodada
        if(jogador2.getNumeroDaRodada() > jogador1.getNumeroDaRodada()
        && jogador3.getNumeroDaRodada() < jogador1.getNumeroDaRodada()){
            rodada++;
            jogador1.incrementarEscore(10);
        }
        if(jogador1.getNumeroDaRodada() > jogador2.getNumeroDaRodada()
        && jogador3.getNumeroDaRodada() < jogador2.getNumeroDaRodada()){
            rodada++;
            jogador2.incrementarEscore(10);
        }
        if(jogador1.getNumeroDaRodada() > jogador3.getNumeroDaRodada()
        && jogador2.getNumeroDaRodada() < jogador3.getNumeroDaRodada()){
            rodada++;
            jogador3.incrementarEscore(10);
        }

        //setando colocação
        if(jogador1.getEscore() > jogador2.getEscore() 
        && jogador1.getEscore() > jogador3.getEscore()){

            setPrimeiroColocado(jogador1);

            if(jogador2.getEscore() >= jogador3.getEscore()){
                setSegundoColocado(jogador2);
                setTerceiroColocado(jogador3);
            }else{       
                setSegundoColocado(jogador3);
                setTerceiroColocado(jogador2);
            }

        }
        if(jogador2.getEscore() > jogador1.getEscore() 
        && jogador2.getEscore() > jogador3.getEscore()){
            setPrimeiroColocado(jogador2);
            
            if(jogador1.getEscore() >= jogador3.getEscore()){
                setSegundoColocado(jogador1);
                setTerceiroColocado(jogador3);
            }else{       
                setSegundoColocado(jogador3);
                setTerceiroColocado(jogador1);
            }
        }
        if(jogador3.getEscore() > jogador2.getEscore() 
        && jogador3.getEscore() > jogador1.getEscore()){
            setPrimeiroColocado(jogador3);
            
            if(jogador1.getEscore() >= jogador2.getEscore()){
                setSegundoColocado(jogador1);
                setTerceiroColocado(jogador2);
            }else{       
                setSegundoColocado(jogador2);
                setTerceiroColocado(jogador1);
            }
        }
    }
    
    public boolean isRodadaCancelada(){
        return rodadaCancelada;
    }
    
    public void reiniciarJogo(){
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
        jogador3 = new Jogador("Jogador 3");
        
        primeiroColocado = jogador1;
        segundoColocado = jogador2;
        terceiroColocado = jogador3;
    }
    
    public String getClassificacao(){
        return "Jogador 1 - " + jogador1.getEscore() + " pontos\n" +
               "Jogador 2 - " + jogador2.getEscore() + " pontos\n" +
               "Jogador 3 - " + jogador3.getEscore() + " pontos";
    }
}
