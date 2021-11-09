package com.sym.program;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularExpressionDemo {
	public static void main(String args[]) {

        // Regular expression pattern to test input
		List<String> list = Arrays.asList("bbb2", "bb3","aaaa","2333","bbb7","BbB8");
        String regex = "^[b]{3}(\\d)$";      
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
       
        List<String> matching = list.stream()
                                    .filter(pattern.asPredicate())
                                    .map(e -> e.toUpperCase())
                                    .collect(Collectors.toList());
        matching.forEach(System.out::println);

            }

}
