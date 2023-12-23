package blackjack.participant

import blackjack.MatchResult

data class GameParticipantPlayerResult(
    val name: String,
    val matchResult: MatchResult,
    val betAmount: Int
) {
    val profit: Double = betAmount * matchResult.rate
}
