package cn.k.autoscrollviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> mList = new ArrayList<>();

    private AutoScrollViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList.clear();
        mList.add(R.mipmap.one);
        mList.add(R.mipmap.two);
        mList.add(R.mipmap.three);
        viewPager = (AutoScrollViewPager) findViewById(R.id.autoScroll);
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        ImagePagerAdapter adapter = new ImagePagerAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        viewPager.setInterval(2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.startAutoScroll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewPager.stopAutoScroll();
    }
}
