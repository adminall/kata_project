package com.sg.kata;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.sg.kata.enums.PlayerName;
import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.factory.PlayerFactory;
import com.sg.kata.factory.impl.PlayerFactoryImpl;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;


/**
 * Tests TDD
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class KataTests
{

	private PlayerFactory<Player, PlayerName> playerFactory;

	@Before
	public void init()
	{
		playerFactory = new PlayerFactoryImpl();
	}

	/**
	 * Test initial Score, the initial score should be equal to zero.
	 */
	@Test
	public void initialScoreShouldBeZeroTest()
	{
		final Player playerOne = playerFactory.createPlayer(PlayerName.PLAYER_ONE);
		final Player playerTwo = playerFactory.createPlayer(PlayerName.PLAYER_TWO);

		assertEquals(0, playerOne.getScoreSet());
		assertEquals(0, playerTwo.getScoreSet());
	}

	/**
	 * Test
	 */
	@Test
	public void incrementScoresTest()
	{
		final Player playerOne = playerFactory.createPlayer(PlayerName.PLAYER_ONE);
		final Player playerTwo = playerFactory.createPlayer(PlayerName.PLAYER_TWO);

		playerOne.incrementScoreSet();
		playerTwo.incrementScoreSet();

		assertEquals(15, playerOne.getScoreSet());
		assertEquals(15, playerTwo.getScoreSet());

		playerOne.incrementScoreSet();
		playerTwo.incrementScoreSet();

		assertEquals(30, playerOne.getScoreSet());
		assertEquals(30, playerTwo.getScoreSet());

		playerOne.incrementScoreSet();
		playerTwo.incrementScoreSet();

		assertEquals(40, playerOne.getScoreSet());
		assertEquals(40, playerTwo.getScoreSet());

	}

	/**
	 * Test score equal 30 points.
	 */
	@Test
	public void scoreShouldBe30Test()
	{
		final Player playerOne = playerFactory.createPlayer(PlayerName.PLAYER_ONE);
		final Player playerTwo = playerFactory.createPlayer(PlayerName.PLAYER_TWO);

		playerOne.incrementScoreSet();
		playerOne.incrementScoreSet();
		playerTwo.incrementScoreSet();
		playerTwo.incrementScoreSet();

		assertEquals(30, playerOne.getScoreSet());
		assertEquals(30, playerTwo.getScoreSet());
	}

	/**
	 * Test score equal 40 points.
	 */
	@Test
	public void scoreShouldBe40AppTest()
	{
		final Player playerOne = playerFactory.createPlayer(PlayerName.PLAYER_ONE);
		final Player playerTwo = playerFactory.createPlayer(PlayerName.PLAYER_TWO);

		playerOne.incrementScoreSet();
		playerOne.incrementScoreSet();
		playerOne.incrementScoreSet();
		playerTwo.incrementScoreSet();
		playerTwo.incrementScoreSet();
		playerTwo.incrementScoreSet();

		assertEquals(40, playerOne.getScoreSet());
		assertEquals(40, playerTwo.getScoreSet());
	}

	/**
	 * Test one point to set.
	 *
	 * @throws KataException
	 */
	@Test
	public void scoreShouldBeWinGameTest() throws KataException
	{

		final Match match = new Match();
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());

		assertEquals(1, match.getSets().last().getScorePlayerOne());
	}

	/**
	 * Test DEUCE rule.
	 *
	 * @throws KataException
	 */
	@Test
	public void twoPlayersReach40DeuceTest() throws KataException
	{

		final Match match = new Match();

		// Score 40
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());

		// Score 40
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());

		assertEquals(40, match.getPlayerOne().getScoreSet());
		assertEquals(40, match.getPlayerTwo().getScoreSet());

		assertEquals(RuleName.DEUCE, match.getCurrentRule());

	}

	/**
	 * Test Deuce rule with take advantage for player one.
	 *
	 * @throws KataException
	 */
	@Test
	public void twoPlayersReach40AdvantageTest() throws KataException
	{

		final Match match = new Match();

		// Score 40
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());

		// Score 40
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());

		assertEquals(40, match.getPlayerOne().getScoreSet());
		assertEquals(40, match.getPlayerTwo().getScoreSet());
		assertEquals(RuleName.DEUCE, match.getCurrentRule());

		// Player one take advantage
		match.addPointForPlayer(match.getPlayerOne());

		assertEquals(Boolean.TRUE, match.getPlayerOne().isAdvantage());

	}

	@Test
	public void twoPlayersReach40AdvantageWinGameTest() throws KataException
	{

		final Match match = new Match();

		// Score 40
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());

		// Score 40
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());

		assertEquals(40, match.getPlayerOne().getScoreSet());
		assertEquals(40, match.getPlayerTwo().getScoreSet());
		assertEquals(RuleName.DEUCE, match.getCurrentRule());

		// Player one take advantage
		match.addPointForPlayer(match.getPlayerOne());

		assertEquals(Boolean.TRUE, match.getPlayerOne().isAdvantage());

		// Mark one point to win game.
		match.addPointForPlayer(match.getPlayerOne());

		assertEquals(1, match.getSets().last().getScorePlayerOne());
		assertEquals(0, match.getSets().last().getScorePlayerTwo());

		// reset
		assertEquals(0, match.getPlayerOne().getScoreSet());
		assertEquals(0, match.getPlayerOne().getScoreSet());
		assertEquals(RuleName.NEW, match.getCurrentRule());
		assertEquals(Boolean.FALSE, match.getPlayerOne().isAdvantage());
		assertEquals(Boolean.FALSE, match.getPlayerTwo().isAdvantage());

	}

	/**
	 * two Players Reach 40 Advantage Loose Game
	 *
	 * @throws KataException
	 */
	@Test
	public void twoPlayersReach40AdvantageLooseGameTest() throws KataException
	{

		final Match match = new Match();

		// Score 40
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());
		match.addPointForPlayer(match.getPlayerOne());

		// Score 40
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());
		match.addPointForPlayer(match.getPlayerTwo());

		assertEquals(40, match.getPlayerOne().getScoreSet());
		assertEquals(40, match.getPlayerTwo().getScoreSet());
		assertEquals(RuleName.DEUCE, match.getCurrentRule());

		// Player one take advantage
		match.addPointForPlayer(match.getPlayerOne());

		assertEquals(Boolean.TRUE, match.getPlayerOne().isAdvantage());

		// Mark one point to win game.
		match.addPointForPlayer(match.getPlayerTwo());

		assertEquals(0, match.getSets().last().getScorePlayerOne());
		assertEquals(0, match.getSets().last().getScorePlayerTwo());
		assertEquals(RuleName.DEUCE, match.getCurrentRule());
		assertEquals(Boolean.FALSE, match.getPlayerOne().isAdvantage());
		assertEquals(Boolean.FALSE, match.getPlayerTwo().isAdvantage());

	}

	/**
	 * Game should be start with Set Score 0
	 */
	@Test
	public void gameShouldBeStartWithSetScore0Test()
	{
		final Match match = new Match();

		assertEquals(0, match.getSets().last().getScorePlayerOne());
		assertEquals(0, match.getSets().last().getScorePlayerTwo());

	}

	/**
	 * Score set should be 123456
	 */
	@Test
	public void scoreSetSouldBe123456Test()
	{
		final Match match = new Match();

		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 2 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 3 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 4 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 5 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 6 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(6, match.getSets().first().getScorePlayerOne());
		assertEquals(0, match.getSets().first().getScorePlayerTwo());

	}

	/**
	 * Score player one (score = 6 ) and the player 2 (score <= 4) -> player one win the set.
	 */
	@Test
	public void scoreSetWinGameTest()
	{

		final Match match = new Match();

		// 4 points
		IntStream.rangeClosed(1, 16).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 6 points
		IntStream.rangeClosed(1, 24).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(6, match.getSets().first().getScorePlayerOne());
		assertEquals(4, match.getSets().first().getScorePlayerTwo());
		// Assert win game
		assertEquals(Boolean.TRUE, match.getSets().first().isFinished());

		// 2 points
		IntStream.rangeClosed(1, 8).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(2, match.getSets().last().getScorePlayerOne());
		assertEquals(0, match.getSets().last().getScorePlayerTwo());
		// Assert win game
		assertEquals(Boolean.FALSE, match.getSets().last().isFinished());
	}

	/**
	 * If a player win a Game and reach the Set score of 6 and the other player has a Set score of 5, a new Game must be
	 * played and the first player who reach the score of 7 wins the match
	 */
	@Test
	public void scoreSet67WinGameTest()
	{

		final Match match = new Match();

		// 5 points
		IntStream.rangeClosed(1, 20).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 6 points
		IntStream.rangeClosed(1, 24).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(6, match.getSets().last().getScorePlayerOne());
		assertEquals(5, match.getSets().last().getScorePlayerTwo());
		assertEquals(Boolean.FALSE, match.getSets().last().isFinished());

		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(7, match.getSets().first().getScorePlayerOne());
		assertEquals(5, match.getSets().first().getScorePlayerTwo());
		assertEquals(Boolean.TRUE, match.getSets().first().isFinished());

	}

	/**
	 * If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
	 *
	 * @throws KataException
	 */
	@Test
	public void Tie_BreakTest() throws KataException
	{

		final Match match = new Match();

		// 5 points
		IntStream.rangeClosed(1, 20).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 5 points
		IntStream.rangeClosed(1, 20).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});
		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(6, match.getSets().last().getScorePlayerOne());
		assertEquals(6, match.getSets().last().getScorePlayerTwo());
		assertEquals(RuleName.TIE_BREAK, match.getCurrentRule());

		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 1 point
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(Boolean.TRUE, match.getSets().first().isFinished());

	}

	/**
	 * Test new match, player one VS player two.
	 */
	@Test
	public void onePlayerShouldBeWinTheMatchTest()
	{
		final Match match = new Match();

		// 4 points
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerOne());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		// 1 point
		IntStream.rangeClosed(1, 24 * 2).forEach((Integer) -> {
			try
			{
				match.addPointForPlayer(match.getPlayerTwo());
			}
			catch (final KataException e)
			{
				e.printStackTrace();
			}
		});

		assertEquals(Boolean.TRUE, match.getSets().first().isFinished());
		assertEquals(match.getPlayerTwo(), match.getMatchWinner());
	}

}
