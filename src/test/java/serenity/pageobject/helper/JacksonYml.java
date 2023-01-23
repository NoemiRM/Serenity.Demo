package serenity.pageobject.helper;

import serenity.pageobject.model.yml.UserYml;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by NoemiRM on 16/01/23
 */
public class JacksonYml {
    public static String PATH_USER_FILE = "data/user/";
    public static UserYml USER_YML = null;

    public static void main(String[] args) throws IOException{

    }

    public static UserYml readUserYmlJackson(String folderPath, String fileName){
        String completePath = folderPath + fileName;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(completePath).getFile());
        com.fasterxml.jackson.databind.ObjectMapper om = new ObjectMapper(new YAMLFactory());

        try{
            USER_YML = om.readValue(file, UserYml.class);
        } catch (IOException e){
            e.printStackTrace();
        }

        return USER_YML;
    }

}
