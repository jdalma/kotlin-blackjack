package blackjack.state

abstract class Started : State {

    override fun profit(money: Int): Double {
        throw IllegalStateException()
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
