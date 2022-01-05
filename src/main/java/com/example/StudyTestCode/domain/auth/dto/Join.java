package com.example.StudyTestCode.domain.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Join {
    private String name;
    private String email;
    private String password;
}
