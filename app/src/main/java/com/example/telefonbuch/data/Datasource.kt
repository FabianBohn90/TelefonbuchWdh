package com.example.telefonbuch.data

import com.example.telefonbuch.data.model.Contact

class Datasource() {

    fun loadContacts(): MutableList<Contact> {
        return mutableListOf(
            Contact("Alix Toxaz", "+49 155 03173420"),
            Contact("Kirda Pranqzo", "+49 163 55564169"),
            Contact("Alaab Rutila", "+49 191 70470452"),
            Contact("Tarla Funqo", "+49 176 88637345"),
            Contact("Aarnus Zarbelle", "+49 178 88637545"),
            Contact("Torinha Saa", "+49 197 86375542"),
            Contact("Haqus Zuxitu", "+49 130 88637998"),
            Contact("Frostal Xaxum", "+49 150 86373324"),
            Contact("Termonto Vandos", "+49 120 86376654"),
            Contact("Contom Vanabella", "+49 177 86373345"),
            Contact("Aamerta Haraz", "+49 153 63766788")
        )
    }
}
