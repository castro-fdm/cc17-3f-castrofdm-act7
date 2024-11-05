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

class CategoryOneFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_category_one, container, false)

        // Set up the back button navigation
        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { it.findNavController().navigate(R.id.action_categoryOneFragment_to_dashboardFragment) }

        // Initialize the RecyclerView and data
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.barista_brew,
            R.drawable.baloking,
            R.drawable.el_garahe,
            R.drawable.donbenitos,
            R.drawable.tastefromthegreens
        )

        textList = arrayOf(
            "Barista Brew Cafe",
            "Baloking Restaurant",
            "El Garahe",
            "Don Benitos",
            "Tastes from the Greens"
        )

        descList = arrayOf(
            "Offers a charming, laid-back café experience with a rustic interior and cozy ambiance. Perfectly situated near the Manaoag Church, it’s an inviting stop for coffee lovers and travelers. The café serves high-quality coffee made from locally sourced beans, alongside a selection of pastries, sandwiches, and light meals. Prices are reasonable, making it an ideal spot to enjoy specialty drinks without stretching the budget. With its warm, friendly vibe and Instagram-worthy decor, Barista Brew Coffee provides a relaxing retreat for unwinding or meeting up with friends.",
            "A vibrant restaurant celebrated for its authentic Filipino and Chinese flavors and hearty servings. it’s a favorite among locals and tourists alike, offering a wide range of traditional dishes, including its signature lechon kawali and kare-kare. The relaxed atmosphere and friendly staff make Baloking a great place to experience the comforting taste of Filipino home-cooked meals, whether for a quick bite or a family gathering.",
            "A trendy dining spot with a unique industrial-style ambiance that gives off a relaxed, garage-inspired vibe. Known for its affordable and generously portioned meals, the menu includes a variety of crowd-pleasers like grilled meats, sizzling platters, burgers, and local favorites. Prices are budget-friendly, making it an ideal spot for students, families, and travelers. With casual outdoor seating, El Garahe offers a laid-back experience perfect for enjoying tasty comfort food and hanging out with friends or family.",
            "A delightful spot specializing in traditional Filipino delicacies. Known for its soft, flavorful cassava cake and the chewy, coconut-coated pichi-pichi, this charming eatery offers a taste of authentic Filipino treats that are perfect for snacking or as gifts. Prices are affordable, making it accessible for anyone wanting to indulge in these classic desserts.",
            "Offers a fresh and healthy dining with a scenic view. Overlooking lush surroundings, this eatery combines vibrant, wholesome dishes with a serene, nature-inspired ambiance. The menu focuses on salads, smoothies, grain bowls, and vegetarian options, crafted with locally sourced ingredients to deliver nourishing flavors. Prices are reasonable, making it an inviting choice for health-conscious diners. With its beautiful view and cozy, green-themed decor, Tastes from the Greens offers a refreshing retreat for a relaxed meal amidst nature."
        )

        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = AdapterClass(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }
}
