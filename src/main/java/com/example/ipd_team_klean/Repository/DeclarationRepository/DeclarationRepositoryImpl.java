package com.example.ipd_team_klean.Repository.DeclarationRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Declaration;
import com.example.ipd_team_klean.Entity.QBlock;
import com.example.ipd_team_klean.Entity.QDeclaration;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class DeclarationRepositoryImpl implements  DeclarationRepositoryCustom{

    private  final JPAQueryFactory queryFactory;



    QDeclaration qDeclaration = QDeclaration.declaration;

    public DeclarationRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    private BooleanExpression NeCount(){
        return  qDeclaration.Declaration_Count.ne(0);
    }



    @Override
    public List<Declaration> getDeclarationSewer() {
        return (List<Declaration>) queryFactory.from(qDeclaration).where(NeCount()).fetch();
    }
}
