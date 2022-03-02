package com.oseamiya.deviceinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Declare and initialize TextView from the layout file
        TextView mTextView = (TextView)findViewById(R.id.text_view);
        TextView TxtlowMemory = (TextView)findViewById(R.id.text_view_lowmemory);

        // Declaring and Initializing the ActivityManager
        ActivityManager actManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        // Declaring MemoryInfo object
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();

        // Fetching the data from the ActivityManager
        actManager.getMemoryInfo(memInfo);

        // Fetching the available and total memory and converting into Giga Bytes
        double availMemory = (double) memInfo.availMem/(1024*1024*1024);
        double totalMemory= (double) memInfo.totalMem/(1024*1024*1024);
        double percentUsed = 100 * (totalMemory - availMemory)/totalMemory;
        boolean lowMemory = memInfo.lowMemory;
        Long threshold = memInfo.threshold/(1024*1024*1024);

        // Displaying the memory info into the TextView
        mTextView.setText("Available RAM: " + String.valueOf(availMemory)
                + "\nTotal RAM: " + String.valueOf(totalMemory)
                + "\nPercentage used: " + String.valueOf(percentUsed) + "%"
        );
        TxtlowMemory.setText("Lowmemory ==" + String.valueOf(lowMemory) + "\n threshold == " + String.valueOf(threshold));


    }
}