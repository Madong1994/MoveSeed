package com.md.move.web;

import com.alibaba.fastjson.JSON;
import com.md.move.service.MoveService;
import com.md.move.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 马东 on 2018/1/10.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 0:21 2018/1/10
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Controller
@RequestMapping("/moves")
public class MoveController {
    @Autowired
    MoveService moveService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    @RequestMapping("/indexMove")
    public String indexData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }
}
