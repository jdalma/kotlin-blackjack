package blackjack.state

class Hands(
    private val cards: List<PlayingCard> = emptyList()
) {
    constructor(vararg cards: PlayingCard) : this(cards.toList())

    val size: Int = cards.size

    operator fun plus(card: PlayingCard): Hands = Hands(this.cards + card)

    fun hasTwo(): Boolean = this.cards.size == STARTED_CARD_SIZE

    fun score(): Score {
        val score = Score(cards.sumOf { it.score })
        if (isSoft()) {
            return score.addBonusIfNotBust()
        }
        return score
    }

    private fun isSoft(): Boolean = this.cards.any { it.isAce }

    companion object {
        private const val STARTED_CARD_SIZE: Int = 2
    }
}
