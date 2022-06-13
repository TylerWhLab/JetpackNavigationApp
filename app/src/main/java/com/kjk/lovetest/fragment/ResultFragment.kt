package com.kjk.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kjk.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    var option = -1
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 이전 fragment에서 보내온 data는 arguments로 받을 수 있다.
        option = arguments?.getInt("index")?:-1
        // 앨비스 연산자로 arguments?.getInt("index") 가 null이면 -1 반환


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)


        // 홈 버튼
        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }

    }

    fun setResult(option: Int) {
        when(option) {
            1 -> {
                tv_main.text = "틀림"
                tv_sub.text = "X"
            }
            2 -> {
                tv_main.text = "틀림"
                tv_sub.text = "X"
            }
            3 -> {
                tv_main.text = "틀림"
                tv_sub.text = "X"
            }
            4 -> {
                tv_main.text = "맞음"
                tv_sub.text = "O"
            }
        }
    }


}