package com.example.androidchallenge.mapper

interface ModelMapper<InT, OutT> {
    fun map(inType: InT): OutT
}