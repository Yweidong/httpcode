package com.dongdong.aspect;

import com.dongdong.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: httpcode
 * @description: 响应切面
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-09-05 15:22
 **/
@Aspect
@Component
public class ResponseAspect {

    @Pointcut("@annotation(com.dongdong.annotation.ResponseResultBody)")
    public void responsePointCut() {}

    @Around(value = "responsePointCut()")
    public Object afterBodyWrite(ProceedingJoinPoint pjp) throws Throwable {
        // 防止重复包裹的问题出现
        Object body = pjp.proceed();
            if (body instanceof Result) {
                return body;
            }

        return Result.success(body);
    }

}
