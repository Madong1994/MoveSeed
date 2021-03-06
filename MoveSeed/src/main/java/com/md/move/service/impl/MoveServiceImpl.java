package com.md.move.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.md.move.crawler.MyMoveProcesser;
import com.md.move.dao.MoveDao;
import com.md.move.entity.Move;
import com.md.move.service.MoveService;
import com.md.move.util.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 马东 on 2018/1/10.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 0:06 2018/1/10
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Service
public class MoveServiceImpl implements MoveService {
    private static Logger logger = LoggerFactory.getLogger(MoveServiceImpl.class);
    @Autowired
    MoveDao moveDao;
    @Override
    public ResultMsg findMoveByPage(int page, int pageSize,int type) {
        ResultMsg resultMsg = new ResultMsg();
        try{
            PageHelper.startPage(page,pageSize);
            List<Move> moves = moveDao.findAllMove(type);
            PageInfo<Move> pageInfo = new PageInfo<>(moves);
            resultMsg.setCode(0);
            resultMsg.setMsg("操作成功！");
            resultMsg.setResult(pageInfo);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultMsg.setMsg("系统异常！");
            resultMsg.setCode(7);
        }
        return resultMsg;
    }

    @Override
    public ResultMsg findAllMoveByPage(int page, int pageSize) {
        ResultMsg resultMsg = new ResultMsg();
        try{
            PageHelper.startPage(page,pageSize);
            List<Move> moves = moveDao.findMove();
            PageInfo<Move> pageInfo = new PageInfo<>(moves);
            resultMsg.setCode(0);
            resultMsg.setMsg("操作成功！");
            resultMsg.setResult(pageInfo);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultMsg.setMsg("系统异常！");
            resultMsg.setCode(7);
        }
        return resultMsg;
    }

    @Override
    public int insertMove(Move move) {
        int res = 0;
        try{
            MyMoveProcesser.startGetPage(moveDao);
        }catch (Exception e){
            res = 1;
            logger.error(e.getMessage());
        }
        return res;
    }
}
