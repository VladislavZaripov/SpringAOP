package configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Configuration_E {

    AgentInt proxy;
    public void setProxy(AgentInt agent) {
        this.proxy = agent;
    }

    public void aroundAdvice(ProceedingJoinPoint pjp, String agentArgument) throws Throwable{
        System.out.println("BEFORE aroundAdvice: " + "argument value - " + agentArgument);
        Object returnValue = pjp.proceed();
        System.out.println("\nAFTER aroundAdvice: " + "return value - " + returnValue);
    }

    public void afterReturningAdvice(JoinPoint joinPoint, String agentArgument) {
        if (agentArgument.equals("agentArgument"))
            System.out.print(" / afterReturningAdvice: " + joinPoint.getTarget() + " " + joinPoint.getArgs()[0]);
    }

    public void execute() {
        System.out.println("\nConfiguration_E - xmlns:aop: ");

        GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
        gctx.load(new ClassPathResource("configuration_E.xml"));
        gctx.refresh();

        Configuration_E configuration_e = gctx.getBean("configuration_e", Configuration_E.class);
        configuration_e.proxy.execute("agentArgument");
    }
}