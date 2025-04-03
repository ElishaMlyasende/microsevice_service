package user_service.user_service.services;

import org.springframework.http.ResponseEntity;
import org.w3c.dom.stylesheets.LinkStyle;
import user_service.user_service.model.PermissionModel;

import java.util.List;

public interface PermissionService {
    public ResponseEntity<?>addPermission(PermissionModel permissionModel);
    public  ResponseEntity<?>findPermissionById(Long id);
    public ResponseEntity<?>deletePermission(Long id);
    public ResponseEntity<?>updatePermission(PermissionModel permissionModel, Long id);
    public List<PermissionModel>getAllPermission();
}
