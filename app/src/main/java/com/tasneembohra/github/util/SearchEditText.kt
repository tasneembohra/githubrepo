package com.tasneembohra.github.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tasneembohra.github.R
import kotlinx.android.synthetic.main.view_search_edit_text.view.*

class SearchEditText : FrameLayout {
    private val _searchTextLiveData = MutableLiveData<String>()
    val searchTextLiveData: LiveData<String>
        get() = _searchTextLiveData

    private var text: String
        set(value) {
            editText.setText(value)
        }
        get() = editText.text.toString()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.view_search_edit_text, this)

        btnSearch.setOnClickListener {
            editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            if (_searchTextLiveData.value.equals(text, ignoreCase = true)) return@setOnClickListener
            _searchTextLiveData.postValue(text)
        }
    }

    fun clear() {
        editText.setText("")
        _searchTextLiveData.postValue("")
    }

}