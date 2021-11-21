package advices;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.print(" / AFTER (returnValue = " + o  + "; agentArgument = " + objects[0] + ")");
    }

    public void execute(){
        System.out.print("\nAfterReturningAdvice: ");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent) proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}