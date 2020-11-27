public class Doboz<T> {
    private T ertek;

    private Doboz(T ertek){
        this.ertek = ertek;
    }

    private static <E> Doboz<E> letrehoz(E ertek){
        return  new Doboz<E>(ertek);
    }

    public T getErtek(){
        return ertek;
    }

    public void setErtek(T ertek){
        this.ertek = ertek;
    }
}
