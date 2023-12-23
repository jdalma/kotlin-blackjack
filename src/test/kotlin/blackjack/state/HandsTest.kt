package blackjack.state

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class HandsTest {

    @Test
    fun blackjack() {
        val hands = Hands(listOf(CLOVER_TEN, CLOVER_ACE))
        val actual = hands.score()

        actual shouldBe Score(21)
    }

    @Test
    fun hit_two_aces() {
        val hands = Hands(listOf(CLOVER_ACE, CLOVER_ACE))
        val actual = hands.score()

        actual shouldBe Score(12)
    }

    @Test
    fun `21`() {
        val hands = Hands(listOf(CLOVER_ACE, CLOVER_TEN, CLOVER_TEN))
        val actual = hands.score()

        actual shouldBe Score(21)
    }
}
