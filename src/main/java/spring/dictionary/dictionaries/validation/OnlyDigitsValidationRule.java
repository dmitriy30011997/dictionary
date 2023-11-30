package spring.dictionary.dictionaries.validation;

public class OnlyDigitsValidationRule implements IValidationRule {
    @Override
    public boolean validate(String input) {
        return input.matches("\\d+");
    }
}
