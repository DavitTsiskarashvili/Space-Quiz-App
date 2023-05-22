package com.space.quiz_app.presentation.taken_quiz_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.databinding.FragmentHomeBinding
import com.space.quiz_app.databinding.FragmentTakenQuizBinding
import com.space.quiz_app.presentation.quiz_home_screen.HomeFragmentDirections

class TakenQuizFragment : Fragment() {

    private var binding: FragmentTakenQuizBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTakenQuizBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation()
    }

    private fun navigation() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding?.backButton?.setOnClickListener {
            findNavController().navigate(TakenQuizFragmentDirections.actionTakenQuizFragmentToHomeFragment())
        }
    }

}