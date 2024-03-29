package com.kajih.practice07;

import static com.kajih.practice07.Logger.LogType.ERROR;

public class BirdWatching {
    public static void main(String[] args) {
        boolean isNeedToValidPigeon = true;
        boolean isNeedToConvertToPigeon = false;

        BirdWatching app = new BirdWatching();

        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);

        System.out.println();

        isNeedToValidPigeon = false;
        isNeedToConvertToPigeon = true;

        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);

        System.out.println();

        isNeedToConvertToPigeon = false;

        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);

    }

    private void execute(
            boolean isNeedToValidPigeon,
            boolean isNeedToConvertToPigeon) {

        Bird eagle = new Eagle("オジロワシ");
        Bird pigeon = new Pigeon(null);

        try {
            eagle.fly();
            if (isNeedToValidPigeon) {
                pigeon.fly();
                pigeon.isEmptyName();
            }
            if (isNeedToConvertToPigeon) {
                Bird convertedPigeon = Bird.convertToPigeon(eagle);
                convertedPigeon.fly();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            Logger.log(ERROR, e);
        }

    }

}