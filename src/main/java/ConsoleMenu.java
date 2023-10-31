import java.util.Scanner;

public class ConsoleMenu {
    private DictionaryService dictionaryService;
    private FileService fileService;
    private Scanner scanner;

    public ConsoleMenu(DictionaryService dictionaryService, FileService fileService) {
        this.dictionaryService = dictionaryService;
        this.fileService = fileService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите словарь:");
            System.out.println("1. Словарь 1");
            System.out.println("2. Словарь 2");
            System.out.println("3. Выйти");

            int dictionaryChoice = scanner.nextInt();
            scanner.nextLine();

            if (dictionaryChoice == 1) {
                dictionaryService.setActiveDictionary(dictionaryService.getDictionary1());
            } else if (dictionaryChoice == 2) {
                dictionaryService.setActiveDictionary(dictionaryService.getDictionary2());
            } else if (dictionaryChoice == 3) {
                exit = true;
                continue;
            } else {
                System.out.println("Неверный выбор словаря.");
                continue;
            }

            System.out.println("Меню команд:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Удалить запись");
            System.out.println("3. Найти запись");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ключ: ");
                    String key = scanner.nextLine();
                    System.out.print("Введите значение: ");
                    String value = scanner.nextLine();
                    dictionaryService.add(key, value, dictionaryChoice);
                    break;
                case 2:
                    System.out.print("Введите ключ для удаления: ");
                    String keyToDelete = scanner.nextLine();
                    dictionaryService.delete(keyToDelete, dictionaryChoice);
                    break;
                case 3:
                    System.out.print("Введите ключ для поиска: ");
                    String keyToFind = scanner.nextLine();
                    String translation = dictionaryService.find(keyToFind, dictionaryChoice);
                    if (translation != null) {
                        System.out.println("Перевод: " + translation);
                    } else {
                        System.out.println("Запись не найдена.");
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
