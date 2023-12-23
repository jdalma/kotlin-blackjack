package blackjack.blackjack

import blackjack.participant.GameParticipantDealer
import blackjack.participant.GameParticipantPlayer
import blackjack.participant.GameParticipants
import blackjack.GamePlayer

interface GameBlackjack {

    fun initialDealing(players: List<GamePlayer>): GameParticipants

    fun continueDealing(player: GameParticipantPlayer): GameParticipantPlayer

    fun continueDealing(dealer: GameParticipantDealer): GameParticipantDealer

    companion object {
        const val GAME_INIT_CARD_SIZE = 2
        const val BLACKJACK_MAX_SCORE = 21
        const val PLAYER_NAME_DELIMITER = ","
    }
}
