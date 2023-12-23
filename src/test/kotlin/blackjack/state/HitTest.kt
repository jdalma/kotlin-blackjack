package blackjack.state

import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class HitTest {

    @Test
    fun hit() {
        val hit = Hit(Hands(CLOVER_TEN, CLOVER_TWO))
        val actual = hit.draw(CLOVER_FOUR)

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun bust() {
        val hit = Hit(Hands(CLOVER_TEN, CLOVER_KING))
        val actual = hit.draw(CLOVER_FOUR)

        actual.shouldBeTypeOf<Bust>()
    }

    @Test
    fun stay() {
        val hit = Hit(Hands(CLOVER_TEN, CLOVER_KING))
        val actual = hit.stay()

        actual.shouldBeTypeOf<Stay>()
    }
}
