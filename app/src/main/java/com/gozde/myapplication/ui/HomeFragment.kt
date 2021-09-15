package com.gozde.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gozde.myapplication.R
import com.gozde.myapplication.databinding.FragmentHomeBinding
import com.gozde.myapplication.ui.adapter.CountriesAdapter
import com.gozde.myapplication.viewmodel.CountiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewModel: CountiesViewModel
    private val countriesAdapter = CountriesAdapter()

    private var fragmentHomeBinding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(CountiesViewModel::class.java)

        val binding = FragmentHomeBinding.bind(view)

        fragmentHomeBinding = binding

        binding.rvCountries.adapter = countriesAdapter

        //get data from viewmodel
        viewModel.getCountriesData()


        viewModel.liveCountries.observe(viewLifecycleOwner, {
            it?.let { countryList ->
                countriesAdapter.submitList(countryList)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBinding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}