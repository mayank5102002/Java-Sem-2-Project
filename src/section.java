public class section {
    // Public array for time-table of a section
    public String[][] s = new String[6][6];

    // Constructor for initialising the value of time-table to Empty
    public section(){
        for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			s[i][j]="0";
		}
	    }
    }

    /* Transfer function which will take input from time-tables of all the teachers and then fill up the
    time-table of the respective section.
    */
    public void transfer(int n,String[][] t1,String[][] t2,String[][] t3,String[][] t4,String[][] t5){
        for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			int s=n;
			String ss;
			ss = String.valueOf(s);
			if(t1[i][j].equals(ss))
			{
				this.s[i][j] = "1";
			}
		}
	    }
	    for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			int s=n;
			String ss;
			ss = String.valueOf(s);
			if(t2[i][j].equals(ss))
			{
				this.s[i][j]="2";
			}
		}
	    }
	    for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			int s=n;
			String ss;
			ss = String.valueOf(s);
			if(t3[i][j].equals(ss))
			{
				this.s[i][j]="3";
			}
		}
	    }
	    for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			int s=n;
			String ss;
			ss = String.valueOf(s);
			if(t4[i][j].equals(ss))
			{
				this.s[i][j]="4";
			}
		}
	    }
	    for(int i=0;i<6;i++)
	    {
		for(int j=0;j<6;j++)
		{
			int s=n;
			String ss;
			ss = String.valueOf(s);
			if(t5[i][j].equals(ss))
			{
				this.s[i][j]="5";
			}
		}
	    }
    }

    /* Here will be 3 functions to display time-tables for science, commerce and humanities sections respectively.*/
}