package com.example.ricardo.interactions;

import com.example.ricardo.model.YellowPeperUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActivateScreen implements Interaction {
    private final Target target;
    public ActivateScreen(Target target) {
        this.target = target;
    }
    @Step("{0} Unlock app")
    public <T extends Actor> void performAs(T theUser) {
        target.resolveFor(theUser).click();
    }



    public static Interaction activatesScreen(Target target) {
        return instrumented(ActivateScreen.class,target);
    }

}
