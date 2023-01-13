package design.pattern.decorator;

public class TitleDashDeco  extends TitleDeco {

    public TitleDashDeco(Title title) {
        super(title);
    }

    @Override
    public void setTitle(String title) {
        super.title.setTitle(title);        
    }

    @Override
    public String display() {
        return "--"+super.title.display() + "--";
    }
    
}
