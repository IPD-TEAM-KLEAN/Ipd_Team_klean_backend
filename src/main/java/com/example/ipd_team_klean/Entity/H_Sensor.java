package com.example.ipd_team_klean.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RequiredArgsConstructor
@Getter
@Entity
public class H_Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    // 습도
    @Column(nullable = false)
    @Setter
    private  double value;  //  습도상태

    @Column(nullable = false)
    @Setter
    private  int Count;  // 총 온도  숫자


    @Setter
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;

    @Builder

    public H_Sensor(int id, double value, int count,  LocalDateTime date, Sewer sewer) {
        this.id = id;
        this.value = value;
        Count = count;
        localDateTime = date;
        this.sewer = sewer;
    }
}
