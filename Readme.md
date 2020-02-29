<!--
*** Thanks for checking out this README Template. If you have a suggestion that would
*** make this better, please fork the repo and create a pull request or simply open
*** an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo, twitter_handle, email
-->





<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->


<!-- PROJECT LOGO -->
<p align="center">
  <h3 align="center">ValidationInputLayout</h3>
  <p align="center">
    Simple and Easy Validation in Android Text Input
    <br />
    <a href="https://github.com/dionsaputra/validation-input-layout"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/dionsaputra/validation-input-layout">View Demo</a>
    ·
    <a href="https://github.com/dionsaputra/validation-input-layout/issues">Report Bug</a>
    ·
    <a href="https://github.com/dionsaputra/validation-input-layout/issues">Request Feature</a>
  </p>
</p>


<!-- GETTING STARTED -->
## Getting Started

### Installation
 
```gradle
dependencies {
    implementation 'com.github.dionsaputra:validator-input-layout:x.y.z'
}
```

<!-- USAGE EXAMPLES -->
## Usage

- Add ValidatorInputLayout in Layout Files

```xml
<com.ds.lib.ValidatorInputLayout
    android:id="@+id/inputNameLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/name"
    app:isRequired="true"
    app:requiredErrorMessage="@string/name_should_be_filled">

    <com.google.android.material.textfield.TextInputEditText
        android:id="@+id/inputName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPersonName" />

</com.ds.lib.ValidatorInputLayout>
```

- Attribute
  - `app:isRequired`, determine if your text input must be filled by user
  - `app:requiredErrorMessage`, error message to show if the input being required

- Add custom validator using `Validator` Class. The class receive argument `errorMessage` and kotlin-lambda function for validate input. Example:

  ```kt
  inputConfirmPasswordLayout.addValidator(
      ValidatorInputLayout.Validator("Password not match") {
          inputPassword.text?.toString() == inputConfirmPassword.text?.toString()
      }
  )
  ```
- Use `isValid` to check the input. Example:
  ```kt
  if (inputEmailLayout.isValid) {
    // your awesome code ...
  }
  ```

For more examples, please check to the sample Apps


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- LICENSE -->
## License
Distributed under the MIT License. See `LICENSE` for more information.
