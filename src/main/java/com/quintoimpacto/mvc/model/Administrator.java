package com.quintoimpacto.mvc.model;

import com.quintoimpacto.mvc.rol.UserRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "tbl_administrators")
public class Administrator extends User {

    private String departament;
    private String status;

    @Column(name = "user_rol")
    @Enumerated(EnumType.STRING)
    private UserRol userRol = UserRol.ADMIN;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Administrator() {

    }

    public Administrator(String name, String lastName, String email, String password, String departament, String status, Date createAt) {
        super(name, lastName, email, password);
        this.departament = departament;
        this.status = status;
        this.createAt = createAt;
    }
}
