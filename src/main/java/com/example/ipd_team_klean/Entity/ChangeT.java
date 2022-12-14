package com.example.ipd_team_klean.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "CollectionTemperature" )
public class ChangeT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  double value;

    @Column(name = "CreateTime")
    private LocalDateTime crateDate;

    @ManyToOne
    @JoinColumn(name = "t_id")
    private  TH_Sensor th_sensor;


    @Builder
    public ChangeT(int id, double value, LocalDateTime crateDate, TH_Sensor th_sensor) {
        this.id = id;
        this.value = value;
        this.crateDate = crateDate;
        this.th_sensor = th_sensor;
    }
}
