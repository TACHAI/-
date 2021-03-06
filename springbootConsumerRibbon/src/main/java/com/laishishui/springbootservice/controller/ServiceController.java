package com.laishishui.springbootservice.controller;

import com.laishishui.springbootservice.common.entity.RestfulResult;
import com.laishishui.springbootservice.common.utils.CommUtils;
import com.laishishui.springbootservice.entity.ServiceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping("/consumerServiceRibbon")
    @HystrixCommand(fallbackMethod = "consumerServiceRibbonFallback")
    public String consumerServiceRibbon(@RequestBody ServiceInfo serviceInfo) {
        String result = this.restTemplate.postForObject("http://springbootService/service/hello?token=1",serviceInfo,String.class);
        return result;

    }

    public String consumerServiceRibbonFallback(@RequestBody ServiceInfo  serviceInfo){
        return "consumerServiceRibbon异常，端口："+port+",Name="+serviceInfo.getName();
    }
}
