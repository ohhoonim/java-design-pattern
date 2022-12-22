package design.pattern.proxy.aspect;

public class Logging implements Aspect {

    @Override
    public void before() {
       System.out.println("start printing..." + System.nanoTime()); 
    }

    @Override
    public void after() {
       System.out.println("printed" + System.nanoTime()); 
        
    }
    
}
