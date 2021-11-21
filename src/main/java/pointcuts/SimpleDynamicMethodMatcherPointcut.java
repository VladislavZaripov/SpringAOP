package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.print("(Static check for " + method.getName() + ")");
        return "execute".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.print("(Dynamic check for " + method.getName() + ")");
        return "rightAgentArgument".equals(objects[0]);
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> aClass==Agent.class;
    }

    public void execute(){
        System.out.print("\nDynamicMethodMatcherPointcut: ");

        Pointcut pointcut = new SimpleDynamicMethodMatcherPointcut();
        Advice advice = new SimpleAfterReturningAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent)proxyFactory.getProxy();
        agent.execute("rightAgentArgument");
        System.out.print(" / ");
        agent.execute("wrongAgentArgument");
    }
}