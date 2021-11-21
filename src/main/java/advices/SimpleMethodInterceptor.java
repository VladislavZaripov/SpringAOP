package advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("BEFORE / ");

        Object oldValue = methodInvocation.proceed();
        String newValue = "newValue";

        System.out.print(
                "("
                        + "agentValue = " + oldValue
                        + "; "
                        + "returnValue = " + newValue
                        + "; "
                        + "methodName = " + methodInvocation.getMethod().getName()
                        + "; "
                        + "methodArgument = " + methodInvocation.getArguments()[0]
                        + "; "
                        + "methodObject = " + methodInvocation.getThis().getClass().getName()
        );

        System.out.print(" / AFTER");

        return newValue;
    }

    public void execute(){
        System.out.print("\nMethodInterceptor: ");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleMethodInterceptor());
        proxyFactory.setTarget(new Agent());

        Agent agent = (Agent) proxyFactory.getProxy();
        agent.execute("agentArgument");
    }
}