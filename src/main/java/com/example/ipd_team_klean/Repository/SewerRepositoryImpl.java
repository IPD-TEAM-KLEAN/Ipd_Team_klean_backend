package com.example.ipd_team_klean.Repository;

import com.example.ipd_team_klean.Entity.QSewer;
import com.example.ipd_team_klean.Entity.Sewer;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class SewerRepositoryImpl implements SewerRepositoryCustom{

    private  final JPAQueryFactory queryFactory;

    public SewerRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    QSewer sewer = QSewer.sewer;

    private BooleanExpression eqStateRed(String state){
        if(StringUtils.isEmpty(state)){
            return null;
        }
        return sewer.States.eq("red");
    }
    private BooleanExpression eqStateOrange(String state){
        if(StringUtils.isEmpty(state)){
            return null;
        }
        return sewer.States.eq("orange");
    }

    //1~12 월
    private BooleanExpression NEJan(){
        return sewer.Jan_Count.ne(0);
    }
    private BooleanExpression NEFeb(){
        return sewer.Feb_Count.ne(0);
    }
    private BooleanExpression NEMar(){
        return sewer.Mar_Count.ne(0);
    }private BooleanExpression NEApr(){
        return sewer.Apr_Count.ne(0);
    }private BooleanExpression NEMay(){
        return sewer.Mar_Count.ne(0);
    }private BooleanExpression NEJUN(){
        return sewer.Jun_Count.ne(0);
    }
    private BooleanExpression NEJUly(){
        return sewer.July_Count.ne(0);
    }
    private BooleanExpression NEAug(){
        return sewer.Aug_Count.ne(0);
    }private BooleanExpression NESep(){
        return sewer.Sep_Count.ne(0);
    }private BooleanExpression NEOct(){
        return sewer.Oct_Count.ne(0);
    }private BooleanExpression NENov(){
        return sewer.Nov_Count.ne(0);
    }private BooleanExpression NEDec(){
        return sewer.Dec_Count.ne(0);
    }








    @Override
    public List<Sewer> getStateActiveSewerRed(String status) {
        return (List<Sewer>) queryFactory.from(sewer).where(eqStateRed(status)).fetch();
    }



    @Override
    public List<Sewer> getStateActiveSewerOrange(String status) {
        return (List<Sewer>) queryFactory.from(sewer).where(eqStateOrange(status)).fetch();
    }

    @Override
    public List<Sewer> getBlockJanSewer() {
        return (List<Sewer>) queryFactory.from(sewer).where(NEJan()).fetch();
    }

    @Override
    public List<Sewer> getBlockFebSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEFeb()).fetch();
    }

    @Override
    public List<Sewer> getBlockMarSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEMar()).fetch();
    }

    @Override
    public List<Sewer> getBlockAprSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEApr()).fetch();
    }

    @Override
    public List<Sewer> getBlockMaySewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEMay()).fetch();
    }

    @Override
    public List<Sewer> getBlockJunSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEJUN()).fetch();
    }

    @Override
    public List<Sewer> getBlockJulySewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEJUly()).fetch();
    }

    @Override
    public List<Sewer> getBlockAugSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEAug()).fetch();
    }

    @Override
    public List<Sewer> getBlockSepSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NESep()).fetch();
    }

    @Override
    public List<Sewer> getBlockOctSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEOct()).fetch();
    }

    @Override
    public List<Sewer> getBlockNovSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NENov()).fetch();
    }

    @Override
    public List<Sewer> getBlockDecSewer( ) {
        return (List<Sewer>) queryFactory.from(sewer).where(NEDec()).fetch();
    }
}
