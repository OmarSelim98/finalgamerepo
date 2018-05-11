package sample;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ContactListener implements org.jbox2d.callbacks.ContactListener{

    public static final int DAMAGE = 20;
    private Game game;
    private Player player1,player2;

    public ContactListener(Game game){
        this.game = game;
        this.player1 = game.player1;
        this.player2 = game.player2;

    }

    @Override
    public void beginContact(Contact contact) {
        try {
            if (contact.isEnabled()) {
                //System.out.println("collision yabaaaaaaaa");
                System.out.println(contact.m_fixtureB.m_userData.toString()+" | "+contact.m_fixtureB.m_userData.toString());
                if (contact.m_fixtureB.m_userData.toString() == contact.m_fixtureA.m_userData.toString()) {
                    System.out.println(contact.m_fixtureB.m_userData.toString()+" | "+contact.m_fixtureB.m_userData.toString());
                    game.endTimer();
                    contact.m_fixtureB.getBody().setActive(false);
                    contact.m_fixtureB.destroy();
                    //Here we check the current turns , update health , apply impulse
                    if(game.getCurrentTurn() == 1) {
                        game.player2.inflictDamage(DAMAGE);
                        contact.m_fixtureA.getBody().applyLinearImpulse(new Vec2(DAMAGE,0),contact.m_manifold.localPoint);
                    }else if(game.getCurrentTurn() == 2){
                        game.player1.inflictDamage(DAMAGE);
                        contact.m_fixtureA.getBody().applyLinearImpulse(new Vec2(-DAMAGE,0),contact.m_manifold.localPoint);
                        game.woah.play();
                    }
                    game.decrementBalls();
                    game.changeTurn();
                    game.startTimer();
                    if(game.player1.getHealth() <= 0 ){
                        game.endTimer();
                        Main.ChangeScene(new GameMenu().getScene(),"Morty");
                        game.stopAudio();
                    }else if(game.player2.getHealth() <= 0){
                        game.endTimer();
                        Main.ChangeScene(new GameMenu().getScene(),"Rick");
                        game.stopAudio();
                    }
                    //contact.getFixtureA().getUserData().equals()
                }
            }
        }
        catch (Exception e){

        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private void endGameText(String playerName){

    }
}
