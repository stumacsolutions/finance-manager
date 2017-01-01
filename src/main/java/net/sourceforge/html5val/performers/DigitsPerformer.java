package net.sourceforge.html5val.performers;

import net.sourceforge.html5val.ValidationPerformer;
import org.thymeleaf.dom.Element;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

import static net.sourceforge.html5val.performers.DigitsRegexpComposer.forDigits;

public class DigitsPerformer implements ValidationPerformer<Digits> {

    public Class<Digits> getConstraintClass() {
        return Digits.class;
    }

    public void putValidationCodeInto(Digits digits, Element element) {
        element.setAttribute("pattern", forDigits(digits).regexp());
        element.setAttribute("step", BigDecimal.valueOf(1, digits.fraction()).toString());
    }
}
