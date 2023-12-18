package prihanto.crudkotlin.room

import android.content.Context
import android.util.Log
import android.widget.Toast
import prihanto.crudkotlin.ApiService
import prihanto.crudkotlin.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//import javax.security.auth.callback.Callback

class ApiCall {
    // this function takes a context and callback function
    // as a parameter, which will be called
    // when the API response is received

    fun getdata(context: Context, callback: (Users) -> Unit){


        // create a retrofit instance with the base URL and
        // a GsonConverterFactory for parsing the response

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://6309-180-254-113-97.ngrok-free.app/").addConverterFactory(GsonConverterFactory.create()).build()

        // Create an ApiService instance from the Retrofit instance

        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        // Cal the getData method of the ApiService
        // to make an API request
        val call: Call<Users> = service.getData()

        // use the enqueue() method of the Call object to
        // make an ansynchronous API request

        call.enqueue(object : Callback<Users>{
            // this is an anonymous inner class that implements the Callback interface
//            override fun onResponse(response: Response<Users>, retrofit: Retrofit?) {
//                TODO("Not yet implemented")
//            }

            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                // if the response is successful, parse the
                // response body to a DataModel object.
                if(response!!.isSuccessful){
                    val datas: Users = response.body() as Users

                    // call the callback function with the DataModel
                    // object as a parameter

                    callback(datas)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable?) {
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                Log.i("apifailed", "Api has no response")
            }
        })
    }
}