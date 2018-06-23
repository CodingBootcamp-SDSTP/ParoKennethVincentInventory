package src;
import java.util.ArrayList;

public class AccountCollection
{
	ArrayList<Account> accounts;

	public AccountCollection() {
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	public ArrayList<Account> getAllAccounts() {
		return(accounts);
	}

	public Account getAccountByIndex(int n) {
		return(accounts.get(n));
	}

	public int getAccountCount() {
		return(accounts.size());
	}
}
