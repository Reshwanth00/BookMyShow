package com.example.Book_my_show_backend.Controllers;


import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto){

        return userService.createUser(userRequestDto);

    }
    @GetMapping("/user-by-name")
    public UserEntity getUser(@RequestParam String name){
        return userService.getName(name);
    }
    public List<String> allUsers(){
        return userService.allUsers();
    }

}
