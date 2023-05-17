package com.space.quiz_app.presentation.quiz_questions_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.space.quiz_app.R

class QuestionsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }



}