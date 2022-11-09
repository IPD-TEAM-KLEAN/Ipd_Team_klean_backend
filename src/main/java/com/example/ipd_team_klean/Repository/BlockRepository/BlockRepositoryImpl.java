package com.example.ipd_team_klean.Repository.BlockRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.QBlock;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class BlockRepositoryImpl implements BlockRepositoryCustom {
    private  final JPAQueryFactory queryFactory;



    QBlock block = QBlock.block;


    public BlockRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    private BooleanExpression eqStateRed(String state){
        if(StringUtils.isEmpty(state)){
            return null;
        }
        System.out.println(block.States);
        return block.States.eq("red");
    }
    private BooleanExpression eqStateOrange(String state){
        if(StringUtils.isEmpty(state)){
            return null;
        }
        System.out.println(state);
        return block.States.eq("orange");
    }

    //1~12 월
    private BooleanExpression NEJan(){
        return block.Jan_Count.ne(0);
    }
    private BooleanExpression NEFeb(){
        return block.Feb_Count.ne(0);
    }
    private BooleanExpression NEMar(){
        return block.Mar_Count.ne(0);
    }
    private BooleanExpression NEApr(){
        return block.Apr_Count.ne(0);
    }
    private BooleanExpression NEMay(){
        return block.Mar_Count.ne(0);
    }
    private BooleanExpression NEJUN(){
        return block.Jun_Count.ne(0);
    }
    private BooleanExpression NEJUly(){
        return block.July_Count.ne(0);
    }
    private BooleanExpression NEAug(){
        return block.Aug_Count.ne(0);
    }
    private BooleanExpression NESep(){
        return block.Sep_Count.ne(0);
    }
    private BooleanExpression NEOct(){
        return block.Oct_Count.ne(0);
    }
    private BooleanExpression NENov(){
        return block.Nov_Count.ne(0);
    }
    private BooleanExpression NEDec(){
        return block.Dec_Count.ne(0);
    }








    @Override
    public List<Block> getStateActiveSewerRed(String status) {
        return (List<Block>) queryFactory.from(block).where(eqStateRed(status)).fetch();
    }



    @Override
    public List<Block> getStateActiveSewerOrange(String status) {
        return (List<Block>) queryFactory.from(block).where(eqStateOrange(status)).fetch();
    }

    @Override
    public List<Block> getBlockJanSewer() {
        return (List<Block>) queryFactory.from(block).where(NEJan()).fetch();
    }

    @Override
    public List<Block> getBlockFebSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEFeb()).fetch();
    }

    @Override
    public List<Block> getBlockMarSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEMar()).fetch();
    }

    @Override
    public List<Block> getBlockAprSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEApr()).fetch();
    }

    @Override
    public List<Block> getBlockMaySewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEMay()).fetch();
    }

    @Override
    public List<Block> getBlockJunSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEJUN()).fetch();
    }

    @Override
    public List<Block> getBlockJulySewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEJUly()).fetch();
    }

    @Override
    public List<Block> getBlockAugSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEAug()).fetch();
    }

    @Override
    public List<Block> getBlockSepSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NESep()).fetch();
    }

    @Override
    public List<Block> getBlockOctSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEOct()).fetch();
    }

    @Override
    public List<Block> getBlockNovSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NENov()).fetch();
    }

    @Override
    public List<Block> getBlockDecSewer( ) {
        return (List<Block>) queryFactory.from(block).where(NEDec()).fetch();
    }
}
