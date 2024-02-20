package com.pact.pact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnimalsController {

    @GetMapping("/zooAnimals")
    public AnimalResponse getAnimals(@RequestParam(value = "name", defaultValue = "Chita") String name) {
        Zoo zoo = new Zoo("Ukumari", "Pereira");
        return new AnimalResponse("1", "gorilla", "black", name, zoo);
    }

    // AnimalResponse class representing the response structure
    public static class AnimalResponse {
        private final String id;
        private final String animal;
        private final String color;
        private final String name;
        private final Zoo zoo;

        public AnimalResponse(String id, String animal, String color, String name, Zoo zoo) {
            this.id = id;
            this.animal = animal;
            this.color = color;
            this.name = name;
            this.zoo = zoo;
        }

        public String getId() {
            return id;
        }

        public String getAnimal() {
            return animal;
        }

        public String getColor() {
            return color;
        }

        public String getName() {
            return name;
        }

        public Zoo getZoo() {
            return zoo;
        }
    }

    // Zoo class representing the embedded Zoo structure
    public static class Zoo {
        private final String name;
        private final String city;

        public Zoo(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }
    }
}

