import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class Create2 extends MyFrame{
	static final int MAZE_SIZE = 19;
	Reroll reroll=new Reroll();
	public void run() {
		addKeyListener(reroll);
		MakeMaze();
	}
	public void MakeMaze() {
		int[][] maze = new int[MAZE_SIZE][MAZE_SIZE];
		 
        // 配列初期化
        initialize(maze);
        // 迷路生成
        mazeCreate(maze);
        // 入口設定
        maze[0][1] = 0;
        setColor(0,0,255);
        fillRect(0 * 10 + 100, 1 * 10 + 100, 10, 10);
        // 出口設定
        maze[MAZE_SIZE - 1][MAZE_SIZE - 2] = 0;
        setColor(255,0,0);
        fillRect(18 * 10 + 100, 17 * 10 + 100, 10, 10);
        // 迷路描画
        mazeOutput(maze);
	}
	
	 /**
     * 配列の初期化
     * @param maze 2次元配列
     */
    public  void initialize(int[][] maze) {
        // 縦軸ループ
        for (int i = 0; i < MAZE_SIZE; i++) {
            // 横軸ループ
            for (int j = 0; j < MAZE_SIZE; j++) {
                // 一番上と一番下の行
                if (i == 0 || i == MAZE_SIZE - 1) {
                    // 壁を設定
                    maze[i][j] = 1;
                // 偶数行は壁と道を交互に
                } else if (i % 2 == 0 && j % 2 == 0) {
                    // 壁を設定
                    maze[i][j] = 1;
                // 奇数行は1列目と最終列を壁にする
                } else if (j == 0 || j == MAZE_SIZE - 1) {
                    // 壁を設定
                    maze[i][j] = 1;
                }
            }
        }
    }
 
    /**
     * 棒倒し法による迷路生成
     * @param maze 2次元配列
     */
    public  void mazeCreate(int[][] maze) {
        // 乱数発生用のインスタンス生成
        Random rnd = new Random();
 
        // 縦軸ループ(棒があるところのみ)
        for (int i = 2; i < MAZE_SIZE - 2; i += 2) {
            // 横軸ループ(棒があるところのみ)
            for (int j = 2; j < MAZE_SIZE - 2; j += 2) {
                // doループ脱出用フラグ
                boolean flag = false;
                // 棒を倒したらdoループを脱出
                do {
                    // 0～3の乱数で生成
                    int random = rnd.nextInt(4);
                    switch (random) {
                    case 0:
                        // 2行目で上が道ならば
                        if (i == 2 && maze[i - 1][j] == 0) {
                            // 上へ倒す
                            maze[i - 1][j] = 1;
                            flag = true;
                        }
                        break;
                    case 1:
                        // 右が道ならば
                        if (maze[i][j + 1] == 0) {
                            // 右へ倒す
                            maze[i][j + 1] = 1;
                            flag = true;
                        }
                        break;
                    case 2:
                        // 下が道ならば
                        if (maze[i + 1][j] == 0) {
                            // 下へ倒す
                            maze[i + 1][j] = 1;
                            flag = true;
                        }
                        break;
                    case 3:
                        // 左が道ならば
                        if (maze[i][j - 1] == 0) {
                            // 左へ倒す
                            maze[i][j - 1] = 1;
                            flag = true;
                        }
                        break;
                    }
                } while (!flag);
            }
        }
    }
 
    /**
     * 迷路描画
     * @param maze 2次元配列
     */
    public void mazeOutput(int[][] maze) {
        // 縦軸ループ
        for (int i = 0; i < MAZE_SIZE; i++) {
            // 横軸ループ
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (maze[i][j] == 1) {
                    // 壁描画
                	setColor(0,0,0);
                	fillRect(i * 10 + 100, j * 10 + 100, 10, 10);
                } 
            }
        }
    }
    public class Reroll implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				clear();
				MakeMaze();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
    	
    }
}

