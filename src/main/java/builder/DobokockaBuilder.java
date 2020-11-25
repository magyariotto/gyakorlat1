package builder;

public class DobokockaBuilder {
    private Integer elsoOldal;
    private Integer masodikOldal;
    private Integer harmadikOldal;
    private Integer negyedikOldal;
    private Integer otodikOldal;
    private Integer hatodikOldal;

    public DobokockaBuilder() {

    }

    public DobokockaBuilder elsoOldal(Integer oldal) {
        elsoOldal = oldal;
        return this;
    }

    public DobokockaBuilder masodikOldal(Integer oldal) {
        masodikOldal = oldal;
        return this;
    }

    public DobokockaBuilder harmadikOldal(Integer oldal) {
        harmadikOldal = oldal;
        return this;
    }

    public DobokockaBuilder negyedikOldal(Integer oldal) {
        negyedikOldal = oldal;
        return this;
    }

    public DobokockaBuilder otodikOldal(Integer oldal) {
        otodikOldal = oldal;
        return this;
    }

    public DobokockaBuilder hatodikoldal(Integer oldal) {
        hatodikOldal = oldal;
        return this;
    }

    public Dobokocka build() {
        return new Dobokocka(elsoOldal, masodikOldal, harmadikOldal, negyedikOldal, otodikOldal, hatodikOldal);
    }
}
