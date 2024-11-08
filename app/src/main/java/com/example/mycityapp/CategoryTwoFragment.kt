package com.example.mycityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryTwoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var textList: Array<String>
    private lateinit var descList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category_two, container, false)

        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { it.findNavController().navigate(R.id.action_categoryTwoFragment_to_dashboardFragment) }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.manaoagchurch,
            R.drawable.virginswell,
            R.drawable.spiritualitycenter
        )

        textList = arrayOf(
            "Minor Basilica of Our Lady of the Rosary of Manaoag",
            "Virgins Well",
            "Our Lady of Manaoag Spirituality Center"
        )

        descList = arrayOf(
            "A revered pilgrimage site in Pangasinan, attracting visitors for both its spiritual significance and stunning architecture. The church’s serene ambiance is highlighted by its grand interiors, beautiful stained glass windows, and the iconic statue of Our Lady of Manaoag, believed to offer blessings and miracles. Pilgrims and tourists visit the church to seek divine intercession, offer prayers, and experience a peaceful retreat. Its historical and cultural importance, combined with its tranquil surroundings, makes it a must-visit destination for reflection and devotion.",
            "Located near the Manaoag Church in Pangasinan, is a sacred site known for its calm and spiritual ambiance. The well is believed to have healing powers, with many visitors seeking its water for blessings, protection, and miracles. Surrounded by lush greenery and peaceful surroundings, the site offers a tranquil space for reflection and prayer. People visit the Virgin’s Well not only for its historical and religious significance but also to experience its serene environment, making it a cherished spot for both locals and pilgrims.",
            "A peaceful retreat located near the Manaoag Church, offering a serene atmosphere for spiritual reflection and renewal. Surrounded by lush greenery and tranquil gardens, the center provides a quiet sanctuary for prayer, meditation, and spiritual activities. It is visited by people seeking solace, spiritual growth, and a deeper connection with God. Pilgrims and visitors come to the center to experience its calm environment, participate in religious programs, or simply enjoy the peaceful ambiance that enhances their spiritual journey."
        )

        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = AdapterTwoClass(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }

}