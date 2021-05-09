package com.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.effects.Effect;
import com.game.entity.npcs.monsters.Ghost;
import com.game.entity.npcs.monsters.Lucifer;
import com.game.entity.npcs.personnes.Girl;
import com.game.entity.npcs.personnes.Player;
import com.game.gfx.Screen;
import com.game.input.InputHandler;
import com.game.levels.Camera;
import com.game.levels.Level;
import com.game.ui.inner.DGInnerLook;
import com.game.utils.Generator;

public class Game extends Canvas implements Runnable{


            public static final int WIDTH = 300;
            public static final int HEIGHT = 168;
            public static final int SCALE = 3;
            public static Level level = Level.SPAWN;
             static {
                 level.initialize();
             }
            public static InputHandler input = new InputHandler();
            public static Player player = new Player(0,0,input);
            public static DGInnerLook look = DGInnerLook.look;
            public static Game game;
            private boolean running;
            private Thread thread;
            private JFrame window;
            private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
            private Screen screen;
            private Lucifer lucifer;
            private Ghost ghost;

            private int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
            private Camera camera;

           public Game(){
            initialize();
            setView();
            }

        private void initialize(){
          screen = new Screen(WIDTH,HEIGHT);
          camera = new Camera(level,screen);
          lucifer = new Lucifer(0,0);
          ghost = new Ghost(0,0);
          Generator.generateMobs(1,16,13,level);
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
                lucifer.update();
                ghost.update();
                look.update();
                Effect.EXPLOSION_EFFECT.update();
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
                lucifer.render(screen);
                ghost.render(screen);

                screen.flipBuffer(this);
                g.drawImage(image,0,0,getWidth(),getHeight(),null);
                look.render(g);
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
                Game.game = game;
                game.start();
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
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
