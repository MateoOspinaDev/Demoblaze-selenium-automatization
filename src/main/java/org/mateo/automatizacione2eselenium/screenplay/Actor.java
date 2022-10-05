package org.mateo.automatizacione2eselenium.screenplay;

import org.mateo.automatizacione2eselenium.utils.DriverFactory;

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
        Actors.onStage(name);
        Arrays.stream(actions).forEach(action -> action.perform(DriverFactory.getDriver()));
    }

    public void shouldSee(Question... questions){
        Actors.onStage(name);
        Arrays.stream(questions).forEach(action -> action.answeredBy(DriverFactory.getDriver()));
    }

    public Action[] seeThat(Action... actions){
        return actions;
    }


}
