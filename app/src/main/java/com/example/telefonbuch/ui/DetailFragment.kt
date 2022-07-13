package com.example.telefonbuch.ui

import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.telefonbuch.R
import com.example.telefonbuch.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var nameId = "name"
    private var telNrId = "telNr"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nameId = it.getString("name").toString()
            telNrId = it.getString("telNr").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.contactNameDetail.text = nameId
        binding.contaktTelNrDetail.text = telNrId

        binding.floatingActionButton.setOnClickListener {
            view.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToEditFragment())

            Toast.makeText(this.context, "Working", Toast.LENGTH_LONG).show()
        }
    }
}
