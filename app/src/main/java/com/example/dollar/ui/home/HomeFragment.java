package com.example.dollar.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dollar.R;
import com.example.dollar.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private MyThread myThread = new MyThread();
    private FragmentHomeBinding binding;
    private NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        click();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.downByeOne.setText(myThread.getByeMid().get(0));
                binding.downBye2One.setText(myThread.getByeMid().get(1));
                binding.downBye3One.setText(myThread.getByeMid().get(2));
                binding.downSaleOne.setText(myThread.getSaleMid().get(0));
                binding.downSale2One.setText(myThread.getSaleMid().get(1));
                binding.downSale3One.setText(myThread.getSaleMid().get(2));
                binding.bestByeTwo.setText(myThread.getByeBest().get(0));
                binding.bestBye2Two.setText(myThread.getByeBest().get(1));
                binding.bestBye3Two.setText(myThread.getByeBest().get(2));
                binding.bestSaleTwo.setText(myThread.getSaleBest().get(0));
                binding.bestSale2Two.setText(myThread.getSaleBest().get(1));
                binding.bestSale3Two.setText(myThread.getSaleBest().get(2));

                Log.e("check", "run: " + myThread.getByeMid().get(0));
            }
        });

        return binding.getRoot();

    }

    public void click() {

        binding.layoutHm.setOnClickListener(v -> {
            Log.e("TAG", "click:2 ");
            navController.navigate(R.id.action_navigation_home_to_navigation_dashboard);
        });


        binding.middleButton.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), " Средний курс за последние два часа \n" +
                    "по активным обменным пунктам города Бишкек", Toast.LENGTH_LONG).show();
        });

        binding.bestButton.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "Лучший курс по активным участникам. \n" +
                    "Нажмите на курс, чтобы перейти к списку.", Toast.LENGTH_LONG).show();
        });
    }
}