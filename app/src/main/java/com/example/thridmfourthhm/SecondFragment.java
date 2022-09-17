package com.example.thridmfourthhm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.thridmfourthhm.databinding.FragmentSecondBinding;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ArrayList<Country> country;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        CountryAdapter adapter = new CountryAdapter(country, requireContext(), this::onItemClick);
        binding.recyclerView.setAdapter(adapter);
    }


    private void loadData() {
        Bundle bundle = getArguments();
        country = new ArrayList<>();
        int continent = bundle.getInt("ID");
        switch (continent) {
            case 1:
                country.add(new Country("Киргизия","Бишкек", R.drawable.ic_kg,1));
                country.add(new Country("Аргентина","Буэнос-Айрес", R.drawable.ic_ar_3x,1));
                country.add(new Country("Канада","Оттава", R.drawable.ic_ca_3x,1));
                country.add(new Country("Австралия","Канберра", R.drawable.ic_au_3x,1));
                country.add(new Country("Марокко","Рабат", R.drawable.ic_ma_3x,1));
                break;
            case 2:
                country.add(new Country("Сша","Вашингтон", R.drawable.ic_us_3x,1));
                country.add(new Country("Венесуэлы","Каракас", R.drawable.ic_ve_3x,1));
                country.add(new Country("Уругвай", "Монтевидео",R.drawable.ic_uy_3x,1));
                country.add(new Country("Палау","Нгерулдмуд", R.drawable.ic_pw_3x,1));
                country.add(new Country("Швейцария","Берн", R.drawable.ic_to_3x,1));
                break;
            case 3:
                country.add(new Country("Норвегия","Осло", R.drawable.ic_no_3x,1));
                country.add(new Country("Мексика", "Мехико",R.drawable.ic_mx_3x,1));
                country.add(new Country("Европа", "",R.drawable.ic_eu,1));
                country.add(new Country("Венесуэлы", "Каракас",R.drawable.ic_ve_3x,1));
                country.add(new Country("Франция","Париж", R.drawable.ic_fr_3x,1));
                break;
            case 4:
                country.add(new Country("Испания","Мадрид", R.drawable.ic_es_3x,1));
                country.add(new Country("Корея","Сеул", R.drawable.ic_kr,1));
                country.add(new Country("Панама","Панама", R.drawable.ic_pa_3x,1));
                country.add(new Country("Нигерия","Абуджа", R.drawable.ic_ng_3x,1));
                country.add(new Country("Фолклендский остров","Порт-Стэнли", R.drawable.ic_ky_3x,1));
                break;
            case 5:
                country.add(new Country("Таиланд","Бангкок", R.drawable.ic_cr_3x,1));
                country.add(new Country("Германия", "Берлин",R.drawable.ic_de_3x,1));
                country.add(new Country("Новая Зеландия","Веллингтон", R.drawable.ic_fj_3x,1));
                country.add(new Country("Швейцария","Берн", R.drawable.ic_to_3x,1));
                country.add(new Country("Сша","Вашингтон",R.drawable.ic_us_3x,1));
                break;
            case 6:
                Toast.makeText(requireActivity(), "КАВАЛЬСКИЙ", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new MemFragment()).commit();
                break;
        }
    }

    private void onItemClick(Country country) {
    }
}