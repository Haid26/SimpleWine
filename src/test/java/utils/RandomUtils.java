package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomBeer() {
        return faker.beer().name();
    }

    public String getRandomRealVine() {
        return faker.options().option("Asti", "пиво", "prosecco");
    }

    public int getRandomAmount() {
        return faker.number().numberBetween(1, 5);
    }
}
