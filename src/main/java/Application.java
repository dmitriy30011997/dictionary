public class Application {
    public static void main(String[] args) {
        FileService latinFileService = new FileService("src/main/latinDictionary.txt");
        FileService digitFileService = new FileService("src/main/digitDictionary.txt");

        DictionaryRepository latinDictionaryRepository = new DictionaryRepository(latinFileService.readFromFile("src/main/latinDictionary.txt"));
        DictionaryRepository digitDictionaryRepository = new DictionaryRepository(digitFileService.readFromFile("src/main/digitDictionary.txt"));

        ConsoleMenu consoleMenu = new ConsoleMenu(latinDictionaryRepository, digitDictionaryRepository, latinFileService, digitFileService);

        consoleMenu.run();

        consoleMenu.close();
    }
}
