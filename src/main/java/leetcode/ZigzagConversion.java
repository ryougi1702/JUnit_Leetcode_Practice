package leetcode;

import java.util.Arrays;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//
//
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
public class ZigzagConversion {

    public String convert (String s, int numRows) {
        // array of strings. string represents x axis while array index is y
        if (numRows == 1) return s;

        String[] grid = new String[numRows];
        Arrays.fill(grid, "");

        boolean goingDown = true;
        int y = 0;

        for (char c : s.toCharArray()) {
            if (goingDown) {
                grid[y] += c;
                if (y != numRows - 1) {
                    y++;
                } else {
                    goingDown = false;
                    y--;
                }
            } else {
                grid[y] += c;
                if (y != 0) {
                    y--;
                } else {
                    goingDown = true;
                    y++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String partialString : grid) {
            sb.append(partialString);
        }

        return sb.toString();
    }
}
