package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class SimpleAspectJExpressionPointcut {

    public void execute(){
        System.out.print("\nAspectJExpressionPointcut: ");

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* execute*(..))");
        Advice advice = new SimpleAfterReturningAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent) proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}