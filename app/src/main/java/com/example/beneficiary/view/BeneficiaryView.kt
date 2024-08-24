package com.example.beneficiary.view

import android.content.Context
import android.graphics.Typeface
import android.widget.LinearLayout
import android.widget.TextView
import com.example.beneficiary.model.Beneficiary

class BeneficiaryView(context: Context) : LinearLayout(context) {
    private val textViewFirstName: TextView
    private val textViewLastName: TextView
    private val textViewDesignation: TextView
    private val textViewBeneficiaryType: TextView

    init {
        // Create a vertical LinearLayout to hold the labels and TextViews
        orientation = VERTICAL

        // Create a LinearLayout for each property
        val firstNameLayout = LinearLayout(context)
        val lastNameLayout = LinearLayout(context)
        val designationLayout = LinearLayout(context)
        val beneficiaryTypeLayout = LinearLayout(context)

        // Set the orientation of each LinearLayout to horizontal
        firstNameLayout.orientation = HORIZONTAL
        lastNameLayout.orientation = HORIZONTAL
        designationLayout.orientation = HORIZONTAL
        beneficiaryTypeLayout.orientation = HORIZONTAL

        // Create TextViews for the labels
        val labelFirstName = TextView(context)
        val labelLastName = TextView(context)
        val labelDesignation = TextView(context)
        val labelBeneficiaryType = TextView(context)

        // Set the label text and style
        labelFirstName.text = "First Name: "
        labelFirstName.setTypeface(null, Typeface.BOLD)
        labelLastName.text = "Last Name: "
        labelLastName.setTypeface(null, Typeface.BOLD)
        labelDesignation.text = "Designation: "
        labelDesignation.setTypeface(null, Typeface.BOLD)
        labelBeneficiaryType.text = "Beneficiary Type: "
        labelBeneficiaryType.setTypeface(null, Typeface.BOLD)

        // Create TextViews for the properties
        textViewFirstName = TextView(context)
        textViewLastName = TextView(context)
        textViewDesignation = TextView(context)
        textViewBeneficiaryType = TextView(context)

        // Add the labels and TextViews to the corresponding LinearLayouts
        firstNameLayout.addView(labelFirstName)
        firstNameLayout.addView(textViewFirstName)
        lastNameLayout.addView(labelLastName)
        lastNameLayout.addView(textViewLastName)
        designationLayout.addView(labelDesignation)
        designationLayout.addView(textViewDesignation)
        beneficiaryTypeLayout.addView(labelBeneficiaryType)
        beneficiaryTypeLayout.addView(textViewBeneficiaryType)

        // Add the LinearLayouts to the BeneficiaryView
        addView(firstNameLayout)
        addView(lastNameLayout)
        addView(designationLayout)
        addView(beneficiaryTypeLayout)
    }
    fun bind(beneficiary: Beneficiary) {
        textViewFirstName.text = beneficiary.firstName
        textViewLastName.text = beneficiary.lastName
        textViewDesignation.text = when (beneficiary.designationCode) {
            "C" -> "Contingent"
            "P" -> "Primary"
            else -> beneficiary.designationCode
        }
        textViewBeneficiaryType.text = beneficiary.beneType
    }
}