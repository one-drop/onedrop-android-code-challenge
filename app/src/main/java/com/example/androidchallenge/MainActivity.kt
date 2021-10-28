package com.example.androidchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TEMP might make sense to move some of the boilerplate stuff to a different module/package so it's clear what's their code and what we provided
// TEMP extend the latest material design components activity type

// TEMP - might be able to borrow some ideas from the twitter assignment
// https://drive.google.com/drive/folders/1DUPy_PJ1ZklG6UqIjn9yvyfpQpyr212F?usp=sharing

// TEMP we should have a development branch where we merge our PRs into
// but the main branch should only have one commit in the history that says "Initial code provided by One Drop"

// TEMP change project package name to today.onedrop.androidchallenge
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
