package configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Configuration_F {

    @Pointcut("execution(* configuration..execute* (java.lang.String)) && args(agentArgument)")
    public void pointcutOne(String agentArgument) {
    }

    @Pointcut("bean(ag*)")
    public void isAg() {    }

    @After("pointcutOne(agentArgument) && isAg()")
    public void afterReturningAdvice(JoinPoint joinPoint, String agentArgument) {
        if (agentArgument.equals("agentArgument"))
            System.out.print(" / afterReturningAdvice: " + joinPoint.getTarget() + " " + joinPoint.getArgs()[0]);
    }

    @Around("pointcutOne(agentArgument) && isAg()")
    public Object aroundAdvice(ProceedingJoinPoint pjp, String agentArgument) throws Throwable {
        System.out.println("BEFORE aroundAdvice: " + "argument value - " + agentArgument);
        Object returnValue = pjp.proceed();
        System.out.println("\nAFTER aroundAdvice: " + "return value - " + returnValue);
        return returnValue;
    }

    public void execute() {
        System.out.println("\nConfiguration_F -");

        GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
        gctx.load(new ClassPathResource("configuration_F.xml"));
        gctx.refresh();

        Agent agent = gctx.getBean("agent", Agent.class);
        agent.execute("agentArgument");
    }
}