package com.payeshgaran.TaskAtm12.Transaction;

import com.payeshgaran.TaskAtm12.Account.Account;
import com.payeshgaran.TaskAtm12.Account.AccountModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface TransactionMapper {


    Transaction toEntity (TransactionModel transactionModel);
    TransactionModel toDTO (Transaction transaction);

    List<Transaction> toEntities (List <TransactionModel> transactionModels);
    List <TransactionModel> toDTOs (List <Transaction> transactions);



}
