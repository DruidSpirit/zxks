package cn.edu.cczu.zxks.constant;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 jjc
 * @创建时间 2019/5/17
 * @描述
 */
@Data
public class Msg {
    //ret=1表示成功，ret=0表示失败，ret=-1表示错误
    private String status;
    private String message;
    private Map<String, Object> data=new HashMap<String, Object>();

    public static Msg SUCCESS(){
        Msg result=new Msg();
        result.setStatus("ok");
        result.setMessage("处理成功！");
        return result;
    }

    public static Msg FAIL(){
        Msg result=new Msg();
        result.setStatus("fail");
        result.setMessage("处理失败！");
        return result;
    }

    public static Msg ERROR(){
        Msg result=new Msg();
        result.setStatus("error");
        result.setMessage("出现异常！");
        return result;
    }

    public Msg addAttribute(String key,Object value){
        this.getData().put(key, value);
        return this;
    }


}
