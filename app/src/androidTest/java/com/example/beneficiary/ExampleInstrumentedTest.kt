package com.example.beneficiary

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.beneficiary.model.Beneficiary
import com.example.beneficiary.model.BeneficiaryFactory

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var beneficiaries: List<Beneficiary>

    @Before
    fun setup() {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val inputStream = context.resources.openRawResource(com.example.beneficiary.R.raw.beneficiary_info)

        val factory = BeneficiaryFactory()
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        beneficiaries = factory.createBeneficiaryList(jsonString);
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

            /**
        ```JSON
        [
          {
            "lastName": "Smith",
            "firstName": "John",
            "designationCode": "P",
            "beneType": "Spouse",
            "socialSecurityNumber": "XXXXX3333",
            "dateOfBirth": "04201979",
            "middleName": "D",
            "phoneNumber": "3035555555",
            "beneficiaryAddress": {
              "firstLineMailing": "8515 E Orchard Rd",
              "scndLineMailing": null,
              "city": "Greenwood Village",
              "zipCode": "80111",
              "stateCode": "CO",
              "country": "US"
            }
          },
          {
            "lastName": "Smith",
            "firstName": "Jane",
            "designationCode": "C",
            "beneType": "Child",
            "socialSecurityNumber": "XXXXX4664",
            "dateOfBirth": "01112012",
            "middleName": "E",
            "phoneNumber": "3034455555",
            "beneficiaryAddress": {
              "firstLineMailing": "8515 E Orchard Rd",
              "scndLineMailing": null,
              "city": "Greenwood Village",
              "zipCode": "80111",
              "stateCode": "CO",
              "country": "US"
            }
          },
          {
            "lastName": "Smith",
            "firstName": "Mary",
            "designationCode": "C",
            "beneType": "Child",
            "socialSecurityNumber": "XXXXX3645",
            "dateOfBirth": "02122013",
            "middleName": "E",
            "phoneNumber": "2035557558",
            "beneficiaryAddress": {
              "firstLineMailing": "8515 E Orchard Rd",
              "scndLineMailing": null,
              "city": "Greenwood Village",
              "zipCode": "80111",
              "stateCode": "CO",
              "country": "US"
            }
          },
          {
            "lastName": "Smith",
            "firstName": "David",
            "designationCode": "C",
            "beneType": "Child",
            "socialSecurityNumber": "XXXXX7652",
            "dateOfBirth": "09022013",
            "middleName": "E",
            "phoneNumber": "8094567777",
            "beneficiaryAddress": {
              "firstLineMailing": "8515 E Orchard Rd",
              "scndLineMailing": null,
              "city": "Greenwood Village",
              "zipCode": "80111",
              "stateCode": "CO",
              "country": "US"
            }
          },
          {
            "lastName": "Smith",
            "firstName": "Peter",
            "designationCode": "C",
            "beneType": "Child",
            "socialSecurityNumber": "XXXXX8756",
            "dateOfBirth": "10052014",
            "middleName": "E",
            "phoneNumber": "8194587755",
            "beneficiaryAddress": {
              "firstLineMailing": "8515 E Orchard Rd",
              "scndLineMailing": null,
              "city": "Greenwood Village",
              "zipCode": "80111",
              "stateCode": "CO",
              "country": "US"
            }
          }
        ]
        */

    @Test
    fun beneficiaryModelConstructor_WithValidJson_CreatesModel() {
        assertEquals(5, beneficiaries.count())

        // Asserting the properties of each beneficiary
        assertEquals("John", beneficiaries[0].firstName)
        assertEquals("Smith", beneficiaries[0].lastName)
        assertEquals("P", beneficiaries[0].designationCode)
        assertEquals("Spouse", beneficiaries[0].beneType)
        assertEquals("XXXXX3333", beneficiaries[0].socialSecurityNumber)
        assertEquals("04201979", beneficiaries[0].dateOfBirth)
        assertEquals("D", beneficiaries[0].middleName)
        assertEquals("3035555555", beneficiaries[0].phoneNumber)
        assertEquals("8515 E Orchard Rd", beneficiaries[0].beneficiaryAddress.firstLineMailing)

        assertNull(beneficiaries[0].beneficiaryAddress.scndLineMailing)
        assertEquals("Greenwood Village", beneficiaries[0].beneficiaryAddress.city)
        assertEquals("80111", beneficiaries[0].beneficiaryAddress.zipCode)
        assertEquals("CO", beneficiaries[0].beneficiaryAddress.stateCode)
        assertEquals("US", beneficiaries[0].beneficiaryAddress.country)

        assertEquals("Jane", beneficiaries[1].firstName)
        assertEquals("Smith", beneficiaries[1].lastName)
        assertEquals("C", beneficiaries[1].designationCode)
        assertEquals("Child", beneficiaries[1].beneType)
        assertEquals("XXXXX4664", beneficiaries[1].socialSecurityNumber)
        assertEquals("01112012", beneficiaries[1].dateOfBirth)
        assertEquals("E", beneficiaries[1].middleName)
        assertEquals("3034455555", beneficiaries[1].phoneNumber)
        assertEquals("8515 E Orchard Rd", beneficiaries[1].beneficiaryAddress.firstLineMailing)
        assertNull(beneficiaries[1].beneficiaryAddress.scndLineMailing)
        assertEquals("Greenwood Village", beneficiaries[1].beneficiaryAddress.city)
        assertEquals("80111", beneficiaries[1].beneficiaryAddress.zipCode)
        assertEquals("CO", beneficiaries[1].beneficiaryAddress.stateCode)
        assertEquals("US", beneficiaries[1].beneficiaryAddress.country)

        assertEquals("Mary", beneficiaries[2].firstName)
        assertEquals("Smith", beneficiaries[2].lastName)
        assertEquals("C", beneficiaries[2].designationCode)
        assertEquals("Child", beneficiaries[2].beneType)
        assertEquals("XXXXX3645", beneficiaries[2].socialSecurityNumber)
        assertEquals("02122013", beneficiaries[2].dateOfBirth)
        assertEquals("E", beneficiaries[2].middleName)
        assertEquals("2035557558", beneficiaries[2].phoneNumber)
        assertEquals("8515 E Orchard Rd", beneficiaries[2].beneficiaryAddress.firstLineMailing)
        assertNull(beneficiaries[2].beneficiaryAddress.scndLineMailing)
        assertEquals("Greenwood Village", beneficiaries[2].beneficiaryAddress.city)
        assertEquals("80111", beneficiaries[2].beneficiaryAddress.zipCode)
        assertEquals("CO", beneficiaries[2].beneficiaryAddress.stateCode)
        assertEquals("US", beneficiaries[2].beneficiaryAddress.country)

        assertEquals("David", beneficiaries[3].firstName)
        assertEquals("Smith", beneficiaries[3].lastName)
        assertEquals("C", beneficiaries[3].designationCode)
        assertEquals("Child", beneficiaries[3].beneType)
        assertEquals("XXXXX7652", beneficiaries[3].socialSecurityNumber)
        assertEquals("09022013", beneficiaries[3].dateOfBirth)
        assertEquals("E", beneficiaries[3].middleName)
        assertEquals("8094567777", beneficiaries[3].phoneNumber)
        assertEquals("8515 E Orchard Rd", beneficiaries[3].beneficiaryAddress.firstLineMailing)
        assertNull(beneficiaries[3].beneficiaryAddress.scndLineMailing)
        assertEquals("Greenwood Village", beneficiaries[3].beneficiaryAddress.city)
        assertEquals("80111", beneficiaries[3].beneficiaryAddress.zipCode)
        assertEquals("CO", beneficiaries[3].beneficiaryAddress.stateCode)
        assertEquals("US", beneficiaries[3].beneficiaryAddress.country)

        assertEquals("Peter", beneficiaries[4].firstName)
        assertEquals("Smith", beneficiaries[4].lastName)
        assertEquals("C", beneficiaries[4].designationCode)
        assertEquals("Child", beneficiaries[4].beneType)
        assertEquals("XXXXX8756", beneficiaries[4].socialSecurityNumber)
        assertEquals("10052014", beneficiaries[4].dateOfBirth)
        assertEquals("E", beneficiaries[4].middleName)
        assertEquals("8194587755", beneficiaries[4].phoneNumber)
        assertEquals("8515 E Orchard Rd", beneficiaries[4].beneficiaryAddress.firstLineMailing)
        assertNull(beneficiaries[4].beneficiaryAddress.scndLineMailing)
        assertEquals("Greenwood Village", beneficiaries[4].beneficiaryAddress.city)
        assertEquals("80111", beneficiaries[4].beneficiaryAddress.zipCode)
        assertEquals("CO", beneficiaries[4].beneficiaryAddress.stateCode)
        assertEquals("US", beneficiaries[4].beneficiaryAddress.country)
    }
}