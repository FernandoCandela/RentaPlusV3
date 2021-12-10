package com.pdhn.userskotlin

import ViewModels.UserViewModel
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pdhn.userskotlin.databinding.DetailsUserBinding

class DetailsUser : AppCompatActivity(){
    private var user: UserViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.details_user)
        val _binding =
            DataBindingUtil.setContentView<DetailsUserBinding>(this, R.layout.details_user)
        user = UserViewModel(this, _binding)
        _binding.details = user
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.colorBlack, null)
    }
    override fun onBackPressed(){
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        )
        finish()
    }
}