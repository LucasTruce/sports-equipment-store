package com.store.model.user;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "storedb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
