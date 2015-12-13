package net.khai.diplom.sigma;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;








import net.khai.diplom.domain.Project;

public class sigma {
	
	static String data;
	static String dataEdges;
	public static String getDataEdges() {
		return dataEdges;
	}
	public static void setDataEdges(String dataEdges) {
		sigma.dataEdges = dataEdges;
	}
	public void generateGraph (List<Project> projectList,int id)
	{  // 1.Ище все проекты у которых Over_project = project id и пишем в список;
	   //   в результате  получаем список всех  проектов  которые входят в даный.+
	   // 2 Ищем в списке все проекты которые Links = NULL
	   // 3 Строим их.
	   // 4 Ищем те проекты у которых Links= Links пердыдущих.
		
		data="";dataEdges="";
		int My_id=1;
		int x=0,y=0,z=0;
		List<Project> ProjList= new LinkedList<Project>();
		List<Project> ProjLst= new LinkedList<Project>();
		
		for(Project project:projectList){
			if (My_id==project.getOver_proj()) 
			{
				ProjList.add(project);
				ProjLst.add(project);
			}
			if(project.getId()==My_id)
			{
				data+="{\"id\": \""+project.getId()+"\",\"label\": \""+project.getName()+"\",\"x\": "+-1+",\"y\": "+0+",\"size\": 5},";	
				   
			}
		}
		
		for(Iterator<Project> ProjIt = ProjList.iterator(); ProjIt.hasNext();)
		 {Project proj=ProjIt.next();
			if (proj.getLinks()!="*"){
		       for(Iterator<Project> ProjIter = ProjLst.iterator(); ProjIter.hasNext();)
				 {Project pr=ProjIter.next();
				 String Str=pr.getLinks();
				if (proj.getLinks().equals(Str))
				{
					data+="{\"id\": \""+pr.getId()+"\",\"label\": \""+pr.getName()+"\",\"x\": "+x+",\"y\": "+y+++",\"size\": 5},";	
				    if (!(pr.getLinks().equals("0")))
				    {String Stri="";
				    Stri=pr.getLinks();
				    Boolean Flag=true;
				    	while(Flag)
				    { if(Stri.indexOf(",")==-1){Flag=false;				     	
				    dataEdges+="{\"id\": \""+z+++"\",\"source\": \""+pr.getId()+"\",\"target\": \""+Integer.parseInt(Stri)+"\"},";	
				    }
				    else
				    {System.out.println(Stri);
				    dataEdges+="{\"id\": \""+z+++"\",\"source\": \""+pr.getId()+"\",\"target\": \""+Integer.parseInt(Stri.substring(0, Stri.indexOf(",")))+"\"},";	
			         Stri=Stri.substring(Stri.indexOf(",")+1,Stri.length());
				    }
				    }
				    }
					ProjIter.remove();
				 
				}
			      }}
			x++;y=0;	
			}
 
		System.out.println("Sigma trace data="+data);
        System.out.println("Data Edges="+dataEdges);		
		
		
		/////////////////////////
		
		//Project project=new Project();
	//	project=projectList.get(2);
	/*String s="",st = "";
	
	int x=1,y=1;
	int k=0;
	for (int i =1;i < projectList.size(); i++){
		
		st=projectList.get(i).getLinks();
		if (st == null){st="*";}
		System.out.println(s+" "+st);
		if(st.equals(s)){y++; x--; }else{y=1;}
		data+="{\"id\": \""+projectList.get(i).getId()+"\",\"label\": \""+projectList.get(i).getName()+"\",\"x\": "+x+++",\"y\": "+y+",\"size\": 5},";
        s=projectList.get(i).getLinks();	
        if (s==null){s="-";}	
	}
	System.out.print(data);*/
	}
	public static Boolean isLinked(int id,Project project)
	{boolean flag =false;
	 String S = Integer.toString(id);
	 String S2=project.getLinks();
	 if (S2.contains(S)){flag=true;}
		return flag;
	}
	public static String getData() {
		return data;
	}
	public static void setData(String data) {
		sigma.data = data;
	}
	
}
