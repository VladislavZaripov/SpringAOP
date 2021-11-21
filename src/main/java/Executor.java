import advices.SimpleAfterReturningAdvice;
import advices.SimpleMethodBeforeAdvice;
import advices.SimpleMethodInterceptor;
import advices.SimpleThrowsAdvice;
import configuration.*;
import introductions.Contact;
import pointcuts.*;

public class Executor {

    public static void main(String[] args) {
        advices();
        pointcuts();
        introductions();
        configuration();
    }

    public static void advices() {
        System.out.println("---ADVICES---");

        SimpleMethodBeforeAdvice simpleMethodBeforeAdvice = new SimpleMethodBeforeAdvice();
        simpleMethodBeforeAdvice.execute();

        SimpleAfterReturningAdvice simpleAfterReturningAdvice = new SimpleAfterReturningAdvice();
        simpleAfterReturningAdvice.execute();

        SimpleMethodInterceptor simpleMethodInterceptor = new SimpleMethodInterceptor();
        simpleMethodInterceptor.execute();

        SimpleThrowsAdvice simpleThrowsAdvice = new SimpleThrowsAdvice();
        simpleThrowsAdvice.execute();
    }

    public static void pointcuts() {
        System.out.println("\n\n---POINTCUTS---");

        SimpleStaticMethodMatcherPointcut simpleStaticMethodMatcherPointcut = new SimpleStaticMethodMatcherPointcut();
        simpleStaticMethodMatcherPointcut.execute();

        SimpleDynamicMethodMatcherPointcut simpleDynamicMethodMatcherPointcut = new SimpleDynamicMethodMatcherPointcut();
        simpleDynamicMethodMatcherPointcut.execute();

        SimpleNameMatchMethodPointcut simpleNameMatchMethodPointcut = new SimpleNameMatchMethodPointcut();
        simpleNameMatchMethodPointcut.execute();

        SimpleJdkRegexpMethodPointcut simpleJdkRegexpMethodPointcut = new SimpleJdkRegexpMethodPointcut();
        simpleJdkRegexpMethodPointcut.execute();

        SimpleAspectJExpressionPointcut simpleAspectJExpressionPointcut = new SimpleAspectJExpressionPointcut();
        simpleAspectJExpressionPointcut.execute();

        SimpleAnnotationMatchingPointcut simpleAnnotationMatchingPointcut = new SimpleAnnotationMatchingPointcut();
        simpleAnnotationMatchingPointcut.execute();

        System.out.print("\n\n---ADVISOR---");

        UnionSimpleNameMatchMethodPointcutAdvisor unionSimpleNameMatchMethodPointcutAdvisor = new UnionSimpleNameMatchMethodPointcutAdvisor();
        unionSimpleNameMatchMethodPointcutAdvisor.execute();

        System.out.print("\n\n---ADVANCED POINTCUTS---");

        AdvancedControlFlowPointcut advancedControlFlowPointcut = new AdvancedControlFlowPointcut();
        advancedControlFlowPointcut.execute();

        AdvancedComposablePointcut advancedComposablePointcut = new AdvancedComposablePointcut();
        advancedComposablePointcut.execute();
    }

    public static void introductions() {
        System.out.println("\n\n---INTRODUCTIONS---");

        Contact contact = new Contact();
        contact.execute();
    }

    public static void configuration() {
        System.out.println("\n---CONFIGURATION---");

        Configuration_A configuration_a = new Configuration_A();
        configuration_a.execute();

        Configuration_B configuration_B = new Configuration_B();
        configuration_B.execute();

        Configuration_C configuration_C = new Configuration_C();
        configuration_C.execute();

        Configuration_D configuration_D = new Configuration_D();
        configuration_D.execute();

        Configuration_E configuration_E = new Configuration_E();
        configuration_E.execute();

        Configuration_F configuration_F = new Configuration_F();
        configuration_F.execute();
    }
}