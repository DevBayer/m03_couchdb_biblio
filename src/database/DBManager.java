package database;
import org.lightcouch.CouchDbClient;
import utils.GetPropertyValues;

/**
 * Created by 23878410v on 09/03/17.
 */
public class DBManager {
    public Database connection;

    public DBManager(GetPropertyValues properties) {
        if(properties.db_type.equals("couch")){
            connection = new MyCouch(new CouchDbClient(properties.db_database, properties.couch_createdb, properties.couch_protocol, properties.db_server, properties.db_port, properties.db_user, properties.db_pass));
        }else{
            System.out.println("The SGBD "+properties.db_type+" isn't configured.");
            System.exit(1);
        }
    }
}
