import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<AgenciaBancaria> agencias = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean controle = true;

        while (controle) {
            System.out.println("\n" + 
                               "========================\n" +
                               "       Menu Principal       \n" +
                               "========================");
            System.out.println("1 - Criar agência");
            System.out.println("2 - Listar agências");
            System.out.println("3 - Criar conta");
            System.out.println("4 - Listar contas de uma agência");
            System.out.println("5 - Acessar conta");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                int opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o número da nova agência: ");
                        int numeroAgencia = input.nextInt();
                        AgenciaBancaria novaAgencia = new AgenciaBancaria(numeroAgencia);
                        agencias.add(novaAgencia);
                        System.out.println("Agência criada com sucesso!");
                        break;
                    case 2:
                        if (agencias.isEmpty()) {
                            System.out.println("Não há agências cadastradas.");
                        } else {
                            System.out.println("Agências cadastradas:");
                            for (AgenciaBancaria agencia : agencias) {
                                System.out.println("Agência número: " + agencia.getAgencyNumber());
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Digite o número da agência onde deseja criar a conta: ");
                        int numAgencia = input.nextInt();
                        AgenciaBancaria agenciaSelecionada = null;
                        for (AgenciaBancaria ag : agencias) {
                            if (ag.getAgencyNumber() == numAgencia) {
                                agenciaSelecionada = ag;
                                break;
                            }
                        }
                        if (agenciaSelecionada == null) {
                            System.out.println("Agência não encontrada.");
                        } else {
                            System.out.print("Digite o número da nova conta: ");
                            int numConta = input.nextInt();
                            System.out.print("Digite o saldo inicial da conta: ");
                            double saldoInicial = input.nextDouble();
                            input.nextLine();  // Consume newline
                            System.out.print("Digite o nome do titular da conta: ");
                            String titular = input.nextLine();
                            ContaBancaria novaConta = new ContaBancaria(numConta, saldoInicial, titular);
                            agenciaSelecionada.addAccount(novaConta);
                            System.out.println("Conta criada com sucesso!");
                        }
                        break;
                    case 4:
                        System.out.print("Digite o número da agência para listar suas contas: ");
                        int agenciaNumero = input.nextInt();
                        AgenciaBancaria agencia = null;
                        for (AgenciaBancaria a : agencias) {
                            if (a.getAgencyNumber() == agenciaNumero) {
                                agencia = a;
                                break;
                            }
                        }
                        if (agencia == null) {
                            System.out.println("Agência não encontrada");
                        } else {
                            agencia.listAccounts();
                        }
                        break;
                    case 5:
                        System.out.print("Digite o número da agência da conta que deseja acessar: ");
                        int agNum = input.nextInt();
                        System.out.print("Digite o número da conta que deseja acessar: ");
                        int accNum = input.nextInt();
                        AgenciaBancaria selectedAgency = null;
                        for (AgenciaBancaria ag : agencias) {
                            if (ag.getAgencyNumber() == agNum) {
                                selectedAgency = ag;
                                break;
                            }
                        }
                        if (selectedAgency == null) {
                            System.out.println("Agência não encontrada.");
                        } else {
                            ContaBancaria conta = selectedAgency.getAccount(accNum);
                            if (conta == null) {
                                System.out.println("Conta não encontrada.");
                            } else {
                                // Aqui você pode adicionar funcionalidades para acessar a conta, como depositar, sacar, etc.
                                System.out.println("Conta acessada com sucesso!");
                            }
                        }
                        break;
                    case 6:
                        controle = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                input.next();
            }
        }
        input.close();
    }
}
