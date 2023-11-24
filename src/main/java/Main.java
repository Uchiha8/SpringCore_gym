import configuration.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.Facade;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Facade facade = context.getBean(Facade.class);
        //facade.TraineeCRUD();
        //facade.readAll();
        //System.out.println(facade.readAll());
        facade.readAll();

    }
}
