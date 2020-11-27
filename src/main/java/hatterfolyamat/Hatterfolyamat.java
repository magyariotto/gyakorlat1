package hatterfolyamat;

public class Hatterfolyamat implements Runnable{
    public void run(){
        try{
            Thread.sleep(3000);
            System.out.println("En vagyok a hatterfolyamat.");
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
