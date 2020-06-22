package com.cmpay.xgf;

import com.cmpay.lemon.common.LemonFramework;
import com.cmpay.lemon.framework.LemonBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@LemonBootApplication(exclude = {RabbitAutoConfiguration.class}, value = {"com.cmpay.xgf"})
public class XgfApplication {
    public static void main(String[] args) {
        LemonFramework.run(XgfApplication.class, args);
    }
}