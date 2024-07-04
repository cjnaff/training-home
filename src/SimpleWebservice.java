import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class SimpleWebservice {
    public static void main(String[] args) {
        try {

        Enrollment enrollment1 = new Enrollment("Commercial", "gold", "01/01/2022", "03/31/2022", 50);
        Enrollment enrollment2 = new Enrollment("Commercial", "silver","04/01/2022", "12/31/2022", 100);
        Enrollment enrollment3 = new Enrollment("State", "Tier1", "06/01/2023", "10/31/2023", 40);
        Enrollment[] enrollments = {enrollment1, enrollment2, enrollment3};

        ItemList list = new ItemList(enrollments);

            Routing routing = Routing.builder()
                    .get("/enrollments", list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws =  WebServer.create(config, routing);
            ws.start();
            /* take IP Address and port from "INFO: Channel '@default' started: [id: 0x090caf64, L:/10.5.0.2:8888] in
            console and in browser paste that + the pathPattern above to see the list. When browser request is sent
            to the server it executes the ItemList.accept() method, which is implementing the webserver Handler.
             */

            // call RandomName Rest API
            getRandomNamesRestAPI();

        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static void getRandomNamesRestAPI() {

        try {
            AsyncHttpClient client = new DefaultAsyncHttpClient();
//            client.prepare("GET", "https://randomuser.me/api?nat=US&results=5&format=csv&dl=&inc=name%2Cdob%2Cgender")
////            client.prepare("OPTIONS", "https://api.arcsecond.io/activities/")
//                    .execute()
//                    .toCompletableFuture()
//                    .thenAccept(System.out::println)
//                    .join();

            client.prepare("OPTIONS", "https://api.arcsecond.io/activities/")
                    .execute()
                    .toCompletableFuture()
                    .thenAccept(response -> System.out.println(response.getCookies()))
                    .join();

                client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}