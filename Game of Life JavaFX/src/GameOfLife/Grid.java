package GameOfLife;

public class Grid {

    private int width = 3;
    private int height = 3;
    private Cell[][] cells;

    public Grid(int width, int height, double p) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                //System.out.println(x + "|" + y);
                cells[x][y] = new Cell();
                if (Math.random() <= p) {
                    cells[x][y].setNextLife(true);
                    cells[x][y].update();
                }

            }
        }
    }
    public int Neighbours(int row, int col) {
        int sum = 0;
        // Positions numbered as phone dial
        if (row != 0 && col != 0) {    //1
            if (isAlive(row - 1, col - 1)) {
                sum++;
            }
        }

        if (row != 0) {
            if (isAlive(row - 1, col)) { //2
                sum++;
            }
        }
        if (col != 0) {
            if (isAlive(row, col - 1)) { //4
                sum++;
            }
        }

        if (row != 0 && col != height - 1) {//3
            if (isAlive(row - 1, col + 1)) {
                sum++;
            }
        }
        if (row != width - 1 && col != 0) {
            if (isAlive(row + 1, col - 1)) { //7
                sum++;
            }
        }
        
        //self
        if (col != height - 1) {
            if (isAlive(row, col + 1)) { //6
                sum++;
            }
        }

        

        if (row != width - 1) {
            if (isAlive(row + 1, col)) { //8
                sum++;
            }
        }

        if (row != width - 1 && col != height - 1) {
            if (isAlive(row + 1, col + 1)) { //9
                sum++;
            }
        }

        return sum;
    }
    public boolean isAlive(int row, int col) {
        return cells[row][col].isAlive();
    }
    public Cell[][] getCell(){
        return cells;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void testing() {
                for(int x = 0 ;x<cells.length ; x++){
                for(int y = 0;y<cells[x].length ;y++){
                int nr = Neighbours(x, y);
                if(nr<2) cells[x][y].setNextLife(false);
                else if(nr == 3) cells[x][y].setNextLife(true);
                else if(nr > 3) cells[x][y].setNextLife(false);
                else if(nr == 2) cells[x][y].setNextLife(cells[x][y].isAlive());
                
            }
        }  
    }
    public void UpdateCell(){
        for(int x = 0 ;x<cells.length ; x++){
            for(int y = 0;y<cells[x].length ;y++){
                cells[x][y].update();
            }
        }
    }

    public void updateAll() {
        
                testing();
                UpdateCell();
            
        }

    }

    
    
    

    

