package com.pdhn.userskotlin.ui.home

import ViewModels.UserViewModel
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pdhn.userskotlin.AddUser
import com.pdhn.userskotlin.R

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _user: UserViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        _user = UserViewModel(this.activity!!, root)
        val fab: FloatingActionButton = root.findViewById(R.id.fab)
        fab.setOnClickListener(this)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        setHasOptionsMenu(true)
        return root
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this.requireContext(), AddUser::class.java))
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu!!, inflater)
        _user!!.onCreateOptionsMenu(menu)
    }
}