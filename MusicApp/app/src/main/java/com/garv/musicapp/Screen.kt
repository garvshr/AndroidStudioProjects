package com.garv.musicapp

import androidx.annotation.DrawableRes

sealed class Screen (val title: String, val route: String) {

    sealed class BottomScreen (
        val bTitle: String, val bRoute: String, @DrawableRes val icon: Int ): Screen(bTitle, bRoute) {
        object Home: BottomScreen(
            bTitle = "Home",
            bRoute = "home",
            icon = R.drawable.baseline_music_video_24
        )

        object Library: BottomScreen(
            bTitle = "Library",
            bRoute = "library",
            icon = R.drawable.baseline_library_music_24
        )

        object Browse: BottomScreen(
            bTitle = "Browse",
            bRoute = "browse",
            icon = R.drawable.baseline_apps_24
        )
    }

    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val Icon: Int): Screen(dTitle, dRoute) {
            object Account: DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )

            object Subscription: DrawerScreen(
                "Subscription",
                "subscription",
                R.drawable.ic_subscribe
            )

            object AddAccount: DrawerScreen(
                "Add Account",
                "add_account",
                R.drawable.ic_baseline_person_add_alt_1_24
            )
        }

}


val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)

val screensInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Library,
    Screen.BottomScreen.Browse
)