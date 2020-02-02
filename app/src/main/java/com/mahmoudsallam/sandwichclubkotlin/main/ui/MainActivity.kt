package com.mahmoudsallam.sandwichclubkotlin.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudsallam.sandwichclubkotlin.R
import com.mahmoudsallam.sandwichclubkotlin.details.DetailsActivity

class MainActivity : AppCompatActivity(), DetailsInterface {

    private lateinit var sandwichsRecyclerView: RecyclerView
    private lateinit var sandwichList: Array<String>
    private lateinit var sandwichAdapter: SandwichAdapter
    private lateinit var linearLayoutManger: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sandwichsRecyclerView = findViewById(R.id.sandwichName_rv)
        linearLayoutManger = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        sandwichList = resources.getStringArray(R.array.sandwich_names)
        sandwichAdapter = SandwichAdapter(this, sandwichList, this)
        sandwichsRecyclerView.layoutManager = linearLayoutManger
        sandwichsRecyclerView.itemAnimator = DefaultItemAnimator()
        sandwichsRecyclerView.adapter = sandwichAdapter

    }

    override fun openDetails(sandwichName: String) {
        var detailsIntent = Intent(this, DetailsActivity::class.java)
        detailsIntent.putExtra("SANDWICH_NAME", sandwichName)
        startActivity(detailsIntent)
    }
}
