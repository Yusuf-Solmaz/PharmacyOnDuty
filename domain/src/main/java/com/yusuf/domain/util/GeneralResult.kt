package com.yusuf.domain.util

sealed class GeneralResult<out R> {
    data class Success<out R>(val data: R?) : GeneralResult<R>()
    data class Error(val message:String) : GeneralResult<Nothing>()
    data object Loading : GeneralResult<Nothing>()
}