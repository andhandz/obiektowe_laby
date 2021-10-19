package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d va=new Vector2d(1,3);
    Vector2d vb=new Vector2d(3,4);
    @Test
    void testToString() {
        assertEquals(va.toString(),"(1,3)");
        assertEquals(vb.toString(),"(3,4)");
    }

    @Test
    void precedes() {
        assertTrue(va.precedes(vb));
        assertFalse(vb.precedes(va));
    }

    @Test
    void follows() {
        assertTrue(vb.follows(va));
        assertFalse(va.follows(vb));
    }

    @Test
    void upperRight() {
        assertEquals(va.upperRight(vb),vb);
    }

    @Test
    void lowerLeft() {
        assertEquals(va.lowerLeft(vb),va);
    }

    @Test
    void add() {
        assertEquals(va.add(vb),new Vector2d(4,7));
    }

    @Test
    void subtract() {
        assertEquals(va.subtract(vb),new Vector2d(-2,-1));
        assertEquals(vb.subtract(va),new Vector2d(2,1));
    }

    @Test
    void testEquals() {
        assertFalse(va.equals(vb));
        assertTrue(va.equals(va));
    }

    @Test
    void opposite() {
        assertEquals(va.opposite(),new Vector2d(-1,-3));
        assertEquals(vb.opposite(),new Vector2d(-3,-4));
    }
}