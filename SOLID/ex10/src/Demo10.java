public class Demo10 {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        ReportService service = new ReportService(consoleLogger);
        service.generate();

        // for testing
        Logger mockLogger = new Logger() {
            @Override
            public void log(String msg) {
                System.out.println("[MOCK] " + msg);
            }
        };
        new ReportService(mockLogger).generate();
    }
}
