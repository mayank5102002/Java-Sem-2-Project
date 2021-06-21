import javax.swing.JOptionPane;

public class teacher {

	// Public array for the time table of a teacher
    public String[][] t = new String[6][6];

	// Contructor initialising the values of time table to empty string
    public teacher(){
        for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
		    t[i][j]="0";
		}
	    }
    }

	/* Function where values are being input in the time-table of the teacher for which
	the time-table is being called in accordance to the time-tables of the other teachers.
	The entries will be following - 
	Empty - Free Period
	1 - Subject 1
	2 - Subject 2
	3 - Subject 3
	4 - Subject 4
	5 - Subject 5
	*/
    public void teacherInput(int sec,int[] n,String[][] t1,String[][] t2,String[][] t3,String[][] t4) throws ArrayIndexOutOfBoundsException{
        int[] p = new int[sec];
	    for(int u=0;u<sec;u++){
		p[u] = n[u];
	    }
	    for(int k=0;k<sec;k++)
	    {
		int i=0,j=0;
		while(p[k]!=0)
		{
			int s=k+1;
			String ss;
			ss = String.valueOf(s);
			if(i<6 && t[i][j].equals("0") && !t1[i][j].equals(ss) && !t2[i][j].equals(ss) && !t3[i][j].equals(ss) && !t4[i][j].equals(ss))
			{
				t[i][j] = ss;
				p[k]--;
				i++;
			}
			else
			{
				if(i>5)
				{
					i=0;
					j++;
				}
				else
				{
					i++;
				}
			}
		}
	    }
    }

	/*Here a function for displaying the time table has to be added  #########
	This function will display the section number for which the class has been scheduled.
	*/
}