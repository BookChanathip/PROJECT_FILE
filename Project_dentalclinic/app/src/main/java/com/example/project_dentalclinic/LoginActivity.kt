package com.example.project_dentalclinic


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

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





    fun Login(v:View){
        val api : LoginAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginAPI ::class.java)

        api.loginUser(
            username.text.toString(),
            password.text.toString()).enqueue(object  : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>){
                if (response.isSuccessful()){
                    Toast.makeText(applicationContext,"เข้าสู่ระบบสำเร็จ",Toast.LENGTH_SHORT).show()
                    setContentView(R.layout.service)
                    setContentView(R.layout.data_clinic)
                    setContentView(R.layout.clinic_map)
                    setContentView(R.layout.home)


                }else{
                    Toast.makeText(applicationContext,"Incorrect !",Toast.LENGTH_SHORT).show()
                }
            }



            override fun onFailure(call: Call<User>,t: Throwable){
                Toast.makeText(applicationContext,"รหัสผ่านไม่ถูกต้อง !",Toast.LENGTH_LONG).show()

            }

        })

    }
}
