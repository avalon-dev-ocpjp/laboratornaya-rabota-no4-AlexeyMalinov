package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(100);

        //Выполнить поиск самого дорого товара
        OptionalDouble maxPrice = commodities.stream()
                .mapToDouble(Commodity::getPrice)
                .max();

        //Найти товары с минимальным остатком
        int minResidue = commodities.stream()
                .mapToInt(Commodity::getResidue)
                .min()
                .orElseThrow(IllegalStateException::new);

        //Найти товар, с самым длинным названием и вывести его на экран
        int maxNameLength = commodities.stream()
                .mapToInt(commodity -> commodity.getName().length())
                .max()
                .orElseThrow(IllegalStateException::new);

        //Выполнить сортировку коллекции commodities
        commodities.stream().sorted();

        for (Commodity commodity : commodities) {

            if (maxPrice.equals(commodity.getPrice())) {
                System.out.println("Максимальная стоимость у " + commodity.getName());
            }
            if (minResidue == commodity.getResidue()) {
                System.out.println("Минимальный остаток у " + commodity.getName());
            }
            if (maxNameLength == commodity.getName().length()) {
                System.out.println("Максимальная длина имени у " + commodity.getName());
            }

        }

        //Найти моду (медиану) стоимости товаров
        double[] array = commodities.stream().mapToDouble(Commodity::getPrice).sorted().toArray();
        double mediana = getMedian(array);
        System.out.println("Медиана стоимости товара: " + mediana);

        //Найти среднюю стоимость товаров
        OptionalDouble average = commodities.stream().mapToDouble(Commodity::getPrice).average();
        System.out.println("Средняя стоимсоть товара: " + average.getAsDouble());

        //Найти товары с остатком меньшим 5 и вывести в консоль их названия
        System.out.println("commodity with residue <= 5:");
        commodities.stream().filter(commodity -> commodity.getResidue() <= 5).map(Commodity::getName).forEach(System.out::println);

        //Подсчитать общую стоимость товаров с учётом их остатка
        double allPrice = commodities.stream().mapToDouble(commodity -> commodity.getPrice() * commodity.getResidue()).sum();
        System.out.println("Общая стоимость товара: " + allPrice);

        /*
         * (Студент): С использованием Java Stream API выполнить задачи из списка:
         * 1. Выполнить поиск самого дорого товара
         * 2. Найти товары с минимальным остатком
         * 3. Найти товары с остатком меньшим 5 и вывести в консоль их названия
         * 4. Подсчитать общую стоимость товаров с учётом их остатка
         * 5. Найти товар, с самым длинным названием и вывести его на экран
         * 6. Выполнить сортировку коллекции commodities
         * 7. Найти среднюю стоимость товаров
         * 8. Найти моду (медиану) стоимости товаров
         */
    }

    static double getMedian(double[] array) {
        if (array.length % 2 == 0) {
            return Arrays.stream(array)
                    .sorted()
                    .skip(array.length / 2 - 1)
                    .limit(2)
                    .average()
                    .orElseThrow(IllegalStateException::new);
                    
           
        } else {
            return Arrays.stream(array)
                    .sorted()
                    .skip(array.length / 2)
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
        }
    }
}
