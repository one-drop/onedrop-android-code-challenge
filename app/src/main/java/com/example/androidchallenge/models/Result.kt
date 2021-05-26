package com.example.androidchallenge.models

sealed class Result<T> {
    open class Success<T>(val data: T) : Result<T>()

    /**
     * Holds error information.
     *
     * Note: We could create a data structure that better represents a "throwable"
     * that fits OneDrop needs.
     */
    open class Error<T>(val error: Throwable) : Result<T>()
}


/**
 * Handles result generically and returns it if response is successful and non-null. Errors are
 * thrown and need to be handled by the caller.
 *
 * Users will need to wrap this function in a try/catch block to handle errors.
 *
 * @param T
 */
fun <T> Result<T>.handle(): T {
    if (this is Result.Error) throw error
    else return (this as Result.Success).data
}