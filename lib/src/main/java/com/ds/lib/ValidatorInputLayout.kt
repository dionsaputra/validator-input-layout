package com.ds.lib

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class ValidatorInputLayout : TextInputLayout {

    var isValid = false
    private val validators = mutableListOf<Validator>()

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(ctx: Context, attrs: AttributeSet, defStyle: Int) : super(ctx, attrs, defStyle) {
        init(attrs)
    }

    fun addValidator(validator: Validator): ValidatorInputLayout {
        validators.add(validator)
        return this
    }

    private fun init(attrs: AttributeSet?) {
        if (!isInEditMode) {
            val typedArray =
                context.theme.obtainStyledAttributes(attrs, R.styleable.ValidatorInputLayout, 0, 0)
            try {
                if (typedArray.getBoolean(R.styleable.ValidatorInputLayout_isRequired, false)) {
                    val errorMessage =
                        typedArray.getString(R.styleable.ValidatorInputLayout_requiredErrorMessage)
                            .orEmpty()
                    validators.add(Validator(errorMessage) {
                        editText?.text?.trim()?.isNotEmpty() ?: false
                    })
                }
            } finally {
                typedArray.recycle()
            }

            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, st: Int, cnt: Int, after: Int) {}
                override fun afterTextChanged(s: Editable) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    performValidation()
                }
            }

            post {
                editText?.apply {
                    if (!isInEditMode) {
                        addTextChangedListener(textWatcher)
                    }
                }
            }
        }
    }

    private fun performValidation() {
        for (validator in validators) {
            isValid = validator.validate()
            isErrorEnabled = !isValid
            if (isErrorEnabled) {
                error = validator.errorMessage
                break
            } else {
                error = null
            }
        }
    }

    class Validator(val errorMessage: String, val validate: () -> Boolean)
}
