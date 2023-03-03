package propLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropLoader {
    public static String getPropertyByName(String propName){
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/IvanovProject.properties");
            prop.load(fis);
        } catch (IOException e){
            System.out.println("Переменная не найдена");
            System.out.println(e.getMessage());
        }
        return String.valueOf(prop.get(propName));
    }
}