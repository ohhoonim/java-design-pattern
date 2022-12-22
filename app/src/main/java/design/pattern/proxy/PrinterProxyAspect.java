package design.pattern.proxy;

import design.pattern.proxy.aspect.Aspect;

public class PrinterProxyAspect implements Printable, Aspect {

    private String name;

    public PrinterProxyAspect(String name) {
        this.name = name;
    }

    @Override
    public String render(String message) {
        before();
        Printer printer = new Printer(this.name);
        String renderedChars = printer.render(message);
        after();
        return renderedChars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void before() {
        System.out.println("프린터 시작: " + System.nanoTime());
    }

    @Override
    public void after() {
        System.out.println("프린터 종료: " + System.nanoTime());
    }

}
