package com.space.quiz_app.presentation.quiz_home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.databinding.FragmentHomeBinding
import com.space.quiz_app.databinding.FragmentStartBinding
import com.space.quiz_app.presentation.quiz_start_screen.StartFragmentDirections

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation()
    }

    private fun navigation() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding?.logOutButton?.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuestionsFragment())
        }
        binding?.gpaButton?.gpaDetailsTextView?.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTakenQuizFragment())
        }
    }

}