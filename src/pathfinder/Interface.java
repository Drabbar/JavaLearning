package pathfinder;

import pathfinder.UnitMover;

public class Interface {

	public static Path path;
	public static Mover mover;

	public Interface() {
		path = new Path();
	}

	public static logic.Player.Blickrichtung[] findpath(int worldin, int xstart, int ystart, int xziel, int yziel) {
		switch (worldin) {
		case 0:
			GameMap0 gm0 = new GameMap0(xstart, ystart);
			path = new AStarPathFinder(gm0, 64, false).findPath(new UnitMover(gm0.getUnit(xstart, ystart)), xstart,
					ystart, xziel, yziel);
			break;
		case 1:
			GameMap1 gm1 = new GameMap1(xstart, ystart);
			path = new AStarPathFinder(gm1, 64, false).findPath(new UnitMover(gm1.getUnit(xstart, ystart)), xstart,
					ystart, xziel, yziel);
			break;
		}
		if (path != null) {
			System.out.println(path.getLength());
			logic.Player.Blickrichtung[] br = new logic.Player.Blickrichtung[path.getLength() - 1];
			for (int i = 0; i < path.getLength(); i++) {
				if (i > 0) {
					if (path.getStep(i).getX() == path.getStep(i - 1).getX()) {
						if (path.getStep(i).getY() > path.getStep(i - 1).getY()) {
							System.out.println("unten");
							br[i - 1] = logic.Player.Blickrichtung.unten;
						} else if (path.getStep(i).getY() < path.getStep(i - 1).getY()) {
							System.out.println("oben");
							br[i - 1] = logic.Player.Blickrichtung.oben;
						}
					} else if (path.getStep(i).getY() == path.getStep(i - 1).getY()) {
						if (path.getStep(i).getX() > path.getStep(i - 1).getX()) {
							System.out.println("rechts");
							br[i - 1] = logic.Player.Blickrichtung.rechts;
						} else if (path.getStep(i).getX() < path.getStep(i - 1).getX()) {
							System.out.println("links");
							br[i - 1] = logic.Player.Blickrichtung.links;
						}
					}
				}
			}
			return br;
		} else {
			return null;
		}
	}
}