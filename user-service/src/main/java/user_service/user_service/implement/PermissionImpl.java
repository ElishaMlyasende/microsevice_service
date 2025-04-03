package user_service.user_service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user_service.user_service.model.PermissionModel;
import user_service.user_service.repository.PermissionRepository;
import user_service.user_service.services.PermissionService;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    // Constructor with Dependency Injection
    public PermissionImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public ResponseEntity<?>addPermission(PermissionModel permissionModel) {
      PermissionModel permissionModel1=permissionRepository.save(permissionModel);
      return ResponseEntity.ok("Added Permission successfully");
    }
    public  List<PermissionModel>getAllPermission(){
        List<PermissionModel>getAllPermissions=permissionRepository.findAll();
        return getAllPermissions;
    }
    public  ResponseEntity<?>findPermissionById(Long id){
        Optional<PermissionModel> findPermission=permissionRepository.findById(id);
        if(findPermission.isPresent()){
            PermissionModel permission=findPermission.get();
            return ResponseEntity.ok(permission);
        }
        else {
            return ResponseEntity.ok("permission not fou nd");
        }
    }
    public ResponseEntity<?>deletePermission(Long id){
        Optional<PermissionModel> deletePermission=permissionRepository.findById(id);
        if (deletePermission.isPresent()){
            permissionRepository.deleteById(id);
            return ResponseEntity.ok("Permission deleted successfully");
        }
        else{
            return  ResponseEntity.ok("Failed to delete permission because permission not found");
        }
    }
    public ResponseEntity<?>updatePermission(PermissionModel permissionModel, Long id){
        Optional<PermissionModel>checkPermission=permissionRepository.findById(id);
        if (checkPermission.isPresent()){
            PermissionModel permissions=checkPermission.get();
            permissions.setPermissionName(permissionModel.getPermissionName());
            permissions.setDescriptions(permissionModel.getDescriptions());
            permissionRepository.save(permissions);
            return ResponseEntity.ok("Permission updated");
        }
        else{
            return  ResponseEntity.ok("Failed to update may permission not found");
        }
    }
 }
