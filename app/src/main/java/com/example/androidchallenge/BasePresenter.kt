package com.example.androidchallenge

interface BasePresenter {
    fun onDestroy(): Any
}

interface BaseView<T> {
    fun onViewStateChanged(state: ViewState)
}

sealed class ViewState {
    object Loading : ViewState()
    object Ready : ViewState()
    data class Error(val message: String) : ViewState()
}