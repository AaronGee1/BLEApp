package com.example.bleproofofconcept

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


private val PERMISSION_CODE = 1
private val REQUEST_ENABLE_BT = 1


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(baseContext,
                            Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                        PERMISSION_CODE)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(baseContext,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        PERMISSION_CODE)
            }
        }

        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            Log.e("bluetoothadapter", "Device doesn't support Bluetooth")
        }

        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }


        val bluetoothLeScanner = bluetoothAdapter!!.bluetoothLeScanner

        val scanButton: Button = findViewById(R.id.button)
        scanButton.setOnClickListener {
            //scanLeDevice(bluetoothLeScanner)
            val toast = Toast.makeText(applicationContext, "Button Pressed", Toast.LENGTH_SHORT)
            toast.show()
        }
    }


//    private var scanning = false
//    val handler = Handler()
//
//    private val SCAN_PERIOD: Long = 10000
//
//
//    private fun scanLeDevice(bluetoothLeScanner: BluetoothLeScanner)
//    {
//        if(!scanning){
//            handler.postDelayed({
//                scanning = false
//                bluetoothLeScanner.stopScan(leScanCallback)
//            }, SCAN_PERIOD)
//            scanning = true
//            bluetoothLeScanner.startScan(leScanCallback)
//        } else {
//            scanning = false
//            bluetoothLeScanner.stopScan(leScanCallback)
//        }
//    }
//
//    private val leScanCallback()

//    private val leDeviceListAdapter = LeDeviceListAdapter()
    // Device scan callback.
//    private val leScanCallback: ScanCallback = object : ScanCallback() {
//        override fun onScanResult(callbackType: Int, result: ScanResult) {
//            super.onScanResult(callbackType, result)
//            leDeviceListAdapter.addDevice(result.device)
//            leDeviceListAdapter.notifyDataSetChanged()
//        }
//    }

}

//class LeDeviceListAdapter extends ListAdapter<User, UserViewHolder>{}