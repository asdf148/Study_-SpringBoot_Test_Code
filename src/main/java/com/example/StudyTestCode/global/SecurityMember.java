package com.example.StudyTestCode.global;


import com.example.StudyTestCode.domain.auth.entity.Account;
import com.example.StudyTestCode.domain.auth.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SecurityMember extends User {
    private static final String ROLE_PREFIX = "ROLE_";
    private static final long serialVersionUID = 1L;

    public SecurityMember(Account account) {
        super(account.getName(), account.getPassword(), makeGrantedAuthority(account.getRole()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(Role role){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getValue()));
        return list;
    }
}