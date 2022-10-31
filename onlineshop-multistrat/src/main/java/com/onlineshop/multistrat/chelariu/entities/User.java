package com.onlineshop.multistrat.chelariu.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false, unique = true)
    @Email
    private String email;

    @Column(length = 64, nullable = false)
    @NotNull
    private String password;

    @Column(name = "first_name",  length = 45, nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name",  length = 45, nullable = false)
    @NotNull
    private String lastName;

    @Column(length = 64)
    private String photos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name ="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Rol> roles = new HashSet<> ();


    public void addRole(Rol rol)
    {
        this.roles.add (rol);
    }

    public Set<Rol> getRoles() {
        return roles;
    }
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public boolean hasRole(String roleName) {
        Iterator<Rol> iterator = roles.iterator();

        while (iterator.hasNext()) {
            Rol role = iterator.next();
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass (this) != Hibernate.getClass (o)) return false;
        User user = (User) o;
        return id != null && Objects.equals (id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass ().hashCode ();
    }
}
