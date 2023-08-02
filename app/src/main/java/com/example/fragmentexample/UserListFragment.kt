package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListFragment : Fragment() {

    private lateinit var userList: List<User>
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userList = listOf(User(1, "Hoàng", "design"), User(2, "Thiện","coder"), User(3, "Lộc","singer"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.user_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UserAdapter(userList) { user ->
            val userDetailFragment = UserDetailFragment.newInstance(user)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, userDetailFragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

        return view
    }
}
