package design.pattern.proxy;

public class PrinterProxy implements Printable {

    private String name;

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public String render(String message) {
        // 기존 소스를 여기에 카피하는 것이 아니라
        // Printer 클래스의 render 함수를 호출 하고
        // 호출 전후로 로깅처리
        System.out.println("프린터 시작: " + System.nanoTime());

        Printer printer = new Printer(this.name);
        String renderedChars = printer.render(message); 

        System.out.println("프린터 종료: " + System.nanoTime());

        return renderedChars;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
