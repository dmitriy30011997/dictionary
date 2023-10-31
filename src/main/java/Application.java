public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryService dictionaryService = new DictionaryService(dictionary);

        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService);
        consoleMenu.run();
        consoleMenu.close();
    }
}