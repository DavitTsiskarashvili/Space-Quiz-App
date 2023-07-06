package com.example.corecommon.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.corecommon.base.view_model.QuizBaseViewModel
import com.example.corecommon.common.extensions.observeNonNullValue
import com.example.corecommon.common.extensions.showToast
import com.example.corecommon.common.utils.navigation.NavigationCommand
import com.example.corecommon.common.utils.observeNonNull
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

abstract class QuizBaseFragment<VM : QuizBaseViewModel> : Fragment() {

    abstract val viewModelClass: KClass<VM>
    protected val viewModel: VM by viewModelForClass(clazz = viewModelClass)

    protected abstract val layout: Int

    abstract fun onBind()
    abstract fun onCreateFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind()
        observeNavigation()
        observeError()
    }

    private fun observeNavigation() {
        viewModel.navigationLiveData.observeNonNull(viewLifecycleOwner) {
            it?.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection -> findNavController().navigate(navCommand.directions)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

    private fun observeError() {
        observeNonNullValue(viewModel.errorLiveData) {
            handleErrorState(it)
        }
    }

    open fun handleErrorState(@StringRes error: Int) {
        requireContext().showToast(error)
    }

}