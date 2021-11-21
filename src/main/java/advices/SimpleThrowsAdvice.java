package advices;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ех) throws Throwable{

        System.out.print("Caught = " + ех.getClass().getName());

    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ех) throws Throwable {

        System.out.print("Caught = " + ех.getClass().getName() + "; " + "Method = " + method.getName());

    }

    public void execute(){
        System.out.print("\nThrowsAdvice: ");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleThrowsAdvice());
        proxyFactory.setTarget(new Error());

        Error agent = (Error) proxyFactory.getProxy();
        try {
            agent.throwException();
        }
        catch (Exception exceptionIgnored) {
        }
        System.out.print(" / ");
        try {
            agent.throwIllegalArgumentException();
        }
        catch (Exception exceptionIgnored) {
        }
    }
}