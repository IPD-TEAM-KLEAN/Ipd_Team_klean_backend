package com.example.ipd_team_klean.Entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Admin {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name ="Admin_ID")
    private String adminId;

    @Setter
    @Column(nullable = false)
    private  String email;
    @Column(nullable = false)
    private  String password;

    @Setter
    @Column(nullable = false)
    private String adminname;

    @Setter
    @Column(nullable = false)
    private  String address;
    @Setter
    @Column(nullable = false,length=13)
    private String phoneNumber;

    private  String roles;

    @CreatedDate
    private LocalDate createDate;


    @PrePersist
    public void createdAt() {
        this.createDate = LocalDate.now();
    }


    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

    @Builder

    public Admin( String email, String password, String adminname, String address, String phoneNumber, String roles) {
        this.email = email;
        this.password = password;
        this.adminname = adminname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }
}
