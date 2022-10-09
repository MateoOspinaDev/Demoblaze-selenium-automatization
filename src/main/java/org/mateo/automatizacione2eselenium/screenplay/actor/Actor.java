package org.mateo.automatizacione2eselenium.screenplay.actor;

import org.mateo.automatizacione2eselenium.screenplay.actions.Action;
import org.mateo.automatizacione2eselenium.screenplay.questions.Question;
import org.mateo.automatizacione2eselenium.driver.DriverFactory;

import java.util.Arrays;

public class Actor {
    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attemptsTo(Action... actions){
        wasAbleTo(actions);
    }

    public void wasAbleTo(Action... actions){
        ActorsLogic.onStage(name);
        Arrays.stream(actions).forEach(action -> action.perform(DriverFactory.getDriver()));
    }

    public void shouldSee(Question... questions){
        ActorsLogic.onStage(name);
        Arrays.stream(questions).forEach(action -> action.answeredBy(DriverFactory.getDriver()));
    }

    public Action[] seeThat(Action... actions){
        return actions;
    }


}
