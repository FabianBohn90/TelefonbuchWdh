package com.example.telefonbuch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.telefonbuch.R
import com.example.telefonbuch.adapter.ItemAdapter
import com.example.telefonbuch.data.Datasource
import com.example.telefonbuch.data.model.Contact
import com.example.telefonbuch.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contact = Datasource().loadContacts()

        binding.recview.adapter = ItemAdapter(contact)

        binding.hinzBtn.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val teleNr = binding.telefonnummerInput.text.toString()

            if (name != "" && teleNr != "") {
                contact.add(0, Contact(name, teleNr))

                binding.recview.adapter?.notifyItemInserted(0)
                binding.nameInput.setText("")
                binding.telefonnummerInput.setText("")
//                Toast.makeText(this, "Contact has been added", Toast.LENGTH_SHORT).show()
            }
//            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}
