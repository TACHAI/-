package com.laishishui.springbootservice.common.entity;

/**
 * Create by tachai on 2021/2/22 11:19 上午
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class RestfulResult {


    private String result="Success";
    private String message;
    private Object data;    //返回数据
    private int cntPage;    //page数
    private long cntData;   //返回数据总数


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCntPage() {
        return cntPage;
    }

    public void setCntPage(int cntPage) {
        this.cntPage = cntPage;
    }

    public long getCntData() {
        return cntData;
    }

    public void setCntData(long cntData) {
        this.cntData = cntData;
    }
}
