package com.laishishui.springbootservice.controller;

import com.laishishui.springbootservice.client.ServiceFeignClient;
import com.laishishui.springbootservice.common.entity.RestfulResult;
import com.laishishui.springbootservice.common.utils.CommUtils;
import com.laishishui.springbootservice.entity.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ServiceController {


    @Autowired
    ServiceFeignClient serviceFeignClient;


    // 调用：localhost:6004/consumerService?token=1
    @RequestMapping(value = "/consumerService")
    public void consumerService(HttpServletRequest request, HttpServletResponse response,
                      @RequestBody ServiceInfo serviceInfo) {

        RestfulResult restfulResult = serviceFeignClient.hello(serviceInfo);



        CommUtils.printDataJason(response, restfulResult);
    }


}
