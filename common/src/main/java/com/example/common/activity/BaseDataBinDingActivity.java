package com.example.common.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.common.utils.PermissionUtil;

/**
 * Created by huangweishui on 2018/8/20.
 */

public abstract class BaseDataBinDingActivity extends AppCompatActivity {
    private Context mContext;
//    public ViewDataBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
//        dataBinding= DataBindingUtil.setContentView(this,getLayoutId());
    }

    public abstract int getLayoutId();

    public void initRequest() {
    }

    public void initView() {
    }

    public void initData() {
    }

    public void showToast( String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]
            grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
