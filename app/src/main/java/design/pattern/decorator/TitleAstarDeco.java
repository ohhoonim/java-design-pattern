package design.pattern.decorator;

public class TitleAstarDeco extends TitleDeco {

    public TitleAstarDeco(Title title) {
        super(title);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String display() {
       return "**" + super.title.display() + "**"; 
    }

}
