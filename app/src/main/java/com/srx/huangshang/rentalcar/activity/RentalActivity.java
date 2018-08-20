//package com.srx.huangshang.rentalcar.activity;
//
//import android.Manifest;
//import android.app.ActivityManager;
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothServerSocket;
//import android.bluetooth.BluetoothSocket;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.RequiresApi;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.adhoc.adhocsdk.AdhocTracker;
//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.alibaba.android.arouter.launcher.ARouter;
//import com.srx.huangshang.BuildConfig;
//import com.srx.huangshang.R;
//import com.example.common.activity.BaseActivity;
//import com.srx.huangshang.rentalcar.factory.CompanyAbtrable.CompanyAbstract;
//import com.srx.huangshang.rentalcar.factory.control.avis.AotoCar;
//import com.srx.huangshang.rentalcar.factory.control.avis.AvisCompanyControl;
//import com.srx.huangshang.rentalcar.factory.control.avis.Passat;
//import com.srx.huangshang.rentalcar.factory.control.didi.DDCompany;
//import com.srx.huangshang.rentalcar.factory.control.didi.Porsche;
//import com.srx.huangshang.rentalcar.utils.MuUtils;
//import com.srx.huangshang.utils.ActivityUtils;
//import com.amap.api.services.core.PoiItem;
//import com.amap.api.services.poisearch.PoiResult;
//import com.amap.api.services.poisearch.PoiSearch;
//import com.example.common.ChannelUtil;
//import com.example.common.utils.PermissionUtil;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.UUID;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import aliylog.logutils.Logger;
//
///**
// * Created by huangweishui on 2018/3/20.
// */
//@Route(path="/rentalcar/RentalActivity")
//public class RentalActivity extends BaseActivity implements PoiSearch.OnPoiSearchListener {
//
//    @BindView(R.id.btn_text)
//    Button btnText;
//    @BindView(R.id.btn_databinding)
//    Button btnDatabinding;
//    @BindView(R.id.btn_java_databinding)
//    Button btnJavaDatabinding;
//    @BindView(R.id.btn_airport)
//    Button btnAirport;
//    @BindView(R.id.btn_train)
//    Button btnTrain;
//    @BindView(R.id.btn_ditie)
//    Button btnDitie;
//    private Button btn_text;
//    private Button btn_databinding;
//    private Button btn_java_databinding;
//    private Button btn_airport;
//    private Button btn_train;
//    private Button btn_ditie;
//    private BluetoothAdapter adapter;
//    private List<String> strings = new ArrayList<>();
//    private Handler handler = new Handler();
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        ButterKnife.bind(this);
//        try {
//            tryException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest
//                .permission.READ_CONTACTS
//                , Manifest.permission.CALL_PHONE};
//        PermissionUtil.requestPermisions(this, 1, permissions, new
//                PermissionUtil.RequestPermissionListener() {
//
//                    @Override
//                    public void onRequestPermissionSuccess() {
//                        showToast("成功");
//                        if
//                                (AdhocTracker.getFlag("isNewHomePage", false)) {//跳转至新首页
//                        } else {//跳转至旧首页
//                        }
//                    }
//
//                    @Override
//                    public void onRequestPermissionFail(int[] grantResults) {
//                        showToast("失败");
//                    }
//                });
//
//        EventBus.getDefault().register(this);
//        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
////        registerReceiver(new BlutoothBrocastReceiver(), intentFilter);
//        btn_text = (Button) findViewById(R.id.btn_text);
//        btn_databinding = (Button) findViewById(R.id.btn_databinding);
//        btn_java_databinding = (Button) findViewById(R.id.btn_java_databinding);
//        btn_airport = (Button) findViewById(R.id.btn_airport);
//        btn_train = (Button) findViewById(R.id.btn_train);
//        btn_ditie = (Button) findViewById(R.id.btn_ditie);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        options.inSampleSize = 2;
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.alert_dark_frame, options);
//        AvisCompanyControl general = CompanyAbstract.getCompanyIntence(AvisCompanyControl.class);
//        general.name();
//        AotoCar aotoCar = general.getCarIntence(AotoCar.class);
//        aotoCar.name("aoto");
//        aotoCar.money("100万");
//        aotoCar.setTabang("踏板");
//
//        Passat passat = general.getCarIntence(Passat.class);
//        passat.name("passat");
//        passat.money("10万");
//
//        DDCompany ddCompany = CompanyAbstract.getCompanyIntence(DDCompany.class);
//        ddCompany.name();
//        AotoCar aotoCar1 = ddCompany.getCarIntence(AotoCar.class);
//        aotoCar1.name("aoto");
//        aotoCar1.money("30万");
//        aotoCar1.action();
//        Porsche porsche = ddCompany.getCarIntence(Porsche.class);
//        porsche.name("porsche");
//        porsche.money("300万");
//        String host = BuildConfig.SERVER_HOST;
//        final String appName = getResources().getString(R.string.avis);
//        showToast(ChannelUtil.getAppMetaData(this, "CHANNEL"));
//        showToast(ChannelUtil.getChannel(this, "CHANNEL"));
//        if (Logger.sDebug) {
//            Toast.makeText(this, appName, Toast.LENGTH_SHORT).show();
//        }
//
////        BuildConfig.SERVER_HOST;
////        MuUtils.MPsort();
////        MuUtils.setLenth(4,10,new TreeSet<Integer>(),new int[5]);
////        MuUtils.setList(new LinkedList<Integer>());
//        MuUtils.setTreemapSort();
//        btn_text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(RentalActivity.this, FirstKotlinActivity.class);
////                startActivity(intent);
////                finish();
////                Toast.makeText(RentalActivity.this, mContext.getClass().getName(), Toast.LENGTH_SHORT).show();
////                Logger.i("TTT", "stacks" + MuUtils.getCurrentStacktraceInfo());
//            }
//        });
//        btn_databinding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                ARouter.getInstance().build("/kotlin/FirstKotlinActivity").withString("key","value").navigation();
////                Intent intent = new Intent(RentalActivity.this, DataBindingActivity.class);
////                startActivity(intent);
////                finish();
////                Toast.makeText(RentalActivity.this, mContext.getClass().getName(), Toast.LENGTH_SHORT).show();
////                Logger.i("TTT", "stacks" + MuUtils.getCurrentStacktraceInfo());
//            }
//        });
//        btn_java_databinding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(RentalActivity.this, MyActivityBinding.class);
////                startActivity(intent);
//            }
//        });
//
////        StackTraceElement[] stacks = new Throwable().getStackTrace();
////        if(stacks!=null) {
////            Logger.i("TTT", "stackslenth:=" + stacks.length);
////            for (int i = 0; i < stacks.length; i++) {
////                Logger.i("TTT", "stacks" + i + "toString:" + stacks[i].toString());
////                Logger.i("TTT", "stacks" + i + "getClassName:" + stacks[i].getClassName());
////                Logger.i("TTT", "stacks" + i + "getMethodName:" + stacks[i].getMethodName());
////                Logger.i("TTT", "stacks" + i + "getLineNumber:" + stacks[i].getLineNumber());
////                Logger.i("TTT", "stacks" + i + "getFileName:" + stacks[i].getFileName());
////
////            }
////        }
//        Logger.i("TTT", "MessageFormat:" + MessageFormat.format("格式化字符串:{0}({1})", "字符串1", "字符串2"));
//
////        Toast.makeText(RentalActivity.this, MuUtils.getCurrentClassName(), Toast.LENGTH_SHORT).show();
////        try {
////            Thread.sleep(1000);
////            Toast.makeText(RentalActivity.this, MuUtils.getCurrentClassNameMethodLine(), Toast.LENGTH_SHORT).show();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
//        ActivityManager.RunningTaskInfo cinfo = runningTasks.get(0);
//        ComponentName component = cinfo.topActivity;
//        Log.e("current activity is ", component.getClassName());
//        adapter = BluetoothAdapter.getDefaultAdapter();
//
//        if (adapter == null) {//设备不支持蓝牙
//
//        } else {
//            if (!adapter.isEnabled()) {//检测当前蓝牙设备是否开启
//                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                startActivityForResult(enableBtIntent, 2);
//            } else {
//
//
//                //开启扫描
//                boolean b = adapter.startDiscovery();
//                ensureDiscoverable();
////                handler.postDelayed(new Runnable() {
////                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
////                    @Override
////                    public void run() {
////                        adapter.stopLeScan(leScanCallback);;
////                    }
////                },1000);
////                adapter.startLeScan(leScanCallback);
//            }
//            //查找已匹配的设备
//            Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
//            if (pairedDevices != null && pairedDevices.size() > 0) {
//                // Loop through paired devices
//                for (BluetoothDevice device : pairedDevices) {
//                    // Add the name and address to an array adapter to show in a ListView
//                    strings.add(device.getName() + "\n" + device.getAddress());
//                }
//                Logger.i("TTT", "strings" + strings.toString());
//            } else {
//                Toast.makeText(RentalActivity.this, "没有找到已匹对的设备", Toast.LENGTH_SHORT).show();
//            }
//        }
//        search();
//        setPress();
//
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_rental;
//    }
//
//    private void setPress() {
//        btn_airport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.startActivity(RentalActivity.this, 1);
//            }
//        });
//        btn_train.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.startActivity(RentalActivity.this, 2);
//            }
//        });
//        btn_ditie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.startActivity(RentalActivity.this, 3);
//            }
//        });
//    }
//
//    private void search() {
//        PoiSearch.Query query = new PoiSearch.Query("", "150000", "上海");
////keyWord表示搜索字符串，
////第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
////cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
//        query.setPageSize(10000);// 设置每页最多返回多少条poiitem
//        query.setPageNum(2);//设置查询页码
//        query.setDistanceSort(true);
//        PoiSearch poiSearch = new PoiSearch(this, query);
//        poiSearch.setOnPoiSearchListener(this);
//        poiSearch.searchPOIAsyn();
//    }
//
//    private void tryException() {
//        try {
//            int b = 0;
//            int a = 0;
//            a = a / b;
//        } catch (Exception e) {
//            throw new RuntimeException("抛出异常");
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
//    private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
//        @Override
//        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
//            Logger.i("TTT", "BluetoothDevice:" + bluetoothDevice.toString());
//        }
//    };
//
//    //使本机蓝牙在300秒内可被搜索
//    private void ensureDiscoverable() {
//        if (adapter.getScanMode() !=
//                BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
//            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
//            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
//            startActivity(discoverableIntent);
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 2) {
//            ensureDiscoverable();
//            Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
//            if (pairedDevices != null && pairedDevices.size() > 0) {
//                // Loop through paired devices
//                for (BluetoothDevice device : pairedDevices) {
//                    // Add the name and address to an array adapter to show in a ListView
//                    strings.add(device.getName() + "\n" + device.getAddress());
//                }
//                Logger.i("TTT", "strings" + strings.toString());
//            }
//        }
//
//    }
//
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(BluetoothDevice device) {
//        adapter.cancelDiscovery();
//
//        new AcceptThread().start();
////    Intent discoverableIntent = new
////                    Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
////            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
////            startActivity(discoverableIntent);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
//
//    //UUID可以看做一个端口号
//    private static final UUID MY_UUID =
//            UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
//
//
//    //像一个服务器一样时刻监听是否有连接建立
//    private class AcceptThread extends Thread {
//        private BluetoothServerSocket serverSocket;
//
//        public AcceptThread() {
//            BluetoothServerSocket temp = null;
//            try {
//                temp = adapter.listenUsingRfcommWithServiceRecord(
//                        "小米5", MY_UUID);
//            } catch (IOException e) {
//                Log.e("app", "listen() failed", e);
//            }
//            serverSocket = temp;
//        }
//
//        public void run() {
//            BluetoothSocket socket = null;
//            while (true) {
//                try {
//                    socket = serverSocket.accept();
//                } catch (IOException e) {
//                    Log.e("app", "accept() failed", e);
//                    break;
//                }
//            }
//            if (socket != null) {
//                //此时可以新建一个数据交换线程，把此socket传进去
////                synchronized (RentalActivity.this) {
////                    switch (mState) {
////                        case STATE_LISTEN:
////                        case STATE_CONNECTING:
////                            // 正常情况。启动ConnectedThread。
////                            adapter.connected(socket, socket.getRemoteDevice());
////                            break;
////                        case STATE_NONE:
////                        case STATE_CONNECTED:
////                            // 没有准备或已连接。新连接终止。
////                            try {
////                                socket.close();
////                            } catch (IOException e) {
////                                Log.e(TAG, "Could not close unwanted socket", e);
////                            }
////                            break;
////                    }
//            }
//        }
//
//        //取消监听
//        public void cancel() {
//            try {
//                serverSocket.close();
//            } catch (IOException e) {
//            }
//        }
//
//    }
//
//    //另一个设备去连接本机,相当于客户端
//    private class ConnectThread extends Thread {
//        private BluetoothSocket socket;
//        private BluetoothDevice device;
//
//        public ConnectThread(BluetoothDevice device, boolean secure) {
//            this.device = device;
//            BluetoothSocket tmp = null;
//            try {
//                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
//            } catch (IOException e) {
//                Log.e("app", "create() failed", e);
//            }
//        }
//
//        public void run() {
//            adapter.cancelDiscovery();    //取消设备查找
//            try {
//                socket.connect();
//            } catch (IOException e) {
//                try {
//                    socket.close();
//                } catch (IOException e1) {
//                    Log.e("app", "unable to close() " +
//                            " socket during connection failure", e1);
//                }
////                connetionFailed();  //连接失败
//                return;
//            }
//            //此时可以新建一个数据交换线程，把此socket传进去
//        }
//
//        public void cancel() {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                Log.e("app", "close() of connect  socket failed", e);
//            }
//        }
//    }
//
//    //建立连接后，进行数据通信的线程
//    private class ConnectedThread extends Thread {
//        private BluetoothSocket socket;
//        private InputStream inStream;
//        private OutputStream outStream;
//
//        public ConnectedThread(BluetoothSocket socket) {
//
//            this.socket = socket;
//            try {
//                //获得输入输出流
//                inStream = socket.getInputStream();
//                outStream = socket.getOutputStream();
//            } catch (IOException e) {
//                Log.e("app", "temp sockets not created", e);
//            }
//        }
//
//        public void run() {
//            byte[] buff = new byte[1024];
//            int len = 0;
//            //读数据需不断监听，写不需要
//            while (true) {
//                try {
//                    len = inStream.read(buff);
//                    //把读取到的数据发送给UI进行显示
////                    Message msg = handler.obtainMessage(BluetoothChat.MESSAGE_READ,
////                            len, -1, buff);
////                    msg.sendToTarget();
//                } catch (IOException e) {
//                    Log.e("app", "disconnected", e);
////                    connectionLost();   //失去连接
//                    start();    //重新启动服务器
//                    break;
//                }
//            }
//        }
//
//
//        public void write(byte[] buffer) {
//            try {
//                outStream.write(buffer);
//
//                // Share the sent message back to the UI Activity
////                handler.obtainMessage(BluetoothChat.MESSAGE_WRITE, -1, -1, buffer)
////                        .sendToTarget();
//            } catch (IOException e) {
//                Log.e("app", "Exception during write", e);
//            }
//        }
//
//        public void cancel() {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                Log.e("app", "close() of connect socket failed", e);
//            }
//        }
//    }
//
//    int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
//
//    public void quickSort() {
//        quick(a);
//        for (int i = 0; i < a.length; i++)
//            System.out.println(a[i]);
//    }
//
//    public int getMiddle(int[] list, int low, int high) {
//        int tmp = list[low];    //数组的第一个作为中轴
//        while (low < high) {
//            while (low < high && list[high] >= tmp) {
//
//                high--;
//            }
//            list[low] = list[high];   //比中轴小的记录移到低端
//            while (low < high && list[low] <= tmp) {
//                low++;
//            }
//            list[high] = list[low];   //比中轴大的记录移到高端
//        }
//        list[low] = tmp;              //中轴记录到尾
//        return low;                   //返回中轴的位置
//    }
//
//    public void _quickSort(int[] list, int low, int high) {
//        if (low < high) {
//            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
//            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
//            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
//        }
//    }
//
//    public void quick(int[] a2) {
//        if (a2.length > 0) {    //查看数组是否为空
//            _quickSort(a2, 0, a2.length - 1);
//        }
//    }
//
//    @Override
//    public void onPoiSearched(PoiResult poiResult, int i) {
//        List<PoiItem> poiItems = poiResult.getPois();
//        if (poiItems != null) {
//            for (int j = 0; j < poiItems.size(); j++) {
//                Logger.i("TTT", poiItems.get(j).getTitle());
//            }
//        }
//
//
//    }
//
//    @Override
//    public void onPoiItemSearched(PoiItem poiItem, int i) {
//        Logger.i("TTT", poiItem.toString());
//    }
//}
