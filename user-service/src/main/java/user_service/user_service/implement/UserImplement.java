package user_service.user_service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user_service.user_service.model.UserModel;
import user_service.user_service.repository.UserRepository;
import user_service.user_service.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplement implements UserService {
    private final UserRepository userRepository;

    // Constructor injection
    public UserImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> AddUser(UserModel userModel) {
        UserModel savedUser = userRepository.save(userModel);
        return ResponseEntity.ok(savedUser);
    }
    @Override
    public List<UserModel> GetAllUser(){
        List<UserModel>  GetUsers= userRepository.findAll();
        return GetUsers;

    }
    public ResponseEntity<?> DeleteUser(Long id){
        // first check if the user exist or not
        Optional<UserModel> user=userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().body("user ot found");
        }
        else{
            userRepository.deleteById(id);
            return ResponseEntity.ok("User Deleted Successfully");
        }
    }
    public ResponseEntity<?>UpdateUser(UserModel userModel, Long id){
        //check first if the user exist
        Optional<UserModel> ExistUser=userRepository.findById(id);
        if(ExistUser.isPresent()){
            UserModel user=ExistUser.get();
            user.setEmail(userModel.getEmail());
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setUsername(userModel.getUsername());
            user.setPhoneNumber(userModel.getPhoneNumber());
            userRepository.save(user);
            return ResponseEntity.ok("User updated successfully");
        }
        else{

            return ResponseEntity.badRequest().body("User not found");
        }
    }

}
