# Horizontal_square_seekbar

A customized horizontal seekbar for selecting the values upto 10 in square blocks.
The horizontal square seekbar can be used for showing the progress in blockwise by clicking the square blocks.


DEMO

![Alt text](https://github.com/MobileDews/Horizontal_square_seekbar/blob/master/seekbar.png?raw=true "Optional Title")

GRADLE

Step 1. Add the JitPack repository to your root build.gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency
  
 	dependencies {
	         compile 'com.github.MobileDews:Horizontal_square_seekbar:1.0.1'
	}
  
USAGE
  
          <com.techdew.lib.CustomSeekBar
            android:id="@+id/CustomSeekBar"
            android:layout_width="match_parent"
            android:layout_height="30dp"
            android:max="100"
            android:progress="0"
            custom:base_color="@color/colorAccent"
            custom:value_color="@color/colorPrimary"
            custom:stroke_color="@android:color/white"
            android:progressDrawable="@android:color/transparent"/>
        
        
             
 Add the following code to the MainActivity.java
 
       final  CustomSeekBar   seekbar = ((CustomSeekBar) findViewById(R.id.CustomSeekBar));
       seekbar.initData(0);

       seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
               seekbar.initData(progress);
               seekbar.getThumb().mutate().setAlpha(0);
               seekbar.invalidate();
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
 
 
