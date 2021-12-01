package ben.desmedt.springdemopet;

import ben.desmedt.springdemopet.models.*;
import ben.desmedt.springdemopet.repositories.*;
import ben.desmedt.springdemopet.utils.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDemoPetApplication {


    public static void main(String[] args) {
        var context = SpringApplication.run(SpringDemoPetApplication.class, args);

        generateData(context);
    }

    private static void generateData(ConfigurableApplicationContext context) {
        var categories = context
                .getBean(CategoryRepository.class)
                .saveAll(DataFactory.getCategories());

        var tags = context
                .getBean(TagRepository.class)
                .saveAll(DataFactory.getTags());


        var pets = context
                .getBean(PetRepository.class)
                .saveAll(DataFactory.getPets(tags, categories));

        var users = context
                .getBean(UserRepository.class)
                .saveAll(DataFactory.getUsers());

        categories.forEach(System.out::println);
        tags.forEach(System.out::println);
        pets.forEach(System.out::println);
        users.forEach(System.out::println);
    }

}
