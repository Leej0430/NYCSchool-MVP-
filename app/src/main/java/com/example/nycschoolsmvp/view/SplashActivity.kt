package com.example.nycschoolsmvp.view

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.nycschoolsmvp.R
import java.util.jar.Manifest

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        requestPermissionAtRuntime()
        Thread(Runnable {
            Thread.sleep(3000)
            startActivity(Intent(this,MainActivity::class.java))
        }).start()
    }

    private fun requestPermissionAtRuntime(){
        val accessGranted = ContextCompat.checkSelfPermission(this,
        android.Manifest.permission.INTERNET)
        if(accessGranted == PackageManager.PERMISSION_DENIED)
            askPermissionRationale()
    }
    private fun askPermissionRationale(){
        requestPermissions(arrayOf(android.Manifest.permission.INTERNET),199)
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {
        if(requestCode==199 && grantResults.size>0){
            Toast.makeText(this,"Gracias!",Toast.LENGTH_SHORT).show()
        }
        else{

        }

    }
}