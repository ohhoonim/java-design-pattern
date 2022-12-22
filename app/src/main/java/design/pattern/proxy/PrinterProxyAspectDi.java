package design.pattern.proxy;

import java.util.List;
import design.pattern.proxy.aspect.Aspect;

public class PrinterProxyAspectDi implements Printable {

    private String name;
    private List<Aspect> aspects;

    public PrinterProxyAspectDi(String name, Aspect ...logging) {
        this.name = name;
        this.aspects = List.of(logging);
    }

    @Override
    public String render(String message) {
        Printer printer = new Printer(this.name);

        aspects.forEach(action -> action.before());
        String renderedChars = printer.render(message);
        aspects.forEach(action -> action.after());
        return renderedChars;
    }

    @Override
    public String getName() {
        return this.name;
    }
}