package com.example.Book_my_show_backend.Service;


import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto){

        //Converted the userRequestDto to UserEntity
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();

        try{
            userRepository.save(userEntity);

        }catch(Exception e){
            return "user couldnt be added";
        }
        return "User added sucessfully";
    }
    public List<String> allUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<String> userNames = new ArrayList<>();
        for(UserEntity user:userEntities){
            userNames.add(user.getName());
        }
        return userNames;
    }

    public UserEntity getName(String name) {
        return userRepository.findByUserName(name);
    }
}
