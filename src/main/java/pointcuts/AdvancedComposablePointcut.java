package pointcuts;

import advices.SimpleAfterReturningAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class AdvancedComposablePointcut {
    public void execute(){
        System.out.print("\nComposablePointcut: ");

        Agent agent = new Agent();
        Agent agentProxy;

        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new FirstMatcher());

        agentProxy = getProxy(pointcut,agent);
        agentProxy.firstMethod("first");
        System.out.print(" | ");
        agentProxy.secondMethod("first");

        System.out.print(" || ");

        pointcut.union((Pointcut) new SecondMatcher());
        agentProxy = getProxy(pointcut,agent);
        agentProxy.firstMethod("second");
        System.out.print(" | ");
        agentProxy.secondMethod("second");

        System.out.print(" || ");

        pointcut.intersection((Pointcut) new ThirdMatcher());
        agentProxy = getProxy(pointcut,agent);
        agentProxy.firstMethod("third");
        System.out.print(" | ");
        agentProxy.secondMethod("third");
    }

    private Agent getProxy(ComposablePointcut pointcut, Agent agent){
        Advice advice = new SimpleAfterReturningAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(agent);
        return (Agent) proxyFactory.getProxy();

    }

    public static class FirstMatcher extends StaticMethodMatcherPointcut {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "firstMethod".equals(method.getName());
        }
    }

    public static class SecondMatcher extends StaticMethodMatcherPointcut {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "secondMethod".equals(method.getName());
        }
    }

    public static class ThirdMatcher extends StaticMethodMatcherPointcut {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "nothing".equals(method.getName());
        }
    }

    public static class Agent {

        public String firstMethod(String agentArgument){
            System.out.print("Agent");
            return "firstMethod";
        }

        public String secondMethod(String agentArgument){
            System.out.print("Agent");
            return "secondMethod";
        }
    }
}