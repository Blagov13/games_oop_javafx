package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {
    @Test
    public void position() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        Cell position = bb.position();
        assertEquals(position, Cell.C8);
    }

    @Test
    public void copy() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        Figure copy = bb.copy(Cell.C8);
        assertEquals(bb.position(), copy.position());
    }

    @Test
    public void way() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.way(Cell.G5)). isEqualTo(new Cell[]{ Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void whenDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.A3);
        assertThrows(ImpossibleMoveException.class,
                () -> bb.way(Cell.C3));
    }
}
