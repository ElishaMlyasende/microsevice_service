package user_service.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_service.user_service.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


}
