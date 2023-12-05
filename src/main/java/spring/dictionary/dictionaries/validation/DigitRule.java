package spring.dictionary.dictionaries.validation;

public class DigitRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("\\d");
    }
}
