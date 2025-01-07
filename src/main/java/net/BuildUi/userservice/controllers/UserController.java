package net.BuildUi.userservice.controllers;

import net.BuildUi.userservice.models.UserInfoDto;
import net.BuildUi.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createOrUpdate")
    public ResponseEntity<?> createOrUpdate(UserInfoDto userInfoDto){
        try{
            UserInfoDto user = userService.createOrUpdate(userInfoDto);
            return new ResponseEntity<>(user , HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<?> getUser(@Param("userId") String userId){
        try{
            UserInfoDto user = userService.getUser(userId);
            return new ResponseEntity<>(user , HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
