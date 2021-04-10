public class Jogador {

    private String nome;
    private int numero;
    private int pontos;

    public Jogador(String nome) {
        this.pontos=0;
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }
    
    private void setNome(String nome) {
        
        if(nome != "" || nome != null){
            this.nome = nome;
        }
        else{
            nome = "";
        }
    }

    public int getNumeroDaRodada() {
        return numero;
    }

    public void setNumeroDaRodada(int numero) {
        this.numero = numero;
    }

    public int getEscore() {
        return pontos;
    }

    public void incrementarEscore(int pontos){
        if(pontos >= 0){
            this.pontos += pontos;
        }
    }

}
