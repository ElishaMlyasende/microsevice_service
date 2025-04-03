package user_service.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;
import user_service.user_service.model.PermissionModel;
import user_service.user_service.services.PermissionService;

import java.util.List;

@RestController
@RequestMapping("api/user/v2")
public class PermissionController {
    private  final PermissionService permissionService;
    public PermissionController(PermissionService permissionService){
        this.permissionService=permissionService;
    }
    @PostMapping("/add/permission")
    public ResponseEntity<?> addPermission(@RequestBody PermissionModel permissionModel){
        return permissionService.addPermission(permissionModel);
    }


    @PutMapping("/update/permission/{id}")
    public ResponseEntity<?>updatePermissions(@PathVariable("id")Long id, @RequestBody PermissionModel permissionModel){
        return permissionService.updatePermission(permissionModel, id);
    }

    @GetMapping("/check/{id}")
    public ResponseEntity<?>findUserById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(permissionService.findPermissionById(id));
    }
    @GetMapping("/AllPermission")
    public List<PermissionModel>getAllPermission(){
        return permissionService.getAllPermission();
    }

    @DeleteMapping("/deletePermission/{id}")
    public ResponseEntity<?>deletePermission(@PathVariable("id") Long id){
        return permissionService.deletePermission(id);
    }
}
