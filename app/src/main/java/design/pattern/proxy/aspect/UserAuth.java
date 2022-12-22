package design.pattern.proxy.aspect;

public class UserAuth implements Aspect {

    @Override
    public void before() {
       System.out.println("당신의 권한은 ... 체크 시작"); 
        
    }

    @Override
    public void after() {
       System.out.println("..........."); 
    }
    
}
