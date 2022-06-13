package com.kjk.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kjk.lovetest.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment(), View.OnClickListener { // 인터페이스는 여러개 상속 가능
    // implement members 로 onClick 자동 생성

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
        return inflater.inflate(R.layout.fragment_question, container, false)
    }


    // 뷰가 만들어지고 나서 호출되는 함수
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

//        // 람다식
//        question_next_btn.setOnClickListener {
//            navController.navigate(R.id.action_questionFragment_to_selectionFragment)
//        }

        question_next_btn.setOnClickListener(this) // onClick에 구현한 내용을 쓰겠다는 의미로 this 사용

    }

    override fun onClick(p0: View?) {
        // 버튼이 여러개라도 여기서 한 번에 관리
        when(p0?.id) {
            R.id.question_next_btn -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }

}