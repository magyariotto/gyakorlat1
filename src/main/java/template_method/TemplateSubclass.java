package template_method;

public class TemplateSubclass extends Template{
    @Override
    protected void lepesElott(){
        System.out.println("Felulirtuk a lepesElott metodust.");
    }

    @Override
    protected void lepesUtan(){
        System.out.println("Felulirtuk a lepesUtan metodust.");
    }
}
