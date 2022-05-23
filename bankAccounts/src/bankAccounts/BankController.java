package bankAccounts;

public class BankController {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		System.out.println("New Acc No. - " + ba.getAccountNumber());
		ba.depositMoney(100.49, "checking");
		ba.depositMoney(3.00, "savings");
		ba.displayAccountBalance();

		System.out.println(BankAccount.totalHoldings);

		ba.withdrawMoney(50, "checking");
		ba.withdrawMoney(50, "savings");
		ba.displayAccountBalance();

		System.out.println(BankAccount.totalHoldings);

		BankAccount ba2 = new BankAccount();
		System.out.println("New Acc No. - " + ba2.getAccountNumber());
		ba2.depositMoney(3, "checking");
		ba2.depositMoney(99, "savings");
		ba2.displayAccountBalance();
		ba2.withdrawMoney(50, "checking");

	}

}
