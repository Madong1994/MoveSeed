package com.md.move.dao;

import com.md.move.entity.Move;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("INSERT INTO move (type_name,move_name,resource,size,gain_date) values (#{move.type_name,move.move_name,move.resource,move.size,move.gain_date})")
    int insertMove(@Param("move") Move move);
}
