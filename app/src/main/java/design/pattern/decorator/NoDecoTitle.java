package design.pattern.decorator;

public class NoDecoTitle implements Title {
    private String title;
    @Override
    public void setTitle(String title) {
       this.title = title; 
    }

    @Override
    public String display() {
        return this.title;
    }
    
}
