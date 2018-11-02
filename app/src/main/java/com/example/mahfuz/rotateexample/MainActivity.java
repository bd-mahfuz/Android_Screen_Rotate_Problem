package com.example.mahfuz.rotateexample;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mahfuz.rotateexample.adapter.ProductAdapter;
import com.example.mahfuz.rotateexample.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{


    FragmentTransaction ft;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.fragmentContainer,new ProductListFragment());
//        ft.commit();

        if (savedInstanceState == null) {

            addFragement();
        }
    }

    public void addFragement() {

        ProductListFragment productListFragment = new ProductListFragment();
        productListFragment.setFragmentChangeListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.fragmentContainer, new ProductListFragment());
        ft.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity", "onRestoreInstanceState");
    }

    @Override
    public void onProductSelected(String productName) {
        addProductFragment(productName);
    }

    public void addProductFragment(String productName) {
        ProductDescriptionFragment descriptionFragment = new ProductDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FragmentChangeListener.SELECTED_PRODUCT, productName);
        descriptionFragment.setArguments(bundle);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, descriptionFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            Log.i("COMMON_TAG", "landscape");
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Log.i("COMMON_TAG", "portrait");
        }
    }
}
