import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room;

    @Before
    public void setup() {
        room = new Room(101);
    }

    @Test
    public void testCheckInSetsOccupiedAndDirty() {
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInFailsIfAlreadyOccupied() {
        room.checkIn(); // first check-in
        room.checkOut(); // still dirty
        room.checkIn(); // should not allow check-in
        assertFalse(room.isOccupied());
    }

    @Test
    public void testCheckInFailsIfDirty() {
        room.checkIn();
        room.checkOut(); // now room is dirty
        room.checkIn(); // should fail
        assertFalse(room.isOccupied());
    }

    @Test
    public void testCheckOutMarksRoomUnoccupied() {
        room.checkIn();
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCleanRoomSuccess() {
        room.checkIn();
        room.checkOut();
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    public void testCleanRoomFailsIfOccupied() {
        room.checkIn();
        room.cleanRoom(); // should not clean
        assertTrue(room.isDirty());
    }
}
