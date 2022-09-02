package com.payeshgaran.TaskAtm12.config;

import com.payeshgaran.TaskAtm12.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final AccountService accountService;

    @Autowired
    public SecurityConfiguration(AccountService accountService) {
        this.accountService = accountService;
    }


    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/hi").permitAll()
//                .antMatchers("/**").authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().permitAll();
//
//
//    }
    //TODO delete comment and check login page


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/h2-console")
                .permitAll()

                // ROLE_ prefix will be added by spring security
                // You can do this with preAuthorize on methods. see MainController
                .antMatchers("/only-user")
                .hasAnyRole("USER")

                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll();
        http.csrf().disable(); // for h2 console
        http.headers().frameOptions().disable(); // for h2 console


    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


}
