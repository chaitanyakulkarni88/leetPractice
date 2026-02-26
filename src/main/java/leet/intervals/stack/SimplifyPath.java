package leet.intervals.stack;

import java.util.Stack;
//71
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/home/user/Documents/../Pictures";
        System.out.println(sp.simplifyPath(path));
    }
    public String simplifyPath(String path) {
        Stack<String> onlyPaths = new Stack<>();

        for(int i=0;i<path.length();i++) {
            if(path.charAt(i) == '/')
                continue;
            StringBuilder temp = new StringBuilder();
            while(i< path.length() && path.charAt(i) != '/') {
                temp.append(String.valueOf(path.charAt(i)));
                i++;
            }
            if(temp.toString().equals("..")) {
                if(!onlyPaths.isEmpty())
                    onlyPaths.pop();
            }
            else if(temp.toString().equals("."))
                continue;

            else
                onlyPaths.push(temp.toString());

        }

        StringBuilder result = new StringBuilder();

        for(String i:onlyPaths){
            result.append("/");
            result.append(i);
        }

        return result.isEmpty() ? "/": result.toString();

    }
}
