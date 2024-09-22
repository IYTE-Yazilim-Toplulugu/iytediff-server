package iyteyazilim.projects.iytediff.entity;

import iyteyazilim.projects.iytediff.dto.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fullName")
    private String name;
    private String schoolNumber;
    private String department;
    private int grade;

    private String username;
    private String password;

    private Role userRole;


}
