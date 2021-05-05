package com.game.entity.npcs;

import com.game.entity.Entity;
import com.game.entity.projectiles.MasterProjectile;
import com.game.entity.projectiles.Projectile;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.gfx.VisualAspect;
import com.game.levels.Level;
import com.game.levels.interactions.Teleporation;
import com.game.levels.tiles.WormHole;
import com.game.utils.Generator;
import com.game.utils.Node;
import com.game.utils.PathFinder;
import com.game.utils.Vector2i;

import java.util.List;
import java.util.Random;

public abstract class Mob extends Entity {

        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;

        public static final int RATE_ANIMATION = 30;
        public static final int RATE_DIRECTION = 80;
        public static final int RATE_SEARCH_PATH = 30;

        public static final int PARTICALS_ON_DEATH = 40;



        protected Sprite sprite;
        protected int direction;
        protected int xDir,yDir;
        protected VisualAspect vAspect;
        protected List<Node> path;
        protected boolean moving,collidingMob;
        protected int life = 100;

        public Mob(){
            random = new Random();
        }

        @Override
        public void update(){
            moveRandomlly();
        }

        @Override
        public void render(Screen screen) {
            screen.renderMob(this,(int)(x - 16),(int)(y - 16));
        }

    /***********BEHAVIOUR**********/

    public void move(int xDir, int yDir){
        if(xDir != 0 && yDir != 0) {
            move(xDir,0);
            move(0,yDir);
            return;
        }
        if(xDir < 0){
            direction = LEFT;
        }
        if(xDir > 0){
            direction = RIGHT;
        }
        if(yDir < 0){
            direction = UP;
        }
        if(yDir > 0){
            direction = DOWN;
        }
        if(!collision(xDir,yDir)){
            x+=xDir;
            y+=yDir;
        }
    }

    protected void updateSprite(){
        if(moving){
            vAspect.animate(direction);
            sprite = vAspect.getSprite();
        }
    }

    /**********RANDOM MOVEMENTS *************/

        protected void moveRandomlly(){
            if(timer < 7500) timer++; else timer = 0;
            if(timer % RATE_DIRECTION == 0) {
                xDir = random.nextInt(3) - 1;
                yDir = random.nextInt(3) - 1;
            }
            if(xDir != 0 || yDir != 0){
                move(xDir,yDir);
                moving = true;
            }
            else{
                moving = false;
            }
            collisionProjectiles();
            collisionMob();
            updateSprite();
        }

    /********** Intelligent Movements *************/
    /********** Track Player ****************/

        protected void followPlayer(){
            findPath();
            followPath();
            collisionMob();
            collisionProjectiles();
        }

        // findPathToPlayer
        private void findPath(){
            if(timer % RATE_SEARCH_PATH  == 0){
                Vector2i playerPos = new Vector2i(this.player.getX() / 16  , this.player.getY() / 16);
                if(!playerPos.equals(new Vector2i((int)(x / 16) , (int)(y / 16))))
                path = PathFinder.findPath(level,new Vector2i((int)(x / 16) , (int)(y / 16)) , playerPos);
            }
        }

        private void followPath(){
            if(timer < 7500) timer++; else timer = 0;
            xDir = 0; yDir = 0;
            if(path != null){
                if(path.size() > 0){

                    Vector2i targetPosition = path.get(path.size() - 1).getPosition();

                    if(x < targetPosition.x << 4) xDir++;
                    if(x > targetPosition.x << 4) xDir--;
                    if(y < targetPosition.y << 4) yDir++;
                    if(y > targetPosition.y << 4) yDir--;

                }
            }
            if(xDir != 0 || yDir != 0){
                move(xDir,yDir);
                moving = true;
            }
            else{
                moving = false;
            }
            updateSprite();

        }


    /*******************ACTIONS********************/

    public void shoot(double angle){
             Projectile p = new MasterProjectile(x,y,angle);
             p.setLevel(level);
             level.addEntity(p);
    }


    /*****************COLLISIONS********************/

        public boolean collision(int xa,int ya){
            return level.collision((int)x + xDir , (int)y + yDir);
        }

        private void collisionProjectiles(){
            List<Projectile> projectiles = level.getProjectiles();
            for(int i=0;i<projectiles.size();i++){
                  if(getWorldPosition().colliding(projectiles.get(i).getWorldPosition())){
                            projectiles.get(i).remove();
                            life--;
                            if(onDeath()){
                                 Generator.generateParticals(PARTICALS_ON_DEATH,projectiles.get(i).getX() , projectiles.get(i).getY() ,level);
                                 remove();
                            }
                  }
            }
        }

        protected void openPortal(){
            Vector2i position = getWorldPosition();
            if(level.getBlockUsingColor(position.x , position.y) instanceof WormHole) {
                    new Teleporation().teleportate(this , Teleporation.TO_FIREWORLD);
                    System.out.println("Teleportation possible !");
            }
        }

    private void collisionMob(){
            List<Mob> mobs = level.getMobs();
            for(int i=0;i<mobs.size();i++){
                 if(getWorldPosition().colliding(mobs.get(i).getWorldPosition()) && this != (mobs.get(i))){

                     collidingMob = true;
                 }
                 else{
                     collidingMob = false;
                 }
            }
        }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean isCollidingWithMob() {
        return collidingMob;
    }


    private boolean onDeath(){
      boolean dead = life <= 0;
      life = (dead) ? 0 : life;
      return dead;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
