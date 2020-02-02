package com.mahmoudsallam.sandwichclubkotlin.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mahmoudsallam.sandwichclubkotlin.R
import kotlinx.android.synthetic.main.activity_details.*
import org.json.JSONObject

class DetailsActivity : AppCompatActivity() {
    lateinit var details: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var sandwichName = intent.getStringExtra("SANDWICH_NAME")
        var detailsList: Array<String> = resources.getStringArray(R.array.sandwich_details)
        getSandwichDetails(sandwichName = sandwichName, detailsList = detailsList)

    }

    fun getSandwichDetails(sandwichName: String, detailsList: Array<String>) {
        for (sandwich in detailsList.indices) {
            if (detailsList[sandwich].contains(sandwichName)) {
                details = detailsList[sandwich]
                var detailsAsJSON = JSONObject(details)
                var name: JSONObject = detailsAsJSON.get("name") as JSONObject
                var mainName = name.get("mainName")
                alsoKnownAs_tv.text = mainName.toString()

                var placeOfOrigin = detailsAsJSON.get("placeOfOrigin")
                placeOfOrigin_tv.text = placeOfOrigin.toString()

                var description = detailsAsJSON.get("description")
                description_tv.text = description.toString()

                var imageURL = detailsAsJSON.get("image")
                Glide.with(this).load(imageURL).into(sandwich_iv)
                var ingredients = detailsAsJSON.getJSONArray("ingredients")

                var ingredientsBuilder: StringBuilder = StringBuilder()
                for (i in 0 until ingredients.length()) {
                    ingredientsBuilder.append(ingredients.get(i)).append("\n")
                }

                ingredients_tv.text = ingredientsBuilder.toString()


            }
        }
    }

}
