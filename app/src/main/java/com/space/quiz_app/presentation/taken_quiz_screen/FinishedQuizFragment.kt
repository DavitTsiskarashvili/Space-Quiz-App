package com.space.quiz_app.presentation.taken_quiz_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.databinding.FragmentTakenQuizBinding

class FinishedQuizFragment : Fragment() {

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
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding?.backButton?.setOnClickListener {
            findNavController().navigate(FinishedQuizFragmentDirections.actionTakenQuizFragmentToHomeFragment())
        }
    }

}