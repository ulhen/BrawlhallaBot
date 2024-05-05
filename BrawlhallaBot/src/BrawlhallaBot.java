// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class BrawlhallaBot {


    private static Coordinate[] checklist = new Coordinate[11];

//15461355

    public static void main(String[] args) { //Coordinates bases on 'ColorPix'
        boolean firstime = true;
        //Main_Menu, (The "." from version control)
        checklist[0] = new Coordinate(
                210,
                20,
                -2236963,
                GameState.MAIN_MENU);

        //Game_Select (The "X" from close window)
        checklist[1] = new Coordinate(
                1753,
                246,
                16777215,
                GameState.Game_Select);

        //Room_Type (The "X" from close window)
        checklist[2] = new Coordinate(
                1682,
                246,
                16777215,
                GameState.Room_Type);

        //LOBBY
        checklist[3] = new Coordinate(
                32,
                354,
                7391442,
                GameState.LOBBY);

        //GAME_RULES
        checklist[4] = new Coordinate(
                1092,
                525,
                7014931,
                GameState.GAME_RULES);

        //LOBBY_RULES
        checklist[4] = new Coordinate(
                1000,
                355,
                8596,
                GameState.LOBBY_RULES);

        //FULL_LOBBY
        checklist[5] = new Coordinate(
                32,
                354,
                4387,
                GameState.FULL_LOBBY);

        //IN_GAME
        checklist[6] = new Coordinate(
                1518,
                70,
                52275,
                GameState.IN_GAME);

        //IN_GAME_MENU
        checklist[7] = new Coordinate(
                1236,
                58,
                16777215,
                GameState.IN_GAME_MENU);

        //OUT_GAME
        checklist[8] = new Coordinate(
                620,
                483,
                14474462,
                GameState.OUT_Game);

        //POST_Game
        checklist[9] = new Coordinate(
                365,
                600,
                16711423,
                GameState.POST_Game);

        //MATCH_REWARDS
        checklist[10] = new Coordinate(
                713,
                306,
                10671606,
                GameState.MATCH_REWARDS);


        try {
            // Start Brawlhalla (assuming it's already installed)
            Runtime.getRuntime().exec("cmd /c start steam://rungameid/291550");

            // Delay to give Brawlhalla time to open
            Thread.sleep(45000);

            // Create Robot instance
            Robot robot = new Robot();

            while (true) {
                // Capture screenshot
                BufferedImage screenshot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

                GameState gameState = null;

                for (Coordinate coordinate : checklist
                ) {
                    // Process screenshot and determine game state
                    gameState = processScreenshot(screenshot, coordinate);
                }


                // Perform actions based on game state
                switch (gameState) {
                    case MAIN_MENU:
                        // Example: Click on "Custom Game Room" button
                        robot.mouseMove(235, 550);
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        System.out.println("main_manu");
                        break;

                    case Game_Select:
                        // Click on "Create Room"
                        robot.mouseMove(570, 570);
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        System.out.println("game_select");
                        break;

                    case Room_Type:
                        //Click on "Private Room"
                        robot.mouseMove(0, 00);
                        System.out.printf("Room_Type");
                        break;

                    case LOBBY:
                        //Click on "Settings"
                        //Click on "Add bot x3"
                        //Maybe make bots pushovers
                        robot.mouseMove(00, 00);
                        System.out.println("Lobby");
                        break;

                    case GAME_RULES:
                        //Set Lobby to "Timed"
                        //Set Timer to "15min"
                        robot.mouseMove(00, 00);
                        System.out.println("Game_rules");
                        break;

                    case LOBBY_RULES:
                        //Set Lobby to "Timed"
                        //Set Timer to "15min"
                        robot.mouseMove(00, 00);
                        System.out.println("Lobby_rules");
                        break;

                    case FULL_LOBBY:
                        //Set Lobby to "Timed"
                        //Set Timer to "15min"
                        robot.mouseMove(00, 00);
                        System.out.println("Full_lobby");
                        break;

                    case IN_GAME:
                        if (firstime == true){
                            firstime = false;
                        // Press ESC
                            System.out.println("IN_GAME");
                        break;

                            } break;


                    case IN_GAME_MENU:

                        // Leave Game
                        robot.keyPress(KeyEvent.VK_W);
                        robot.keyRelease(KeyEvent.VK_W);
                        System.out.println("IN game menu");
                        break;

                    case OUT_Game:
                        // Press Rejoin
                        // Make sure it dont click anymore as it goes back to IN_GAME gamestate.
                        System.out.println("Out_game");
                        break;

                    case POST_Game:
                        firstime = true;
                        // Spam "C" going back to Lobby
                        System.out.println("post game");
                        break;
                    case MATCH_REWARDS:
                        // Spam "C" going back to Lobby
                        // Add more cases for different game states
                        System.out.println("match rewards");
                        break;
                    default:
                        // Do nothing or handle unrecognized state (Exceptions)
                        robot.mouseMove(235, 550);
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        robot.mouseMove(570, 570);
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        System.out.println("3");
                        break;
                }

                // Wait before capturing the next screenshot
                Thread.sleep(10000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static GameState processScreenshot(BufferedImage screenshot, Coordinate coordinate) {
        // Analyze the colors in specific regions of the screenshot to determine game state

        int pixelColor = screenshot.getRGB(coordinate.getX(), coordinate.getY()); // Get the color of a specific pixel
        if(pixelColor == coordinate.color) {
        return coordinate.gameState;
        }
        return GameState.UNKNOWN;
        }



       /* // Compare the pixel color with known colors associated with different game states
        if (isMainMenuColor(pixelColor)) {
            return GameState.MAIN_MENU;
        } else if (isInGameColor(pixelColor)) {
            return GameState.IN_GAME;
        } else {
            return GameState.UNKNOWN; // Unknown state
        }

        */


    /*private static boolean isMainMenuColor(int color) {
        // Check if the color matches the main menu color
        if (color == 0) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isInGameColor(int color) {
        // Check if the color matches the in-game color
        if (color == 0) {
            return true;
        } else {
            return false;
        }
    }*/

}
