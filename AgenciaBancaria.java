import java.util.ArrayList;

public class AgenciaBancaria {
    private int agencyNumber;
    private ArrayList<ContaBancaria> accounts;

    public AgenciaBancaria(int agencyNumber) {
        this.agencyNumber = agencyNumber;
        this.accounts = new ArrayList<>();
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void addAccount(ContaBancaria account) {
        accounts.add(account);
    }

    public ContaBancaria getAccount(int accountNumber) {
        for (ContaBancaria conta : accounts) {
            if (conta.getAccountNumber() == accountNumber) {
                return conta;
            }
        }
        return null;
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Não há contas cadastradas nesta agência.");
        } else {
            System.out.println("Contas cadastradas na agência " + agencyNumber + ":");
            for (ContaBancaria conta : accounts) {
                System.out.println("Conta número: " + conta.getAccountNumber() + 
                                   ", Titular: " + conta.getAccountHolderName() +
                                   ", Saldo: " + conta.getAccountBalance());
            }
        }
    }
}
