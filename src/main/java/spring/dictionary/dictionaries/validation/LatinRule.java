package spring.dictionary.dictionaries.validation;

@LatinValidation
public class LatinRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[a-zA-Z]+");
    }
}