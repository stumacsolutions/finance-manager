package net.sourceforge.html5val.performers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.thymeleaf.dom.Element;

import javax.validation.constraints.Digits;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DigitsPerformerTest
{
    @InjectMocks
    private DigitsPerformer performer;

    @Test
    public void shouldPerformForDigitsAnnotation()
    {
        assertEquals(Digits.class, performer.getConstraintClass());
    }

    @Test
    public void shouldSetPatternAttributeOnElement() throws NoSuchFieldException
    {
        Element element = perform();
        String expectedPattern = "([0-9]{1,6}\\.?|\\.[0-9]{1,2}|[0-9]{1,6}\\.[0-9]{1,2}){1}";
        assertEquals(expectedPattern, element.getAttributeValue("pattern"));
    }

    @Test
    public void shouldSetStepAttributeOnElement() throws NoSuchFieldException
    {
        Element element = perform();
        String expectedStep = "0.01";
        assertEquals(expectedStep, element.getAttributeValue("step"));
    }

    private Element perform() throws NoSuchFieldException
    {
        Field field = TestClass.class.getField("testField");
        Digits annotation = field.getAnnotation(Digits.class);
        Element element = new Element("");
        performer.putValidationCodeInto(annotation, element);
        return element;
    }

    private static final class TestClass
    {
        @Digits(integer = 6, fraction = 2)
        public BigDecimal testField;
    }
}
