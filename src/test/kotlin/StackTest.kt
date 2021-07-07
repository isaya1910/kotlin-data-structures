import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StackTest {

    @Test
    fun testStackInitialization() {
        val stack = Stack<Int>()
        assertEquals(stack.getPeekStatus(), Stack.PEEK_NIL)
        assertEquals(stack.getPopStatus(), Stack.POP_NIL)
    }

    @Test
    fun testPush() {
        val stack = Stack<Int>()
        stack.push(0)
        stack.push(2)
        assertEquals(stack.size(), 2)
    }

    @Test
    fun testPop() {
        val stack = Stack<Int>()
        stack.push(0)
        stack.pop()
        assertEquals(stack.getPopStatus(), Stack.POP_OK)
        stack.pop()
        assertEquals(stack.getPopStatus(), Stack.POP_ERR)
    }

    @Test
    fun testPeek() {
        val stack = Stack<Int>()
        stack.push(0)
        assertEquals(stack.peek(), 0)
        assertEquals(stack.getPeekStatus(), Stack.PEEK_OK)
        stack.pop()
        assertEquals(stack.peek(), null)
        assertEquals(stack.getPeekStatus(), Stack.PEEK_ERR)
    }

    @Test
    fun testClear() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.peek()
        stack.clear()
        assertEquals(stack.size(), 0)
        assertEquals(stack.getPeekStatus(), Stack.PEEK_NIL)
        assertEquals(stack.getPopStatus(), Stack.POP_NIL)
    }

}