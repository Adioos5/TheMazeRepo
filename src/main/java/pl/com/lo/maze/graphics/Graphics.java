package pl.com.lo.maze.graphics;

public enum Graphics {

    SPIKES("spikes.png", GraphicsType.TILE),
    COIN("coin.png", GraphicsType.TILE),
    PLAYER("player.png", GraphicsType.TILE),
    BUSH("bush.png", GraphicsType.TILE),
    GRASS("grass.png", GraphicsType.TILE),
    GAME_ICON("game_icon.jpg", GraphicsType.IMAGE),
    MENU_BACKGROUND("menu_background.jpg", GraphicsType.IMAGE);

    private String fileName;
    private GraphicsType graphicsType;

    Graphics(String fileName, GraphicsType type) {
        this.fileName = fileName;
        this.graphicsType = type;
    }

    public String getFileName() {
        return fileName;
    }

    public GraphicsType getGraphicsType() {
        return graphicsType;
    }
}
