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
        List<Category> categories = context
                .getBean(CategoryRepo.class)
                .saveAll(DataFactory.getCategories());

        List<Tag> tags = context
                .getBean(TagRepo.class)
                .saveAll(DataFactory.getTags());


        List<Pet> pets = context
                .getBean(PetRepo.class)
                .saveAll(DataFactory.getPets(tags, categories));

        List<User> users = context
                .getBean(UserRepo.class)
                .saveAll(DataFactory.getUsers());

        categories.forEach(System.out::println);
        tags.forEach(System.out::println);
        pets.forEach(System.out::println);
        users.forEach(System.out::println);
    }

}
