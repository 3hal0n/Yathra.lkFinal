package com.example.yathralkfinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set click listener for Yala card
        view.findViewById<View>(R.id.yalaCard).setOnClickListener {
            startActivity(Intent(requireActivity(), YalaDetailsActivity::class.java))
        }
    }
}