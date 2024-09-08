package com.yusuf.domain.model.base

data class RootData<T>(
    val creditUsed: Int,
    val data: List<T>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)