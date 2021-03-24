/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetsnack

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.jetsnack.ui.JetsnackApp
import com.example.jetsnack.ui.MainActivity
import com.example.jetsnack.ui.home.HomeSectionTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetsnackApp(OnBackPressedDispatcher())
        }
    }

    @Test
    fun app_launches() {
        // Check app launches at the correct destination
        composeTestRule.onNodeWithText("HOME").assertIsDisplayed()
        composeTestRule.onNodeWithText("Android's picks").assertIsDisplayed()
    }

    @Test
    fun app_canNavigateToAllScreens() {
        // Check app launches at HOME
        composeTestRule.onNodeWithText("HOME").assertIsDisplayed()
        composeTestRule.onNodeWithText("Android's picks").assertIsDisplayed()

        // Navigate to Search
        composeTestRule.onNodeWithTag(HomeSectionTag.SEARCH.toString()).performClick()
        composeTestRule.onNodeWithText("SEARCH").assertIsDisplayed()
        composeTestRule.onNodeWithText("Categories").assertIsDisplayed()

        // Navigate to Cart
        composeTestRule.onNodeWithTag(HomeSectionTag.CART.toString()).performClick()
        composeTestRule.onNodeWithText("MY CART").assertIsDisplayed()
        composeTestRule.onNodeWithText("Order (3 items)").assertIsDisplayed()

        // Navigate to Profile
        composeTestRule.onNodeWithTag(HomeSectionTag.PROFILE.toString()).performClick()
        composeTestRule.onNodeWithText("PROFILE").assertIsDisplayed()
        composeTestRule.onNodeWithText("Profile").assertIsDisplayed()
    }
}
