#include <iostream>
#define N 9
using namespace std;

int grid[N][N];

bool check_col(int col,int num)
{
     for(int row=0;row<N;row++)
     {
         if(grid[row][col]==num)
            return true;
     }
     return false;
}

bool check_row(int row,int num)
{
     for(int col=0;col<N;col++)
     {
         if(grid[row][col]==num)
            return true;
     }
     return false;
}

bool check_box(int boxRow,int boxCol,int num)
{
    for(int row=0;row<3;row++)
    {
        for(int col=0;col<3;col++)
        {
            if(grid[row+boxRow][col+boxCol]==num)
                 return true;
        }
    }
    return false;
}

bool isValid(int row,int col,int num){

    return ((!check_row(row,num)) && (!check_col(col,num)) && (!check_box(row-row%3,col-col%3,num)) && (grid[row][col]==0));
}

bool isEmpty(int &row,int &col)
{
    for(row=0;row<N;row++)
    {
        for(col=0;col<N;col++)
        {
            if(grid[row][col]==0)
               return true;
        }
    }
    return false;

}

bool solve_sudoku()
{
    int row,col,num;
    if(!isEmpty(row,col))
       return true;
    for(num=1;num<=9;num++)
    {
        if(isValid(row,col,num))
        {
            grid[row][col]=num;
            if(solve_sudoku())
                return true;
            grid[row][col]=0;
        }
    }
    return false;
}

void print_grid()
{
    for(int row=0;row<9;row++)
    {
        for(int col=0;col<9;col++)
        {
            cout << grid[row][col] << " ";
        }
        cout << endl;
    }
}

int main()
{    
    
    int row,col;
    cout << "Enter the Sudoku grid" << endl;
    for(row=0;row<N;row++)
       for(col=0;col<N;col++)
          cin >> grid[row][col];

    cout << "-------------------" << endl;

    if(solve_sudoku()==true)
    {
        print_grid();
    }
    else
    {
       cout << "No Solution";
    }
       
}





 

