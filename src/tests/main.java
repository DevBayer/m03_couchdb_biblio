package tests;

import org.lightcouch.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 23878410v on 09/03/17.
 */
public class main {
    public static void main(String[] args) {

        CouchDbClient dbClient = new CouchDbClient("test", true, "http", "127.0.0.1", 5984, "lbayer", "lbayer");

        Foo foo = new Foo(); // Plain Java Object

        Response response = dbClient.save(foo);

        foo.id = response.getId();
        foo.rev = response.getRev();

        Map<String, Object> map = new HashMap<>();
        map.put("_id", "doc-id1234");
        map.put("title", "value");
        //Response response2 = dbClient.save(map);
        //System.out.println(response2.toString());

//        tests.Foo foo123 = dbClient.find(tests.Foo.class, "doc-id1234");

//        dbClient.update(foo);

//        dbClient.remove(foo123);

        boolean b = dbClient.contains("doc-id");

// views
        /*
        List<tests.Foo> list = dbClient.view("ddoc/by_date")
                .key("test")
                .includeDocs(true)
                .query(tests.Foo.class);

        long count = dbClient.view("ddoc/by_tag")
                .key("couchdb").queryForLong();
                */

        List<Foo> allDocs = dbClient.view("_all_docs").includeDocs(true).query(Foo.class);
        for (Foo f: allDocs) {
            System.out.println("("+f.id+") "+f.test);
            System.out.println(f.ja2);
        }


// attachments
        //Response response = dbClient.saveAttachment(inputStream, "photo.png", "image/png");
        //InputStream in = dbClient.find("doc-id/photo.png");
        //in.close();

// replication
        ReplicationResult replication = dbClient.replication()
                .source("source-db").target("target-db")
                .createTarget(true)
                .trigger();

// changes feed
        Changes changes = dbClient.changes()
                .includeDocs(true)
                .heartBeat(30000)
                .continuousChanges();

        while (changes.hasNext()) {
            ChangesResult.Row feed = changes.next();
        }

// shutdown the client
        dbClient.shutdown();

    }
}
