package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserDetailFragment : Fragment() {

    private var userId: Int = 0
    private var userName: String = ""
    private var userOccupation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getInt(ARG_USER_ID)
            userName = it.getString(ARG_USER_NAME) ?: ""
            userOccupation = it.getString(ARG_USER_OCCUPATION) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_detail, container, false)
        view.findViewById<TextView>(R.id.detail_user_name).text = userName
        view.findViewById<TextView>(R.id.detail_user_occupation).text = userOccupation


        return view
    }

    companion object {
        private const val ARG_USER_ID = "userId"
        private const val ARG_USER_NAME = "userName"
        private const val ARG_USER_OCCUPATION = "userOccupation"

        @JvmStatic
        fun newInstance(user: User) = UserDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_USER_ID, user.id)
                putString(ARG_USER_NAME, user.name)
                putString(ARG_USER_OCCUPATION, user.job)
            }
        }
    }
}
