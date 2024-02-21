package com.blog;

import java.util.Scanner;

import java.awt.Desktop;
import java.net.URI;

public class OpenYouTube {
    public static void main(String[] args) {
        try {
            // Create a URI object for the YouTube URL
            URI youtubeUri = new URI("www.wathsApp.com");

            // Check if the Desktop is supported
            if (Desktop.isDesktopSupported()) {
                // Get the Desktop instance
                Desktop desktop = Desktop.getDesktop();

                // Check if browsing is supported
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Open the YouTube URI in the default browser
                    desktop.browse(youtubeUri);
                } else {
                    System.out.println("Browsing is not supported on this platform.");
                }
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
