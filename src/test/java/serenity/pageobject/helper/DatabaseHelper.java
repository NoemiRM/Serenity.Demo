package serenity.pageobject.helper;


import net.serenitybdd.core.Serenity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by NoemiRM on 11/01/23
 */
public class DatabaseHelper {
    private static EntityManager manager;
    private static EntityManagerFactory emFact;

    public static void main(String[] args){

    }

    public static void get_user_data(String ymlUserFile){
        JacksonYml.readUserYmlJackson(JacksonYml.PATH_USER_FILE,ymlUserFile);
        Serenity.setSessionVariable("user_data").to(JacksonYml.USER_YML);
        System.out.println("hi");

    }

}
