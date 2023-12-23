package blackjack.state

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

class Blackjack(
    override val rate: Double = 1.5
) : Finished()

class Bust(
    override val rate: Double = 0.0
) : Finished()

class Stay(
    override val rate: Double = 1.0
) : Finished()
