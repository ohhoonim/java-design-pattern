package design.pattern.proxy;

public class Printer implements Printable {
    private String name;

    public Printer(String name) {
        this.name = name;
    }

    public String render(String message) {
        return startTag() + message + endTag();
    }

    public String getName() {
        return this.name;
    }

    private String startTag() {
        return "<" + name + ">";
    }
    private String endTag() {
        return "</" + name + ">";
    }

}
