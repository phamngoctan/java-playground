package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day4ThrowingCardsAwayOne {
	
	static class Pair {
		public int remainingCard;
		public List<Integer> discardedCards;
		public Pair(int remainingCard, List<Integer> discardedCards) {
			super();
			this.remainingCard = remainingCard;
			this.discardedCards = discardedCards;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<>();
		while (true) {
			int number = sc.nextInt();
			if (number == 0) {
				break;
			}
			numbers.add(number);
		}
		sc.close();
		for (int i = 0; i < numbers.size(); i++) {
			Pair result = proceed(numbers.get(i));
			String space = " ";
			if (result.discardedCards.isEmpty()) {
				space = "";
			}
			System.out.println("Discarded cards:" + space + result.discardedCards.stream().map(item -> item.toString()).collect(Collectors.joining(", ")));
			System.out.println("Remaining card: " + result.remainingCard);
		}
	}
	
	public static Pair proceed(int number) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < number; i++) {
			queue.add(i + 1);
		}
		
		List<Integer> discardedCards = new ArrayList<>();
		int lastCard = 0;
		while (!queue.isEmpty()) {
			Integer val = queue.poll();
			if (queue.isEmpty()) {
				lastCard = val;
			} else {
				discardedCards.add(val);
				queue.add(queue.poll());
			}
			
		}
		return new Pair(lastCard, discardedCards);
	}
	
}
