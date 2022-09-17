package com.example.thridmfourthhm;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.thridmfourthhm.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemClick {

    private FragmentMainBinding binding;
    private ArrayList<Country> countries;
    public static final String KEY = "ID";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(LayoutInflater.from(getContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        CountryAdapter adapter = new CountryAdapter(countries, requireContext(), this::onItemClick);
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        countries = new ArrayList<>();
        countries.add(new Country("Евразия", "",R.drawable.ic_cna_3x, 1));
        countries.add(new Country("Северная Америка","", R.drawable.ic_caf, 2));
        countries.add(new Country("Южная Америка","", R.drawable.ic_ceu, 3));
        countries.add(new Country("Африка","", R.drawable.ic_csa, 4));
        countries.add(new Country("Австралия","", R.drawable.ic_cas, 5));
        countries.add(new Country("Антарктида","", R.drawable.ic_coc, 6));
    }

    @Override
    public void onItemClick(Country country) {
        Bundle bundle = new Bundle();
        SecondFragment fragment = new SecondFragment();
        bundle.putInt("ID", country.getKey_id());
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).
                addToBackStack("").commit();
    }
}