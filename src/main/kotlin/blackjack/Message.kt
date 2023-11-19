package blackjack

object Message {

    const val INPUT_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)"
    const val PRINT_DEAL_CARDS = "%s에게 2장의 카드를 나누었습니다."
    const val PRINT_PLAYER_CARDS = "%s 카드: %s"
    const val PRINT_CONTINUE_DEAL = "%s는 한 장의 카드를 더 받겠습니까?(예 y, 아니오 n)"
    const val PRINT_PLAYER_RESULT = "%s 카드: %s - 결과: %d"
    const val PRINT_DEALER_DEALING = "딜러는 16이하라 한 장의 카드를 더 받았습니다."
    const val PRINT_RESULT_MESSAGE = "## 최종 승패"
    const val PRINT_DEALER_RESULT_MESSAGE = "%s: %d승 %d패"
    const val PRINT_PLAYER_RESULT_MESSAGE = "%s: %s"
}
