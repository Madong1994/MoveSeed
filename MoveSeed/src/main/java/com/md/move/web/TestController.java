package com.md.move.web;

import com.alibaba.fastjson.JSON;
import com.md.move.dao.UserDao;
import com.md.move.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @类名: ${CLASS_NAME}
 * @包名: com.md.move.web
 * @描述: ${TODO}(用一句话描述该文件做什么)
 * @日期: 2018/1/8 10:52
 * @版本: V1.0
 * @创建人：马东
 * @修改人：马东
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/index")
    @ResponseBody
    public String test(){
        User user = userDao.findAll();
        System.out.println(user.getName());
        return JSON.toJSONString(user);
    }
}
