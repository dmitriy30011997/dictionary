import java.util.Scanner;

public class ConsoleMenu {
    DictionaryRepository dictionaryRepository = new DictionaryRepository();
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
            System.out.println("Меню команд:");
            System.out.println("1. Выбрать словарь (1 или 2)");
            System.out.println("2. Показать все записи со словарей");
            System.out.println("3. Выйти");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainChoice == 1) {
                chooseDictionary();
            } else if (mainChoice == 2) {
                dictionaryService.viewDictionaryContents();
            } else if (mainChoice == 3) {
                exit = true;
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    public void chooseDictionary() {
        System.out.print("Выберите словарь (1 или 2): ");
        int dictionaryChoice = scanner.nextInt();
        scanner.nextLine();

        if (dictionaryChoice == 1) {
            dictionaryService.setActiveDictionary(dictionaryService.getDictionary1());
            dictionaryFunctions();
        } else if (dictionaryChoice == 2) {
            dictionaryService.setActiveDictionary(dictionaryService.getDictionary2());
            dictionaryFunctions();
        } else {
            System.out.println("Неверный выбор словаря.");
        }
    }

    public void dictionaryFunctions() {
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
                    dictionaryService.add(key, value, dictionaryService.getActiveDictionaryLanguage());
                    break;
                case 2:
                    System.out.print("Введите ключ для удаления: ");
                    String keyToDelete = scanner.nextLine();
                    dictionaryService.delete(keyToDelete, dictionaryService.getActiveDictionaryLanguage());
                    break;
                case 3:
                    String dictionaryContents = dictionaryService.viewDictionaryContents();
                    System.out.println(dictionaryContents);
                    break;
                case 4:
                    fileService.writeToFile(dictionaryRepository.getDictionary1());
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
