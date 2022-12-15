package com.example.ipd_team_klean.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class CollectionBattery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    private  double value;
    private LocalDateTime crateDate;

    @ManyToOne
    @JoinColumn(name = "battery_id")
    private  Battery battery;


    @Builder
    public CollectionBattery(int id, double value, LocalDateTime crateDate, Battery battery) {
        this.id = id;
        this.value = value;
        this.crateDate = crateDate;
        this.battery = battery;
    }
}
