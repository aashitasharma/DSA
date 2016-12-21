package data_structures_and_algorithms.leetCode.medium;

public class WallsGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static final int INF=2147483647;
	
	public void wallsAndGates(int[][] rooms) {
        boolean[][] visited=new boolean[rooms.length][rooms[0].length];
        for(int i=0;i<rooms.length;i++){
        	for(int j=0;j<rooms[0].length;j++){
        		visited[i][j]=false;
        	}
        }
        
        for(int i=0;i<rooms.length;i++){
        	for(int j=0;j<rooms[0].length;j++){
        		if(rooms[i][j]==INF && !visited[i][j]){
        			visited[i][j]=true;
        			rooms[i][j]=getMinDistance(rooms, i, j, visited);
        		}
        	}
        }
    }
	
	public int getMinDistance(int[][] rooms, int r, int c, boolean[][] visited){
		if(r<0 || r>=rooms.length || c<0 || c>=rooms[0].length)
			return 0;
		if(rooms[r][c]!=-1 && rooms[r][c]!=INF)
			return rooms[r][c]+1;
		else{
			int a=getMinDistance(rooms, r-1, c, visited);
			int b=getMinDistance(rooms, r+1, c, visited);
			int e=getMinDistance(rooms, r, c-1, visited);
			int d=getMinDistance(rooms, r, c+1, visited);
			rooms[r][c]=Math.min(a, Math.min(b,Math.min(e, d)));
			visited[r][c]=true;
			return rooms[r][c];
		}
		
	}

	
	

}
