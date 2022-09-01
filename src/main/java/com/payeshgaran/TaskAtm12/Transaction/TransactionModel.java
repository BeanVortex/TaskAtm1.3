package com.payeshgaran.TaskAtm12.Transaction;


import lombok.Data;
import java.util.Date;

@Data
public class TransactionModel {


    private boolean type;


    private long fromAccount;


    private long toAccount;


    private long Volume;


    private Date created_at;

}
