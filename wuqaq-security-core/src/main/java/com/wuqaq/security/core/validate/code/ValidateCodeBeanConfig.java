package com.wuqaq.security.core.validate.code;

import com.wuqaq.security.core.properties.SecurityProperties;
import com.wuqaq.security.core.validate.code.image.ImageCodeGenerator;
import com.wuqaq.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.wuqaq.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 不存在imageCodeGenerator，才生成这个Bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "smsCodeSender")
    public SmsCodeSender smsCodeGenerator() {
        return new DefaultSmsCodeSender();
    }
}
