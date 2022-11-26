package com.example.ipd_team_klean.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



@Entity
@NoArgsConstructor
@Getter
public class TH_Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private  int id;

    // 온도

    @Column(nullable = false)
    @Setter
    private  double value;  //  온도상태

    @Column(nullable = false)
    @Setter
    private  int Count;  // 총 온도  숫자

    // 월별 막힌 숫자

    @Setter
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer; // 하수구와 일대일 관계






   @Builder
    public TH_Sensor(int id, double value, int count,  LocalDateTime datetime, Sewer sewer) {
        this.id = id;
        this.value = value;
        Count = count;

        localDateTime= datetime;
        this.sewer = sewer;
    }
}
