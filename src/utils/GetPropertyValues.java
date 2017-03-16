package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 23878410v on 09/03/17.
 */
public class GetPropertyValues {
    InputStream inputStream;

    public String db_type;
    public String db_database;
    public String db_server;
    public int db_port;
    public String db_user;
    public String db_pass;
    public Boolean couch_createdb;
    public String couch_protocol;

    public GetPropertyValues() {
        try {
            getPropValues();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value
            db_type = prop.getProperty("db_type", "couch");
            db_database = prop.getProperty("db_database");
            db_server = prop.getProperty("db_server");
            db_port = Integer.parseInt(prop.getProperty("db_port"));
            db_user = prop.getProperty("db_user");
            db_pass = prop.getProperty("db_pass");
            couch_createdb = Boolean.parseBoolean(prop.getProperty("couch_createdb", "0"));
            couch_protocol = prop.getProperty("couch_protocol");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
