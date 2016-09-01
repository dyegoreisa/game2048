package br.com.biavan.game2048.core;

public class SquareArea {

	public static final int SIZE = 4;
	public static final boolean LINE = true;
	public static final boolean COLUMN = false;

	private Tile[][] tiles = new Tile[SIZE][SIZE];

	public SquareArea() {
		for (int x = 0; x < tiles[0].length; x++){
			for (int y = 0; y < tiles.length; y++){
				tiles[x][y] = new Tile();
			}

		}

		int x = 0, y = 0;
		for(int i = 0; i < 2; i++) {
			do {
				x = generateRandonPosition();
				y = generateRandonPosition();
			} while(hasTileAt(x, y));
			setTileAt(new Tile(2), x, y);
		}

	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public void setTileAt(Tile tile, int x, int y) {
		tiles[x][y] = tile;
	}

	public Tile getTileAt(int x, int y) {
		return tiles[x][y];
	}

	public Boolean hasTileAt(int x, int y) {
		return (tiles[x][y].getValue() != 0);
	}

	public Boolean hasBlank() {
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				if (tiles[x][y].getValue() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private Tile[] getLine(int lineNumber) {
		Tile[] line = new Tile[SIZE];

		for(int y = 0; y < line.length; y++) {
			line[y] = tiles[lineNumber][y];
		}

		return line;
	}

	private Tile[] getColumn(int columnNumber) {
		Tile[] column = new Tile[SIZE];

		for(int x = 0; x < column.length; x++) {
			column[x] = tiles[x][columnNumber];
		}

		return column;
	}

	private void setLine(int lineNumber, Tile[] line) {
		for(int y = 0; y < line.length; y++) {
			tiles[lineNumber][y] = line[y];
		}
	}

	private void setColumn(int columnNumber, Tile[] column) {
		for(int x = 0; x < column.length; x++) {
			tiles[x][columnNumber] = column[x];
		}
	}

	private int countTiles(int number, boolean lineOrColumn) {
		int count = 0;
		Tile[] list;
		if (lineOrColumn) {
			list = getLine(number);
		} else {
			list = getColumn(number);
		}
		for(int i = 0; i < list.length; i++) {
			if (list[i].getValue() != 0) {
				count++;
			}
		}

		return count;
	}

	public int generateRandonPosition() {
		return (int)(Math.random() * SIZE);
	}

	public void calculate(Direction direction) {

		switch (direction) {
		case RIGHT:
			calculateLineRight();
			break;

		case LEFT:
			calculateLineLeft();
			break;
		case DOWN:
			calculateColumnDown();
			break;

		case UP:
			calculateColumnUp();
			break;


		default:
			break;
		}

	}

	private void calculateLineRight() {
		for(int x = 0; x < SIZE; x++) {
			int lastPosition = 3;
			Tile lastTile = tiles[x][lastPosition];
			for(int i = 2; i >= 0; i--) {
				if (lastTile.equals(tiles[x][i])) {
					lastTile.merge(tiles[x][i]);
					tiles[x][i] = lastTile = new Tile(0);
					lastPosition = i;
				} else if(tiles[x][i].getValue() != 0) {
					lastTile = tiles[x][i];
					lastPosition = i;
				}
			}

			for (int j = 0; j < countTiles(x, LINE); j++) {
				setLine(x, moveItensRight(getLine(x), SIZE));
			}
		}
	}

	private void calculateLineLeft() {
		for(int x = 0; x < SIZE; x++) {
			int lastPosition = 0;
			Tile lastTile = tiles[x][lastPosition];
			for(int i = 1; i < SIZE; i++) {
				if (lastTile.equals(tiles[x][i])) {
					lastTile.merge(tiles[x][i]);
					tiles[x][i] = lastTile = new Tile(0);
					lastPosition = i;
				} else if(tiles[x][i].getValue() != 0) {
					lastTile = tiles[x][i];
					lastPosition = i;
				}
			}

			for (int j = 0; j < countTiles(x, LINE); j++) {
				setLine(x, moveItensLeft(getLine(x), 0));
			}
		}
	}
	
	private void calculateColumnDown() {
		for(int y = 0; y < SIZE; y++) {
			int lastPosition = 3;
			Tile lastTile = tiles[lastPosition][y];
			for(int i = 2; i >= 0; i--) {
				if (lastTile.equals(tiles[i][y])) {
					lastTile.merge(tiles[i][y]);
					tiles[i][y] = lastTile = new Tile(0);
					lastPosition = i;
				} else if(tiles[i][y].getValue() != 0) {
					lastTile = tiles[i][y];
					lastPosition = i;
				}
			}

			for (int j = 0; j < countTiles(y, COLUMN); j++) {
				setColumn(y, moveItensRight(getColumn(y), SIZE));
			}
		}
	}

	private void calculateColumnUp() {
		for(int y = 0; y < SIZE; y++) {
			int lastPosition = 0;
			Tile lastTile = tiles[lastPosition][y];
			for(int i = 1; i < SIZE; i++) {
				if (lastTile.equals(tiles[i][y])) {
					lastTile.merge(tiles[i][y]);
					tiles[i][y] = lastTile = new Tile(0);
					lastPosition = i;
				} else if(tiles[i][y].getValue() != 0) {
					lastTile = tiles[i][y];
					lastPosition = i;
				}
			}

			for (int j = 0; j < countTiles(y, COLUMN); j++) {
				setColumn(y, moveItensLeft(getColumn(y), 0));
			}
		}
	}

	private Tile[] moveItensRight(Tile[] tiles, int position) {

		int last = position - 2;
		int actual = position - 1;

		if (last < 0) {
			return tiles;
		}

		tiles = moveItensRight(tiles, actual);

		if (tiles[actual].getValue() == 0) {
			tiles[actual] = tiles[last];
			tiles[last] = new Tile(0);
		}

		return tiles; 
	}

	private Tile[] moveItensLeft(Tile[] tiles, int position) {

		int next = position + 1;
		int actual = position;

		if (next >= tiles.length) {
			return tiles;
		}

		tiles = moveItensLeft(tiles, actual + 1);

		if (tiles[actual].getValue() == 0) {
			tiles[actual] = tiles[next];
			tiles[next] = new Tile(0);
		}

		return tiles; 
	}
}
