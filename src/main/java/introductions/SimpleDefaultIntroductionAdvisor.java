package introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class SimpleDefaultIntroductionAdvisor extends DefaultIntroductionAdvisor{

    public SimpleDefaultIntroductionAdvisor() {
        super(new SimpleDelegatingIntroductionInterceptor());
    }
}