package spring.dictionary.dictionaries.validation;

public class LatinCharactersValidationRule implements IValidationRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
