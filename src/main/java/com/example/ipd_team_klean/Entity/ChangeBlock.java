package com.example.ipd_team_klean.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
// 막힘이 변화 되었을 때 변경 사항
public class ChangeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  double value;
    private LocalDateTime crateDate;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private  Block block;

    @Builder
    public ChangeBlock(double value, LocalDateTime crateDate, Block block) {
        this.value = value;
        this.crateDate = crateDate;
        this.block = block;
    }

}
