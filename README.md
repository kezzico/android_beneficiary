# Android Beneficiary

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## Description

This project is a Android Native application that reads a JSON file containing an Array and displays some of the data in a RecyclerView. The RecyclerView is used to efficiently display a large list of items, and the JSON data is parsed and displayed using a custom adapter.

Checkout the [code walkthrough](https://drive.google.com/file/d/1piyeun7zZ1rMVJG0D10pKX8cezL190yA/view?usp=share_link) for a tour of the Android Beneficiary's codebase.

This application does not use Jetpack, Hermes, or Android XML. All views are created in code

## Usage

Run the MainActivity to view the JSON data embedded in the application.

## Tests

Run ExampleInstrumentTests on device to run JSON parsing tests.

## Ideas for future development

- Better handling of Null values

- Localization of Contingent / Primary strings hard coded into the application

- Colors, layouts, animations, font styles, responsiveness

- JSON in the cloud

- More types, like DOB and SSN. Custom views to represent the complex subtypes.

## Concepts

**com.example.beneficiary.model**

The `Beneficiary` object and `BeneficiaryAddress` represent the data present in the data file. JSON data is read from `res/raw` and is assumed to be a JSONArray.

**com.example.beneficiary.view**

The `BeneficiaryAdapter` is a custom adapter class in the `com.example.beneficiary.view` package. It is responsible for binding the data from a Beneficiary object to a BeneficiaryView

## License

This project is licensed under the [MIT License](LICENSE).

## About the Author

Lee Irvine is a technical consultant skilled in mobile technology. He is experienced in a range of different cross platform and native rendering technologies including UIKit, React Native, Flutter, and Android Views.

[LinkedIn Profile](https://www.linkedin.com/in/lee-irvine-b2617913/)

[Resume](http://kezzi.co/lee-resume)

[Code walkthrough](https://drive.google.com/file/d/1piyeun7zZ1rMVJG0D10pKX8cezL190yA/view?usp=share_link)
