package com.gozde.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gozde.myapplication.databinding.ItemCountryBinding
import com.gozde.myapplication.model.CountryResult

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    inner class CountriesViewHolder(binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val countryName = binding.tvCountry
        fun setData(item: CountryResult) {
            countryName.text = item.country
        }
    }

    private val diffUtil = object : DiffUtil.ItemCallback<CountryResult>() {
        override fun areItemsTheSame(oldItem: CountryResult, newItem: CountryResult): Boolean {
            return oldItem.country == newItem.country
        }

        override fun areContentsTheSame(oldItem: CountryResult, newItem: CountryResult): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    fun submitList(itemList: List<CountryResult>) {
        recyclerListDiffer.submitList(itemList)
    }

//    var countries: List<CountryResult>
//        get() = recyclerListDiffer.currentList
//        set(value) = recyclerListDiffer.submitList(countries)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesAdapter.CountriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return CountriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesAdapter.CountriesViewHolder, position: Int) {
        val country = recyclerListDiffer.currentList.get(position)
        holder.setData(country)
    }

    override fun getItemCount(): Int {
        return recyclerListDiffer.currentList.size
    }
}