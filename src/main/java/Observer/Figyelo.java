package Observer;

public class Figyelo implements Observer{
    @Override
    public void observe(Subject subject){
        System.out.println(subject + " allapota megvaltozott.Az uj allapot: " + subject.getAllapot());
    }
}
