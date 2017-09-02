package com.yhase.yhase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_MyProfile) {
            // Handle the camera action
        } else if (id == R.id.nav_uploadDesign) {

        } else if (id == R.id.nav_newOffers) {

        } else if (id == R.id.nav_men) {

        } else if (id == R.id.nav_women) {

        } else if (id == R.id.nav_kids) {

        } else if (id == R.id.nav_sports){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @SuppressWarnings("WrongThread")
    class DownloadingAnimation extends AsyncTask<String,String ,String> implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener{

        SliderLayout sliderLayout;
        HashMap<String,String> Hash_file_maps ;


        @Override
        protected String doInBackground(String... strings) {

            Hash_file_maps = new HashMap<String, String>();
            sliderLayout = (SliderLayout)findViewById(R.id.slider);
            Hash_file_maps.put("1", "https://firebasestorage.googleapis.com/v0/b/ieeefinal.appspot.com/o/IEEE_DTU.png?alt=media&token=029f0e99-44f3-460a-8dd5-4baa2d6e304a");
            Hash_file_maps.put("2", "https://firebasestorage.googleapis.com/v0/b/ieeefinal.appspot.com/o/poster?alt=media&token=00d7ac14-2826-4699-9710-13c399f65378");
            Hash_file_maps.put("3", "https://firebasestorage.googleapis.com/v0/b/ieeefinal.appspot.com/o/ieeedtu3.jpg?alt=media&token=29434b1a-6c42-4444-9dae-87a792a4ac4a");
            Hash_file_maps.put("4", "https://firebasestorage.googleapis.com/v0/b/ieeefinal.appspot.com/o/ieeedtu4.jpg?alt=media&token=ba1fe0e0-cd72-4cc6-9076-8987cd1e01ac");
            for(String name : Hash_file_maps.keySet()){

                TextSliderView textSliderView = new TextSliderView(MainActivity.this);
                textSliderView
                        .description(name)
                        .image(Hash_file_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra",name);
                sliderLayout.addSlider(textSliderView);
            }
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(3000);
            sliderLayout.addOnPageChangeListener(this);

            return "";
        }

        @Override
        public void onSliderClick(BaseSliderView slider) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
