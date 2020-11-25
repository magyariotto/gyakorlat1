import Observer.Figyelo;
import Observer.Subject;
import adapter.Auto;
import adapter.AutoMoso;
import adapter.AutoMosoAdapter;
import adapter.Kocsi;
import builder.Dobokocka;
import builder.DobokockaBuilder;
import chain_of_responsibility.ElsoLepes;
import chain_of_responsibility.Lepes;
import chain_of_responsibility.MasodikLepes;
import decorator.AutoMosoSzarito;
import facade.AutoMosoFacade;
import proxy.AutoMosoProxy;
import strategy.Concatenator;
import strategy.Joiner;
import strategy.Osszefuzes;
import template_method.TemplateSubclass;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Dobokocka kocka = new Dobokocka(1, 56, 4, 5, 6, 4);
        Dobokocka epitettKocka = new DobokockaBuilder()
                .elsoOldal(2)
                .masodikOldal(4)
                .harmadikOldal(8)
                .negyedikOldal(16)
                .otodikOldal(32)
                .hatodikoldal(64)
                .build();

        //Adapter
        Kocsi kocsi = new Kocsi("Ferrari");
        AutoMosoAdapter autoMosoAdapter = new AutoMosoAdapter(new AutoMoso());
        autoMosoAdapter.mos(kocsi);

        //Decorator
        AutoMosoSzarito autoMosoSzarito = new AutoMosoSzarito(new AutoMoso());
        autoMosoSzarito.mos(new Auto("Toyota"));

        //Facade
        AutoMosoFacade autoMosoFacade = new AutoMosoFacade();
        autoMosoFacade.autoMosas(new Auto("Szuzuki"));
        autoMosoFacade.autoMosasEsSzaritas(new Auto("Lamborgimi"));
        autoMosoFacade.kocsiMosas(kocsi);

        //Proxy
        AutoMosoProxy autoMosoProxy = new AutoMosoProxy();
        for (int i = 0; i < 10; i++) {
            autoMosoProxy.mos(new Auto("KicsiKocsi"));
        }

        //Chain of responsibility
        List<Lepes> lepesek = Arrays.asList(new ElsoLepes(), new MasodikLepes());
        for (Lepes lepes : lepesek) {
            lepes.lep();
        }

        //Observer
        Figyelo figyelo = new Figyelo();
        Subject subject = new Subject();
        subject.addObserver(figyelo);
        subject.setAllapot("Uj allapot");

        //Strategy
        Osszefuzes osszefuzes = new Osszefuzes();
        List<String> darabok = Arrays.asList("ElsoSzo", "MasodikSzo");
        System.out.println(osszefuzes.osszefuz(darabok, new Concatenator()));
        System.out.println(osszefuzes.osszefuz(darabok, new Joiner()));

        //TemplateMethod
        new TemplateSubclass().businessLogika();
    }
}