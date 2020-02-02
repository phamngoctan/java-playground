package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day4ThatIsYourQueue {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> result = new ArrayList<>();
		while (true) {
			int population = sc.nextInt();
			int totalCommands = sc.nextInt();
			if (population == 0 && totalCommands == 0) {
				break;
			}
			
			List<String> commands = new ArrayList<>();
			sc.nextLine();
			for (int i = 0; i < totalCommands; i++) {
				commands.add(sc.nextLine());
			}
			result.add(patientOrders(population, commands));
		}
		sc.close();
		
		for (int count = 0; count < result.size(); count++) {
			System.out.println("Case " + (count + 1) + ":");
			List<Integer> eachCase = result.get(count);
			for (int i = 0; i < eachCase.size(); i++) {
				System.out.println(eachCase.get(i));
			}
		}
	}
	
	public static List<Integer> patientOrders(int population, List<String> commands) {
		Queue<Integer> patientQueue = new LinkedList<>();
		int totalToBeCheckedPatients = Math.min(population, commands.size());
		for (int i = 1; i <= totalToBeCheckedPatients; i++) {
			patientQueue.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		for (String command : commands) {
			if (command.charAt(0) == 'N') {
				// result.add(patientQueue.poll());
				result.add(patientQueue.peek());
				// The best is in this line
				patientQueue.add(patientQueue.poll());
			} else {
				Integer patientNo = Integer.valueOf(command.substring(2));
				movePatientToFrontOfQueue(patientQueue, patientNo);
			}
		}
		return result;
	}

	private static void movePatientToFrontOfQueue(Queue<Integer> patientQueue, Integer patientNo) {
		int size = patientQueue.size();
		// If we add something like this to the queue
		// the queue will have patent like this 1 2 3 x 4 5 x
		// This is not good, after rolling the whole queue, it should contain
		// only one x
		patientQueue.add(patientNo);
		for (int j = 0; j < size; j++) {
			Integer temp = patientQueue.poll();
			// That's why we have the if here
			if (!temp.equals(patientNo)) {
				patientQueue.add(temp);
			}
		}
	}
	
}
