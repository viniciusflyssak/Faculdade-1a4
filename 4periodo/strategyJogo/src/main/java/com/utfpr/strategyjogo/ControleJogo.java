package com.utfpr.strategyjogo;

public class ControleJogo {
    private IInteracao interacao;
    
    public ControleJogo(){
    };
    
    public void mudaControle(IInteracao interacao){
        this.interacao = interacao;
        this.interacao.mover();
    };
}
