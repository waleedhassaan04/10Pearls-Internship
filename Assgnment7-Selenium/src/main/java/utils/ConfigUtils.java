package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {

    static public Properties getProps(String filename) {
        Properties myProp = new Properties();
        try{
            File propfile = new File("src/test/resources/"+filename+".properties");
            if(propfile.exists())
           myProp.load(new FileInputStream(propfile));
       else
           System.out.println("File doesnot exist or found");
        }
        catch(Exception e){
            e.printStackTrace();
    }
        return myProp;
    }
}
