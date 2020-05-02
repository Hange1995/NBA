package com.hardworking.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hardworking.training.jsonview.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    //@SequenceGenerator(name = "role_id_generator", sequenceName = "role_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = SEQUENCE, generator = "role_id_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.AdminView.class})
    private long id;
    @Column(name = "name")
    @JsonView({Views.AdminView.class})
    private String name;
    @Column(name = "allowed_resource")
    @JsonView({Views.AdminView.class})
    private String allowedResource;
    @Column(name = "allowed_read")
    @JsonView({Views.AdminView.class})
    private boolean allowedRead;
    @Column(name = "allowed_create")
    @JsonView({Views.AdminView.class})
    private boolean allowedCreate;
    @Column(name = "allowed_update")
    @JsonView({Views.AdminView.class})
    private boolean allowedUpdate;
    @Column(name = "allowed_delete")
    @JsonView({Views.AdminView.class})
    private boolean allowedDelete;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

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

    public String getAllowedResource() {
        return allowedResource;
    }

    public void setAllowedResource(String allowedResource) {
        this.allowedResource = allowedResource;
    }

    public boolean isAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(boolean allowedRead) {
        this.allowedRead = allowedRead;
    }

    public boolean isAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(boolean allowedCreate) {
        this.allowedCreate = allowedCreate;
    }

    public boolean isAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(boolean allowedUpdate) {
        this.allowedUpdate = allowedUpdate;
    }

    public boolean isAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(boolean allowedDelete) {
        this.allowedDelete = allowedDelete;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}