package com.cmpay.xgf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PowerAccessConfig {
    protected boolean isAccessOK(String functionName) {
        //权限查阅
        return false;
    }

    protected boolean canAccess(String functionName) {
        if (functionName != null) {
            //总是允许访问
            //针对名称进行权限查阅判断是否有权限
            //
            if (isAccessOK(functionName)) {
                System.out.println(" 具备删除权限 ");
                return true;
            } else {
                System.out.println(" 不具备删除权限 ");
                return false;
            }
        } else {
            System.out.println(" 违法访问 ");
            return false;
        }

    }

}