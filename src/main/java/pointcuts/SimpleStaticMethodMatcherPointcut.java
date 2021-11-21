package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.print("(Static check for " + method.getName() + ")");
        return "execute".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> aClass==Agent.class;
    }

    public void execute(){
        System.out.print("StaticMethodMatcherPointcut: ");

        Pointcut pointcut = new SimpleStaticMethodMatcherPointcut();
        Advice advice = new SimpleAfterReturningAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent)proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}