package blackjack.state

interface State {

    fun draw(card: PlayingCard): State
    fun stay(): State
    fun profit(money: Int): Double
}
