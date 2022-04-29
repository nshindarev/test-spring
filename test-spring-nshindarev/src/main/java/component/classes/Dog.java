package component.classes;

import component.interfaces.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("dogBean")
public class Dog implements Pet {


    public Dog(){
        log.info("dog has been created");
    }

    @Override
    public void voice() {
        log.info ("Wuf wuf");
    }
}
