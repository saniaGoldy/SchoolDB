package com.example.schooldb.presentation.navigation.destinations.login

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.schooldb.presentation.navigation.destinations.NavigationDestination

object HomeDestination : NavigationDestination {
    override fun route(): String = HOME_DESTINATION

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(USER_ID_PARAM) { type = NavType.StringType }
        )


    const val USER_ID_PARAM = "user_id"
    private const val HOME_ROUTE = "home"
    private const val HOME_DESTINATION = "$HOME_ROUTE/{$USER_ID_PARAM}"

    /**
     * Use it to navigate to destination
     */
    fun createHomeRoute(userID: String) = "$HOME_ROUTE/$userID"
}

/*
object BookDetailsDestination : NavigationDestination {

    override fun route(): String = BOOK_DETAILS_BOTTOM_NAV_ROUTE

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(BOOK_ID_PARAM) { type = NavType.StringType },
            hideBottomNamedArgument
        )

    const val BOOK_ID_PARAM = "book"

    private const val BOOK_DETAILS_ROUTE = "book_details"
    private const val BOOK_DETAILS_BOTTOM_NAV_ROUTE = "$BOOK_DETAILS_ROUTE/{$BOOK_ID_PARAM}"
    fun createBookDetailsRoute(bookID: String) = "$BOOK_DETAILS_ROUTE/${bookID.lowercase()}"

}*/
