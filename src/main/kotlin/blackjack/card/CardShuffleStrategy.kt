package blackjack.card

fun interface CardShuffleStrategy {
    fun shuffle(): List<Card>
}
