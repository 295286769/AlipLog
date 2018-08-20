package com.srx.huangshang.kotlin.controll

import android.os.Handler
import android.os.Message
import com.srx.huangshang.kotlin.inteface.KotlinTimeInteface
import com.example.common.utils.KotlinTimeUtils


/**
 * Created by huangweishui on 2018/4/25.
 */
object TimeControll {
    private var defaultTime:Long=0
    private var stepTime:Long=1000
    private var kotlinTimeInteface:KotlinTimeInteface? = null

    //创建线程
    var thread:Thread=Thread(Runnable {
        kotlin.run {
            synchronized(TimeControll){
                while (defaultTime>0){
                    defaultTime -= stepTime
                }
            }

        }
    })
    //创建handler
     var handler: Handler =object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }
    val runnable:Runnable= object :Runnable{
        override fun run() {
            synchronized(TimeControll){
                defaultTime -= stepTime
                if(defaultTime>0){
                    val timeString= KotlinTimeUtils.ms2HMS(defaultTime)
                    kotlinTimeInteface?.returnTime(timeString)
                    handler.postDelayed(this,stepTime)
                }else{
                    kotlinTimeInteface?.finish()
                }
            }

        }

    }

    fun setTime(time:Long,stepTime:Long,kotlinTimeInteface: KotlinTimeInteface?){
        this.defaultTime= time
        if(stepTime>0){
            this.stepTime=stepTime
        }
        this.kotlinTimeInteface=kotlinTimeInteface
        if(thread!=null&&thread.isInterrupted()){
            thread.start()
        }
        if (time != null&&time>0) {
        if(handler!=null){
            handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable,stepTime)
                }

        }else{
            kotlinTimeInteface?.finish()
        }
    }
    fun setTime(time:Long,kotlinTimeInteface: KotlinTimeInteface?){
        setTime(time,0,kotlinTimeInteface)
    }

    fun stop(){
        if(thread!=null&&Thread.State.RUNNABLE == thread .getState()){
            try {
                Thread.sleep(500);
                thread .interrupt();
            } catch(e: Exception) {
                thread.interrupt();//重新设置中断标示
            }
        }
        if(handler!=null){
            handler.removeCallbacks(runnable)
        }
        if(kotlinTimeInteface!=null){
            kotlinTimeInteface=null
        }
    }

}