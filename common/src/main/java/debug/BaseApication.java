package debug;

import android.app.Application;
import android.content.Context;


/**
 * Created by shang on 2018/7/4.
 */

public class BaseApication extends Application {
    private static Application mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
//        if(BuildConfig.DEBUG){
//            ARouter.openLog();
//            ARouter.openDebug();
//        }
//        ARouter.init(this);
    }
    public static Application getInstance(){
        if(mContext==null){
            mContext=new BaseApication();
        }
        return mContext;
    }
}
