package com.example.ipd_team_klean.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TH_Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    // 온도

    @Column(nullable = false)
    @Setter
    private  String TStates;  //  온도상태

    @Column(nullable = false)
    @Setter
    private  int TCount;  // 총 온도  숫자

    // 월별 막힌 숫자
    @Column(nullable = false)
    @Setter
    private int TJan_Count;
    @Column(nullable = false)
    @Setter
    private int TFeb_Count;
    @Column(nullable = false)
    @Setter
    private int TMar_Count;
    @Column(nullable = false)
    @Setter
    private int TApr_Count;
    @Column(nullable = false)
    @Setter
    private int TMay_Count;
    @Column(nullable = false)
    @Setter
    private int TJun_Count;
    @Column(nullable = false)
    @Setter
    private int TJuly_Count;
    @Column(nullable = false)
    @Setter
    private int TAug_Count;
    @Column(nullable = false)
    @Setter
    private int TSep_Count;
    @Column(nullable = false)
    @Setter
    private int TOct_Count;
    @Column(nullable = false)
    @Setter
    private int TNov_Count;
    @Column(nullable = false)
    @Setter
    private int TDec_Count;
    @Setter
    private LocalDate TDate;
    @Setter
    private LocalTime TTime;



    // 습도
    @Column(nullable = false)
    @Setter
    private  String HStates;  //  습도상태

    @Column(nullable = false)
    @Setter
    private  int HCount;  // 총 온도  숫자

    // 월별 막힌 숫자
    @Column(nullable = false)
    @Setter
    private int HJan_Count;
    @Column(nullable = false)
    @Setter
    private int HFeb_Count;
    @Column(nullable = false)
    @Setter
    private int HMar_Count;
    @Column(nullable = false)
    @Setter
    private int HApr_Count;
    @Column(nullable = false)
    @Setter
    private int HMay_Count;
    @Column(nullable = false)
    @Setter
    private int HJun_Count;
    @Column(nullable = false)
    @Setter
    private int HJuly_Count;
    @Column(nullable = false)
    @Setter
    private int HAug_Count;
    @Column(nullable = false)
    @Setter
    private int HSep_Count;
    @Column(nullable = false)
    @Setter
    private int HOct_Count;
    @Column(nullable = false)
    @Setter
    private int HNov_Count;
    @Column(nullable = false)
    @Setter
    private int HDec_Count;
    @Setter
    private LocalDate HDate;
    @Setter
    private LocalTime HTime;

    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;

   @Builder

    public TH_Sensor(String TStates, int TCount, int TJan_Count, int TFeb_Count, int TMar_Count, int TApr_Count, int TMay_Count, int TJun_Count, int TJuly_Count, int TAug_Count, int TSep_Count, int TOct_Count, int TNov_Count, int TDec_Count, LocalDate TDate, LocalTime TTime, String HStates, int HCount, int HJan_Count, int HFeb_Count, int HMar_Count, int HApr_Count, int HMay_Count, int HJun_Count, int HJuly_Count, int HAug_Count, int HSep_Count, int HOct_Count, int HNov_Count, int HDec_Count, LocalDate HDate, LocalTime HTime, Sewer sewer) {
        this.TStates = TStates;
        this.TCount = TCount;
        this.TJan_Count = TJan_Count;
        this.TFeb_Count = TFeb_Count;
        this.TMar_Count = TMar_Count;
        this.TApr_Count = TApr_Count;
        this.TMay_Count = TMay_Count;
        this.TJun_Count = TJun_Count;
        this.TJuly_Count = TJuly_Count;
        this.TAug_Count = TAug_Count;
        this.TSep_Count = TSep_Count;
        this.TOct_Count = TOct_Count;
        this.TNov_Count = TNov_Count;
        this.TDec_Count = TDec_Count;
        this.TDate = TDate;
        this.TTime = TTime;
        this.HStates = HStates;
        this.HCount = HCount;
        this.HJan_Count = HJan_Count;
        this.HFeb_Count = HFeb_Count;
        this.HMar_Count = HMar_Count;
        this.HApr_Count = HApr_Count;
        this.HMay_Count = HMay_Count;
        this.HJun_Count = HJun_Count;
        this.HJuly_Count = HJuly_Count;
        this.HAug_Count = HAug_Count;
        this.HSep_Count = HSep_Count;
        this.HOct_Count = HOct_Count;
        this.HNov_Count = HNov_Count;
        this.HDec_Count = HDec_Count;
        this.HDate = HDate;
        this.HTime = HTime;
        this.sewer = sewer;
    }
}
