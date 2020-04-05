package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class PlaceholderFragment extends Fragment {

    private String[] data = {"用户1","用户2","用户3","用户4","用户5","用户6","用户7","用户8","用户9","用户10","用户11","用户12","用户13","用户14"
            ,"用户15","用户16","用户17","用户18","用户19","用户20","用户21","用户22","用户23","用户24"};
    private ListView listView;
    private TextView text;
    private LottieAnimationView animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View s= inflater.inflate(R.layout.fragment_placeholder,container,false);
        //View.inflate(getActivity(), R.layout.fragment_placeholder, null);
        //inflater.inflate(R.layout.fragment_placeholder,container,false);
        Log.d("G","第三步完成");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                container.getContext(), android.R.layout.simple_list_item_1 , data);
        Log.d("G","第四步完成");
        Log.d("G",String.valueOf(adapter.getCount()));
        listView = (ListView) s.findViewById(R.id.list_view);

        Log.d("G","第五步完成");
        listView.setAdapter(adapter);
        Log.d("G","第六步完成");
        listView.setAlpha(0f);
        return s;
        //inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                Log.d("G","爬了啊");
                ObjectAnimator a1 =ObjectAnimator.ofFloat(animation,"alpha",1f,0f);
                a1.setDuration(1000);
                a1.start();
                ObjectAnimator a2 =ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                a2.setDuration(1000);
                a2.start();
            }
        }, 5000);
    }
}