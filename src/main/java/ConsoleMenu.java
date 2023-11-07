import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private Map<Integer, DictionaryService> services = new HashMap<>();
    private DictionaryRepository dictionaryRepository;
    private FileService latinFileService;
    private FileService digitFileService;
    private Scanner scanner;

    public ConsoleMenu(DictionaryRepository latinDictionaryRepository, DictionaryRepository digitDictionaryRepository,
                       FileService latinFileService, FileService digitFileService) {
        this.latinFileService = latinFileService;
        this.digitFileService = digitFileService;

        services.put(1, new LatinDictionaryService(latinDictionaryRepository));
        services.put(2, new DigitDictionaryService(digitDictionaryRepository));

        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню команд:");
            System.out.println("1. Выбрать словарь (1 или 2)");
            System.out.println("2. Показать все записи со словарей");
            System.out.println("3. Выйти");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainChoice == 1) {
                chooseDictionary();
            } else if (mainChoice == 2) {
                viewAllDictionaryContents();
            } else if (mainChoice == 3) {
                exit = true;
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }
    private int dictionaryChoice;
    public void chooseDictionary() {
        System.out.print("Выберите словарь (1 - латинский, 2 - цифровой): ");
        int dictionaryChoice = scanner.nextInt();
        scanner.nextLine();

        DictionaryService selectedService = services.get(dictionaryChoice);
        if (selectedService != null) {
            dictionaryFunctions(selectedService);
        } else {
            System.out.println("Неверный выбор словаря.");
        }
    }
    public void viewAllDictionaryContents() {
        System.out.println("Содержимое латинского словаря:");
        String latinDictionaryContents = services.get(1).viewDictionaryContents();
        System.out.println(latinDictionaryContents);

        System.out.println("Содержимое цифрового словаря:");
        String digitDictionaryContents = services.get(2).viewDictionaryContents();
        System.out.println(digitDictionaryContents);
    }

    public void dictionaryFunctions(DictionaryService service) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню команд для выбранного словаря:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Удалить запись");
            System.out.println("3. Показать содержимое словарей");
            System.out.println("4. Выйти из словаря");

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
                    String keyToDelete = scanner.nextLine();
                    service.delete(keyToDelete);
                    break;
                case 3:
                    viewAllDictionaryContents();
                    break;
                case 4:
                    fileService.writeToFile(dictionaryRepository.getDictionary());
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
