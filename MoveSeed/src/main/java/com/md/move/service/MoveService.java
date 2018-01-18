package com.md.move.service;

import com.md.move.entity.Move;
import com.md.move.util.ResultMsg;

/**
 * Created by 马东 on 2018/1/10.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 0:04 2018/1/10
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public interface MoveService {
    ResultMsg findMoveByPage(int page,int pageSize,int type);

    ResultMsg findAllMoveByPage(int page,int pageSize);

    int insertMove(Move move);
}
