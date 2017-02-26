package com.sg.kata;

import java.util.Scanner;

import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;


/**
 * This Class is the entry point to run application.
 *
 * @author Yassine.Mejri
 * @version 0.1
 */
public class Runner
{

	@SuppressWarnings("resource")
	public static void main(final String[] args) throws KataException
	{

		System.out.print(" You would like to start a new party (Player One Vs Player Two) ? (tape y or n) : ");

		final Scanner scanner = new Scanner(System.in);
		final String answer = scanner.next();

		if (answer.trim().toLowerCase().equals("y") || answer.trim().toLowerCase().equals("yes"))
		{
			// run new match
			new Match().run();
		}

	}
}
