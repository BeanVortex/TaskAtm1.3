package com.payeshgaran.TaskAtm12.Account;

import com.payeshgaran.TaskAtm12.Transaction.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // to add objects without initialization: private final AccountRepository accountRepository;
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getByID(long accountId) {
        Optional <Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isEmpty()){
            throw new RuntimeException("Not Found");
        }
        return optionalAccount.get();
    }


    @Override
    public boolean checkLoginPasswordByAccountId(long accountId , long inputPassword) {
        if ( getByID(accountId).getPassword().equals(inputPassword) ) return true;
        else return false;
    }

    @Override
    public boolean checkLoginPasswordByAccNumber(long accNumber, long inputPassword) {
        if ( getByID(finAccIdByAccNumber(accNumber)).getPassword().equals(inputPassword)  ) return true;
        else return false;
    }

    @Override
    public long getBalance(long accountId) {
        return getByID(accountId).getBalance();
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Transaction> getTransActions() {
        return null;//TODO Complete this methode
    }

    @Override
    public long finAccIdByAccNumber( long accNumber){

        List <Account> accounts = getAll();

        long acountId = 0;

        accounts = getAll();
        for (Account item: accounts){
            if (item.getAccNumber()==accNumber){
                acountId= item.getId();
            }

        }

        return acountId;


    }

    //TODO Update methode
}
