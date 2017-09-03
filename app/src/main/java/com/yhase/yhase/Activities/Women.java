package com.yhase.yhase.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yhase.yhase.MainActivity;
import com.yhase.yhase.R;

import java.util.HashMap;

/**
 * Created by ravneet on 2/9/17.
 */

public class Women extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commonfile);

        TextView common = (TextView) findViewById(R.id.tv_commonText);
        common.setText("Women/Girls Wear");
    }

}
