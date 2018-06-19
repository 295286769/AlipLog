package com.aliyun.sls.rentalcar.brodcast;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.aliyun.sls.android.sdk.logutils.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangweishui on 2018/4/12.
 */

public class BlutoothBrocastReceiver extends BroadcastReceiver {
    private List<String> strings=new ArrayList<>();
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        // When discovery finds a device
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // Add the name and address to an array adapter to show in a ListView
            strings.add(device.getName() + "\n" + device.getAddress());
            Logger.i("TTT", "BlutoothBrocastReceiver:strings:" + strings.toString());
            EventBus.getDefault().post(device);
//
        }

    }
}
