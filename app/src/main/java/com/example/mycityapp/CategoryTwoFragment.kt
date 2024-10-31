package com.example.mycityapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_category_two, container, false)

        val backBtn = layout.findViewById<ImageButton>(R.id.backButton)

        backBtn.setOnClickListener {
            view -> view.findNavController().navigate(R.id.action_categoryTwoFragment_to_dashboardFragment)
        }

        return layout
    }

}