import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n--- MENU BANCO ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private void criarConta() {
        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        contas.add(new Conta(nome, numero));
        System.out.println("Conta criada com sucesso!");
    }

    private void acessarConta() {
        System.out.print("Informe o número da conta: ");
        int numero = scanner.nextInt();
        Conta conta = encontrarConta(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        int opcao;
        do {
            System.out.println("\n--- Conta " + numero + " ---");
            System.out.println("1. Ver dados");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.exibirDados();
                    break;
                case 2:
                    System.out.print("Valor para depósito: R$");
                    double valorDep = scanner.nextDouble();
                    conta.depositar(valorDep);
                    break;
                case 3:
                    System.out.print("Valor para saque: R$");
                    double valorSaq = scanner.nextDouble();
                    conta.sacar(valorSaq);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private Conta encontrarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}
