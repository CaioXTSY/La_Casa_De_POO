public class ContaBancaria {
    private int accountNumber;
    private double accountBalance;
    private String accountHolderName;

    public ContaBancaria(int accountNumber, double accountBalance, String accountHolderName) {
        if (accountBalance < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");
        }
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Valor de depósito deve ser positivo.");
            return;
        }
        accountBalance += amount;
        System.out.println("Depósito realizado com sucesso. Saldo atual: " + accountBalance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Valor de saque deve ser positivo.");
            return;
        }
        if (amount > accountBalance) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        accountBalance -= amount;
        System.out.println("Saque realizado com sucesso. Saldo atual: " + accountBalance);
    }
}
