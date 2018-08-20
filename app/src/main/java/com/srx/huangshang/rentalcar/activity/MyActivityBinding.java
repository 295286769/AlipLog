//package com.aliyun.sls.rentalcar.activity;
//
////import android.databinding.DataBindingUtil;
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.View;
//import android.view.ViewStub;
//
//import com.aliyun.sls.R;
////import com.aliyun.sls.databinding.ActivityTestTwoBinding;
//import com.aliyun.sls.databinding.ActivityMyTestBinding;
//import com.aliyun.sls.rentalcar.BaseActivity;
//import com.aliyun.sls.rentalcar.model.BindingBean;
//
///**
// * Created by huangweishui on 2018/5/22.
// */
//
//public class MyActivityBinding extends BaseActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ActivityMyTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_my_test);
//        BindingBean bindingBean=new BindingBean("黄尚",11);
//        binding.setBindingBean(bindingBean);
//        binding.viewstub.setOnInflateListener(new ViewStub.OnInflateListener() {
//            @Override
//            public void onInflate(ViewStub viewStub, View view) {
////                Viewstub binding = DataBindingUtil.bind(view);
//            }
//        });
//    }
//}
