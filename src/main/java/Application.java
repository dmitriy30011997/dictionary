public class Application {
    public static void main(String[] args) {
        FileService latinFileService = new FileService("src/main/latinDictionary.txt");
        FileService digitFileService = new FileService("src/main/digitDictionary.txt");

        LatinDictionaryRepository latinDictionaryRepository = new LatinDictionaryRepository(latinFileService.readFromFile("src/main/latinDictionary.txt"));
        DigitDictionaryRepository digitDictionaryRepository = new DigitDictionaryRepository(digitFileService.readFromFile("src/main/digitDictionary.txt"));

        ConsoleMenu consoleMenu = new ConsoleMenu(latinDictionaryRepository, digitDictionaryRepository, latinFileService, digitFileService);

        consoleMenu.run();

        consoleMenu.close();
    }
}
