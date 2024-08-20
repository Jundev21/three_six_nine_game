package Main;

import java.util.Scanner;

public class GamePrompt {

	public void startGame(){
		Scanner sc = new Scanner(System.in);
		Scanner lineSc = new Scanner(System.in);
		System.out.println("플레이어 수를 입력해주세요");
		ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(sc.nextInt());
		int playerNumber = threeSixNineGame.playerList.size();

		while(true) {
			System.out.println("지역을 입력해주세요");
			System.out.println("1.서울");
			System.out.println("2.부산");
			int chooseRegion = sc.nextInt();
			if(chooseRegion == 1){
				threeSixNineGame.setRegion("서울");
				break;
			}else if (chooseRegion == 2){
				threeSixNineGame.setRegion("부산");
				break;
			}
		}


		for (int i = 0; i < playerNumber; i++) {
			System.out.println(i + 1 + " 플레이어의 이름을 입력해주세요");
			Player player = threeSixNineGame.playerList.get(i);
			player.setName(sc.next());
		}

		System.out.println("현재 참여한 플레이 리스트");
		for (int i = 0; i < playerNumber; i++) {
			Player player = threeSixNineGame.playerList.get(i);
			System.out.println(i + 1 + "." + player.getName());
		}
		System.out.println("현재 지역 룰");
		System.out.println(threeSixNineGame.getRegion());

		System.out.println("-------------------369 게임을 시작하겠습니다.-------------------");
		int currentPlayer = 0;
		while (true) {
			String playerName = threeSixNineGame.playerList.get(currentPlayer).getName();
			System.out.println("현재 턴 " + playerName);
			String playerAnswer = lineSc.nextLine();
			System.out.println(playerName + " 님이 입력한 숫자 " + playerAnswer);

			if(!threeSixNineGame.checkAnswer(playerAnswer)){
				System.out.println(playerName + " 님이 오답을 입력하셨습니다.");
				System.out.println("------------------------게임종료------------------------");
				break;
			}
			currentPlayer = (currentPlayer+1)%playerNumber;
			threeSixNineGame.setCurrentStage();
			System.out.println("------------------------------------------------");
		}
	}
}
