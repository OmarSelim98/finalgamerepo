package sample;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.*;

public class Wall {
    private World world;
    private BodyDef wallDef = new BodyDef();
    /**Initiate a 100 meter (3000 px) height wall (Edge) , at a given position.
     * @param world the world you want to put the wall into.
     * @param PosX  position X in the World(in meters).
     * @param PosY position Y in the World(in meters).
     * */
    public Wall(World world, int PosX,int PosY)//PosX and PosY in JBox2d world
    {
        this.world=  world;
        wallDef.position.set(PosX,PosY);
        wallDef.type= BodyType.STATIC;
        Body wallBody = world.createBody(wallDef);
        PolygonShape wallShape = new PolygonShape();
        wallShape.setAsBox(0,100);
        FixtureDef wallFixture = new FixtureDef();
        wallFixture.shape = wallShape;
        wallFixture.filter.categoryBits = 0x0003 & ~0x0006;

        wallBody.createFixture(wallFixture);


    }
}
