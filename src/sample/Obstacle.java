package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;


public class Obstacle {
    private World world;
    private BodyDef obsBodyDef;
    private Body obsBody;
    private FixtureDef obsFixture;
    private PolygonShape obsShape;
    private ImageView obsImg;
    private float x;
    private float y;
    private float width = 40;
    private float height = 110;
    private float offsetX = width/2;
    private float offsetY = height/2;
    private int vel;

    public Obstacle(World world, float posX, float posY, int vel){
        this.world = world;
        this.x = posX;
        this.y = posY;
        this.vel = vel;
        this.obsBodyDef = new BodyDef();
        this.obsBodyDef.position.set(((posX+this.offsetX)/Game.meterToPixel),-((posY+this.offsetY)/Game.meterToPixel));
        this.obsBodyDef.type = BodyType.KINEMATIC;
        this.obsBody = world.createBody(this.obsBodyDef);
        this.obsShape = new PolygonShape();
        this.obsShape.setAsBox((this.width/2)/Game.meterToPixel,((height/2)/Game.meterToPixel));
        this.obsFixture = new FixtureDef();
        this.obsFixture.shape = this.obsShape;
        this.obsFixture.filter.categoryBits = 0x0005;
        this.obsFixture.userData = this;
        this.obsBody.createFixture(this.obsFixture);

        this.obsImg = new ImageView(new Image("gameres/pickle.png",this.width,this.height,false,false));
        this.obsImg.setTranslateX(this.x);
        this.obsImg.setTranslateY(this.y);

        this.obsBody.setLinearVelocity(new Vec2(0,-vel));
    }

    public ImageView getObstacleImageView(){
        return this.obsImg;
    }
    public void updateObstacle(){
        this.obsImg.setTranslateX((this.obsBody.getPosition().x*Game.meterToPixel)-this.offsetX);
        this.obsImg.setTranslateY(-(this.obsBody.getPosition().y*Game.meterToPixel)-this.offsetY);
        if(-(this.obsBody.getPosition().y*Game.meterToPixel) >= 600){
            this.obsBody.setLinearVelocity(new Vec2(0,this.vel));
        }else if(-(this.obsBody.getPosition().y*Game.meterToPixel) <= 10){
            this.obsBody.setLinearVelocity(new Vec2(0,-this.vel));
        }
    }

    @Override
    public String toString(){
        return "pickle";
    }


    public void remove(){
        this.obsBody.setActive(false);
        world.destroyBody(this.obsBody);
    }
}
