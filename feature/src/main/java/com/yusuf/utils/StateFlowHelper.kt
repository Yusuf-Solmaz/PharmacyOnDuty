package com.yusuf.utils

import kotlinx.coroutines.flow.MutableStateFlow

object StateFlowHelper {
    fun <T> createStateFlow(stateFlow: MutableStateFlow<T>? = null, initialValue: T): MutableStateFlow<T> {
        return stateFlow ?: MutableStateFlow(initialValue)
    }
}

