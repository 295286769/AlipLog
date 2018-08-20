package com.srx.huangshang.rentalcar.adapter;

import android.content.Context;

import com.srx.huangshang.R;
import com.srx.huangshang.rentalcar.holder.TrainHolder;
import com.amap.api.services.core.SuggestionCity;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * Created by huangweishui on 2018/6/19.
 */

public class TrainAdapter extends BaseQuickAdapter<SuggestionCity,TrainHolder> {
    public TrainAdapter(Context context) {
        super(R.layout.train_item);
        mContext=context;
    }

    @Override
    protected void convert(TrainHolder helper, SuggestionCity item) {
        helper.setData(item);
    }
}
