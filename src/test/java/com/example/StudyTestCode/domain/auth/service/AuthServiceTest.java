package com.example.StudyTestCode.domain.auth.service;

import com.example.StudyTestCode.domain.auth.dto.AccountList;
import com.example.StudyTestCode.domain.auth.dto.Join;
import com.example.StudyTestCode.domain.auth.dto.RequestResult;
import com.example.StudyTestCode.domain.auth.entity.Account;
import com.example.StudyTestCode.domain.auth.entity.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AuthService authService;

    @Spy
    private PasswordEncoder passwordEncoder;

//    @Before
//    public void setUp() {
//        Account account = Account.builder()
//            .name("asdf")
//            .email("asdf@asdf.com")
//            .password("asdfqwer12@")
//            .build();
//
//        when(accountRepository.findAll()).thenReturn(Optional.of(ArrayList<>()));
//    }

    @Test
    @DisplayName("계정 목록 가져오기")
    void accounts() {
        AccountList accounts = authService.accounts();

        List<Account> mockAccounts = accountRepository.findAll();
        assertThat(accounts.getAccounts()).isEqualTo(mockAccounts);
    }

    @Test
    void join() {
        Join join = Join.builder()
                .name("dkssud")
                .email("asdf@qwer.com")
                .password("asdfqw12")
                .build();

        String result = authService.join(join);

        assertThat(result).isEqualTo("Joined");
    }
}
