package blackjack.state

abstract class Started : State {

    override fun profit(money: Int): Double {
        throw IllegalStateException()
    }
}
