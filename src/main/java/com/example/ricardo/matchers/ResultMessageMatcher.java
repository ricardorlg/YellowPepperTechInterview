package com.example.ricardo.matchers;

import com.example.ricardo.model.ResultMessage;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ResultMessageMatcher extends TypeSafeMatcher<ResultMessage> {

    private final ResultMessage expectedResult;

    ResultMessageMatcher(ResultMessage expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    protected boolean matchesSafely(ResultMessage actual) {
        return (actual.getTittle().equals(expectedResult.getTittle()) && actual.getMessage().contains(expectedResult.getMessage()));
    }

    @Override
    public void describeTo(Description description) {

        description.appendText("Expected ").appendText(expectedResult.toString());
    }

    @Override
    protected void describeMismatchSafely(ResultMessage item, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendText(item.toString());
    }

    @Override
    public String toString() {
        return "a "+expectedResult.toString();
    }
}
