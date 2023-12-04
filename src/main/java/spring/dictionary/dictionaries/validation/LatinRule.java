package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

@Component("latinRule")
public class LatinRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[a-zA-Z]+");
    }
}