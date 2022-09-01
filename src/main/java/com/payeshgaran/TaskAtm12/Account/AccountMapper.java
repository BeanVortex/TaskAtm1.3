package com.payeshgaran.TaskAtm12.Account;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface AccountMapper {

    Account toEntity (AccountModel accountDto);
    AccountModel toDTO (Account account);

    List <Account> toEntities (List <AccountModel> accountDtos);
    List <AccountModel> toDTOs (List <Account> accounts);



}
