package DomaineRoute;

import DomaineRoute.Exceptions.PositionInvalideException;

/**
 * Created by 21103619 on 09/04/2015.
 */
public class Route {

    private int x;
    private int y;
    private int angle;


    public Route(){
        x=0;
        y=0;
        angle=0;
    }

    public Route(int x, int y) throws PositionInvalideException {
        if (x>1000 || x<0 || y>1000 || y<0){
            throw new PositionInvalideException();
        }
        this.x=x;
        this.y=y;
        angle=0;
    }

    public Route(int x, int y,int angle) throws PositionInvalideException {
        if (x>1000 || x<0 || y>1000 || y<0){
            throw new PositionInvalideException();
        }
        this.x=x;
        this.y=y;
        this.angle=angle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setAngle(int angle) {
        this.angle = Math.abs(angle) % 180;
    }

    public int getAngle() {
        return angle;
    }
}
