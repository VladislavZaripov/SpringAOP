package introductions;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void execute(){
        Contact target = new Contact();
        target.setName("Vlad");

        IntroductionAdvisor advisor = new SimpleDefaultIntroductionAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setOptimize(true);

        Contact proxy = (Contact) proxyFactory.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Tatyana");
        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Eric Clapton");
        System.out.println("Has been modified?: " + proxyInterface.isModified() );
    }
}