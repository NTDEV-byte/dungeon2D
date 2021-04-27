package com.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.entity.npcs.Player;
import com.game.gfx.Screen;
import com.game.gfx.Sprite;
import com.game.input.InputHandler;
import com.game.levels.Level;
import com.game.utils.Generator;

public class Game extends Canvas implements Runnable{

    // TODO: EngineBase Game , GameLoop  XXX
    // TODO: Graphics Screen , SpriteSheet , Sprite XXX
    /**************************************************/
    // TODO: Level System   XXX
    /**************************************************/
    // TODO: 25/04/2021  Level Class XXX
    // TODO: 25/04/2021  RandomLevel , MappedLevel XXX
    // TODO: 25/04/2021  Tiles System and logic XXX
    // TODO: Design Levels XXX
    /**************************************************/
    // TODO:  Entity System
    /**************************************************/
    // TODO: 25/04/2021  Entity System XXX
    // TODO: 25/04/2021  Particals XXX
    // TODO: 25/04/2021  Projectiles XXX
    /*****************************************************
    //  // TODO:  Entity Interactions
    //****************************************************/
    // TODO: 25/04/2021 PlayerShoots XXX
    /******************************************************/
    // TODO: 25/04/2021 Intelligent Mobs System A*
    // TODO: 25/04/2021 Entity System
    // TODO: 25/04/2021 Camera
    /****************************************************/
    // TODO: Collisions
    /****************************************************/
    // TODO: Mob VS World
    // TODO: Mob VS Particals
    // TODO: Mob VS Mob
    /**************************************************/
    // TODO: Font
    /**************************************************/
    // TODO: 25/04/2021  Font
    /**************************************************/
    // TODO: Level Interactions
    /**************************************************/
    // TODO: 25/04/2021  Level Interactions (collisions , interaction , messages)
    // TODO: 25/04/2021  Sound Effetcs
    // TODO: 25/04/2021  Effect Exploisions portals ...
    /**************************************************/
    // TODO: Utils
    /**************************************************/
    // TODO: ImageUtils
    // TODO: Sprite Rotation
    /**************************************************/
    // TODO: UI
    /**************************************************/
    // TODO: 25/04/2021  InnerUI
    // TODO: 25/04/2021  External UI
    /**************************************************/


            public static final int WIDTH = 300;
            public static final int HEIGHT = WIDTH * 9 / 16;
            public static final int SCALE = 3;
            public static Level level;
            private boolean running;
            private Thread thread;
            private JFrame window;
            private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
            private Screen screen;
            private InputHandler input;
            private int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
            private Player player;


           public Game(){
            initialize();
            setView();
            }

        private void initialize(){
          screen = new Screen(WIDTH,HEIGHT);
          input = new InputHandler();
          level = Level.SPAWN;
          player = new Player(0,0,input);
          player.setLevel(level);
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
            }

            public void render(){
                BufferStrategy bs = getBufferStrategy();
                if(bs == null){
                    createBufferStrategy(3);
                    return;
                }
                // draw part
                Graphics g = bs.getDrawGraphics();
                level.render(screen,player.getCenterX(),player.getCenterY());
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
