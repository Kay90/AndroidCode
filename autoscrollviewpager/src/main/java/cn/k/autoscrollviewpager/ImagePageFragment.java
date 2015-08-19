package cn.k.autoscrollviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Kaizen on 2015/8/10.
 * 被用于 ImagePagerAdapter 的图片显示
 */
public class ImagePageFragment extends Fragment {

    public static final String IMAGE_PAGE = "IMAGE_PAGE";

    private int mImage;

    private ImageView mImageView;

    public static ImagePageFragment newInstance(int image) {
        Bundle bundle = new Bundle();
        bundle.putInt(IMAGE_PAGE, image);
        ImagePageFragment imagePageFragment = new ImagePageFragment();
        imagePageFragment.setArguments(bundle);
        return imagePageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImage = getArguments().getInt(IMAGE_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_item, container, false);
        mImageView = (ImageView) view;
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ImagePageFragment", "onClick : " + mImage);
            }
        });
        mImageView.setImageResource(mImage);
        return view;
    }

}
