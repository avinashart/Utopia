package com.justmailtoavi.avinashk.utopia;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;


public class t_shirt_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.t_shirt_fragment,container,false);


        SliderLayout mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        final HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("Upotia Men's T-Shirt",R.drawable.front_boy);
        file_maps.put("Upotia Women's T-Shirt   ",R.drawable.front_girl);
        file_maps.put("Upotia Men's T-Shirt ",R.drawable.rear_boy);
        file_maps.put("Upotia Women's T-Shirt  ",R.drawable.rear_girl);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(7000);
        return view;
    }
}
