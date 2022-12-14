package com.example.ipd_team_klean.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "CollectionHumidity")
public class ChangeH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  double value;
    private LocalDateTime crateDate;

    @ManyToOne
    @JoinColumn(name = "t_id")
    private  H_Sensor h_sensor;


    @Builder
    public ChangeH(int id, double value, LocalDateTime crateDate, H_Sensor h_sensor) {
        this.id = id;
        this.value = value;
        this.crateDate = crateDate;
        this.h_sensor = h_sensor;
    }

}
