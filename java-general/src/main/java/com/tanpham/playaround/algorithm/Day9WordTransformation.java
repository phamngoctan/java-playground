package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Day9WordTransformation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < testCases; i++) {
			try {
				handleATestCase(sc);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			res.forEach(System.out::println);
		}
	}

	private static void handleATestCase(Scanner sc) {
		sc.nextLine();
		Set<String> dict = new HashSet<>();
		String next = sc.nextLine();
		while (!next.equals("*")) {
			dict.add(next);
			next = sc.next();
		}
		
		// skip blank line
		sc.nextLine();
		
		while (true) {
			String line = sc.nextLine();
			if (line.isEmpty()) {
				break;
			}
			String[] e = line.split("\\s+");
			System.out.println(e[0] + " " + e[1] + " " + BFS(e[0], e[1], dict));
		}
	}
	
	private static int BFS(String beginWord, String target, Set<String> iDict) {
		Set<String> dict = new HashSet<>(iDict);
		if (beginWord.equals(target)) {
			// handle edge case
			return 0;
		}
		
		Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
        	// DON'T DO THIS, you will get the wrong result, because the queue size is updated =)), you have to store it before moving
        	//for (int q = 0; q < queue.size(); q++) {
        	int size = queue.size();
        	for (int q = 0; q < size; q++) {
                char[] cur = queue.poll().toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    char tmp = cur[i];
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(target)) {
                            	return level + 1;
                            }
                            queue.add(dest);
                            // use the dict instead of using visited<String>
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }
            }
        	level++;
        }
        return 0;
	}
	
}
