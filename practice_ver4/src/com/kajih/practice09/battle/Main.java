// package com.kajih.practice09.battle;

// import java.util.ArrayList;
// import java.util.List;

// public class Main {
// private static final int NUM_OF_TEAMS = 4;
// private static final int NUM_OF_PLAYERS_IN_TEAM = 3;

// public static void main(String[] args) {
// List<String> playerNames = new ArrayList<>();
// List<Integer> playerTeamIDs = new ArrayList<>();
// List<Integer> playerHps = new ArrayList<>();
// int winnerTeamID;

// initPlayerStatus(NUM_OF_TEAMS, NUM_OF_PLAYERS_IN_TEAM, playerNames,
// playerTeamIDs, playerHps);
// winnerTeamID = battle(playerNames, playerTeamIDs, playerHps);
// showResult(winnerTeamID, playerNames, playerTeamIDs);

// }

// private static int battle(List<String> playerNames, List<Integer>
// playerTeamIDs, List<Integer> playerHps) {
// while(isOneTeamSurviving(playerTeamIDs,playerHps)){

// for(int i = 0; i < playerNames.size();i++){
// if(isDeth(playerHps.get(i))){
// continue;
// }

// int turgetIndex = decideTarget(playerTeamIDs,playerHps);

// updateHP(turgetIndex,playerHps)
// }
// }

// return 0;
// }

// private static void initPlayerStatus(int numOfTeams, int numOfPlayers,
// List<String> playerNames,
// List<Integer> playerTeamIDs, List<Integer> playerHps) {

// int totalNumOfPlayers = numOfTeams * numOfPlayers;
// playerNames = generatePlayerNames(totalNumOfPlayers);
// playerTeamIDs = generatePlayerTeamIDs(numOfTeams, numOfPlayers);
// playerHps = generatePlayerHps(totalNumOfPlayers);
// }
// }
