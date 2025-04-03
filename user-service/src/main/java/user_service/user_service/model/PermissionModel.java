package user_service.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Permissions")
public class PermissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_name")
    @NotBlank(message = "Permission name cannot be blank")
    private String permissionName;

    @Column(name = "descriptions")
    @NotBlank(message = "Description cannot be blank")
    private String descriptions;

     // this is just default controller
    public PermissionModel() {}

    // Parameterized constructor wih arguments
    public PermissionModel(String permissionName, String descriptions) {
        this.permissionName = permissionName;
        this.descriptions = descriptions;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @ManyToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private Set<UserModel> users;

    public Set<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }
}
