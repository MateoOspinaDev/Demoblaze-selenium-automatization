package org.mateo.automatizacione2eselenium.utils;

public class Sleep {
    public static void sleep(){
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
