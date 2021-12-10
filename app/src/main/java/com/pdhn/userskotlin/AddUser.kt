package com.pdhn.userskotlin

import ViewModels.UserViewModel
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pdhn.userskotlin.databinding.AddUserBinding

class AddUser : AppCompatActivity(){
    private var user: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.add_user)
        val _binding =
            DataBindingUtil.setContentView<AddUserBinding>(this, R.layout.add_user)
        user = UserViewModel(this, _binding)
        _binding.userModel = user
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.colorBlack, null)
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ){
        super.onActivityResult(requestCode, resultCode, data)
        user!!.onActivityResult(requestCode, resultCode, data)
    }
}