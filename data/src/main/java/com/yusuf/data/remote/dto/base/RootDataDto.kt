package com.yusuf.data.remote.dto.base

data class RootDataDto<T>(
    val creditUsed: Int,
    val data: List<T>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)