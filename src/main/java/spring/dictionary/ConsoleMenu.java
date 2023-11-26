package spring.dictionary;

import spring.dictionary.dictionaries.serveces.IDictionaryService;
import spring.dictionary.synonyms.services.ISynonymService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsoleMenu {
    private final Map<Integer, IDictionaryService> services;
    private final Map<Integer, ISynonymService> synonymServices;
    private final Scanner scanner;

    public ConsoleMenu(List<IDictionaryService> servicesList, List<ISynonymService> synonymServicesList) {
        this.services = servicesList.stream()
                .collect(Collectors.toMap(IDictionaryService::getType, Function.identity()));
        this.synonymServices = synonymServicesList.stream()
                .collect(Collectors.toMap(ISynonymService::getType, Function.identity()));
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню команд:");
            System.out.println("1. Выбрать словарь (1 или 2)");
            System.out.println("2. Показать все записи со словарей");
            System.out.println("3. Поработать с синонимами");
            System.out.println("4. Выйти");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();
            switch (mainChoice) {
                case 1:
                    chooseDictionary();
                case 2:
                    viewAllDictionaryContents();
                case 3:
                    chooseSynonym();
                case 4:
                    exit = true;
                    close();
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private void chooseSynonym() {
        System.out.print("Выберите словарь синонимов (1 - латинский, 2 - цифровой): ");
        int synonymChoice = scanner.nextInt();
        scanner.nextLine();

        ISynonymService selectedService = synonymServices.get(synonymChoice);
        if (selectedService != null) {
            synonymFunctions(selectedService);
        } else {
            System.out.println("Неверный выбор словаря.");
        }
    }

    private void viewAllDictionaryContents() {
        services.values()
                .forEach((IDictionaryService service) -> System.out.println(service.viewDictionaryContents()));
    }

    private void chooseDictionary() {
        System.out.print("Выберите словарь (1 - латинский, 2 - цифровой): ");
        int dictionaryChoice = scanner.nextInt();
        scanner.nextLine();

        IDictionaryService selectedService = services.get(dictionaryChoice);
        if (selectedService != null) {
            dictionaryFunctions(selectedService);
        } else {
            System.out.println("Неверный выбор словаря.");
        }
    }

    private void synonymFunctions(ISynonymService service) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню команд для выбранного словаря:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Удалить запись");
            System.out.println("3. Показать синонимы к слову");
            System.out.println("4. Выход в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите слово, к которому нужно добавить синоним:");
                    String word = scanner.nextLine();

                    System.out.println("Введите синоним:");
                    String synonym = scanner.nextLine();

                    service.addSynonym(word, synonym);
                    break;
                case 2:
                    System.out.print("Введите ключ для удаления: ");
                    String keyToDelete = scanner.nextLine();
                    service.deleteSynonym(keyToDelete);
                    break;
                case 3:
                    System.out.println("Введите слово, для которого нужно показать все синонимы:");
                    String synword = scanner.nextLine();

                    List<String> synonyms = service.getSynonyms(synword);
                    if (synonyms.isEmpty()) {
                        System.out.println("Нет синонимов для данного слова.");
                    } else {
                        System.out.println("Синонимы для слова '" + synword + "':");
                        synonyms.forEach(System.out::println);
                    }
                    break;
                case 4:
                    exit = true;
            }
        }
    }

    private void dictionaryFunctions(IDictionaryService service) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню команд для выбранного словаря синонимов:");
            System.out.println("1. Добавить запись в словарь");
            System.out.println("2. Удалить запись");
            System.out.println("3. Показать содержимое всех словарей");
            System.out.println("4. Показать значение ключа");
            System.out.println("5. Выйти из словаря");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ключ: ");
                    String key = scanner.nextLine();
                    System.out.print("Введите значение: ");
                    String value = scanner.nextLine();
                    service.add(key, value);
                    break;
                case 2:
                    System.out.print("Введите ключ для удаления: ");
                    String synonym = scanner.nextLine();
                    service.delete(synonym);
                    break;
                case 3:
                    viewAllDictionaryContents();
                    break;
                case 4:
                    System.out.println("Введите ключ, значение которого надо найти");
                    String keyToFind = scanner.nextLine();
                    System.out.println(service.findEntry(keyToFind));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная команда для словаря. Попробуйте снова.");
            }

        }
    }
    public void close() {
        scanner.close();
    }
}