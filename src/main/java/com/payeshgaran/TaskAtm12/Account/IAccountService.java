package com.payeshgaran.TaskAtm12.Account;

import com.payeshgaran.TaskAtm12.Transaction.Transaction;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {

    Account save(Account account);

    Account getByID(long accountId);

    long getBalance(long accountId);

    List<Account> getAll();

    List<Transaction> getTransActions();

    long finAccIdByAccNumber(String accNumber);


}
