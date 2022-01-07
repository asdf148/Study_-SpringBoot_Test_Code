package com.example.StudyTestCode.domain.auth.dto;

import com.example.StudyTestCode.domain.auth.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AccountList {
    private List<Account> accounts;
}
