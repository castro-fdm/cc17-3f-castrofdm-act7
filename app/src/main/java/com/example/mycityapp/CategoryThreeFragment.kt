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

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryThreeFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_category_three, container, false)

        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { view -> view.findNavController().navigate(R.id.action_categoryThreeFragment_to_dashboardFragment) }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.kabalikatfarm,
            R.drawable.pugarow,
            R.drawable.foodpark
        )

        textList = arrayOf(
            "Kabalikat People's Farm",
            "Pug-a-Row MTB",
            "Food and Music Park"
        )

        descList = arrayOf(
            "A vibrant community-driven agricultural project offering visitors a chance to experience sustainable farming firsthand. The farm’s peaceful ambiance, with its lush fields and organic gardens, creates a perfect backdrop for a variety of activities. Visitors can enjoy farm tours, participate in workshops on organic farming, and engage in hands-on activities such as planting, harvesting, or cooking with fresh farm ingredients. The farm also hosts eco-tourism events, nature walks, and community gatherings. People visit to learn about sustainable agriculture, support local farming, and enjoy interactive, educational experiences in a serene rural setting.",
            "An exciting and scenic mountain biking trail that attracts outdoor enthusiasts and adventure seekers. The trail winds through dense forests, rocky paths, and challenging terrain, offering riders a thrilling experience amid nature’s beauty. The trail’s ambiance is one of rugged tranquility, with breathtaking views of the surrounding landscapes, making it a favorite for nature lovers and bikers alike. People visit Pug-a-Row MTB Trail for its adrenaline-pumping rides, connection with nature, and the opportunity to test their biking skills in a peaceful, yet challenging, environment.",
            "A vibrant spot along the Manaoag River offers a wide range of local and street food favorites at affordable prices, typically ranging from ₱30 to ₱150. The park is especially popular at night, when the cool evening breeze and illuminated stalls create a lively, festive atmosphere perfect for enjoying meals with friends and family. The relaxed, outdoor setting becomes even more inviting as the night sets in, making it an ideal time to savor savory grilled dishes, sweet treats, and local snacks. People visit the Coastal Road food park at night for the enjoyable ambiance, delicious variety of foods, and the chance to unwind in a bustling yet chill environment."
        )

        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = AdapterThreeClass(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }
}