package com.aliyun.sls.kotlin.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import com.aliyun.sls.R
import com.aliyun.sls.android.sdk.logutils.Logger
import com.aliyun.sls.databinding.TestActivityBinding
import com.aliyun.sls.kotlin.adapter.MyKotlinAdapter
import com.aliyun.sls.kotlin.controll.MyHandler
import com.aliyun.sls.kotlin.model.DataBean
import com.example.common.activity.BaseKotlinActivity
import com.example.common.utils.ToastUtil
import com.example.common.view.RefreshLoadMoreView
import java.lang.ref.WeakReference
import java.util.*



class DataBindingActivity : BaseKotlinActivity() {
    override fun getBinding(): Int {
        return R.layout.test_activity
    }

    lateinit var  dataBinding: TestActivityBinding
    lateinit var adapter:MyKotlinAdapter
    var handler=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }
    init {

    }

    override fun initData() {
        super.initData()
        dataBinding=baseDataBinding as TestActivityBinding
    }

    override fun initView() {
        super.initView()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        dataBinding = DataBindingUtil.setContentView(this, R.layout.test_activity)
       var dataBean:DataBean=DataBean(this,"黄尚",19)
        dataBean.name="阿拉"
        dataBinding.setDataBean(dataBean)

        dataBinding.tvName.setText("小明")
        dataBinding.setOnClick { view ->
            ToastUtil.show(this,"成功")
        }
        initViewStub()
        initAdapter()
        var students= arrayOf(5,2,3,9,7,4)
        var temp=0;
        for (i in students.indices){
            for (j in 0 until  students.size-1-i){
                if(students[j]>students[j+1]){
                    temp=students[j];
                    students[j]=students[j+1]
                    students[j+1]=temp
                }
            }
        }
        for (i in students.indices){
            Logger.i("TTT","students:"+students[i])
        }

        var tearchs= arrayOf(5,2,3,9,7,4)
        var low=0
        var hight=tearchs.size-1
        _quickSort(tearchs,low,hight)
        for (i in tearchs.indices){
            Logger.i("TTT","tearchs:"+tearchs[i])
        }
        var childs= arrayOf(5,1,8,9,5,7,4,2)
        InsertSort(childs)
        for (i in tearchs.indices){
            Logger.i("TTT","childs:"+childs[i])
        }
    }

    fun _quickSort(list: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            val middle = getMiddle(list, low, high)  //将list数组进行一分为二
            _quickSort(list, low, middle - 1)        //对低字表进行递归排序
            _quickSort(list, middle + 1, high)       //对高字表进行递归排序
        }
    }

    fun getMiddle(list:  Array<Int>, low: Int, high: Int): Int {
        var low = low
        var high = high
        val tmp = list[low]    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--
            }
            list[low] = list[high]   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++
            }
            list[high] = list[low]   //比中轴大的记录移到高端
        }
        list[low] = tmp              //中轴记录到尾
        return low                   //返回中轴的位置
    }

    fun InsertSort(arr: Array<Int>) {
        var i: Int
        var j: Int
        val n = arr.size
        var target: Int

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        i = 1
        while (i < n) {
            j = i
            target = arr[i]

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1]
                j--
            }

            arr[j] = target
            i++
        }
    }
    private fun initAdapter() {

        var list=ArrayList<DataBean>()
        var dataBean=DataBean("老师",20)
        list.add(dataBean)
        adapter=MyKotlinAdapter(this)

        dataBinding.list.setAdapter(adapter)
        adapter.setNewData(list)
    }

    override fun onPress() {
        super.onPress()
//        dataBinding.viewStub.setOnInflateListener { viewStub, view ->
//            val binding = DataBindingUtil.bind<ViewDataBinding>(view)
//        }
//        dataBinding.tvName.setOnClickListener(object :View.OnClickListener{
//            override fun onClick(p0: View?) {
//            }
//
//        })
    }
    fun initViewStub(){
        if(!dataBinding.viewStub.isInflated()){
            dataBinding.viewStub.getViewStub().inflate();
        }
    }
    inner class MyClass{

    }
      class  KotlinHandler: Handler {
        lateinit var refrece:WeakReference<Activity>
        constructor(activity:Activity):super(){
            refrece=WeakReference(activity)
        }

    }
}
