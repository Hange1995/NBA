package com.hardworking.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    //@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = SEQUENCE, generator = "user_id_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @JsonView({Views.UserView.class})
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "secret_key")
    private String secretKey;
    @Column(name = "first_name")
    @JsonView({Views.UserView.class})
    private String firstName;
    @Column(name = "last_name")
    @JsonView({Views.UserView.class})
    private String lastName;
    @Column(name = "email")
    @JsonView({Views.UserView.class})
    private String email;
    @Column(name= "active_status")
    @JsonView({Views.UserView.class})
    private boolean activeStatus=true;

    @ManyToMany(cascade = {CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id")}

    )
    @JsonIgnore
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password.trim());
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}