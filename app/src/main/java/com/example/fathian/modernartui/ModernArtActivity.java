package com.example.fathian.modernartui;

import android.app.DialogFragment;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class ModernArtActivity extends ActionBarActivity{

    private DialogFragment mDialog;
    private TextView text_view1, text_view3, text_view4, text_view5, text_view6;
    private SeekBar seek_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_art);
        
        text_view1 = (TextView)findViewById(R.id.tv_1);
        text_view3 = (TextView)findViewById(R.id.tv_3);
        text_view4 = (TextView)findViewById(R.id.tv_4);
        text_view5 = (TextView)findViewById(R.id.tv_5);
        text_view6 = (TextView)findViewById(R.id.tv_6);
        seek_bar = (SeekBar)findViewById(R.id.color_seek_bar);

        seek_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_view1.setBackgroundColor(Color.rgb(255, 255-progress, 204));
                text_view3.setBackgroundColor(Color.rgb(161, 218-progress, 180));
                text_view4.setBackgroundColor(Color.rgb(65, 182-progress, 196));
                text_view5.setBackgroundColor(Color.rgb(44, 127-progress, 184));
                text_view6.setBackgroundColor(Color.rgb(37, 52, 148-progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modern_art, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_more) {
            // show Dialog box
            mDialog = new OpenMomaDialogFragment();
            mDialog.show(getFragmentManager(),"OpenMomaDialogFragment");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

