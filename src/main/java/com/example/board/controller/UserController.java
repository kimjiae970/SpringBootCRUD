package com.example.board.controller;

import com.example.board.dto.RegisterDto;
import com.example.board.dto.ResponseDto;
import com.example.board.entity.Users;
import com.example.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public Users getMyInfo() {
        return userService.getMyInfo();
    }

    @GetMapping("/{username}")
    public Users getUserInfo(@PathVariable String username) {
        return userService.getUserInfo( username );
    }

}