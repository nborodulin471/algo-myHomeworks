package hash;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> res = Substring.search("Alibaba or Alibubab? I do not know!", "b*b");
        res.stream().forEach(System.out::println);
    }
}
