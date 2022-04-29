package component.classes;

import component.interfaces.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("personBean")
public class Person {

    @Value("${person.age}")
    private Integer age;

    @Value("${person.surname}")
    private String surname;


    private Pet myPet;

    public Person (){
    }

    public void callMyPet(){

        log.info("=== voice ===");
        myPet.voice();
    }

    @Autowired
    @Qualifier("catBean")
    public void setMyPet(Pet myPet){
        this.myPet = myPet;
    }

}
