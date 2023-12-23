package blackjack.state

interface State {

    fun draw(card: PlayingCard): State
    fun stay(): State
    fun profit(money: Int): Double
}

class Hit(
    private val hands: Hands
) : Started() {
    init {
        require(hands.size >= 2)
    }

    override fun draw(card: PlayingCard): State {
        val hands = hands + card
        if (hands.score().overBlackjackScore()) {
            return Bust()
        }
        return Hit(hands + card)
    }

    override fun stay(): State = Stay()
}

class Blackjack(
    override val rate: Double = 1.5
) : Finished()

class Bust(
    override val rate: Double = 0.0
) : Finished()

class Stay(
    override val rate: Double = 1.0
) : Finished()

abstract class Finished : State {

    protected abstract val rate: Double

    override fun draw(card: PlayingCard): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        throw IllegalStateException()
    }

    override fun profit(money: Int): Double = money * rate
}

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

class Start(
    private val hands: Hands
) : Started() {
    constructor(card: PlayingCard) : this(listOf(card))
    constructor(cards: List<PlayingCard> = emptyList()) : this(Hands(cards))

    init {
        require(hands.size <= 2)
    }

    override fun draw(card: PlayingCard): State {
        require(hands.size < 2)
        val hands = hands + card
        if (hands.score().isBlackjackScore()) {
            return Blackjack()
        }
        if (hands.hasTwo()) {
            return Hit(hands)
        }

        return Start(hands)
    }

    override fun stay(): State {
        throw IllegalStateException()
    }
}
