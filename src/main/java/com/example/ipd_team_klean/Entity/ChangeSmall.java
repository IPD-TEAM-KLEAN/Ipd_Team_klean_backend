package com.example.ipd_team_klean.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
@Table(name = "CollectionSmell")
public class ChangeSmall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  double value;
    private LocalDateTime crateDate;
    @ManyToOne
    @JoinColumn(name = "small_id")
    private  Small_Sensor small_sensor;


    @Builder
    public ChangeSmall(double value, LocalDateTime crateDate, Small_Sensor small_sensor) {
        this.value = value;
        this.crateDate = crateDate;
        this.small_sensor = small_sensor;
    }

}
