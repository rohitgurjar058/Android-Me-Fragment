package mrmusicplayer.mrcoder.com.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import mrmusicplayer.mrcoder.com.android_me.R;
import mrmusicplayer.mrcoder.com.android_me.data.AndroidImageAssets;

/**
 * Created by rohit on 19/5/18.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyFragment";
    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIds;
    private int mListIndex;

    //Manndatory constructor for instantiating the fragment
    public BodyPartFragment() {
    }

    //Inflates the fragment layout and sets any image resources
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState!=null)
        {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //Infalte the fragment layout
        View rootView = inflater.inflate(R.layout.fragament_body_part,container,false);

        //Get the reference to the imageview in fregmant layout
        final ImageView imageView = (ImageView)rootView.findViewById(R.id.body_part_image_view);

        //set the image Rsource to display
        if(mImageIds!=null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            //Click Listener
            imageView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    }
                    else
                        mListIndex=0;

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }
        else
            Log.d(TAG, "No Image Ids");

        return rootView;
    }

    public void setImageIds(List<Integer> imageIds)
    {
        mImageIds = imageIds;
    }

    public void setListIndex(int index)
    {
        mListIndex = index;
    }


    //Override OnSaveInstance State and saves the imageList and imageIndex
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)mImageIds);
        outState.putInt(LIST_INDEX,mListIndex);
        super.onSaveInstanceState(outState);
    }
}
