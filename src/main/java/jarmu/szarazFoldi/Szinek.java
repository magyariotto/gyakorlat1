package jarmu.szarazFoldi;

public enum Szinek {
    Zold("Zold"),
    Kek("Kek"),
    Sarga("Sarga"),
    Piros("Piros");

    Szinek(String ertek){
        this.ertek = ertek;
    }

    private final String ertek;

    public String getErtek(){
        return  ertek;
    }
}
