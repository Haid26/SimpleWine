package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public static String getRandomBeer(){
        return faker.beer().name();
    }

    public static String getRandomRealVine(){
        return faker.options().option("Asti", "Шампанское", "prosecco");
    }

    public static int getRandomAmount(){
        return faker.number().numberBetween(1,101);
    }
}
