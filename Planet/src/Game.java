public class Game {
    Panel panel;
    Screen screen;
    Game() {
        panel = new Panel();
        screen = new Screen(panel);
    }
}
