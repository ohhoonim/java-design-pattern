package design.pattern.decorator;

public abstract class TitleDeco implements Title {
    protected Title title;

    public TitleDeco(Title title) {
        this.title = title;
    }

     public void setTitle(String title) {
        this.title.setTitle(title);
     }
    abstract public String display() ;

}
