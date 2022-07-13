package com.example.telefonbuch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.telefonbuch.data.model.Contact
import com.example.telefonbuch.databinding.ListItemBinding
import com.example.telefonbuch.ui.HomeFragmentDirections
import com.google.android.material.card.MaterialCardView

class ItemAdapter(
    private val dataset: List<Contact>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val nameText: TextView = binding.nameTxt
        val teleNrText: TextView = binding.telenrTxt
        val contactCard: MaterialCardView = binding.contactCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentContact = dataset[position]

        holder.teleNrText.text = currentContact.teleNr
        holder.nameText.text = currentContact.name

        holder.contactCard.setOnClickListener {
            val navController = holder.itemView.findNavController()

            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    name =
                    currentContact.name,
                    telNr =
                    currentContact.teleNr
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
