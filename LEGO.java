package test;

public class LEGO {
	private class Point{
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private int[][] ch = null; // 棋盘数组
	private int count = 1; // 用于记录第几次铺砖 
	
	
	public int[][] lego(int l, int x, int y){
		Point spot = new Point(x, y);
		Point start = new Point(0, 0);
		ch = new int[l][l];
		ch[x][y] = 0;
		LEGO(l, spot, start);
		return ch;
	}
	
	private void LEGO(int l, Point spot, Point start){
		
		if(l>1){
		
			int n = l/2;
			// 初始化要铺砖的点
			Point[][] p = new Point[2][2];
			p[0][0] = new Point(start.x+n-1, start.y+n-1);
			p[0][1] = new Point(start.x+n-1, start.y+n);
			p[1][0] = new Point(start.x+n, start.y+n-1);
			p[1][1] = new Point(start.x+n, start.y+n);
			
			// 记录原来所铺砖的编号
			int m = ch[p[(spot.x-start.x)/n][(spot.y-start.y)/n].x][p[(spot.x-start.x)/n][(spot.y-start.y)/n].y];
			
			
			//铺砖操作
			
			ch[p[0][0].x][p[0][0].y] = count;
			ch[p[0][1].x][p[0][1].y] = count;
			ch[p[1][0].x][p[1][0].y] = count;
			ch[p[1][1].x][p[1][1].y] = count;
			count++;
			//特殊位置
			ch[p[(spot.x-start.x)/n][(spot.y-start.y)/n].x][p[(spot.x-start.x)/n][(spot.y-start.y)/n].y] = m;
			p[(spot.x-start.x)/n][(spot.y-start.y)/n] = spot;
			
			//子问题的起始点
			Point start_zero_zero = start;
			Point start_zero_one = new Point(start.x, start.y+n);
			Point start_one_zero = new Point(start.x+n, start.y);
			Point start_one_one = new Point(start.x+n, start.y+n);
			
			// 四个子棋盘覆盖问题
			LEGO(n, p[0][0], start_zero_zero);
			LEGO(n, p[0][1], start_zero_one);
			LEGO(n, p[1][0], start_one_zero);
			LEGO(n, p[1][1], start_one_one);
		}
		
	}
	
	
	public static void main(String[] args) {
		LEGO l = new LEGO();
		int[][] ans = l.lego(8, 0, 1);
		
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans.length; j++)
				System.out.print(ans[i][j]+" ");
			System.out.println();
		}
	}

}
