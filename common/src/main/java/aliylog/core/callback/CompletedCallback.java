package aliylog.core.callback;


import aliylog.LogException;
import aliylog.core.Request;
import aliylog.core.Result;

/**
 * Created by zhouzhuo on 11/19/15.
 */
public interface CompletedCallback<T1 extends Request, T2 extends Result> {

    public void onSuccess(T1 request, T2 result);

    public void onFailure(T1 request, LogException exception);
}
