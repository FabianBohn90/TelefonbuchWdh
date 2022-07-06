package com.example.telefonbuch

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.telefonbuch.adapter.ItemAdapter
import com.example.telefonbuch.data.Datasource
import com.example.telefonbuch.data.model.Contact
import com.example.telefonbuch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
                Toast.makeText(this, "Contact has been added", Toast.LENGTH_SHORT).show()
            }
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}
