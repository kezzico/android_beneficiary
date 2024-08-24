package com.example.beneficiary.model

import org.json.JSONArray
import org.json.JSONObject

class BeneficiaryFactory {
    fun createBeneficiaryList(jsonString: String): List<Beneficiary> {
        // Read the input stream and parse its contents
        val jsonArray = JSONArray(jsonString)

        val beneficiaries = mutableListOf<Beneficiary>()

        for (i in 0 until jsonArray.length()) {
            val entry = jsonArray.getJSONObject(i)
            beneficiaries.add(this.createBeneficiary(entry))
        }

        return beneficiaries.toList()
    }

    fun createBeneficiary(jsonObject: JSONObject): Beneficiary {
            // Extract the values from the JSON object
        val lastName = jsonObject.getString("lastName")
        val firstName = jsonObject.getString("firstName")
        val designationCode = jsonObject.getString("designationCode")
        val beneType = jsonObject.getString("beneType")
        val socialSecurityNumber = jsonObject.getString("socialSecurityNumber")
        val dateOfBirth = jsonObject.getString("dateOfBirth")
        val middleName = jsonObject.optString("middleName", null)
        val phoneNumber = jsonObject.getString("phoneNumber")

        // Extract the address object from the JSON object
        val addressObject = jsonObject.getJSONObject("beneficiaryAddress")
        val beneficiaryAddress = BeneficiaryAddress(
            addressObject.getString("firstLineMailing"),
            addressObject.optString("scndLineMailing"),
            addressObject.getString("city"),
            addressObject.getString("zipCode"),
            addressObject.getString("stateCode"),
            addressObject.getString("country")
        )

        // Create and return the Beneficiary object
        return Beneficiary(
            lastName = lastName,
            firstName = firstName,
            designationCode = designationCode,
            beneType = beneType,
            socialSecurityNumber = socialSecurityNumber,
            dateOfBirth = dateOfBirth,
            middleName = middleName,
            phoneNumber = phoneNumber,
            beneficiaryAddress = beneficiaryAddress
        )
    }
}
