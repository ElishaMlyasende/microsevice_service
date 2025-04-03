package user_service.user_service.services;

import org.springframework.http.ResponseEntity;
import user_service.user_service.model.UserModel;

import java.util.List;

public interface UserService {
    public ResponseEntity<?>AddUser(UserModel userModel);
    public List<UserModel> GetAllUser();
    public ResponseEntity<?>DeleteUser(Long id);
    public ResponseEntity<?> UpdateUser(UserModel userModel,Long id);

}
