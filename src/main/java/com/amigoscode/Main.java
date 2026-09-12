package com.amigoscode;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication

public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

// Java Objects to JSON Objects Example
    /* @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse("Hello",
                List.of("Java", "Golang", "Javascript"),
                new Person("Alex", 28, 30_000),
                new Number(List.of(2,5,7,3)
                )
        );
        return response;
    }

    record Person(String name, int age, double savings){

    }

    record Number(List<Integer> numbers){

    }

    record GreetResponse(String v_greet,
                         List<String> favProgrammingLanguages,
                         Person person,
                         Number number){} */


}
