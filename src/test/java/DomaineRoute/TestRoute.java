package DomaineRoute;

import DomaineRoute.Exceptions.PositionInvalideException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by 21103619 on 09/04/2015.
 */
public class TestRoute {
    private Route maroute;

    @Before
    public void setUp() throws Exception {
        maroute=new Route (100,0);
    }

    @Test
    public void testPositionRoute() throws Exception {
        assertEquals(maroute.getX(), 100);
        assertEquals(maroute.getY(), 0);
    }

    @Test
    public void testRouteAngle() throws Exception {
        maroute.setAngle(90);
        assertEquals(maroute.getAngle(),90);
        maroute.setAngle(45);
        assertEquals(maroute.getAngle(),45);
        maroute.setAngle(0);
        assertEquals(maroute.getAngle(),0);
        maroute.setAngle(200);
        assertEquals(maroute.getAngle(),20);
        maroute.setAngle(-20);
        assertEquals(maroute.getAngle(),20);
        maroute.setAngle(-500);
        assertEquals(maroute.getAngle(),140);
    }



    @Test (expected = PositionInvalideException.class)
    public void testPositionInvalideXNeg() throws Exception {
        maroute=new Route (-10,0);
    }

    @Test (expected = PositionInvalideException.class)
    public void testPositionInvalideYNeg() throws Exception {
        maroute=new Route (0,-10);
    }

    @Test (expected = PositionInvalideException.class)
    public void testPositionInvalideXTooFat() throws Exception {
        maroute=new Route (1001,0);
    }

    @Test (expected = PositionInvalideException.class)
    public void testPositionInvalideYTooFat() throws Exception {
        maroute=new Route (0,1001);
    }


}
