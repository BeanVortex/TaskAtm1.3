package com.payeshgaran.TaskAtm12.Transaction;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private boolean type;

    @Column(nullable = false)
    private long fromAccount;

    @Column(nullable = false)
    private long toAccount;

    @Column(nullable = false)
    private long Volume;

    @Column
    @CreationTimestamp
    private Date created_at;

}
