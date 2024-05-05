package gerenciador_estoque;

import gerenciador_estoque.model.Produto;
import gerenciador_estoque.singleton.Estoque;
import gerenciador_estoque.observer.ConcreteSubjectEstoque;
import gerenciador_estoque.observer.ConcreteObserverEstoque;
import java.util.Scanner;

public class Main {

    private static ConcreteObserverEstoque estoqueObserver;
    private static ConcreteSubjectEstoque estoqueSubject;

    public static void main(String[] args) {

        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        estoqueObserver = new ConcreteObserverEstoque();

        while (opcao != 0) {
            System.out.println("Bem vindo ao EstoqueMaster 2000!");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Cadastrar produto ");
            if (Estoque.getInstancia().qtdeProdutos() > 0) {
                System.out.println("2 - Listar produtos ");
                System.out.println("3 - Alterar quantidade de um produto ");
                System.out.println("4 - Alterar um produto ");
                System.out.println("5 - Salvar dados ");
                System.out.println("6 - Restaurar últimos dados salvos ");
            }
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 ->
                    cadastrarProduto();
                case 2 ->
                    Estoque.getInstancia().listarProdutos();
                case 3 ->
                    atualizarQuantidadeProduto();
                case 4 ->
                    atualizarProduto();
                case 5 ->
                    Estoque.getInstancia().salvarDados();
                case 6 -> 
                    Estoque.getInstancia().voltarAnterior();
            }
        }

    }

    private static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto();
        produto.setQuantidadeAntiga(0);

        estoqueSubject = new ConcreteSubjectEstoque(produto);
        estoqueSubject.registraObserver(estoqueObserver);

        System.out.println("Digite o nome: ");
        produto.setNome(scanner.nextLine());

        System.out.println("Digite a quantidade: ");
        produto.setQuantidade(scanner.nextInt());
        scanner.nextLine();

        produto.setId(Estoque.getInstancia().qtdeProdutos() + 1);
        Estoque.getInstancia().addProduto(produto);
        estoqueSubject.setProduto(produto);
    }

    private static void atualizarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto desejado:");
        Produto produto = Estoque.getInstancia().obterProduto(scanner.nextInt());
        scanner.nextLine();

        estoqueSubject = new ConcreteSubjectEstoque(produto);
        estoqueSubject.registraObserver(estoqueObserver);

        System.out.println("Digite o nome: ");
        produto.setNome(scanner.nextLine());

        System.out.println("Digite a quantidade: ");
        produto.setQuantidade(scanner.nextInt());
        scanner.nextLine();

        Estoque.getInstancia().atualizaProduto(produto);
        estoqueSubject.setProduto(produto);
    }

    private static void atualizarQuantidadeProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto desejado:");
        Produto produto = Estoque.getInstancia().obterProduto(scanner.nextInt());
        scanner.nextLine();

        estoqueSubject = new ConcreteSubjectEstoque(produto);
        estoqueSubject.registraObserver(estoqueObserver);

        System.out.println("Digite a quantidade: ");
        produto.setQuantidade(scanner.nextInt());
        scanner.nextLine();

        Estoque.getInstancia().atualizaProduto(produto);
        estoqueSubject.setProduto(produto);
    }
    

}
