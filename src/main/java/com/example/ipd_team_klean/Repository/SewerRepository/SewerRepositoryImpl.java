package com.example.ipd_team_klean.Repository.SewerRepository;


import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.Entity.QSewer;
import com.example.ipd_team_klean.Entity.Sewer;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @Override
    public Slice<ResponseActiveSewerListDto> getSewerScroll(Pageable pageable) {
        QueryResults<Sewer> results = queryFactory.selectFrom(sewer).where(
                eqStateActive()
        ).offset(pageable.getOffset()).limit(pageable.getPageSize()+1).fetchResults();
        List<ResponseActiveSewerListDto> content = new ArrayList<>();
        for(Sewer eachSewer : results.getResults()){
            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto
                    .builder()
                    .id(eachSewer.getId())
                    .latitude(eachSewer.getLat())
                    .longtitude(eachSewer.getLon())
                    .state(eachSewer.getState())
                    .address_name(eachSewer.getAddress_name())
                    .region_name(eachSewer.getRegion_name())
                    .build();
            content.add(responseActiveSewerListDto);
        }
        boolean hasNext = false;

        if(content.size()> pageable.getPageSize()){
            content.remove(pageable.getPageSize());
            hasNext = true;
        }
        return  new SliceImpl<>(content,pageable,hasNext);
    }
}
