package com.example.mahfuz.rotateexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mahfuz.rotateexample.FragmentChangeListener;
import com.example.mahfuz.rotateexample.MainActivity;
import com.example.mahfuz.rotateexample.ProductDescriptionFragment;
import com.example.mahfuz.rotateexample.R;
import com.example.mahfuz.rotateexample.model.Product;

import java.util.List;

/**
 * Created by mahfuz on 11/1/18.
 */

public class ProductAdapter extends BaseAdapter {


    private Context contex;
    private List<Product> products;

    Bundle bundle;

    public ProductAdapter(Context contex, List<Product> products, FragmentChangeListener fragmentChangeListener) {
        this.contex = contex;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(contex).inflate(R.layout.layout_product, viewGroup,
                    false);
        }

        TextView nameTv = view.findViewById(R.id.userNameTv);

        final Product product = (Product) getItem(i);
        nameTv.setText(product.getUserName());

        bundle = new Bundle();
        bundle.putString("description", product.getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchFragment(new ProductDescriptionFragment());
                //((MainActivity)contex).onProductSelected(product.getDescription());

            }
        });

        return view;
    }

    public void switchFragment(Fragment baseFragment) {
        try {
            FragmentTransaction ft = ((MainActivity)contex).getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.slide_out_right);

            baseFragment.setArguments(bundle);

            ft.replace(R.id.fragmentContainer, baseFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
