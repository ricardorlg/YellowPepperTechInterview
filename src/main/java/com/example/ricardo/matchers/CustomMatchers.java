package com.example.ricardo.matchers;

import com.example.ricardo.model.ResultMessage;
import net.serenitybdd.core.pages.WebElementState;
import org.hamcrest.Matcher;

public class CustomMatchers {

    public static ResultMessageMatcher successfulRegistration(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().successfulRegistrationResult());
    }
    public static ResultMessageMatcher unSuccessfulRegistrationMissingUserName(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().missingUserNameRegistrationResult());
    }
    public static ResultMessageMatcher unSuccessfulRegistrationMissingPassword(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().missingPasswordRegistrationResult());
    }
    public static ResultMessageMatcher unSuccessfulRegistrationUsernameUsed(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().errorWithRegistrationUsernameInUse());
    }
    public static <T extends WebElementState> Matcher<T> notContainsText(String expectedText) {
        return new NotContainsTextMatcher<>(expectedText);
    }
    public static ResultMessageMatcher successfulLoginResult(String actorName){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().successfulLoginResult(actorName));
    }
    public static ResultMessageMatcher unSuccessfulLoginResultMissingUsername(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().missingUserNameLoginResult());
    }
    public static ResultMessageMatcher unSuccessfulLoginResultMissingPassword(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().missingPasswordLoginResult());
    }
    public static ResultMessageMatcher unSuccessfulLoginResultBadCredentials(){
        return new ResultMessageMatcher(new ResultMessage.ResultMessagesBuilder().invalidLoginCredentials());
    }

}
