package com.example.StudyTestCode.domain.auth.controller;

import com.example.StudyTestCode.domain.auth.dto.AccountList;
import com.example.StudyTestCode.domain.auth.dto.Join;
import com.example.StudyTestCode.domain.auth.dto.Login;
import com.example.StudyTestCode.domain.auth.dto.RequestResult;
import com.example.StudyTestCode.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/")
    public ResponseEntity<RequestResult> accounts(){
        try{
            return new ResponseEntity<>(new RequestResult(authService.accounts()), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new RequestResult(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/join")
    public ResponseEntity<RequestResult> join( @RequestBody Join join){
        try{
            return new ResponseEntity<>(new RequestResult(authService.join(join)), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new RequestResult(e.getMessage()), HttpStatus.BAD_REQUEST);
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
