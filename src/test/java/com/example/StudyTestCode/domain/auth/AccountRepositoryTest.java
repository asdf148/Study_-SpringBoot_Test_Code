package com.example.StudyTestCode.domain.auth;

import com.example.StudyTestCode.domain.auth.entity.Account;
import com.example.StudyTestCode.domain.auth.entity.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest // @DataJpaTest 포함되어 있다는 것 같은데 적용 안됨
@DataJpaTest // 이걸 써야 save를 해도 저장이 안되는데 error 남
public class AccountRepositoryTest {
    @Mock
    private AccountRepository accountRepository;

    @Spy
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("계정 디테일")
    void accountDetail(){
        Account account = accountRepository.findById(1L).orElseThrow();

        assertThat(account.getName()).isEqualTo("test");
        assertThat(account.getEmail()).isEqualTo("asdf@asdf.com");
    }

    @Test
    @DisplayName("계정 목록")
    void accountList(){
        List<Account> accounts = new ArrayList<Account>();

        List<Account> mockAccounts = accountRepository.findAll();

        assertInstanceOf(accounts.getClass(), mockAccounts);
    }

    @Test
    @DisplayName("계정 생성 테스트")
    void joinAccount(){
        Account account = Account.builder()
                .name("xptmxm")
                .email("test@test.com")
                .password(passwordEncoder.encode("asdfqw12@"))
                .build();

        Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount.getName()).isEqualTo("xptmxm");
        assertThat(savedAccount.getEmail()).isEqualTo("test@test.com");
        assertThat(savedAccount.getPassword()).isEqualTo(passwordEncoder.encode("asdfqw12@"));
    }
}
