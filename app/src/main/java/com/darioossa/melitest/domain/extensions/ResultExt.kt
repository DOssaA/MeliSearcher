package com.darioossa.melitest.domain.extensions

import com.darioossa.melitest.domain.util.Result

val Result<Any>.isSuccess get() = this is Result.Success
val <T: Any> Result<T>.successData get() = (this as Result.Success).data
val Result<Any>.errorData get() = (this as Result.Error).throwable