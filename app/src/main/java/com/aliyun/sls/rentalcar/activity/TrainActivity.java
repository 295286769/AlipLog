package com.aliyun.sls.rentalcar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.aliyun.sls.R;
import com.aliyun.sls.rentalcar.BaseActivity;
import com.aliyun.sls.rentalcar.adapter.TrainAdapter;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.common.view.RefreshLoadMoreView;

import java.util.List;

/**
 * Created by huangweishui on 2018/6/19.
 */

public class TrainActivity extends BaseActivity implements PoiSearch.OnPoiSearchListener{
    private RefreshLoadMoreView refreshLoadMoreView;
    private BaseQuickAdapter adapter;
    private List<SuggestionCity> suggestionCities;
    private int type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        type=getIntent().getIntExtra("type",0);
        refreshLoadMoreView=(RefreshLoadMoreView)findViewById(R.id.refreshLoadMoreView);
        adapter=new TrainAdapter(this);
        refreshLoadMoreView.setAdapter(adapter);
        search();
    }
    private void search() {
        PoiSearch.Query query = new PoiSearch.Query("", "150000", "上海");
//keyWord表示搜索字符串，
//第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
//cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query.setPageSize(1000000);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查询页码
        PoiSearch poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }
    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        suggestionCities= poiResult.getSearchSuggestionCitys();
        adapter.addData(suggestionCities);
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
}
