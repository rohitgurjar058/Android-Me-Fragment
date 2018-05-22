package mrmusicplayer.mrcoder.com.android_me.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by rohit on 20/5/18.
 */

public class MasterListAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> mImageIds;

    public MasterListAdapter(Context context,List<Integer> mImageIds)
    {
        this.context = context;
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(context);
            // Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
}
