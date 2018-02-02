package com.md.move.dao;

import com.md.move.dao.provider.provider;
import com.md.move.entity.Move;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 马东 on 2018/1/10.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 0:03 2018/1/10
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public interface MoveDao {
    @Select("SELECT * FROM move where type=#{type}")
    List<Move> findAllMove(@Param("type") int type);

    @Select("SELECT * FROM move")
    List<Move> findMove();

    @Insert("INSERT INTO move (move_type,move_name,resource,size,gain_date, type) values (#{move_type},#{move_name},#{resource},#{size},#{gain_date},#{type})")
    int insertMove(Move move);

//    @Insert("INSERT INTO move (move_type,move_name,resource,size,gain_date, type) values (#{move_type},#{move_name},#{resource},#{size},#{gain_date},#{type})")
    @InsertProvider(type = provider.class,method = "insertAllMove")
    int insertMoves(List<Move> list);
}
