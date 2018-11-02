package com.example.mahfuz.rotateexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mahfuz.rotateexample.adapter.ProductAdapter;
import com.example.mahfuz.rotateexample.model.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {
    private List<Product> mProductList = new ArrayList<>();
    private ListView mProductLV;

    FragmentChangeListener fragmentChangeListener;


    public ProductListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Product list Fragment", "onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("Product list Fragment", "onViewStateRestored");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        getListData();

        mProductLV = view.findViewById(R.id.productListView);
        Log.d("listerner", this.fragmentChangeListener+"");
        ProductAdapter adapter = new ProductAdapter(getActivity(), mProductList, fragmentChangeListener);

        mProductLV.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    private void getListData() {

        Product product1 = new Product("Laptop", "this is the product description");
        Product product2 = new Product("Mouse", "this is the product description");
        Product product3 = new Product("TouchPad", "this is the product description");
        Product product4 = new Product("Key board", "this is the product description");

        mProductList.add(product1);
        mProductList.add(product2);
        mProductList.add(product3);
        mProductList.add(product4);
    }

    public void setFragmentChangeListener(FragmentChangeListener fragmentChangeListener) {
        this.fragmentChangeListener = fragmentChangeListener;

    }

}
