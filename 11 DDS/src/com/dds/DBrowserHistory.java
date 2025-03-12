package com.dds;

import java.util.Stack;

public class DBrowserHistory {

	Stack<String> backDir;
	Stack<String> forwardDir;
	String curUrl;

	public DBrowserHistory(String homepage) {
        backDir = new Stack<String>();
        forwardDir = new Stack<String>();
        this.curUrl = homepage;
    }

	public void visit(String url) {
	    backDir.push(curUrl);
		curUrl = url;
		forwardDir.clear();// Clear forward history on a new visit
	}

	public String back(int steps) {
		while (!backDir.empty() && steps > 0) {
			forwardDir.push(curUrl);
			
			curUrl = backDir.pop();
			steps--;

		}
		return curUrl;
	}

	public String forward(int steps) {
		while(!forwardDir.isEmpty() && steps > 0) {
			backDir.add(curUrl);
			curUrl = forwardDir.pop();
			steps--;
		}
		return curUrl;
	}

	public static void main(String[] args) {
		DBrowserHistory browser = new DBrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
		System.out.println("Back : " + browser.backDir + " :: " + browser.forwardDir + "::Current Page :" + browser.curUrl);
        System.out.println(browser.back(1)); // facebook.com
        System.out.println(browser.back(1)); // google.com
        System.out.println(browser.forward(1)); // facebook.com
        browser.visit("linkedin.com"); // forward history is cleared
        System.out.println(browser.forward(2)); // linkedin.com
        System.out.println(browser.back(2)); // google.com
        System.out.println(browser.back(7)); // leetcode.com
	}
}
/*
https://leetcode.com/problems/design-browser-history/description/
Leetcode 1472
*/