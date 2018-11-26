package com.appnroll.recruitment.data._base

abstract class BaseMapper<T, R> {

    protected abstract fun mapOrReturnNull(from: T): R?

    fun mapOrSkip(from: List<T>?): List<R> =
            mutableListOf<R>()
                    .apply {
                        from?.forEach {
                            mapOrReturnNull(it)?.let { add(it) }
                        }
                    }

    fun mapOrThrow(from: T?): R =
            from?.let { mapOrReturnNull(it) }
                    ?: throw IllegalStateException()
}
