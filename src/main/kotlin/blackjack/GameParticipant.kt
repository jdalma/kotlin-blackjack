package blackjack

import blackjack.GameBlackjack.Companion.BLACKJACK_MAX_SCORE

sealed class GameParticipant(
    val name: String,
    val cards: List<Card> = emptyList()
) {
    val isBust: Boolean
        get() = getScore() > BLACKJACK_MAX_SCORE

    class Player(
        name: String,
        cards: List<Card> = emptyList()
    ) : GameParticipant(name, cards) {
        override fun isNotAllowedDealing(): Boolean = this.isBust || this.isBlackjack() || this.isSameMaxScore()
    }

    class Dealer(
        name: String = NAME,
        cards: List<Card> = emptyList()
    ) : GameParticipant(name, cards) {
        override fun isNotAllowedDealing(): Boolean = getScore() > CONTINUE_DEALING_SCORE

        companion object {
            const val NAME = "딜러"
            private const val CONTINUE_DEALING_SCORE = 16
        }
    }

    operator fun compareTo(other: GameParticipant) = this.getScore() - other.getScore()

    abstract fun isNotAllowedDealing(): Boolean

    fun isBlackjack(): Boolean =
        cards.size == 2 && cards.any { it.number == Card.Number.ACE } && cards.any { it.number.value == Card.Number.TEN.value }

    fun isSameMaxScore() = getScore() == BLACKJACK_MAX_SCORE

    fun receiveCard(card: Card): GameParticipant =
        Player(
            name = this.name,
            cards = this.cards + card
        )

    fun getScore(): Int = if (isContainsAce()) getSoftScore() else getHardScore()

    private fun isContainsAce(): Boolean =
        this.cards.any { it.number == Card.Number.ACE }

    private fun getSoftScore(): Int {
        val sum = getHardScore()
        return if (sum > BLACKJACK_MAX_SCORE) sum - Card.Number.TEN.value else sum
    }

    private fun getHardScore(): Int = this.cards.sumOf { it.number.value }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameParticipant

        if (name != other.name) return false
        if (cards != other.cards) return false
        return isBust == other.isBust
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + cards.hashCode()
        result = 31 * result + isBust.hashCode()
        return result
    }
}
