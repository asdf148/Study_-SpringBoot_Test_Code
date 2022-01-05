package com.example.StudyTestCode.domain.auth.controller;

import com.example.StudyTestCode.domain.auth.dto.Join;
import com.example.StudyTestCode.domain.auth.dto.Login;
import com.example.StudyTestCode.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<String> join( @RequestBody Join join){
        try{
            return new ResponseEntity<>(authService.join(join), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/join")
//    public ResponseEntity<String> login( @RequestBody Login login){
//        try{
//            return new ResponseEntity<>(authService.login(login), HttpStatus.CREATED);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
}
