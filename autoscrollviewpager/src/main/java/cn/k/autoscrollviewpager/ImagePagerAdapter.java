package cn.k.autoscrollviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Kaizen on 2015/8/10.
 * 被 InterrogationFragment 用于图片轮播
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {

    private List<Integer> mImageArray;

    public ImagePagerAdapter(FragmentManager fm, List<Integer> imageArray) {
        super(fm);
        this.mImageArray = imageArray;
    }

    @Override
    public Fragment getItem(int position) {
        return ImagePageFragment.newInstance(mImageArray.get(position));
    }

    @Override
    public int getCount() {
        return mImageArray.size();
    }
}
