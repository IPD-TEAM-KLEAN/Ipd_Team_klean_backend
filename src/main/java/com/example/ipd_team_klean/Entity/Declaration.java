package com.example.ipd_team_klean.Entity;


import lombok.*;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "declaration_id")
    private  int id;

    @Setter
    @Column(nullable = false)
    private int Declaration_Count;  // 신고 카운터

    @Setter
    @Column(nullable = false)
    private  int Accumulate_Count; // 누적 카운터
    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;

    @Builder
    public Declaration(int declaration_Count,int accumulate_Count, Sewer sewer) {
        Declaration_Count = declaration_Count;
        Accumulate_Count = accumulate_Count;
        this.sewer = sewer;
    }
}
