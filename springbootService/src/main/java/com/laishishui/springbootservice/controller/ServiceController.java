package com.laishishui.springbootservice.controller;

import com.laishishui.springbootservice.common.entity.RestfulResult;
import com.laishishui.springbootservice.common.utils.CommUtils;
import com.laishishui.springbootservice.entity.ServiceInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by tachai on 2021/2/22 11:51 上午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController //重要，如果Controller会404
@RequestMapping("service")
public class ServiceController {
    @RequestMapping(value = "hello")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestBody ServiceInfo serviceInfo) {

        RestfulResult restfulResult = new RestfulResult();

        try {
            restfulResult.setData("Service1:Welcome " + serviceInfo.getName() + "!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        CommUtils.printDataJason(response, restfulResult);
    }

    @RequestMapping(value = "rest")
    public String rest(@RequestBody ServiceInfo serviceInfo){

        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }
}
