package user_service.user_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.user_service.RABBITMQ_PUBLISHER.MessageProducer;
import user_service.user_service.model.UserModel;
import user_service.user_service.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user/v2")
public class UserController {
    private  final UserService userService;
    private final MessageProducer messageProducer;

    //just creating constructor
    public UserController(MessageProducer messageProducer,UserService userService) {

        this.userService=userService;
        this.messageProducer=messageProducer;
    }

    @PostMapping("/add")
    public ResponseEntity<?>AddUser(@Valid @RequestBody   UserModel userModel){
        return  userService.AddUser(userModel);

    }
    @GetMapping("/get")
    public List<UserModel> GetAllUser(){
        return userService.GetAllUser();
    }
    @DeleteMapping("/remove/{user-id}")
    public ResponseEntity<?>DeleteUser(@PathVariable("user-id") Long id){
        return userService.DeleteUser(id);
    }
    @PutMapping("/update/{user-id}")
    public ResponseEntity<?> UpdateUser(@PathVariable("user-id") Long id,  @RequestBody UserModel userModel){
        return userService.UpdateUser(userModel, id);
    }
    @GetMapping("/publish")
    public ResponseEntity<String> PublishMessage(@RequestParam("message") String message){
        messageProducer.sendMessage(message);
        return  ResponseEntity.ok("message sent successfully");
    }
}
