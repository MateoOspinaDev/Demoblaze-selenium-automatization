package org.mateo.automatizacione2eselenium.screenplay.actor;

import java.util.HashMap;

public class ActorsLogic {
    private static HashMap<String, Actor> actorsMap;
    private static String lastNameActor = "";

    private ActorsLogic() {
    }

    public static Actor theActorCalled(String name){
        Actor actor = new Actor(name);
        ActorsLogic.registerActor(actor);
        return actor;
    }

    public static void onStage(String name) {
        lastNameActor = name;
    }

    public static void registerActor(Actor actor){
        createHashMapIfRequired();
        actorsMap.put(actor.getName(), actor);
    }

    public static Actor theActorInTheSpotlight(){
        createHashMapIfRequired();
        return actorsMap.get(lastNameActor);
    }

    private static void createHashMapIfRequired() {
        if(actorsMap == null){
            actorsMap = new HashMap<>();
        }
    }


}
