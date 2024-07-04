import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

import java.util.Arrays;

public class ItemList implements Handler {

    private Enrollment[] items;

    public ItemList(Enrollment[] enrollments) {
        this.items = enrollments;

    }

    @Override
    public void accept(ServerRequest serverRequest, ServerResponse serverResponse) {
        serverResponse.status(Http.Status.OK_200);
        serverResponse.headers().put("Content-Type", "text/plain; charset=UTF-8");
        System.out.println("Items List: " + Arrays.toString(items));
        serverResponse.send(Arrays.toString(items));

    }
}
