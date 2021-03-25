package com.example.dollar.ui.midEndBest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dollar.R;
import com.example.dollar.databinding.FragmentBankBinding;

public class BankFragment extends Fragment {
    private FragmentBankBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bank, container, false);
    }
}