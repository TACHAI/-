package com.laishishui.springbootservice.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by tachai on 2021/2/22 11:27 上午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class JsonUtils {
    public JsonUtils(){

    }

    public static String renderString(HttpServletResponse response,Object object){
        return renderString(response,JsonMapper.toJsonString(object),"application/json");
    }

    public static String renderString(HttpServletResponse response,String string,String type){
        try {
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException var4) {
            return null;
        }
    }
}
