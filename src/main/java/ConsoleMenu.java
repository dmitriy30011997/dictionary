import java.util.Scanner;
public class ConsoleMenu {
    private DictionaryService dictionaryService;
    private Scanner scanner;

    public ConsoleMenu(DictionaryService dictionaryService, DictionaryFileReader fileReader) {
        this.dictionaryService = dictionaryService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
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
                    dictionaryService.add(key, value);
                    break;
                case 2:
                    System.out.print("Введите ключ для удаления: ");
                    String keyToDelete = scanner.nextLine();
                    dictionaryService.delete(keyToDelete);
                    break;
                case 3:
                    System.out.print("Введите ключ для поиска: ");
                    String keyToFind = scanner.nextLine();
                    String translation = dictionaryService.find(keyToFind);
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