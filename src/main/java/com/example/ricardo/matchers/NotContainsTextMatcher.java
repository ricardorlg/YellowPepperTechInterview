package com.example.ricardo.matchers;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.matchers.statematchers.WebElementStateDescription;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class NotContainsTextMatcher<T extends WebElementState> extends TypeSafeMatcher<T> {

    private final String expectedText;

    public NotContainsTextMatcher(String expectedText) {
        this.expectedText = expectedText;
    }
    @Override
    protected boolean matchesSafely(T element) {
        return !element.containsText(expectedText);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an element not containing '").appendText(expectedText).appendText("'");
    }

    @Override
    protected void describeMismatchSafely(T item, Description mismatchDescription) {
        mismatchDescription.appendText(" was ").appendText(WebElementStateDescription.forElement(item)).appendText(" containing text '").appendText(item.getTextValue());
    }
}
