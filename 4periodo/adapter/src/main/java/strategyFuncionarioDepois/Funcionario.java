package strategyFuncionarioDepois;

public abstract class Funcionario {
    //Agragação com o campo do tipo da estratégia para gerenciar salários
    protected ISalario salario;
    protected IFerias ferias;
    
    //atributos e métodos diversos relacionados aos funcionário
    public void calcularSalario(){
        salario.calcularSalario();
    }
    
    public void calcularFerias(){
        ferias.calcularFerias();
    }
}
