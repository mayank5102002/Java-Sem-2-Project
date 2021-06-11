public class Main {

    public static void error(int[] n, int sec){
       int sum=0;
	   for(int i=0;i<sec;i++)
	   {
		sum=sum+n[i];
	   }
	   if(sum>36)
	   {
		//Here, the user will be informed about the error that the number of classes for the teacher has been extended.
		System.exit(0);
	   }
    }
    public static void main(String[] args) throws Exception {

        /* Intro of the whole application to be provided first. */
        // Input will be taken for clas through a textfield.
    	System.out.println("Hello World");
        String clas = new String();
    if(clas.equals("SCIENCE"))
	{
        // Input will be taken for sec through a textfield.
    int sec = 0;
	int[] math = new int[sec],
    phy = new int[sec],
    chem = new int[sec],
    eng = new int[sec],
    cs = new int[sec];

	error(cs,sec);

	teacher maths = new teacher(),
			physics = new teacher(),
			chemistry = new teacher(),
			english = new teacher(),
			compsc = new teacher();
	maths.teacherInput(sec,math,english.t,compsc.t,physics.t,chemistry.t);
    maths.not_comp(sec,math);
	physics.teacherInput(sec,phy,maths.t,english.t,compsc.t,chemistry.t);
    physics.not_comp(sec,phy);
	chemistry.teacherInput(sec,chem,maths.t,english.t,compsc.t,physics.t);
    chemistry.not_comp(sec,chem);
	english.teacherInput(sec,eng,maths.t,compsc.t,physics.t,chemistry.t);
    english.not_comp(sec,eng);
	compsc.teacherInput(sec,cs,maths.t,english.t,physics.t,chemistry.t);
    compsc.not_comp(sec,cs);
    // Display functions for all the sections will be called here.

	for(int i=0;i<sec;i++)
	{
		section p = new section();
		p.transfer(i+1,maths.t,english.t,compsc.t,physics.t,chemistry.t);
        // Display function for the sections will be called here.
	}
}
if(clas.equals("HUMANITIES"))
{
    // Input will be taken for sec through a textfield.
    int sec = 0;
	int[] math = new int[sec],
    hind = new int[sec],
    geo = new int[sec],
    eng = new int[sec],
    pol = new int[sec];

	error(pol,sec);

	teacher maths = new teacher(),
			hindi = new teacher(),
			geography = new teacher(),
			english = new teacher(),
			polsc = new teacher();
	maths.teacherInput(sec,math,english.t,polsc.t,geography.t,hindi.t);
	maths.not_comp(sec,math);
	hindi.teacherInput(sec,hind,maths.t,english.t,polsc.t,geography.t);
	hindi.not_comp(sec,hind);
	geography.teacherInput(sec,geo,maths.t,english.t,polsc.t,hindi.t);
	geography.not_comp(sec,geo);
	english.teacherInput(sec,eng,maths.t,polsc.t,geography.t,hindi.t);
	english.not_comp(sec,eng);
	polsc.teacherInput(sec,pol,maths.t,english.t,geography.t,hindi.t);
	polsc.not_comp(sec,pol);
    // Display functions for all the sections will be called here.

	for(int i=0;i<sec;i++)
	{
		section p = new section();
		p.transfer(i+1,maths.t,english.t,polsc.t,geography.t,hindi.t);
        // Display function for the sections will be called here.
	}	
}
if(clas.equals("COMMERCE"))
{
    // Input will be taken for sec through a textfield.
    int sec = 0;
	int[] math = new int[sec],
    acc = new int[sec],
    buss = new int[sec],
    eng = new int[sec],
    eco = new int[sec];

	error(eco,sec);

	teacher maths = new teacher(),
			accounts = new teacher(),
			bus_st = new teacher(),
			english = new teacher(),
			economics = new teacher();
	maths.teacherInput(sec,math,english.t,economics.t,bus_st.t,accounts.t);
	maths.not_comp(sec,math);
	accounts.teacherInput(sec,acc,maths.t,english.t,economics.t,bus_st.t);
	accounts.not_comp(sec,acc);
	bus_st.teacherInput(sec,buss,maths.t,english.t,accounts.t,economics.t);
	bus_st.not_comp(sec,buss);
	english.teacherInput(sec,eng,maths.t,economics.t,accounts.t,bus_st.t);
	english.not_comp(sec,eng);
	economics.teacherInput(sec,eco,maths.t,english.t,bus_st.t,accounts.t);
	economics.not_comp(sec,eco);
    // Display functions for all the sections will be called here.

	for(int i=0;i<sec;i++)
	{
		section p = new section();
		p.transfer(i+1,maths.t,english.t,bus_st.t,accounts.t,economics.t);
        // Display function for the sections will be called here.
	}	
}
}
}