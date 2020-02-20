package pathfinder;

import pathfinder.Mover;
import pathfinder.TileBasedMap;;

public class GameMap1 implements TileBasedMap {
	public static final int WIDTH = logic.Main.house1.length;
	public static final int HEIGHT = logic.Main.house1[0].length;

	public static final int PLAYER = 2;
	public static final int TANGIBEL = 1;
	public static final int INTANGIBEL = 0;

	private int[][] terrain = new int[WIDTH][HEIGHT];
	private int[][] units = new int[WIDTH][HEIGHT];
	private boolean[][] visited = new boolean[WIDTH][HEIGHT];

	public GameMap1(int nx, int ny) {
		for (int y = 0; y < terrain[0].length; y++) {
			for (int x = 0; x < terrain.length; x++) {
				terrain[x][y] = logic.Main.house1[x][y][1];
			}
		}
		units[nx][ny] = 2;
	}

	/**
	 * Fill an area with a given terrain type
	 * 
	 * @param x      The x coordinate to start filling at
	 * @param y      The y coordinate to start filling at
	 * @param width  The width of the area to fill
	 * @param height The height of the area to fill
	 * @param type   The terrain type to fill with
	 */
	@SuppressWarnings("unused")
	private void fillArea(int x, int y, int width, int height, int type) {
		for (int xp = x; xp < x + width; xp++) {
			for (int yp = y; yp < y + height; yp++) {
				terrain[xp][yp] = type;
			}
		}
	}

	public void clearVisited() {
		for (int x = 0; x < getWidthInTiles(); x++) {
			for (int y = 0; y < getHeightInTiles(); y++) {
				visited[x][y] = false;
			}
		}
	}

	/**
	 * @see TileBasedMap#visited(int, int)
	 */
	public boolean visited(int x, int y) {
		return visited[x][y];
	}

	/**
	 * Get the terrain at a given location
	 * 
	 * @param x The x coordinate of the terrain tile to retrieve
	 * @param y The y coordinate of the terrain tile to retrieve
	 * @return The terrain tile at the given location
	 */
	public int getTerrain(int x, int y) {
		return terrain[x][y];
	}

	public int getUnit(int x, int y) {
		return units[x][y];
	}

	public void setUnit(int x, int y, int unit) {
		units[x][y] = unit;
	}

	/**
	 * @see TileBasedMap#getHeightInTiles()
	 */
	public int getHeightInTiles() {
		return WIDTH;
	}

	/**
	 * @see TileBasedMap#getWidthInTiles()
	 */
	public int getWidthInTiles() {
		return HEIGHT;
	}

	/**
	 * @see TileBasedMap#pathFinderVisited(int, int)
	 */
	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}

	@Override
	public boolean blocked(Mover mover, int x, int y) {
		if (getTerrain(x, y) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public float getCost(Mover mover, int sx, int sy, int tx, int ty) {
		return 1;
	}
}