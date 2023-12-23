package blackjack.state

@JvmInline
value class Score(
    private val value: Int
) {

    fun addBonusIfNotBust(): Score = if (this.canBonus()) this.addBonus() else this

    fun isBlackjackScore(): Boolean = value == BLACKJACK_SCORE

    fun overBlackjackScore(): Boolean = value > BLACKJACK_SCORE

    private fun canBonus() = value + BONUS_SCORE <= BLACKJACK_SCORE

    private fun addBonus(): Score = Score(value + BONUS_SCORE)

    companion object {
        private const val BONUS_SCORE: Int = 10
        private const val BLACKJACK_SCORE: Int = 21
    }
}
