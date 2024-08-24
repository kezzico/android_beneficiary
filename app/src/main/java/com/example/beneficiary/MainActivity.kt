package com.example.beneficiary

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiary.model.BeneficiaryFactory
import com.example.beneficiary.view.BeneficiaryAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Read the input stream and parse its contents
        val inputStream = resources.openRawResource(R.raw.beneficiary_info)
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        val beneficiaryFactory = BeneficiaryFactory()
        val beneficiaryList = beneficiaryFactory.createBeneficiaryList(jsonString)

        // Create a RecyclerView
        val recyclerView = RecyclerView(this)
        // Create a LinearLayoutManager to manage the layout of the RecyclerView
        val layoutManager = LinearLayoutManager(this)
        // Set the layout manager for the RecyclerView
        recyclerView.layoutManager = layoutManager

        // Create an adapter for the RecyclerView
        val adapter = BeneficiaryAdapter(beneficiaryList)
        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter

        // Set the RecyclerView as the content view
        setContentView(recyclerView)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        dividerItemDecoration.setDrawable(ColorDrawable(Color.BLACK)) // or use a drawable resource
        recyclerView.addItemDecoration(dividerItemDecoration)
    }
}

