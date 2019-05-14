package com.klezovich.demo.repository;

import com.klezovich.demo.model.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {


    default Greeting getRandomGreeting() {

        return new Greeting("Hola");
    }
}
