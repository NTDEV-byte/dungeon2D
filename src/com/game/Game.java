package com.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.effects.Effect;
import com.game.entity.npcs.Girl;
import com.game.entity.npcs.Player;
import com.game.font.DGFont;
import com.game.gfx.EffectAnimator;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.gfx.SpriteSheet;
import com.game.input.InputHandler;
import com.game.levels.Camera;
import com.game.levels.Level;
import com.game.utils.Generator;
import com.game.utils.IMGFilter;

public class Game extends Canvas implements Runnable{

    // TODO: EngineBase Game , GameLoop  XXX
    // TODO: Graphics Screen XXX
    // TODO  SpriteSheet XXX
    // TODO  Sprite XXX
    // TODO  SpriteAnimator
    /**************************************************/
    // TODO: Level System   XXX
    /**************************************************/
    // TODO: Level Class XXX
    // TODO: RandomLevel , MappedLevel XXX
    // TODO: Tiles System and logic XXX
    // TODO: Design Levels XXX
    /**************************************************/
    // TODO:  Entity System
    /**************************************************/
    // TODO: Entity System XXX
    // TODO  MOBS  + Player XXX
    // TODO: Particals XXX
    // TODO: Projectiles XXX
    // TODO: PlayerShoots XXX
    // TODO: Intelligent Mobs System A* XXX
    // TODO: Camera XXX
    /****************************************************/
    // TODO: Collisions
    /****************************************************/
    // TODO: Mob VS World XXX
    // TODO: Projectile VS  World XXX
    // TODO: Mob VS Projectile XXX
    // TODO: Mob VS Mob XXX
    /**************************************************/
    // TODO: Font
    /**************************************************/
    // TODO: Font XXX
    /**************************************************/
    // TODO: Utils
    /**************************************************/
    // TODO: ImageFilter XXX
    /**************************************************/
    // TODO: Level Interactions
    /**************************************************/
    //  TODO: DayNightCycle XXX
    // TODO: Level Interactions (collisions , interaction , messages) XXX
    // TODO: Sound Effetcs
    // TODO: Effect Exploisions portals ...
    /*****************************************************
     //TODO: Entity Interactions
     //****************************************************/
     //TODO: Shoot Different Projectiles
     //TODO: Inventory
    /**************************************************/
     //TODO: UI
    /**************************************************/
     //TODO: InnerUI
     //TODO: External UI
    /**************************************************/


            public static final int WIDTH = 300;
            public static final int HEIGHT = 168;
            public static final int SCALE = 3;
            public static Level level = Level.SPAWN;;
            public static InputHandler input;
            public static Player player;
            private boolean running;
            private Thread thread;
            private JFrame window;
            private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
            private Screen screen;

            private int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
            private Girl girl;
            private Camera camera;

           public Game(){
            initialize();
            setView();
            }

        private void initialize(){
          screen = new Screen(WIDTH,HEIGHT);
          input = new InputHandler();
          player = new Player(0,0,input);
          player.setLevel(level);
          camera = new Camera(level,screen);
          Generator.generateMobs(10,0,0,level);
        }

        private void setView(){
            window = new JFrame("Window");
            window.setResizable(false);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
            addKeyListener(input);
            addMouseListener(input);
            addMouseMotionListener(input);
            window.add(this);
            window.pack();
        }

            public void start(){
                running = true;
                thread = new Thread(this,"Game-Thread");
                thread.start();
            }

             public void stop(){
                try {
                    running = false;
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public void update(){
                input.update();
                player.update();
                level.update();
                Effect.CIRCLE.update();
            }

            public void render(){
                BufferStrategy bs = getBufferStrategy();
                if(bs == null){
                    createBufferStrategy(3);
                    return;
                }
                // draw part
                Graphics g = bs.getDrawGraphics();
                camera.followPlayer();
                player.render(screen);
                screen.flipBuffer(this);
                g.drawImage(image,0,0,getWidth(),getHeight(),null);
                g.dispose();
                bs.show();
            }

            @Override
            public void run() {
                final double oneSecond = 1000;
                final double TARGET_FPS = 60;
                double fps = 1000000000 / TARGET_FPS;
                double lastime = System.nanoTime();
                double now;
                double delta = 0;
                double timer = System.currentTimeMillis();
                int updates = 0,renders = 0;
                while(running){
                        now = System.nanoTime();
                        delta += (now - lastime) / fps;
                        lastime = now;
                        if(delta >= 1){
                            update();
                            updates++;
                            delta--;
                        }
                      render();
                      renders++;
                        if(System.currentTimeMillis() - timer >= oneSecond){
                                   timer+=oneSecond;
                                   window.setTitle("Game2D FPS: "+renders+" Updates: "+updates);
                                   updates = 0;
                                   renders = 0;
                            }
                }
             }

    public static void main(String args[]){
                Game game = new Game();
                game.start();
    }

    public static int getWidthWindow(){
           return WIDTH * SCALE;
    }

    public static int getHeightWindow(){
        return HEIGHT * SCALE;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }
}
