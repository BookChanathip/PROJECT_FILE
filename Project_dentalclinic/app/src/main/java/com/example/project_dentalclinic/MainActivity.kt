package com.example.project_dentalclinic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun LOGIN(v: View) {
        setContentView(R.layout.home)
    }

    fun cancel(v: View) {
        setContentView(R.layout.activity_main)
    }

    fun service(v: View) {
        setContentView(R.layout.service)
    }

    fun dataClinic(v: View) {
        setContentView(R.layout.data_clinic)
    }

    fun clinicMap(v: View) {
        setContentView(R.layout.clinic_map)
    }

    fun booking(v: View) {
        setContentView(R.layout.booking)
    }

    fun register(v: View) {
        setContentView(R.layout.register)
    }

    fun home(v: View) {
        setContentView(R.layout.home)
    }


    fun login(v: View) {
        val api: LoginAPI = Retrofit.Builder()
            .baseUrl("http//10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginAPI::class.java)

        api.loginUser(
            username.text.toString(),
            password.text.toString()).enqueue(object : Callback<User> {


    override fun onResponse(call: Call<User>, response: Response<User>) {
        if (response.isSuccessful()) {
            Toast.makeText(
                applicationContext,
                "Login Successfull !!", LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Error", LENGTH_SHORT).show()
        }
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        Toast.makeText(applicationContext, "Incorrect !", Toast.LENGTH_LONG).show()
    }
})
}
}









