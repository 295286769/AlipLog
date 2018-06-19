package com.aliyun.sls.kotlin.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Message
import android.widget.ImageView
import com.adhoc.fa
import com.aliyun.sls.MainActivity
import com.aliyun.sls.R
import com.aliyun.sls.android.sdk.logutils.Logger
import com.aliyun.sls.kotlin.controll.StaticControll
import com.aliyun.sls.kotlin.inteface.KotlinTimeInteface
import com.aliyun.sls.kotlin.model.KotlinBean
import com.aliyun.sls.rentalcar.activity.RentalActivity
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class FirstKotlinActivity<T> : KotlinActivity(), com.aliyun.sls.kotlin.inteface.FirstInterface {
    override fun getAge(age: Int) {

        com.aliyun.sls.android.sdk.logutils.Logger.i("AVIS", "avis:age+" + java.text.MessageFormat.format("格式化字符串:{0}({1})", "字符串1", "字符串2"))
    }

    //
    val btn_text: android.widget.Button by lazy { findViewById(com.aliyun.sls.R.id.btn_text) as android.widget.Button }
    val tv_text: android.widget.TextView by lazy { findViewById(com.aliyun.sls.R.id.tv_text) as android.widget.TextView }
    val tv_name: android.widget.TextView by lazy { findViewById(com.aliyun.sls.R.id.tv_name) as android.widget.TextView }
    val img_lauch: ImageView by lazy { findViewById(com.aliyun.sls.R.id.img_lauch) as ImageView }
    val ll_emty_view: android.widget.LinearLayout by lazy { findViewById(com.aliyun.sls.R.id.ll_emty_view) as android.widget.LinearLayout }
    val firstKotlinView: com.aliyun.sls.kotlin.view.FirstKotlinView by lazy { findViewById(com.aliyun.sls.R.id.firstKotlinView) as com.aliyun.sls.kotlin.view.FirstKotlinView }
    val myView: com.aliyun.sls.rentalcar.view.MyView by lazy { findViewById(com.aliyun.sls.R.id.myView) as com.aliyun.sls.rentalcar.view.MyView }

    var adapter: com.aliyun.sls.kotlin.adapter.ViewAdapter<T>? = null

    lateinit var name: String
    val v1 = age?.toInt() //不做处理返回 null
    val v2 = age?.toInt() ?: 0 //判断为空时返回0

    val huang: String by lazy { huang }
    var height: Int = 0
    var with = 2
    lateinit var namesList: Array<String>
    var firstControll: com.aliyun.sls.kotlin.controll.FirstControll? = null
    var ages = arrayOf(1)
    val firstModel: com.aliyun.sls.kotlin.model.FirstModel = com.aliyun.sls.kotlin.model.FirstModel("")
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.aliyun.sls.R.layout.activity_first_kotlin)


        showToast("成功")
//        var intent = Intent(this, RentalActivity::class.java)
        getAge(3)
        name = ""
        namesList = emptyArray()
        firstControll = com.aliyun.sls.kotlin.controll.FirstControll()
        try {
            val v3 = age!!.toInt() //抛出空指针异常（用“!!”表示不能为空）
        } catch(e: Exception) {
            com.aliyun.sls.android.sdk.logutils.Logger.i("AVIS", "Exception+" + e.message)
        }
        var bean: com.aliyun.sls.kotlin.model.KotlinBean = com.aliyun.sls.kotlin.model.KotlinBean("黄尚", 30)
        firstKotlinView.setName("小明")

        var beanInner = bean.KotlinInner()
        beanInner.getAge(object : com.aliyun.sls.kotlin.model.KotlinBean.KotlinInteface {
            override fun getAge() {
            }
        })
        tv_text.text = bean.age.toString()
        tv_name.text = bean.name
        btn_text.setOnClickListener { view ->
            tv_name.text = view.id.toString()
            var intent = android.content.Intent(FirstKotlinActivity@ this, MainActivity::class.java)
//            startActivity(intent)
        }
        setTime()
        setProxy()
        setDecorativePattern()
//        var intent=Intent(this,KotlinActivity::class.java)
//        startActivity(intent)

        var bitmap1 = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
        var bitmapround = BitmapFactory.decodeResource(resources, R.mipmap.relese_icon)

        Logger.i("TTT", "bitmap1:" + bitmap1.byteCount)
        Logger.i("TTT", "bitmapround:" + bitmapround.byteCount)
        var bitmap = getBitMap(50, 50)

        Logger.i("TTT", "byteCount:" + bitmap.byteCount)
        bitmap = bitmapCompress(bitmap)
        Logger.i("TTT", "bitmapCompress:byteCount:" + bitmap.byteCount)
        img_lauch.setImageBitmap(bitmap)
        hadler.sendEmptyMessage(0)

        sdf?.setAge()
    }
   var sdf:StaticControll?=StaticControll.getInstence(this)

    var hadler:Handler=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            try {
                Thread.sleep(1000)
            } catch(e: Exception) {
            }
//            sendEmptyMessage(0)
        }
    }

    fun getBitMap(with: Int, height: Int): Bitmap {
        var sampleSize = 1

        var option: BitmapFactory.Options = BitmapFactory.Options()

        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher, option)
        option.inPreferredConfig = Bitmap.Config.ARGB_8888
        option.outWidth = with
        option.outHeight = height
        var optionwith = option.outWidth
        var optionheight = option.outHeight
        if (with < optionwith || height < optionheight) {
            sampleSize = Math.max(Math.ceil((optionwith.toDouble() / with.toDouble())), Math.ceil(((optionheight.toDouble() / height.toDouble())))).toInt()
        }
        option.inSampleSize = sampleSize
        option.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher, option)
    }

    fun bitmapCompress(bitmap: Bitmap): Bitmap {
        var quit = 100
        var stream: ByteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, quit, stream)
//        while (stream.toByteArray().size/1024>100){
        quit -= 20
        stream.reset()
        bitmap.compress(Bitmap.CompressFormat.PNG, quit, stream)
//        }
        var inputStream: ByteArrayInputStream = ByteArrayInputStream(stream.toByteArray())
//        stream.close()
//        inputStream.close()
        return BitmapFactory.decodeStream(inputStream)
    }

    fun setDecorativePattern() {
        var person: com.aliyun.sls.kotlin.inteface.Person = com.aliyun.sls.kotlin.model.Student()
        var base: com.aliyun.sls.kotlin.controll.DescriptionBase = com.aliyun.sls.kotlin.controll.DescriptionBase(person)
        var studentWorkControll: com.aliyun.sls.kotlin.controll.StudentWorkControll = com.aliyun.sls.kotlin.controll.StudentWorkControll(base)
        var seconStudentControll = com.aliyun.sls.kotlin.controll.SeconStudentControll(studentWorkControll)
        var schoolUniform = com.aliyun.sls.kotlin.model.SchoolUniform(studentWorkControll)
        com.aliyun.sls.android.sdk.logutils.Logger.i("TTT", seconStudentControll.description())
        com.aliyun.sls.android.sdk.logutils.Logger.i("TTT", schoolUniform.description())
//         seconStudentControll.description()
    }

    private fun setProxy() {
        var hourse: com.aliyun.sls.kotlin.inteface.HouseInteface = com.aliyun.sls.kotlin.model.Hourse("滨江预警", "10000000")
        val proxy: com.aliyun.sls.kotlin.controll.ProxyHandler = com.aliyun.sls.kotlin.controll.ProxyHandler()
        hourse = proxy.newProxyInstance(hourse) as com.aliyun.sls.kotlin.inteface.HouseInteface

    }

    private fun setTime() {
        var time: Long = 20 * 60 * 1000
        com.aliyun.sls.kotlin.controll.TimeControll.setTime(time, object : KotlinTimeInteface {
            override fun returnTime(time: String) {
                tv_name.text = time
            }

            override fun finish() {
                tv_name.text = "已超时"
            }

        })
    }

    fun getName(): Unit {
        if (age in 1..5) {//在1-5区间

        }
        if (name is String) {//判断是哪种类型

        }
        if (name in namesList) {

        }
        for (i in namesList) {

        }
        for (age in 1 until 5 step 3) {//在[1-5)区间排除5

        }
        for (i in namesList.size - 1..0) {

        }
        namesList.forEach {

        }
        when (name) {

        }
        do {

        } while (age in 1..3)
        ages.forEach abc@ {
            when (age) {1 -> return@abc
            }
        }
        getHeigt()

    }

    fun getHeigt() {
        java.text.MessageFormat.format("格式化字符串:{0}({1})", "字符串1", "字符串2");
    }

    override fun initView() {


    }

    override fun initData() {
        super.initData()
        var bean: KotlinBean = KotlinBean()
        bean.getMyName()
        var names = arrayOf("1", "2")
        var students = arrayListOf<String>()
        students.forEach {
            Logger.i("TTT", "forEach" + it)

        }
        students.add("黄尚")
        var ages = Array(2, { i -> (i * 1) })
        bean.main(names)
        adapter = com.aliyun.sls.kotlin.adapter.ViewAdapter(this)
        var datas = mutableListOf<com.aliyun.sls.kotlin.model.KotlinBean>()
        datas.add(com.aliyun.sls.kotlin.model.KotlinBean("黄尚", 11))
        datas.add(com.aliyun.sls.kotlin.model.KotlinBean("关大夫", 19))
        datas.add(com.aliyun.sls.kotlin.model.KotlinBean("地方都是", 13))

        var views = adapter?.initAdapter(datas as List<T>) ?: null
        if (adapter != null) {
            val list = adapter?.mKotlinBeans ?: null
            if (list != null) {
                for (i in list.indices) {
                    val bean: com.aliyun.sls.kotlin.model.KotlinBean? = list.get(i) as com.aliyun.sls.kotlin.model.KotlinBean
                    com.aliyun.sls.android.sdk.logutils.Logger.i("TTT", "mKotlinBeans:+" + bean?.name)
                }
            }
            ll_emty_view.removeAllViews()
            ll_emty_view.addView(adapter?.emtyViewItem())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        com.aliyun.sls.kotlin.controll.TimeControll.stop()
    }
}


