package algorithm.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qidi
 * @date 2019-12-12 17:04
 */
public class ParenthesesDemo {


    public boolean isValid(String s) {

        Map<Character, Character> matchMap = new HashMap<>();
        matchMap.put(')', '(');
        matchMap.put('}', '{');
        matchMap.put(']', '[');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //合法字符
            if (matchMap.containsKey(c)) {
                //栈顶 不存在给个不合法空字符
                char top = stack.isEmpty() ? '$' : stack.pop();
                //栈顶和元素是否相等
                if (top != matchMap.get(c)) {
                    return false;
                }
            } else {
                //左面入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
