package com.example.beneficiary.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiary.model.Beneficiary

class BeneficiaryAdapter(private val beneficiaryList: List<Beneficiary>) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = BeneficiaryView(parent.context)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beneficiary = beneficiaryList[position]
        val view = holder.itemView as BeneficiaryView
        view.bind(beneficiary)
    }

    override fun getItemCount(): Int {
        return beneficiaryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(beneficiary: Beneficiary) {
            bind(beneficiary)
        }
    }
}