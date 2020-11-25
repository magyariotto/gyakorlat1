package Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String allapot;

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void setAllapot(String allapot){
        this.allapot = allapot;
        for(Observer observer : observers){
            observer.observe(this);
        }
    }

    public String getAllapot(){
        return allapot;
    }

    @Override
    public String toString(){
        return "En vagyok a targy.";
    }
}
