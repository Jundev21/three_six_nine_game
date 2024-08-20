package Main;

import java.util.ArrayList;
import java.util.List;

public class ThreeSixNineGame {
	List<Player> playerList = new ArrayList<>();
	int currentStage = 1;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	String region;

	ThreeSixNineGame(int players) {
		for (int i = 0; i < players; i++) {
			playerList.add(new Player());
		}
	}

	public int getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage() {
		currentStage += 1;
	}

	private String makeAnswer (String answer, int makeNum){
		StringBuilder stringBuffer = new StringBuilder();
		for(int i=0; i<makeNum; i++){
			stringBuffer.append(answer).append(" ");
		}
		return stringBuffer.substring(0, stringBuffer.length()-1);
	}

	public boolean checkAnswer(String userAnswer) {
		String answer = "clap";
		String currentStageToStr = String.valueOf(currentStage);

		// 서울 일경우 에러
		if (region.equals("서울")) {
			if (currentStageToStr.contains("3") || currentStageToStr.contains("6") || currentStageToStr.contains("9")) {
				return userAnswer.equals(answer);
			}
		}

		// 부산 일경우 에러
		if(region.equals("부산")) {
			if (currentStageToStr.contains("3")) {
				return userAnswer.equals(makeAnswer(answer,3));
			} else if(currentStageToStr.contains("6")){
				return userAnswer.equals(makeAnswer(answer,6));
			}else if(currentStageToStr.contains("9")){
				return userAnswer.equals(makeAnswer(answer,9));
			}

		}

		//숫자가 1부터 순서대로 진행이 되는지 확인 1.
		return Integer.parseInt(userAnswer) == currentStage;
	}

}
