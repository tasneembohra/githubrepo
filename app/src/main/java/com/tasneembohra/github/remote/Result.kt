package com.tasneembohra.github.remote

sealed class Result<T>
class LoadingState<T> : Result<T>()
class SuccessState<T>(val data: T) : Result<T>()
class ErrorState<T>(val error: ErrorModel) : Result<T>()