package com.payeshgaran.TaskAtm12.Account;

import com.payeshgaran.TaskAtm12.Transaction.Transaction;
import java.util.List;

public interface IAccountService {

    Account save  (Account account);
    Account getByID (long accountId);
    boolean checkLoginPasswordByAccountId(long accountId , long inputPassword);
    boolean checkLoginPasswordByAccNumber(long accountId , long inputPassword);
    long getBalance (long accountId);
    List<Account> getAll();
    List<Transaction> getTransActions ();
    long finAccIdByAccNumber( long accNumber);


}
