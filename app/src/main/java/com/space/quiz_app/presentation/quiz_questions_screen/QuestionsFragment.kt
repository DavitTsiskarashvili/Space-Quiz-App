package com.space.quiz_app.presentation.quiz_questions_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {

    private var binding: FragmentQuestionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding?.cancelButton?.setOnClickListener {
            findNavController().navigate(QuestionsFragmentDirections.actionQuestionsFragmentToHomeFragment())
        }
    }

}