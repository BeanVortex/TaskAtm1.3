package com.payeshgaran.TaskAtm12.Account;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private long accNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private long balance;


}

//TODO add toString and others