package com.qf.util;

import static com.qf.constant.SsmConstant.*;

import com.qf.constant.SsmConstant;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 发短信的工具类.
 * create by 郑大仙丶
 * 2019/7/15 16:24
 */
@Component
public class SendSMSUtil {

    @Value("${apikey}")
    private String apikey;

    public String sendSMS(HttpSession session,String phone){
        //初始化clnt,使用单例方式
        YunpianClient clnt = new YunpianClient(apikey).init();
        // 生成6位随机数
        int code = (int)((Math.random()*9+1)*100000);
        // 将正确的验证码设置到session域中
        session.setAttribute(CODE,code);
        System.out.println(code);
        //发送短信API
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, phone);
        param.put(YunpianClient.TEXT, "【云片网】您的验证码是" + code);
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        //账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*
        //释放clnt
        clnt.close();
        return r.getMsg();
    }

}
