package com.wuqaq.security.core.validate.code.sms;

/**
 * 短信验证码处理接口
 *
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
