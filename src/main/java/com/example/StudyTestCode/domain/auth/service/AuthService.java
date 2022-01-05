package com.example.StudyTestCode.domain.auth.service;

import com.example.StudyTestCode.domain.auth.dto.Join;
import com.example.StudyTestCode.domain.auth.dto.Login;
import com.example.StudyTestCode.domain.auth.entity.Account;
import com.example.StudyTestCode.domain.auth.entity.AccountRepository;
import com.example.StudyTestCode.domain.auth.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String join(Join join) {
        Account user = Account.builder()
                .name(join.getName())
                .email(join.getEmail())
                .password(passwordEncoder.encode(join.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return "Joined";
    }

    public String login(Login login) throws Exception {
        Account user = Account.builder()
                .email(login.getEmail())
                .password(passwordEncoder.encode(login.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return "Joined";
    }
}
