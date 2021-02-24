package com.laishishui.springbootservice.client;

import com.laishishui.springbootservice.common.entity.RestfulResult;
import com.laishishui.springbootservice.entity.ServiceInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by tachai on 2021/2/22 2:28 下午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Component
@FeignClient(value = "springbootService",fallback = ServiceFallback.class)
//这里的value对应调用服务的spring.applicatoin.name
public interface ServiceFeignClient {
    @RequestMapping(value = "/service/hello")
    RestfulResult hello(@RequestBody ServiceInfo serviceInfo);
}
