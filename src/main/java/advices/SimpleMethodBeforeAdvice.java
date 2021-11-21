package advices;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.print("BEFORE (methodName = " + method.getName() + "; agentArgument = " + objects[0] +") / ");
    }

    public void execute(){
        System.out.print("MethodBeforeAdvice: ");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleMethodBeforeAdvice());
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent) proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}