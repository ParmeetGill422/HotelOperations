import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room;

    @Before
    public void setup() {
        room = new Room(2, 120.0, false, false);
    }

    @Test
    public void testCheckInMakesRoomOccupiedAndDirty() {
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInFailsIfOccupied() {
        room = new Room(2, 120.0, true, false);
        room.checkIn();
        assertTrue(room.isOccupied());
    }

    @Test
    public void testCheckInFailsIfDirty() {
        room = new Room(2, 120.0, false, true);
        room.checkIn();
        assertFalse(room.isOccupied());
    }

    @Test
    public void testCheckOut() {
        room = new Room(2, 120.0, true, true);
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCleanRoomSuccess() {
        room = new Room(2, 120.0, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    public void testCannotCleanIfOccupied() {
        room = new Room(2, 120.0, true, true);
        room.cleanRoom();
        assertTrue(room.isDirty());
    }
}
