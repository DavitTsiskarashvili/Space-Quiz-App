package com.example.navigation_impl.navigation

import androidx.navigation.NavDirections
import com.example.corecommon.common.utils.navigation.NavigationCommand

sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
}
