package com.md.controller;

import com.md.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 马东 on 2017/12/12.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 21:08 2017/12/12
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Controller
@RequestMapping("/video")
public class VideoController extends BaseController {

    @RequestMapping("/get")
    public String getVideo(){
        return ""
    }
}
