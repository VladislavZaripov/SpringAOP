package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AdvancedControlFlowPointcut {

    public void execute(){
        System.out.print("\nControlFlowPointcut: ");

        Pointcut pointcut = new ControlFlowPointcut(AdvancedControlFlowPointcut.class,"test");
        Advice advice = new SimpleAfterReturningAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent)proxyFactory.getProxy();

        agent.execute("agentArgument");
        System.out.print(" / ");

        test(agent);
    }

    private void test (Agent agent){
        agent.execute("agentArgument from test");
    }
}