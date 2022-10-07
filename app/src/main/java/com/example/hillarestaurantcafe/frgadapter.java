package com.example.hillarestaurantcafe;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class frgadapter extends FragmentStateAdapter {

    public frgadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return new TakeAwayFragment();
        }else if(position == 2){
            return new DineInFragment();
        }else{
            return new OrdersFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}