import configuration.AppConfiguration;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.Facade;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Facade facade = context.getBean(Facade.class);
        for (User e : facade.readAllUser()) {
            System.out.println(e.toString());
        }
    }
}
