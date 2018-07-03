package com.aliyun.sls.rentalcar.holder;

import android.view.View;
import android.widget.TextView;

import com.aliyun.sls.R;
import com.aliyun.sls.rentalcar.model.TrainBean;
import com.amap.api.services.core.SuggestionCity;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by huangweishui on 2018/6/19.
 */

public class TrainHolder extends BaseViewHolder {
    TextView tv_name;
    public TrainHolder(View view) {
        super(view);
        tv_name=(TextView)view.findViewById(R.id.tv_name);
    }
    public void setData(SuggestionCity item){
        tv_name.setText(item.getCityName());
    }
}
