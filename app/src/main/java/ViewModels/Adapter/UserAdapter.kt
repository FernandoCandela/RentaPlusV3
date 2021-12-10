package ViewModels.Adapter

import Models.Pojo.User
import android.content.res.ColorStateList
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pdhn.userskotlin.R
import com.pdhn.userskotlin.databinding.ItemUserBinding

class UserAdapter (
    userList: List<User>,
    listener: AdapterListener?
) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>(){
    private val _userList: List<User> = userList
    private var _layoutInflater: LayoutInflater? = null
    private val _listener: AdapterListener? = listener

    inner class MyViewHolder(val _binding: ItemUserBinding) :
        RecyclerView.ViewHolder(_binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder{
        if (_layoutInflater == null) {
            _layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ItemUserBinding>(
            _layoutInflater!!,
            R.layout.item_user,
            parent,
            false
        )
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ){
        val user = _userList[position]
        holder._binding.user = user
        val bytes = user.image
        val _selectedImage = BitmapFactory.decodeByteArray(bytes, 0, bytes!!.size)
        holder._binding!!.thumbnail.setImageBitmap(_selectedImage)
        holder._binding.cardViewUser.setOnClickListener { v: View? ->
            _listener?.onUserClicked(user)
        }
        var fab = holder._binding.floatingActionButton
        fab.setOnClickListener{v: View? ->
            _listener?.onUserDelete(user)
        }
        if (user.active != ""){
            val active = user.active.toBoolean()
            val r: Int = if (active) R.color.colorWhite else R.color.colorGray
            fab.imageTintList = ColorStateList.valueOf(
                fab.context.resources.getColor(r, null)
            )
        }
    }
    override fun getItemCount(): Int {
        return _userList.size
    }
    interface AdapterListener {
        fun onUserClicked(user: User?)
        fun onUserDelete(user: User?)
    }
}