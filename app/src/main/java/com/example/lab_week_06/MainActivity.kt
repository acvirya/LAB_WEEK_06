package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
//Glide is used here to load the images
//Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
//Setup the layout manager for the recycler view
//A layout manager is used to set the structure of the item views
//For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)


//Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Leo",
                    "Loves to nap in the sun",
                    "https://cdn2.thecatapi.com/images/1bq.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Expert at finding snacks",
                    "https://cdn2.thecatapi.com/images/b1u.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Milo",
                    "A bit of a grump, but sweet",
                    "https://cdn2.thecatapi.com/images/9u4.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Chloe",
                    "Always wants to play",
                    "https://cdn2.thecatapi.com/images/aax.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Simba",
                    "Thinks he's a lion",
                    "https://cdn2.thecatapi.com/images/d55.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Bella",
                    "Elegant and poised",
                    "https://cdn2.thecatapi.com/images/d99.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Shadow",
                    "Master of hiding",
                    "https://cdn2.thecatapi.com/images/ebv.jpg"
                )
            )
        )
    }
//This will create a pop up dialog when one of the items from the recycler view
//    is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
//Set the title for the dialog
            .setTitle("Cat Selected")
//Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
//Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}
