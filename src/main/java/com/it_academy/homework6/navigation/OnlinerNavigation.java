package com.it_academy.homework6.navigation;

import com.it_academy.homework6.page_object.HomePage;

public class OnlinerNavigation {

    private static final String ONLINER_URL = "https://www.onliner.by/";

    /**
     * Navigates to Onliner home page
     */
    public static void navigateToOnlinerHomePage() {
        new HomePage().navigate(ONLINER_URL);
    }
}
