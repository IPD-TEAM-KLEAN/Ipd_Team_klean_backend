package com.example.ipd_team_klean.Entity;


import lombok.*;

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
    private int Declaration_Count;  // 신고 카운터
    @OneToOne
    @JoinColumn(name ="sewer_id")
    private Sewer sewer;

    @Builder
    public Declaration(int declaration_Count, Sewer sewer) {
        Declaration_Count = declaration_Count;
        this.sewer = sewer;
    }
}
