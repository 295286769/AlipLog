package aliylog;


import okhttp3.Response;
import aliylog.core.parser.AbstractResponseParser;
import aliylog.result.PostLogResult;

/**
 * Created by zhuoqin on 10/18/17.
 */
public final class ResponseParsers {

    public static class PostLogResponseParser extends AbstractResponseParser<PostLogResult> {

        @Override
        public PostLogResult parseData(Response response,PostLogResult result) throws Exception{
            return result;
        }
    }


}
