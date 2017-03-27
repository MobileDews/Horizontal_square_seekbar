package com.techdew.horizontal_squareboxes_seekbar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.techdew.lib.CustomSeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomSeekBar seekbar;
//in=R.color.colorAccent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar = ((CustomSeekBar) findViewById(R.id.CustomSeekBar));
        initDataToSeekbar(0);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                initDataToSeekbar(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void initDataToSeekbar(int val) {
        seekbar.initData(val);
        seekbar.getThumb().mutate().setAlpha(0);
        seekbar.invalidate();
    }
}
