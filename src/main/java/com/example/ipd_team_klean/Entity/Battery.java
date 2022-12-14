package com.example.ipd_team_klean.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Entity
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Setter
    private  double value;

    @Column(name = "BatteryDate")
    @Setter
    private LocalDate createDate;
    @Column(name = "BatteryTime")
    @Setter
    private LocalTime createTime;

    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;


    @Builder
    public Battery(int id, double value, LocalDate createDate, LocalTime createTime, Sewer sewer) {
        this.id = id;
        this.value = value;
        this.createDate = createDate;
        this.createTime = createTime;
        this.sewer = sewer;
    }
}
