package hash;

import java.util.ArrayList;
import java.util.List;

abstract public class Substring {

    public static List<String> search(String s, String p) {

        char[] source = s.toCharArray();
        char[] pattern = p.toCharArray();

        List<String> found = new ArrayList<>();
        if (pattern.length > source.length) {
            found.add("Такой подстроки точно нет!");
            return found;
        }

        int window_hash = 0;
        int pattern_hash = patternHashCode(pattern);
        int asterik_position = positionAsterik(pattern);

        for (int start = 0; start < (source.length - pattern.length + 1); start++) {
            if (start == 0) {
                window_hash = hash(source, start, pattern.length -1);
                window_hash -= source[asterik_position];
            } else {
                window_hash -= source[start - 1];
                window_hash += source[start + pattern.length - 1];
                window_hash -= source[start + asterik_position];
            }
            if (window_hash == pattern_hash) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < pattern.length; i++) {
                    if (pattern[i] != '*' && source[start + i] != pattern[i]) {
                        continue;
                    } else {
                        builder.append(source[start + i]);
                    }
                }
                found.add(builder.toString());
            }
            window_hash += source[start + asterik_position];
        }
        return found;
    }

    public static int hash(char[]data, int start, int end){
        int res = 0;
        if(end > data.length - 1){
            return res;
        }
        for (int i = start; i <= end; i++) {
            res += data[i];
        }
        return res;
    }

    public static int patternHashCode(char[] chars) {
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                continue;
            }
            res += chars[i];
        }
        return res;
    }

    public static int positionAsterik(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                return i;
            }
        }
        return -1;
    }
}
