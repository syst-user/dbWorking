package com.example.dbWorking.v2.entitie;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "", name = "users")
@NamedQueries({
        @NamedQuery(
                name = "UserJPA.findAllByFirstName",
                query = "select u from User u where u.firstName like :filter" //jpql
        ),
        @NamedQuery(
                name = "UserJPA.findAllByLastName",
                query = "select u from User u where u.lastName like :filter" //jpql
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "UserJPA.findAllByFirstName2",
                query = "select * from users where firstname like :filter", //sql
                resultClass = User.class)
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    @NotNull
    private String firstName; //firstName -> first_name (дефолтное переименование в названия колонок)

    @Column(name = "lastname")
    @NotNull
    private String lastName;

    @Size(min = 5, max = 100)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
