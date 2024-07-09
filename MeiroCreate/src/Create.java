import java.util.ArrayList;
import java.util.Collections;

public class Create extends MyFrame {
	private int[][] Maze = new int[15][15];
	private int[][] NewMaze = new int[15][15];
	private int[][] Candidate = new int[15][15];
	private ArrayList<Integer> listI = new ArrayList<Integer>();
	private ArrayList<Integer> listJ = new ArrayList<Integer>();
	private ArrayList<Integer> listDirection = new ArrayList<Integer>();

	public void run() {
		MazeCheck();
		MazeCreate();
	}

	public void MazeCreate() {

		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				if (Maze[i][j] == 1) {
					fillRect(i * 10 + 100, j * 10 + 100, 10, 10);
				}

			}
		}

	}

	public void MazeCheck() {
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				MazeWall(i, j);
			}
		}
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				MazeCandidate(i, j);
			}
		}
		MazeRandom();
	}

	public void MazeWall(int i, int j) {
		if (i == 14 || j == 14 || i == 0 || j == 0) {
			Maze[i][j] = 1;
		}
	}

	public void MazeCandidate(int i, int j) {
		if (i % 2 == 0 && j % 2 == 0 && Maze[i][j] == 0) {
			Candidate[i][j] = 1;
		}
	}

	public void MazeRandom() {
		Shuffle();
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {

				int ShuffleI = listI.get(i);
				int ShuffleJ = listJ.get(j);

				if (Candidate[ShuffleI][ShuffleJ] == 1) {
					RandomMaze(ShuffleI, ShuffleJ);
				}
			}
		}
	}

	public void Shuffle() {

		for (int i = 0; i <= 14; i++) {
			listI.add(i);
			listJ.add(i);
		}

		Collections.shuffle(listI);
		Collections.shuffle(listJ);
	}

	public void ShuffleDirection() {
		for (int i = 0; i <= 3; i++) {
			listDirection.add(i);
		}

		Collections.shuffle(listDirection);
	}

	public void RandomMaze(int i, int j) {
		int Direction;
		int Frag=0;
		ShuffleDirection();
		NewMaze[i][j] = 1;
		while (true) {
			Collections.shuffle(listDirection);
			for (int n = 0; n <= 3; n++) {
				Direction = listDirection.get(n);
				if (Direction == 0) {
					if(Maze[i][j--]==0) {
						j--;
						NewMaze[i][j]=1;
						Frag =1;
					}
					
				} else if (Direction == 1) {
					

				} else if (Direction == 2) {
					

				} else if (Direction == 3) {
				
				}
			}

			if (Frag == 0) {
				break;
			}

		}

		for (int m = 0; m <= 14; m++) {
			for (int k = 0; k <= 14; k++) {
				if (Maze[m][k] == 0) {
					Maze[m][k] = NewMaze[m][k];
				}
				if(NewMaze[m][k]==1) {
					NewMaze[m][k]=0;
				}
			}
		}

	}

}
