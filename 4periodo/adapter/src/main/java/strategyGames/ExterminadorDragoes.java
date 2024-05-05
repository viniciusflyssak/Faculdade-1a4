package strategyGames;

public class ExterminadorDragoes {
    //Agragação, um atributo genérico referente a estratégia criada
    private IAcaoDeExterminio acao;
    
    public ExterminadorDragoes(IAcaoDeExterminio acao){
        this.acao = acao;
    };
    
    public void mudaEstrategia(IAcaoDeExterminio acao){
        this.acao = acao;
        acao.executar();
    };
    
    public void iniciarBatalha(){
        acao.executar();
    }
}
