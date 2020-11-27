package hatterfolyamat;

public class Application {
    public static void main(String[] args){
        Thread ujThread = new Thread(new Hatterfolyamat());
        ujThread.start();
        System.out.println("A folyamatot elinditottam.");

    }
}