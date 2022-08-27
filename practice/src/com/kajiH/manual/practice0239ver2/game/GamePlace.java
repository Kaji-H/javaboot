package com.kajiH.manual.practice0239ver2.game;

/**
 * GamePlace
 */
public class GamePlace {

    public void play() {
        Config config = new Config();
        Maneger mgn = new Maneger(config);

        mgn.start();
        mgn.game();
        mgn.end();
    }
}