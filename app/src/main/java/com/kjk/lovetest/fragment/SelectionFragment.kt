package com.kjk.lovetest.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kjk.lovetest.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(), View.OnClickListener {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        // 버튼에 리스너 설정, 구현은 onClick()에서
        btn_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
    }

    // fragment class에서 View.OnClickListener 상속 받아야 이렇게 쓸 수 있는듯
    override fun onClick(p0: View?) {
        Log.d("onClick_view", "${p0?.id}")
        Log.d("r_id_option1", "${R.id.option_1}")
        when(p0?.id) { // view가 null 이 아니면 id 가져옴, view가 null이면 null 반환
            R.id.option_1 -> { navigateWithIndex(1) }
            R.id.option_2 -> { navigateWithIndex(2) }
            R.id.option_3 -> { navigateWithIndex(3) }
            R.id.option_4 -> { navigateWithIndex(4) }
            R.id.btn_back -> {
                navController.popBackStack() // 뒤로 가기
            }
        }
    }

    fun navigateWithIndex(index: Int) {
        // 번들로 다음 프레그먼트로 데이터 전달
        val bundle = bundleOf("index" to index) // key: "index", value: index
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }

}