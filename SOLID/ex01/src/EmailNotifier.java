public class EmailNotifier implements INotifier{

    @Override
    public void send(String to, String body) {
       System.out.println("[EMAIL to=" + to + "] " + body);
    }
    
}
