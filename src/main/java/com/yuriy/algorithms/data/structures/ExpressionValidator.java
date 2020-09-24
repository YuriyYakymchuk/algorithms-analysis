package com.yuriy.algorithms.data.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionValidator {

    private final static Map<Character, Character> symbolMap = new HashMap<>();
    static {
        symbolMap.put('}', '{');
        symbolMap.put(']', '[');
        symbolMap.put(')', '(');
    }

    public static boolean isExpressionValid(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (symbolMap.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != symbolMap.get(c)) {
                    return false;
                }
                stack.pop();
            } else if (symbolMap.containsValue(c)) {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
