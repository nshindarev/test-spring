package component.classes;

import component.interfaces.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("catBean")
@Slf4j
public class Cat implements Pet {


    public Cat(){
        log.info("cat has been created");
    }

    @Override
    public void voice() {
        log.info("Meow");
    }
}
