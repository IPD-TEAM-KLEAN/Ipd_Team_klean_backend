package com.example.ipd_team_klean.Repository.Small_SensorRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.QSmall_Sensor;
import com.example.ipd_team_klean.Entity.Small_Sensor;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class Small_SensorRepositoryImpl implements Small_SensorRepositoryCustom {
    private  final JPAQueryFactory queryFactory;

    QSmall_Sensor small_sensor = QSmall_Sensor.small_Sensor;

    public Small_SensorRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    private BooleanExpression eqState(){

        return small_sensor.States.eq("Active");
    }


    private BooleanExpression NEJan(){
        return small_sensor.Jan_Count.ne(0);
    }
    private BooleanExpression NEFeb(){
        return small_sensor.Feb_Count.ne(0);
    }
    private BooleanExpression NEMar(){
        return small_sensor.Mar_Count.ne(0);
    }
    private BooleanExpression NEApr(){
        return small_sensor.Apr_Count.ne(0);
    }
    private BooleanExpression NEMay(){
        return small_sensor.Mar_Count.ne(0);
    }
    private BooleanExpression NEJUN(){
        return small_sensor.Jun_Count.ne(0);
    }
    private BooleanExpression NEJUly(){
        return small_sensor.July_Count.ne(0);
    }
    private BooleanExpression NEAug(){
        return small_sensor.Aug_Count.ne(0);
    }
    private BooleanExpression NESep(){
        return small_sensor.Sep_Count.ne(0);
    }
    private BooleanExpression NEOct(){
        return small_sensor.Oct_Count.ne(0);
    }
    private BooleanExpression NENov(){
        return small_sensor.Nov_Count.ne(0);
    }
    private BooleanExpression NEDec(){
        return small_sensor.Dec_Count.ne(0);
    }


    @Override
    public List<Small_Sensor> getActiveSmall() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(eqState()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallJanSewer() {
        return  (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEJan()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallFebSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEFeb()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallMarSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEMar()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallAprSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEApr()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallMaySewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEMay()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallJunSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEJUN()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallJulySewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEJUly()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallAugSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEAug()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallSepSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NESep()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallOctSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEOct()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallNovSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NENov()).fetch();
    }

    @Override
    public List<Small_Sensor> getSmallDecSewer() {
        return (List<Small_Sensor>) queryFactory.from(small_sensor).where(NEDec()).fetch();
    }
}
