package user_service.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "users") // Use plural for tables in DB

public class UserModel {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "First name cannot be null, must be filled with a value")
        @Column(name = "first_name")
        private String firstName;

        @NotBlank(message = "Last name cannot be null")
        @Column(name = "last_name")
        private String lastName;

        @NotBlank(message = "Username must be filled")
        @Column(name = "username", unique = true)
        private String username;

        @NotBlank(message = "Email must be filled")
        @Email(message = "Not a valid email format")
        @Column(name = "email", unique = true)
        private String email;

        @NotBlank(message = "Phone number must be filled")
        @Size(min = 10, max = 15, message = "Phone number should be between 10 and 15 characters")
        @Column(name = "phone_number", unique = true)
        private String phoneNumber;

        // Default Constructor (Required by JPA)
        public UserModel() {}

        // Constructor to Initialize Object
        public UserModel(String firstName, String lastName, String username, String email, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }


        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "user_permission",
                joinColumns = {
                        @JoinColumn(name="user_id", referencedColumnName = "id")
                },
                inverseJoinColumns = {
                         @JoinColumn(name = "permission_id", referencedColumnName = "id")
                }
        )
        private Set<PermissionModel> permission;
        public Set<PermissionModel> getPermission(){
                return permission;
        }
        public void setPermission(Set<PermissionModel> permission){
                this.permission=permission;
        }

}



