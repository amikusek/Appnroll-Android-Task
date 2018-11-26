package com.appnroll.recruitment.data.remote

class ApiManager {

    private val retrofitFactory = RetrofitFactory()

    private fun <T> getApi(clazz: Class<T>) = retrofitFactory.retrofit.create(clazz)
}
