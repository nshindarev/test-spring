package component.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* call*(..))")
    public void pointCutCall() {};

    @Before("pointCutCall()")
    public void beforeCallMyPetAdvice(){
      log.info("calling your pet aspect ");
    }
}
