package com.payeshgaran.TaskAtm12;

import com.payeshgaran.TaskAtm12.Account.Account;
import com.payeshgaran.TaskAtm12.Account.AccountService;
import com.payeshgaran.TaskAtm12.Account.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MainApplication {

    private final PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }


    @Bean
    CommandLineRunner run(AccountService accountService) {
        return args -> {
            var account1 = new Account();
            account1.setBalance(5000000);
            account1.setAccNumber("1111");
            account1.setPassword(encoder.encode("2222"));
            account1.setRoles(List.of(RoleEnum.ROLE_USER));

            var account2 = new Account();
            account2.setBalance(5000000);
            account2.setAccNumber("123");
            account2.setPassword(encoder.encode("23"));
            account2.setRoles(List.of(RoleEnum.ROLE_ADMIN));

            accountService.save(account1);
            accountService.save(account2);


        };
    }


}
