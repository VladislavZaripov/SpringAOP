package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class UnionSimpleNameMatchMethodPointcutAdvisor {

    public void execute(){
        System.out.print("\nNameMatchMethodPointcutAdvisor: ");

        NameMatchMethodPointcutAdvisor pointcutAdvisor = new NameMatchMethodPointcutAdvisor(new SimpleAfterReturningAdvice());
        pointcutAdvisor.addMethodName("execute");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(pointcutAdvisor);
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent)proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}