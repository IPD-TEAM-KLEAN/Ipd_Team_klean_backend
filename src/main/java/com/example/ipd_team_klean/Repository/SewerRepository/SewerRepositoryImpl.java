package com.example.ipd_team_klean.Repository.SewerRepository;


import com.example.ipd_team_klean.Entity.QSewer;
import com.example.ipd_team_klean.Entity.Sewer;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class SewerRepositoryImpl implements  SewerRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public SewerRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    QSewer sewer = QSewer.sewer;
    private BooleanExpression eqStateActive(){

        return sewer.state.eq("Active");
    }


    @Override
    public List<Sewer> getStateActiveSewer() {
        return (List<Sewer>) queryFactory.from(sewer).where(eqStateActive()).fetch();
    }
}
