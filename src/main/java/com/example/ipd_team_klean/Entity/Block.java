package com.example.ipd_team_klean.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Column(nullable = false,name = "States")
    @Setter
    private  String States;
    @Column(nullable = false)
    @Setter
    private  int BlockCount;
    @Column(nullable = false)
    @Setter
    private int Jan_Count;
    @Column(nullable = false)
    @Setter
    private int Feb_Count;
    @Column(nullable = false)
    @Setter
    private int Mar_Count;
    @Column(nullable = false)
    @Setter
    private int Apr_Count;
    @Column(nullable = false)
    @Setter
    private int May_Count;
    @Column(nullable = false)
    @Setter
    private int Jun_Count;
    @Column(nullable = false)
    @Setter
    private int July_Count;
    @Column(nullable = false)
    @Setter
    private int Aug_Count;
    @Column(nullable = false)
    @Setter
    private int Sep_Count;
    @Column(nullable = false)
    @Setter
    private int Oct_Count;
    @Column(nullable = false)
    @Setter
    private int Nov_Count;
    @Column(nullable = false)
    @Setter
    private int Dec_Count;
    @Setter
    private LocalDate BlockDate;
    @Setter
    private LocalTime BlockTime;


    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;

    @Builder
    public Block(String states, int blockCount, int jan_Count, int feb_Count, int mar_Count, int apr_Count, int may_Count, int jun_Count, int july_Count, int aug_Count, int sep_Count, int oct_Count, int nov_Count, int dec_Count, LocalDate blockDate, LocalTime blockTime, Sewer sewer) {
        States = states;
        BlockCount = blockCount;
        Jan_Count = jan_Count;
        Feb_Count = feb_Count;
        Mar_Count = mar_Count;
        Apr_Count = apr_Count;
        May_Count = may_Count;
        Jun_Count = jun_Count;
        July_Count = july_Count;
        Aug_Count = aug_Count;
        Sep_Count = sep_Count;
        Oct_Count = oct_Count;
        Nov_Count = nov_Count;
        Dec_Count = dec_Count;
        BlockDate = blockDate;
        BlockTime = blockTime;
        this.sewer = sewer;
    }
}
