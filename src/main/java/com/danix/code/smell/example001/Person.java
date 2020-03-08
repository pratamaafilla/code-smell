package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class Person extends Customer {
    protected String surname;

    Person(final String name, final String surname, final String email, final Account account) {
        super(name, email, account);
        this.surname = surname;
    }

    @Override       
    boolean premiumChecker = account.getType().isPremium();
    public void withdraw(final Money money) {
    	
		if (premiumChecker) {
            overDraftChecker(money);
        } else {
        	overDraftChecker(money);
        }
		
    }

	private void overDraftChecker(final Money money) {
		if (account.isOverdraft()) {
		    substractOverdraft(money);
		} else {
		    substractNonOverdraft(money);
		}
	}


	private void substractOverdraft(final Money money) {
		account.substract(Money.newInstance(money.getAmount() + money.getAmount() * account.overdraftFee(),
		        money.getCurrency()));
	}
	
	private void substractNonOverdraft(final Money money) {
		account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
	}
	
	
    @Override
    protected String getFullName() {
        return name + " " + surname + " ";
    }
}
