public class teacher {

	// Public array for the time table of a teacher
    public String[][] t = new String[6][6];

	// Contructor initialising the values of time table to empty string
    public teacher(){
        for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
		    t[i][j]="";
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
    public void teacherInput(int sec,int[] n,String[][] t1,String[][] t2,String[][] t3,String[][] t4){
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
			if(t[i][j]=="" && i<6 && t1[i][j]!=ss && t2[i][j]!=ss && t3[i][j]!=ss && t4[i][j]!=ss)
			{
				t[i][j] = String.valueOf(s);
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

	/* Error function which identifies if there is an error and then notifies the user
	and then ends the program.
	This function is specific for the non comopatible error type, like when the time table
	can't be made for the given numbers of periods.
	*/
	public void not_comp(int sec, int[] n){
		int[] sum = new int[sec];
	for(int k=0;k<sec;k++)
	{
		sum[k]=0;
		for(int i=0;i<6;i++)
	{
		for(int j=0;j<6;j++)
		{
			int s=k+1;
			String ss;
			ss = String.valueOf(s);
			if(t[i][j]==ss)
			{
				sum[k]++;
			}
		}
	}
	}
	for(int i=0;i<sec;i++)
	{
		if(sum[i]!=n[i])
		{
			//Here a statement of informing the user about the error will come and then program will exit
			System.exit(2);
		}
	}
	}

	/*Here a function for displaying the time table has to be added  #########
	This function will display the section number for which the class has been scheduled.
	*/
}