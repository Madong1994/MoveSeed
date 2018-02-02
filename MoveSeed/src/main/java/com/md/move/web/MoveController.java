package com.md.move.web;

import com.alibaba.fastjson.JSON;
import com.md.move.service.MoveService;
import com.md.move.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 首页
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/indexMove")
    public String indexData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findAllMoveByPage(page,pageSize);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 欧美
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/eaMove")
    public String EAData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize,1);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 日韩
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/jskMove")
    public String JSKData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize,2);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 国产
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/domesticMove")
    public String domesticData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize,3);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 动画
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/animationMove")
    public String animationData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize,4);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 其他
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/otherMove")
    public String otherData(int page,int pageSize){
        ResultMsg resultMsg = moveService.findMoveByPage(page,pageSize,0);
        String json = JSON.toJSONString(resultMsg);
        return json;
    }

    /**
     * 开始爬取数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMove")
    public String getMove(){
        int res = moveService.insertMove(null);
        if(res == 0){
            return "ok!";
        }
        return "<span style='color:red;'>error!</span>";
    }
}
