package blackjack.state

data class PlayingCard(
    val denomination: Denomination,
    val suit: Suit
) {

    val isAce: Boolean
        get() = this.denomination == Denomination.ACE

    val score: Int
        get() = this.denomination.score
}
