package com.inspiredcoda.aadpracticeproject.data

import com.inspiredcoda.aadpracticeproject.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(request : suspend () -> Response<T>): T{
        val response = request.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }
        if (response.code() == 503) {
            throw ApiException("Service Temporarily Unavailable")
        }

        if(response.code() == 500){
            throw ApiException("")
        }

        if (response.code() == 400) {
            throw ApiException("")
        }

        if (response.code() == 404){
            throw ApiException("Not Found!")
        }
        else {

            val error = response.errorBody()?.string()

            val message = StringBuilder()
            error?.let{
                try{
                    val v = JSONObject(it).getString("responseText")
                    message.append((v))
                }catch(e: JSONException){ }
                message.append("\n")
            }
            message.append("Error Code: ${response.code()}")
            throw ApiException(message.toString())

//            throw ApiException("Something went wrong")
        }
    }

}