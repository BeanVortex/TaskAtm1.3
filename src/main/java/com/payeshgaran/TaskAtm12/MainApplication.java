package com.payeshgaran.TaskAtm12;

import com.payeshgaran.TaskAtm12.Account.Account;
import com.payeshgaran.TaskAtm12.Account.AccountService;
import com.payeshgaran.TaskAtm12.Account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

//    @Autowired
//    IAccountService iAccountService;


    public static void main(String[] args) {


        SpringApplication.run(MainApplication.class);


    }


//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//
//        Account account = new Account();
//        account.setBalance(5000000);
//        account.setAccNumber(1111);
//        account.setPassword("2222");
//
//        iAccountService.save(account);
//
//
//
//
//    }


    @Bean
    CommandLineRunner run(AccountService accountService) {
        return args -> {
            Account account = new Account();
            account.setBalance(5000000);
            account.setAccNumber(1111);
            account.setPassword("2222");

            accountService.save(account);


        };
    }


}
