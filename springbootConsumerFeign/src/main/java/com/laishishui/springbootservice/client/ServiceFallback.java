package com.laishishui.springbootservice.client;

import com.laishishui.springbootservice.common.entity.RestfulResult;
import com.laishishui.springbootservice.entity.ServiceInfo;
import org.springframework.stereotype.Component;

/**
 * Create by tachai on 2021/2/22 2:28 下午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Component
public class ServiceFallback implements ServiceFeignClient {
    @Override
    public RestfulResult hello(ServiceInfo serviceInfo) {

        RestfulResult result = new RestfulResult();
        result.setData("服务调用失败");
        return result;
    }
}
