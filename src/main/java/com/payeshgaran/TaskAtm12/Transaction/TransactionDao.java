package com.payeshgaran.TaskAtm12.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository <Transaction, Long> {
}
