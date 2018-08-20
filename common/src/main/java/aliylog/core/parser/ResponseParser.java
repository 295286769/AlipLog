package aliylog.core.parser;



import java.io.IOException;

import okhttp3.Response;
import aliylog.core.Result;

/**
 * Created by zhouzhuo on 11/23/15.
 */
public interface ResponseParser<T extends Result> {

    public T parse(Response response) throws IOException;
}
