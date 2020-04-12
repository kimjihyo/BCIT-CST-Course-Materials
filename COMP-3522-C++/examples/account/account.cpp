#include <iostream>

class Account
{ public: virtual ~Account() { } };

class BankAccount : public virtual Account
{ public: virtual ~BankAccount() { } };

class OnlineAccount : public virtual Account
{ public: virtual ~OnlineAccount() { } };

class ChequingAccount : public BankAccount, public OnlineAccount
{ public: virtual ~ChequingAccount() { } };

class SavingsAccount : public BankAccount, public OnlineAccount 
{public: virtual ~SavingsAccount() { } };

int main()
{
	Account a;
	BankAccount b;
	OnlineAccount o;
	ChequingAccount c;
	SavingsAccount s;

	Account * account_pointer = dynamic_cast<Account *>(&c); // Pointer upcast
	account_pointer = dynamic_cast<Account *>(&b); // Pointer upcast
	account_pointer = dynamic_cast<Account *>(&o); // Pointer upcast
	account_pointer = &c; // will &a work?

	try
	{
		OnlineAccount * oa = dynamic_cast<OnlineAccount *>(&s); // Pointer upcast
		SavingsAccount * sa = dynamic_cast<SavingsAccount *>(oa);  // Pointer downcast

		BankAccount * ba = dynamic_cast<BankAccount *>(&c); // Pointer upcast
		oa = dynamic_cast<OnlineAccount *>(ba); // Pointer cross cast!

	}
		catch ( const std::exception& e )
	{
		std::cerr << e.what();
	}


	return 0;
}