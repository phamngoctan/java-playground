package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Day6LakesInBerland_GoodOne {
	
	static final int MAX = 50 + 1;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M, K;
    static char[][] backyard = new char[MAX][MAX];
    static char[][] backupBackyard = new char[MAX][MAX];
    static List<Cell> minLake;
    static int totalLakes = 0;
    static Map<Integer, List<List<Cell>>> counter = new TreeMap<>();

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + "]";
		}
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    
    /**
     * 
     * 
     * 
5 4 1
****
*..*
****
**.*
..**

3 5 1
.**.*
*.*.*
***.*

3 5 0
.**.*
*.*.*
***.*

3 50 7
***.********.*********************.**********.****
*...**..*.**.*.*.*.*.*.*.*..*.*.*.*.*.*.*.*.*.*..*
.***************.*.********.**********************


     * @param args
     */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            String str = sc.next();
			backyard[i] = str.toCharArray();
			backupBackyard[i] = str.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backyard[i][j] == '.') {
                    DFS(new Cell(i, j));
                }
            }
        }
        sc.close();

    	int j = totalLakes;
    	int minimumNumberOfCells = 0;
    	for (Entry<Integer, List<List<Cell>>> entry : counter.entrySet()) {
    		for (List<Cell> lakes : entry.getValue()) {
    			if (j <= K) {
    				break;
    			}
    			for (Cell c : lakes) {
    				backupBackyard[c.r][c.c] = '*';
                	minimumNumberOfCells++;
				}
    			j--;
			}
		}
    	
    	System.out.println(minimumNumberOfCells);
        for (int i = 0; i < N; i++) {
			System.out.println(new String(backupBackyard[i]));
        }
        
	}

	private static void DFS(Cell s) {
		Stack<Cell> q = new Stack<>();
        q.add(s);

        List<Cell> lakeCells = new ArrayList<>();

        boolean isLake = true;
        backyard[s.r][s.c] = '*';
        lakeCells.add(new Cell(s.r, s.c));
        
        while (!q.isEmpty()) {
            Cell u = q.pop();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (!isValid(r, c)) {
                	isLake = false;
                    continue;
                }

                if (backyard[r][c] != '*') {
                	lakeCells.add(new Cell(r, c));
                    backyard[r][c] = '*';
                    q.add(new Cell(r, c));
                }
            }
        }
        
        if (isLake) {
        	counter.computeIfAbsent(lakeCells.size(), k -> new ArrayList<>());
        	counter.get(lakeCells.size()).add(lakeCells);
        	totalLakes++;
        }
	}
	
}
