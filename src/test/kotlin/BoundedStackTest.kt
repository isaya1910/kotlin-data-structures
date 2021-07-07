import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoundedStackTest {
    @Test
    fun testBoundedStackInitialization() {
        val boundedStack = BoundedStack<Int>()
        assertEquals(boundedStack.getPeekStatus(), BoundedStack.PEEK_NIL)
        assertEquals(boundedStack.getPopStatus(), BoundedStack.POP_NIL)
        assertEquals(boundedStack.getPushStatus(), BoundedStack.PUSH_NIL)
        assertEquals(boundedStack.maxStackSize,32)
    }

    @Test
    fun testPush() {
        val boundedStack = BoundedStack<Int>()
        boundedStack.push(0)
        boundedStack.push(2)
        assertEquals(boundedStack.size(), 2)
        repeat((0 .. 40).count()) {
            boundedStack.push(it)
        }
        assertEquals(boundedStack.size(), 32)
        assertEquals(boundedStack.getPushStatus(), BoundedStack.PUSH_ERR)
    }

    @Test
    fun testPop() {
        val boundedStack = BoundedStack<Int>()
        boundedStack.push(0)
        boundedStack.pop()
        assertEquals(boundedStack.getPopStatus(), BoundedStack.POP_OK)
        boundedStack.pop()
        assertEquals(boundedStack.getPopStatus(), BoundedStack.POP_ERR)
    }

    @Test
    fun testPeek() {
        val boundedStack = BoundedStack<Int>()
        boundedStack.push(0)
        assertEquals(boundedStack.peek(), 0)
        assertEquals(boundedStack.getPeekStatus(), BoundedStack.PEEK_OK)
        boundedStack.pop()
        assertEquals(boundedStack.peek(), null)
        assertEquals(boundedStack.getPeekStatus(), BoundedStack.PEEK_ERR)
    }

    @Test
    fun testClear() {
        val boundedStack = BoundedStack<Int>()
        boundedStack.push(1)
        boundedStack.peek()
        boundedStack.clear()
        assertEquals(boundedStack.size(), 0)
        assertEquals(boundedStack.getPeekStatus(), BoundedStack.PEEK_NIL)
        assertEquals(boundedStack.getPopStatus(), BoundedStack.POP_NIL)
    }

}